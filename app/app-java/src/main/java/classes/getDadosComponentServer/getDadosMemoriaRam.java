package classes.getDadosComponentServer;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class getDadosMemoriaRam {
    //FORMATAR O VALOR DE MEMORIA TOTAL PRA DECIMAL
    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    Looca looca = new Looca();

    private Double memoriaEmUso = looca.getMemoria().getEmUso().doubleValue();
    private Double memoriaEmUsoFormatada = Math.floor(memoriaEmUso);

    private Double memoriaTotal = looca.getMemoria().getTotal().doubleValue();
    private Double memoriaTotalFormada = Math.floor(memoriaTotal);

    private Integer fkMemoriaRam = 1;
    private Integer fkTipo = 2;
    private Integer fkServer = 12345;

    public Double getMemoriaEmUsoFormatada() {
        return memoriaEmUsoFormatada;
    }

    public Double getMemoriaTotalFormada() {
        return memoriaTotalFormada;
    }

    public Integer getFkMemoriaRam() {
        return fkMemoriaRam;
    }

    public Integer getFkTipo() {
        return fkTipo;
    }

    public Integer getFkServer() {
        return fkServer;
    }

    public void setTipoComponente() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo tipo do componente(RAM)");
            String sql = String.format("INSERT INTO ComponentType VALUES (NULL, 'Memoria Ram', '%.2f', NULL, NULL)", getMemoriaTotalFormada());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setInfoMemoriaComponente() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(RAM)");
            String sql = String.format("INSERT INTO ComponentServer VALUES (NULL, NULL, 'Memoria Ram', NULL, %d, %d, NULL, NULL)",
                    getFkServer(), getFkTipo());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getUsoMemoriaRam() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo utilização memoria ram no banco");
            String sql = String.format("INSERT INTO usoCpu VALUES(NULL, %.2f, %d)", getMemoriaEmUsoFormatada(), getFkMemoriaRam());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
