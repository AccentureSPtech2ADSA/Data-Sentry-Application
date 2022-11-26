package app.dao;

import app.model.ComponentModel;
import app.model.ProcessModel;
import app.util.LOGGER;
import java.util.List;
import java.util.Map;

public class ProcessDAO extends Dao {

  public ProcessModel saveProcess(ProcessModel model) throws Exception {
    if (!processExists(model)) {
      setComponent(model);
    }
    model.setId((long) getProcessIdPerName(model.getName()));
    return model;
  }

  private ProcessModel setComponent(ProcessModel model) throws Exception {
    String query = "INSERT INTO Process (name) "
            + "VALUES (?)";

      String msg = String.format("Inserindo processo: ", model.getName());


      System.out.println(msg);
      LOGGER.info(msg, "components");

    System.out.println(model);

    Integer res = conn.update(query, model.getName());
    if (res > 0) {
      model.setId((long) getLastInsertedProcessId());

      setComponentAws(model);
    } else {
      System.out.println("Houve algum erro.");
        LOGGER.error("Houve algum erro", "components");

    }
    return model;
  }

  private ProcessModel setComponentAws(ProcessModel model) throws Exception {
    int exists = processExists(model, true);
    if (exists <= 0) {

      String query = "INSERT INTO Process (_idProcess, name) VALUES (?,?)";

      System.out.println("Set Process in AWS");

      int res = conn.updateAws(
              query,
              true,
              model.getId(),
              model.getName());

    } else {
      model.setId((long) exists);
    }
    return model;
  }

  private Boolean processExists(ProcessModel model) throws Exception {
    String query = String.format("SELECT TOP 1 _idProcess id FROM Process p WHERE name = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, model.getName());

    if (!queryForList.isEmpty()) {

      int id = (int) queryForList.get(0).get("id");

      model.setId((long) id);

      setComponentAws(model);

    }
    return !queryForList.isEmpty();
  }

  private int processExists(ProcessModel model, boolean aws) throws Exception {
    String query = String.format("SELECT TOP 1 _idProcess id FROM Process p WHERE name = ?");

    List<Map<String, Object>> queryForList = null;
    queryForList = aws
            ? conn.queryForList(query, true, model.getName())
            : conn.queryForList(query, model.getName());

    return queryForList != null
            && !queryForList.isEmpty()
            ? (int) queryForList.get(0).get("id") : -1;
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
