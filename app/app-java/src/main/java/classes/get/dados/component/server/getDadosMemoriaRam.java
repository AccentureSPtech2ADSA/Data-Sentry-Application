package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class getDadosMemoriaRam {
    
    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    Looca looca = new Looca();

    private Long memoriaEmUso = looca.getMemoria().getEmUso();
    private Double memoriaEmUsoFormatada = memoriaEmUso * 0.000000001;

    private Double memoriaTotal = looca.getMemoria().getTotal().doubleValue();
    private Double memoriaTotalFormatada = Math.floor(memoriaTotal * 0.000000001);

    private Integer fkMemoriaRam = 1;
    private Integer fkTipo = 2;
    private Integer fkServer = 12345;

    public Double getMemoriaEmUsoFormatada() {
        return memoriaEmUsoFormatada;
    }

    public Double getMemoriaTotalFormada() {
        return memoriaTotalFormatada;
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
            System.out.println("\nInserindo tipo do componente(RAM)\n");
            String sql = "INSERT INTO ComponentType VALUES (NULL, 'Memoria Ram', 'GB', NULL, NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setInfoMemoriaRam() {
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
    
    //FALTA TERMINAR FUNÇÃO
    public void getUsoMemoriaRam() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo utilização memoria ram no banco");
            String sql = String.format("INSERT INTO LogComponentPerProcess VALUES(NULL, %.2f, %d)", getMemoriaEmUsoFormatada(), getFkMemoriaRam());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
