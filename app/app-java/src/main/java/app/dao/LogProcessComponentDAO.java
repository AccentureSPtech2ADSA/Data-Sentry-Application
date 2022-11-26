package app.dao;

import app.controller.ProcessController;
import app.model.LogComponentProcess;
import app.model.ProcessModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogProcessComponentDAO extends Dao {

  public Integer save(LogComponentProcess model, String date) {
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
