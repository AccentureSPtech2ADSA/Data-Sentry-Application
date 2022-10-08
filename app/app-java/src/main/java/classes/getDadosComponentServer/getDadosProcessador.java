package classes.getDadosComponentServer;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class getDadosProcessador {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "admin";

    Looca looca = new Looca();

    private String nomeCpu = looca.getProcessador().getNome();
    private String fabricanteCpu = looca.getProcessador().getFabricante();
    private String identificadorCpu = looca.getProcessador().getIdentificador();
    private String serialProcessador = looca.getProcessador().getId();
    private Double frequenciaCpu = looca.getProcessador().getFrequencia().doubleValue();
    private Double frequenciaCpuFormata = frequenciaCpu * 0.000000001;

    private Double usoDeCpu = looca.getProcessador().getUso();
    
    private Integer fkCpu = 1;
    private Integer fkTipo = 1;
    private Integer fkServer = 12345;

    public Looca getLooca() {
        return looca;
    }

    public String getNomeCpu() {
        return nomeCpu;
    }

    public String getFabricanteCpu() {
        return fabricanteCpu;
    }

    public String getIdentificadorCpu() {
        return identificadorCpu;
    }

    public String getSerialProcessador() {
        return serialProcessador;
    }

    public Double getFrequenciaCpuFormata() {
        return frequenciaCpuFormata;
    }

    public Double getUsoDeCpu() {
        return usoDeCpu;
    }

    public Integer getFkCpu() {
        return fkCpu;
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
            System.out.println("\nInserindo tipo do componente");
            String sql = String.format("INSERT INTO ComponentType VALUES "
                    + "(NULL, 'Processador', '%.2f', NULL, NULL)",
                    getFrequenciaCpuFormata());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setInfoProcessador() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente");
            String sql = String.format("INSERT INTO ComponentServer VALUES (NULL, '%s', '%s', '%s', %d, %d, NULL, NULL)",
                    getSerialProcessador(), getNomeCpu(), getFabricanteCpu(), getFkServer(), getFkTipo());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //FALTA TERMINAR FUNÇÃO
    public void getUsoCpu() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo utilização cpu no banco");
            String sql = String.format("INSERT INTO LogComponentPerProcess VALUES(NULL, %.2f, %d)", getUsoDeCpu(), getFkCpu());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
