package app.DAO;

import app.controller.ServerController;
import app.model.ServerModel;
import org.springframework.jdbc.core.JdbcTemplate;
import app.database.Database;
import java.io.IOException;

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

  public static void main(String[] args) {

    try {
      ServerController controller = new ServerController();
      ServerModel model = controller.getServer();
      
      ServerDAO dao = new ServerDAO();
      Integer res = dao.insertServer(model);
      System.out.println("Resultado: "+ res);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
