package classes.get.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetDadosLogin {

    //CONEXÃO LOCAL - WORKBENCH
    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";
    static final String QUERY = "SELECT email, password FROM UserHospital";

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

    public String isLoginValido(String email, String senha) throws ClassNotFoundException {
        Boolean existe = false;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection conn = DriverManager.getConnection(connectionUrl);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(String.format("exec sp_loginUser '%s', '%s';", email, senha));) {
            // PEGAR VALORES DO BANCO DE DADOS
            while (rs.next()) {
                // Retrieve by column name
                Integer id = rs.getInt("id");
                if (id != null && id > 0) {
                    existe = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return String.valueOf(existe);
    }
}
