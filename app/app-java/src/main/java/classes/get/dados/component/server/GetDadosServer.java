package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class GetDadosServer {
    //CONEXÃO LOCAL - WORKBENCH
    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";
    
    /*PARA CONECTAR NO WORKBECH,
    PASSE ESSE VALOR EM TODAS AS CLASSES QUE POSSUEM O GET CONNECTION
    VALOR: DB_URL, USER, PASS*/


    // CONEXÃO SQL SERVER - AZURE
    String connectionUrl
            = "jdbc:sqlserver://datasentry.database.windows.net:1433;"
            + "database=datasentry;user=datasentry@datasentry;"
            + "password=#Gfgrupo1;"
            + "encrypt=true;trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    Looca looca = new Looca();

    private String serialWindows;
    private String serialLinux;
    private String serialServer;

    private String isActive = "A";
    private String description = "Sistema operacional: " + looca.getSistema().getSistemaOperacional();
    private Integer fkHospital = 1;

    public String getMotherboardSerialWindows() {
        serialWindows = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                serialWindows += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serialWindows.trim();
    }

    public String getMotherboardSerialLinux() throws SocketException {
        serialLinux = null;
        Map<String, String> addressByNetwork = new HashMap<>();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface network = networkInterfaces.nextElement();
            byte[] bmac = network.getHardwareAddress();
            if (bmac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bmac.length; i++) {
                    sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));
                }
                if (sb.toString().isEmpty() == false) {
                    addressByNetwork.put(network.getName(), sb.toString());
                }
                if (sb.toString().isEmpty() == false && serialLinux == null) {
                    serialLinux = network.getName();
                }
            }
        }

        if (serialLinux != null) {
            return addressByNetwork.get(serialLinux).replaceAll("-", "");
        }

        return null;
    }

    final String getMotherboardSerial() throws IOException {
        String os = System.getProperty("os.name");

        try {
            if (os.startsWith("Windows")) {
                return getMotherboardSerialWindows();
            } else if (os.startsWith("Linux")) {
                return getMotherboardSerialLinux();
            } else {
                throw new IOException("unknown operating system: " + os);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException(ex.getMessage());
        }
    }

    public GetDadosServer() throws IOException {
        serialServer = getMotherboardSerial();
    }

    public void setServerInfo() {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(SERVER)");
            String sql = String.format("INSERT INTO Server"
                    + "(_serialServer, isActive, description, fkHospital) VALUES"
                    + " ('%s', '%s', '%s', %d)",
                    serialServer, isActive, description, fkHospital);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
