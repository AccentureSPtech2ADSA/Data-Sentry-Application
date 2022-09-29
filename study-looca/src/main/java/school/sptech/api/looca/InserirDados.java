package school.sptech.api.looca;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirDados {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    public void inserirBd() {

        Looca looca = new Looca();
        String dadosFabricante = looca.getSistema().getFabricante();
        String dadosSo = looca.getSistema().getSistemaOperacional();
        String dadosNomeProcessador = looca.getProcessador().getNome();
        String dadosFrequenciaProcessador = 
                looca.getProcessador().getFrequencia().toString();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nTESTANDO INSERÇÃO");
            String sql = "INSERT INTO Usuario VALUES (INSERIR OS VALORES)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
