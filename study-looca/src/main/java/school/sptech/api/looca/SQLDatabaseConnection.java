package school.sptech.api.looca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl    
                = "jdbc:sqlserver://;serverName=localhost;databaseName=datasentry";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            System.out.println("SUCESSO");
            // Code here.  
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
