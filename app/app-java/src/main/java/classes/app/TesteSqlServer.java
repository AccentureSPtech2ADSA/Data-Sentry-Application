package classes.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteSqlServer {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                        + "database=datasentry;"
                        + "user=SA;"
                        + "password=#Gfgrupo1;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            System.out.println("SUCESSO");
            // Code here.  
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
