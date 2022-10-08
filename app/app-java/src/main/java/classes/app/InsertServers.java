package classes.app;

import static classes.app.InserirDados.DB_URL;
import static classes.app.InserirDados.PASS;
import static classes.app.InserirDados.USER;
import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertServers {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "admin";

    Looca looca = new Looca();

    public String getIdProcessador() {
        return looca.getProcessador().getId();
    }

    public String getSistemaOperacional() {
        return looca.getSistema().getSistemaOperacional();
    }
    
    //COMO PEGAR A FK DOS HOSPITAL QUE ESTÁ LOGADO NO MOMENTO
    public Integer getFkHospital() {
        return null;
    }

    public void InsertServer() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações da tabela Server");
            String sql = String.format("INSERT INTO Server VALUES ('%s', 'true', 'Sistema Operacional: %s', '%d', NULL, NULL)",
                    getIdProcessador(), getSistemaOperacional(), getFkHospital());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
