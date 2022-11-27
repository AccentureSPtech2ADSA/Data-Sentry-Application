package app.dao;

import app.model.ServerModel;
import app.util.LOGGER;
import java.util.List;
import java.util.Map;

public class ServerDAO extends Dao {

  public ServerModel save(ServerModel server) {
    if (componentExists(server)) {

      String msg = "Servidor com serial: " + server.getSerialServer() + " ja foi inserido.";
      System.out.println(msg);
      LOGGER.warning(msg, "components");
      return server;
    }
    String query = "INSERT INTO Server (_serialServer, isActive, description, fkHospital) "
            + "VALUES (?, ?, ?, ?)";
    String msg = String.format("Inserindo servidor: ", server.getSerialServer());
    System.out.println(msg);
    LOGGER.info(msg, "components");
    Integer res = conn.update(query, server.getSerialServer(), server.getIsActive(), server.getDescription(), server.getFkHospital());
    conn.updateAws(query, true, server.getSerialServer(), server.getIsActive(), server.getDescription(), server.getFkHospital());
    if (res > 0) {
      return server;
    }
    return null;
  }

  private Boolean componentExists(ServerModel model) {
    String query = String.format("SELECT 1 FROM "
            + "Server WHERE _serialServer = ?;");

    List<Map<String, Object>> queryForList = conn.queryForList(query, model.getSerialServer());

    if (!queryForList.isEmpty()) {
      String exists = componentExists(model, true);
      if (exists == null) {
        String queryInsert = "INSERT INTO Server (_serialServer, isActive, description, fkHospital) VALUES (?, ?, ?, ?)";
        System.out.println(String.format("Inserindo servidor AWS: ", model.getSerialServer()));
        LOGGER.info(String.format("Inserindo servidor AWS: ", model.getSerialServer()), "components");
        System.out.println(model);
        Integer res = conn.updateAws(queryInsert, true, model.getSerialServer(), model.getIsActive(), model.getDescription(), model.getFkHospital());

      } else {

        System.out.println("Server already exists in aws database");
      }
    }
    return !queryForList.isEmpty();
  }

  private String componentExists(ServerModel model, boolean aws) {
    String query = String.format("SELECT top 1 _serialServer id FROM "
            + "Server WHERE _serialServer = ?;");

    List<Map<String, Object>> queryForList = null;
    queryForList = aws
            ? conn.queryForList(query, true, model.getSerialServer())
            : conn.queryForList(query, model.getSerialServer());

    return queryForList != null
            && !queryForList.isEmpty()
            ? queryForList.get(0).get("id").toString() : null;
  }

  private Integer getServerIdPerSerial(String serial) {
    String query = String.format("SELECT TOP 1 _serialServer id FROM "
            + "Process Server _serialServer = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);

    return (int) queryForList.get(0).get("id");
  }

}
