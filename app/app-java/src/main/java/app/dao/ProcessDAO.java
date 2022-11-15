package app.dao;

import app.model.ProcessModel;
import app.util.LOGGER;
import java.util.List;
import java.util.Map;

public class ProcessDAO extends Dao {

  public ProcessModel saveProcess(ProcessModel model) {
    if (!processExists(model.getName())) {
      String msg = String.format("Inserindo processo: ", model.getName());
      String query = "INSERT INTO Process (name) "
              + "VALUES (?)";

      System.out.println(model);
      System.out.println(msg);
      LOGGER.info(msg, "components");

      Integer res = conn.update(query, model.getName());
      if (res > 0) {
        model.setId((long) getLastInsertedProcessId());
      }else{
        System.out.println("Houve algum erro.");
        LOGGER.error("Houve algum erro", "components");
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
  
}
