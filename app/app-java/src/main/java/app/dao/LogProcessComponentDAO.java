package app.dao;

import app.controller.ProcessController;
import app.model.LogComponentProcess;
import app.model.ProcessModel;

public class LogProcessComponentDAO extends Dao {

  public Integer save(LogComponentProcess model) {
    String query = "INSERT INTO LogComponentPerProcess (fkProcess, fkComponentType, fkComponentServer, usageComponent)"
            + "VALUES (?, ?, ?, ?)";
//    System.out.println(String.format("Inserindo servidor: ", model.getSerialServer()));
//    System.out.println(model);
    return conn.update(
            query,
            model.getProcess().getId(),
            model.getComponent().getComponentType().getIdTypeComponent(),
            model.getComponent().getIdComponent(),
            model.getFormatedUsage()
    );
  }

}
