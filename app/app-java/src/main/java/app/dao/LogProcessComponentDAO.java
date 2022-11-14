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
//    System.out.println(String.format("Inserindo servidor: ", model.getSerialServer()));
//    System.out.println(model);
    return conn.update(
            query,
            model.getProcess().getId(),
            model.getComponent().getComponentType().getIdTypeComponent(),
            model.getComponent().getIdComponent(),
            model.getFormatedUsage(),
            date
    );
  }

  public static void main(String[] args) {
    
     Calendar c = Calendar.getInstance();
                   
                      Date date = new Date();
                      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:s.S");
                      String now = sdf.format(date);
                      System.out.println(now);
                      System.out.println(sdf.format(date));
  }
}
