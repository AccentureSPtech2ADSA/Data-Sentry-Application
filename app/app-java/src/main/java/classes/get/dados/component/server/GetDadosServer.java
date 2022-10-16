package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
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

    private String serialWindows = "";
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

    public void setServerInfo() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(SERVER)");
            String sql = String.format("INSERT INTO Server"
                    + "(_serialServer, isActive, description, fkHospital) VALUES"
                    + " ('%s', '%s', '%s', %d)",
                    getMotherboardSerialWindows(), isActive, description, fkHospital);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
