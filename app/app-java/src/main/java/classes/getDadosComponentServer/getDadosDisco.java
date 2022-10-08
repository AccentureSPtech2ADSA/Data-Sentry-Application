package classes.getDadosComponentServer;

import static classes.getDadosComponentServer.getDadosMemoriaRam.DB_URL;
import static classes.getDadosComponentServer.getDadosMemoriaRam.PASS;
import static classes.getDadosComponentServer.getDadosMemoriaRam.USER;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class getDadosDisco {

    static final String DB_URL = "jdbc:mysql://localhost/dataSentry";
    static final String USER = "root";
    static final String PASS = "admin";

    Looca looca = new Looca();
    
    private Integer fkDisco = 1;
    private Integer fkTipo = 3;
    private Integer fkServer = 12345;

    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    List<Disco> discos = grupoDeDiscos.getDiscos();

    private String nomeDisco = discos.get(0).getNome();
    private String modeloDisco = discos.get(0).getModelo();
    private String serialDisco = discos.get(0).getSerial();
    private Double tamanhoDisco = discos.get(0).getTamanho().doubleValue();
    private Double tamanhoDiscoFormatado = Math.floor(tamanhoDisco * 0.000000001);

    public Integer getFkDisco() {
        return fkDisco;
    }

    public Integer getFkTipo() {
        return fkTipo;
    }

    public Integer getFkServer() {
        return fkServer;
    }

    public String getNomeDisco() {
        return nomeDisco;
    }

    public String getModeloDisco() {
        return modeloDisco;
    }

    public String getSerialDisco() {
        return serialDisco;
    }

    public Double getTamanhoDisco() {
        return tamanhoDisco;
    }

    public Double getTamanhoDiscoFormatado() {
        return tamanhoDiscoFormatado;
    }
    
        public void setTipoComponente() {
            System.out.println(getTamanhoDiscoFormatado());
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();) {
            // INSERIR NO BANCO DE DADOS
            System.out.println("\nInserindo tipo do componente(DISCO)\n");
            String sql = String.format("INSERT INTO ComponentType VALUES (NULL, 'Disco', '%.2f', NULL, NULL)", getTamanhoDiscoFormatado());
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
            String sql = String.format("INSERT INTO ComponentServer VALUES (NULL, '%s', '%s', NULL, %d, %d, NULL, NULL)",
                    getSerialDisco(), getModeloDisco(), getFkServer(), getFkTipo());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
