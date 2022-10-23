package app.DAO;

import app.model.ServerModel;
import org.springframework.jdbc.core.JdbcTemplate;
import app.database.Database;

public class ServerDAO {

    private JdbcTemplate conn;

    public ServerDAO() {
        this.conn = Database.getConn();
    }

    public Integer insertServer(ServerModel server) {
        String query = "INSERT INTO Server (_serialServer, isActive, description, fkHospital) "
                + "VALUES (?, ?, ?, ?)";
        return conn.update(query, server.getSerialServer(), server.getIsActive(), server.getDescription(), server.getFkHospital());
    }
    
}
