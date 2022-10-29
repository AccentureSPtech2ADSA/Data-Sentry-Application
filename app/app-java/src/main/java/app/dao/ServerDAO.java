package app.dao;

import app.controller.ServerController;
import app.model.ServerModel;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServerDAO extends Dao{

  public Integer save(ServerModel server) {
    if(componentExists(server.getSerialServer())){
        System.out.println("Servidor com serial: "+ server.getSerialServer()+ " ja foi inserido.");
      return -1;
    }
    String query = "INSERT INTO Server (_serialServer, isActive, description, fkHospital) "
            + "VALUES (?, ?, ?, ?)";
    System.out.println(String.format("Inserindo servidor: ", server.getSerialServer()));
    System.out.println(server);
    return conn.update(query, server.getSerialServer(), server.getIsActive(), server.getDescription(), server.getFkHospital());
  }
  
  public Boolean componentExists(String serial) {
    String query = String.format("SELECT 1 FROM "
            + "Server WHERE _serialServer = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);
    
    return !queryForList.isEmpty();
  }
  
  public static void main(String[] args) throws Exception {
    ServerDAO dao = new ServerDAO();
    ServerController server = new ServerController();
    
    try {
      dao.save(server.getServer());
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Erro: "+e.getMessage());
    }
  }
}
