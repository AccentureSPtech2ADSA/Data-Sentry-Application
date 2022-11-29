package app.dao;

import app.model.ComponentTypeEnum;
import app.model.LogComponentProcess;
public class LogProcessComponentDAO extends Dao {

  public Integer save(LogComponentProcess model, String date) {
    if(model.getComponent().getComponentType() == ComponentTypeEnum.DISCO){
      model.setUsageComponent(model.getUsageComponent() * 10);
    }
    String query = "INSERT INTO LogComponentPerProcess (fkProcess, fkComponentType, fkComponentServer, usageComponent, createdAt)"
            + "VALUES (?, ?, ?, ?, ?)";
    conn.updateAws(
            query,
            true,
            model.getProcess().getId(),
            model.getComponent().getComponentType().getIdTypeComponent(),
            model.getComponent().getIdComponent(),
            model.getFormatedUsage(),
            date
    );
    return conn.update(
            query,
            model.getProcess().getId(),
            model.getComponent().getComponentType().getIdTypeComponent(),
            model.getComponent().getIdComponent(),
            model.getFormatedUsage(),
            date
    );
  }

}
