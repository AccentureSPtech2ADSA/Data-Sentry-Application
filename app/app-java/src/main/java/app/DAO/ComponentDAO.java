package app.DAO;

import app.controller.MemoriaRamController;
import app.database.Database;
import app.model.DiscoModel;
import app.model.MemoriaRamModel;
import app.model.ProcessadorModel;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ComponentDAO {

    private static final String SERIAL = "serial";
    private static final String MODEL = "model";
    private static final String BRAND = "brand";
    private static final String MAXUSE = "maxUse";
    private static final String FKSERVER = "fkServer";
    private static final String FKTYPE = "fkComponentType";

    private final JdbcTemplate conn;

    public ComponentDAO() {
        conn = Database.getConn();
    }

    public Integer insertDisco(DiscoModel disco) throws IOException, ClassNotFoundException {
        String sql = String.format(
                "INSERT INTO ComponentServer (%s, %s, %s, %s, %s, %s)"
                + " VALUES ('?', '?', '?', '?', '?', 3)",
                SERIAL, MODEL, BRAND, MAXUSE, FKSERVER, FKTYPE);
        return conn.update(sql, disco.getSerialDisco(), disco.getModeloDisco(), disco.getNomeDisco(), disco.getReplaceVirgulaTamanhoDisco(), disco.getSerialDisco());
    }

    public Integer insertProcessador(ProcessadorModel processador) throws IOException, ClassNotFoundException {
        String sql = String.format("INSERT INTO ComponentServer (%s, %s, %s, %s, %s, %s)"
                + " VALUES ('?', '?', '?', '?', '?', 1)",
                SERIAL, MODEL, BRAND, MAXUSE, FKSERVER, FKTYPE);
        return conn.update(sql, processador.getSerial(), processador.getModel(), processador.getBrand(), processador.getMaxUse(), processador.getSerial());
    }

    public Integer insertMemoriaRam(MemoriaRamModel memoriaRam) throws IOException, ClassNotFoundException {
        String sql = String.format("INSERT INTO ComponentServer (%s, %s, %s, %s, %s, %s)"
                + " VALUES ('?', '?', '?', '?', '?', 2)",
                SERIAL, MODEL, BRAND, MAXUSE, FKSERVER, FKTYPE);
        return conn.update(sql, memoriaRam.getSerial(), memoriaRam.getModel(), memoriaRam.getBrand(), memoriaRam.getMaxUse(), memoriaRam.getSerial());
    }

    public static void main(String[] args) {

        try {
            MemoriaRamController memoriaController = new MemoriaRamController();
            MemoriaRamModel memoriaModel = memoriaController.getMemoriaRam();

            ComponentDAO componentDao = new ComponentDAO();
            Integer res = componentDao.insertMemoriaRam(memoriaModel);
            System.out.println("Resultado: " + res);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
