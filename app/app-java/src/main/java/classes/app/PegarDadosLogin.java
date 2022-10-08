<<<<<<<< HEAD:app/app-java/src/main/java/classes/app/PegarDadosLogin.java
package classes.app;
========
package classes.getLogin;
>>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb:app/app-java/src/main/java/classes/getLogin/getDadosLogin.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class getDadosLogin {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
<<<<<<<< HEAD:app/app-java/src/main/java/classes/app/PegarDadosLogin.java
    static final String PASS = "matheus123";
========
    static final String PASS = "admin";
>>>>>>>> ab18762fc6e08a5db6e6265ea85d23f8105301bb:app/app-java/src/main/java/classes/getLogin/getDadosLogin.java
    static final String QUERY = "SELECT email, password FROM UserHospital";

    public List<String> getEmails() {

        String emailLogin;
        List<String> emails = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            // PEGAR VALORES DO BANCO DE DADOS
            while (rs.next()) {
                // Retrieve by column name
                emailLogin = rs.getString("Email");
                emails.add(emailLogin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }

    public List<String> getSenhas() {

        String senhaLogin;
        List<String> senhas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {

            // PEGAR VALORES DO BANCO DE DADOS
            while (rs.next()) {
                // Retrieve by column name
                senhaLogin = rs.getString("Password");
                senhas.add(senhaLogin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return senhas;
    }

    public Integer getTamanhoLista() {

        Integer tamanhoLista = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {

            // PEGAR VALORES DO BANCO DE DADOS
            while (rs.next()) {
                // Retrieve by column name
                rs.getString("Email");
                tamanhoLista++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tamanhoLista;
    }
}
