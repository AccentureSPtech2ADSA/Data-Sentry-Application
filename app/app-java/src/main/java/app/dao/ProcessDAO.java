package app.dao;

import app.controller.ProcessController;
import app.model.ProcessModel;
import java.util.List;
import java.util.Map;

public class ProcessDAO extends Dao {

  public ProcessModel saveProcess(ProcessModel model) {
    if (!processExists(model.getName())) {
      String query = "INSERT INTO Process (name) "
              + "VALUES (?)";

      System.out.println(String.format("Inserindo processo: ", model.getName()));

      Integer res = conn.update(query, model.getName());
      if (res > 0) {
        model.setId((long) getLastInsertedProcessId());
      }else{
        System.out.println("Houve algum erro.");
      }
      return model;
    }
    model.setId((long) getProcessIdPerName(model.getName()));
    return model;
  }

  private Boolean processExists(String name) {
    String query = String.format("SELECT TOP 1 1 FROM "
            + "Process WHERE name = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, name);

    return !queryForList.isEmpty();
  }

  private Integer getLastInsertedProcessId() {
    String query = String.format("SELECT TOP 1 _idProcess id FROM "
            + "Process ORDER BY _idProcess DESC");

    List<Map<String, Object>> queryForList = conn.queryForList(query);

    return (int) queryForList.get(0).get("id");
  }

  private Integer getProcessIdPerName(String name) {
    String query = String.format("SELECT TOP 1 _idProcess id FROM "
            + "Process WHERE name = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, name);

    return (int) queryForList.get(0).get("id");
  }
  
  public static void main(String[] args) {
    
    ProcessDAO dao = new ProcessDAO();
    ProcessController controller = new ProcessController();
    
    controller.getProcessPerMemo()
            .forEach(p->{
              System.out.println(dao.saveProcess(p));
            });
  }
}
