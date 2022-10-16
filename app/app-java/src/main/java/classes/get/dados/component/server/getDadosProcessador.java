package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDadosProcessador {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    Looca looca = new Looca();
    GetDadosServer getDadosServer = new GetDadosServer();

    private String nomeCpu = looca.getProcessador().getNome();

    private String fabricanteCpu = looca.getProcessador().getFabricante();

    private String identificadorCpu = looca.getProcessador().getIdentificador();

    private String serialProcessador = looca.getProcessador().getId();

    private Double frequenciaCpu
            = looca.getProcessador().getFrequencia().doubleValue();

    private Double frequenciaCpuFormata = frequenciaCpu * 0.000000001;

    private String replaceVirgulaFrequenciaCpuFormatada
            = frequenciaCpuFormata.toString().replaceAll("\\,", ".");

    private Double usoDeCpu = looca.getProcessador().getUso();

    private Integer fkCpu = 1;
    private Integer fkTipo = 1;
    private String fkServer = getDadosServer.getMotherboardSerialWindows();

    public Looca getLooca() {
        return looca;
    }

    public void setTipoComponente() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo tipo do componente(CPU)");
            String sql = "INSERT INTO ComponentType"
                    + "(description, measuramentUnit) "
                    + "VALUES('Processador', 'GHz')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setInfoProcessador() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(CPU)");
            String sql = String.format("INSERT INTO ComponentServer"
                    + "(serial, model, brand, maxUse, fkServer, fkComponentType)"
                    + " VALUES ('%s', '%s', '%s', '%s', '%s', %d)",
                    serialProcessador, nomeCpu, fabricanteCpu,
                    replaceVirgulaFrequenciaCpuFormatada, fkServer, fkTipo);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
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
     */
}
