package classes.get.dados.component.server;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GetDadosDisco {
    //CONEXÃO LOCAL - WORKBENCH
    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "matheus123";
    
    /*PARA CONECTAR NO WORKBECH,
    PASSE ESSE VALOR EM TODAS AS CLASSES QUE POSSUEM O GET CONNECTION
    VALOR: DB_URL, USER, PASS*/

    // CONEXÃO SQL SERVER - AZURE
    String connectionUrl
            = "jdbc:sqlserver://datasentry.database.windows.net:1433;"
            + "database=datasentry;user=datasentry@datasentry;"
            + "password=#Gfgrupo1;"
            + "encrypt=true;trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    Looca looca = new Looca();

    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();

    private Integer fkDisco = 1;
    private Integer fkTipo = 3;
    private String fkServer;

    private String nomeDisco;
    private String modeloDisco;
    private String serialDisco;
    private Double tamanhoDisco;
    private Double tamanhoDiscoFormatado;
    private String replaceVirgulaTamanhoDiscoFormatado;

    public GetDadosDisco() throws IOException {
        GetDadosServer getDadosServer = new GetDadosServer();
        fkServer = getDadosServer.getMotherboardSerial();
    }

    public void setTipoComponente() {
        try (Connection conn = DriverManager.getConnection(connectionUrl);
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
        
        try (Connection conn = DriverManager.getConnection(connectionUrl);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo informações do componente(DISCO)");
            for (int i = 0; i < discos.size(); i++) {
                nomeDisco = discos.get(i).getNome();
                modeloDisco = discos.get(i).getModelo();
                serialDisco = discos.get(i).getSerial();
                tamanhoDisco = discos.get(i).getTamanho().doubleValue();
                tamanhoDiscoFormatado = Math.floor(tamanhoDisco * 0.000000001);
                replaceVirgulaTamanhoDiscoFormatado = tamanhoDiscoFormatado.toString().replaceAll("\\,", ".");

                String sql = String.format("INSERT INTO ComponentServer"
                        + "(serial, model, brand, maxUse, fkServer, fkComponentType)"
                        + " VALUES ('%s', '%s', '%s', '%s', '%s', %d)",
                        serialDisco.trim(), modeloDisco, nomeDisco,
                        replaceVirgulaTamanhoDiscoFormatado, fkServer, fkTipo);

                stmt.executeUpdate(sql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
