package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDadosMemoriaRam {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    Looca looca = new Looca();

    private Long memoriaEmUso = looca.getMemoria().getEmUso();

    private Double memoriaEmUsoFormatada = memoriaEmUso * 0.000000001;

    private Double memoriaTotal = looca.getMemoria().getTotal().doubleValue();

    private Double memoriaTotalFormatada
            = Math.floor(memoriaTotal * 0.000000001);

    private String replaceVirgulaMemoriaTotalFormatada
            = memoriaTotalFormatada.toString().toString().replaceAll("\\,", ".");

    private Integer fkMemoriaRam = 1;
    private Integer fkTipo = 2;
    private String fkServer;
    
    public GetDadosMemoriaRam() throws IOException {
        GetDadosServer getDadosServer = new GetDadosServer();
        fkServer = getDadosServer.getMotherboardSerial();
    }

    public void setTipoComponente() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo tipo do componente(RAM)\n");
            String sql = "INSERT INTO ComponentType"
                    + "(description, measuramentUnit) "
                    + "VALUES ('Memoria Ram', 'GB')";
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
            String sql = String.format("INSERT INTO ComponentServer"
                    + "(serial, model, brand, maxUse, fkServer, fkComponentType)"
                    + " VALUES (NULL, 'Memoria Ram', NULL, '%s', '%s', %d)",
                    replaceVirgulaMemoriaTotalFormatada, fkServer, fkTipo);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
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
     */
}
