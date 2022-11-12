package app.dao;

import app.controller.ServerController;
import app.model.ServerModel;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServerDAO extends Dao{

  public ServerModel save(ServerModel server) {
    if(componentExists(server.getSerialServer())){
        System.out.println("Servidor com serial: "+ server.getSerialServer()+ " ja foi inserido.");
      return server;
    }
    String query = "INSERT INTO Server (_serialServer, isActive, description, fkHospital) "
            + "VALUES (?, ?, ?, ?)";
    System.out.println(String.format("Inserindo servidor: ", server.getSerialServer()));
    System.out.println(server);
    Integer res = conn.update(query, server.getSerialServer(), server.getIsActive(), server.getDescription(), server.getFkHospital());
    if(res > 0){
      return server;
    }
    return null;
  }
  
  private Boolean componentExists(String serial) {
    String query = String.format("SELECT 1 FROM "
            + "Server WHERE _serialServer = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);
    
    return !queryForList.isEmpty();
  }
  private Integer getServerIdPerSerial(String serial){
    String query = String.format("SELECT TOP 1 _serialServer id FROM "
            + "Process Server _serialServer = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);

    return (int) queryForList.get(0).get("id");
  }
  
}
