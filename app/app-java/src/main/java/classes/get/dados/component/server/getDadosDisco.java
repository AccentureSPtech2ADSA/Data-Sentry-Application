package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GetDadosDisco {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";

    Looca looca = new Looca();
    GetDadosServer getDadosServer = new GetDadosServer();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();

    private Integer fkDisco = 1;
    private Integer fkTipo = 3;
    private String fkServer = getDadosServer.getMotherboardSerialWindows();

    private String nomeDisco = discos.get(1).getNome();

    private String modeloDisco = discos.get(1).getModelo();

    private String serialDisco = discos.get(1).getSerial();

    private Double tamanhoDisco = discos.get(1).getTamanho().doubleValue();

    private Double tamanhoDiscoFormatado
            = Math.floor(tamanhoDisco * 0.000000001);

    private String replaceVirgulaTamanhoDiscoFormatado
            = tamanhoDiscoFormatado.toString().replaceAll("\\,", ".");

    public void setTipoComponente() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo tipo do componente(DISCO)\n");
            String sql = "INSERT INTO ComponentType(description, measuramentUnit)"
                    + " VALUES ('Disco', 'GB')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setInfoDisco() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(DISCO)");
            String sql = String.format("INSERT INTO ComponentServer"
                    + "(serial, model, brand, maxUse, fkServer, fkComponentType)"
                    + " VALUES ('%s', '%s', '%s', '%s', '%s', %d)",
                    serialDisco.trim(), modeloDisco, nomeDisco,
                    replaceVirgulaTamanhoDiscoFormatado, fkServer, fkTipo);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
