package classes.app;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteSqlServer {
    
            Looca looca = new Looca();
        String dadosFabricante = looca.getSistema().getFabricante();

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl
                = "jdbc:sqlserver://;serverName=localhost;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "#Gfgrupo1";
        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
