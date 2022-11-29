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
    
    if(server.getIsActive().equalsIgnoreCase("A")){
      
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
    }
    return null;
  }

  public Boolean componentExists(ServerModel model) {
    String query = String.format("SELECT top 1 isActive FROM "
            + "Server WHERE _serialServer = ?;");

    List<Map<String, Object>> queryForList = conn.queryForList(query, model.getSerialServer());

    if (!queryForList.isEmpty()) {
      String isActive = queryForList.get(0).get("isActive").toString();
      System.out.println("isActive " + isActive);
      model.setIsActive(isActive);
      if (isActive.equalsIgnoreCase("A")) {
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
      }else if(isActive.equalsIgnoreCase("S")){
        System.out.println("Servidor Parado...");
        return false;
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

  private Integer removeServerBySerial(String serial){
      String query = String.format("DELETE FROM Server WHERE _serialServer = ?");

    int res = conn.update(query, serial);

    return res;
  }
  
  
}
