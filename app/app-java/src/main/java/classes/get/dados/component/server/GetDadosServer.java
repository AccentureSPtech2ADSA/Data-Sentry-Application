package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDadosServer {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    Looca looca = new Looca();
    GetDadosServer getDs = new GetDadosServer();

    private String serialWindows;
    private String serialLinux;
    private String changeSerialPerSystem;
    private String isActive = "A";
    private String description = "Sistema operacional: " + looca.getSistema().getSistemaOperacional();
    private Integer fkHospital = 1;
    /*
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

    public String getMotherboardSerialLinux() {
        serialLinux = "";
        try {
            String[] args = {"bash", "-c", "lshw -class bus | grep serial"};
            Process p = Runtime.getRuntime().exec(args);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                serialLinux += line;
            }
            input.close();

        } catch (Exception e) {
        }
        if (serialLinux.trim().length() < 1 || serialLinux == null) {
            serialLinux = "NO_DISK_ID";
        }

        return serialLinux.trim();
    }

    public final String getMotherboardSerial() {
        String loocaSystem = looca.getSistema().getSistemaOperacional();
        changeSerialPerSystem = "";

        try {
            if (loocaSystem.startsWith("Windows")) {
                changeSerialPerSystem = getMotherboardSerialWindows();
            } else if (loocaSystem.startsWith("Linux")) {
                changeSerialPerSystem = getMotherboardSerialLinux();
            } else {
                new IOException("unknown operating system: " + loocaSystem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return changeSerialPerSystem;
    }
    */
    
    private final String getMotherboardSerial() throws IOException {
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

    // Implementacoes
    /*
     * Captura serial de placa mae no WINDOWS, atraves da execucao de script
     * visual basic
     */
    public String getMotherboardSerialWindows() {
        String result = "";
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
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }

    /*
     * Captura serial de placa mae em sistemas LINUX, atraves da execucao de
     * comandos em shell.
     */
    public String getMotherboardSerialLinux() {
        String result = "";
        try {
            String[] args = {"bash", "-c", "lshw -class bus | grep serial"};
            Process p = Runtime.getRuntime().exec(args);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();

        } catch (Exception e) {
        }
        if (result.trim().length() < 1 || result == null) {
            result = "NO_DISK_ID";

        }

        return result.trim();

    }
    
    
    public void setServerInfo() throws IOException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(SERVER)");
            String sql = String.format("INSERT INTO Server"
                    + "(_serialServer, isActive, description, fkHospital) VALUES"
                    + " ('%s', '%s', '%s', %d)",
                    getMotherboardSerial(), isActive, description, fkHospital);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
