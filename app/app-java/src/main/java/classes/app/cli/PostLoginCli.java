package classes.app.cli;

import app.controller.ProcessController;
import app.controller.ServerController;
import app.controller.UserSingleton;
import app.controller.component.DiscoControllerStrategy;
import app.controller.component.ProcessadorControllerStrategy;
import app.controller.component.RamControllerStrategy;
import app.dao.ComponentDAO;
import app.dao.LogProcessComponentDAO;
import app.dao.ProcessDAO;
import app.dao.ServerDAO;
import app.model.ComponentModel;
import app.model.LogComponentProcess;
import app.model.ProcessModel;
import app.model.ServerModel;
import app.model.UserModel;
import app.util.LOGGER;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PostLoginCli {

  public static void exec(UserModel user) {
    // set server;
    try {
      ServerDAO serverDAO = new ServerDAO();
      ServerModel server = serverDAO.save(new ServerController().getServer(UserSingleton.user.getFkHospital()));
      if (server == null) {
        System.out.println("Servidor parado ou apagado.");
        return;
      }
      System.out.println("Serial server: " + server.getSerialServer());

      ComponentDAO componentDAO = new ComponentDAO();
      ComponentModel ram = componentDAO.save(new RamControllerStrategy().getComponent(server.getSerialServer()));
      ComponentModel cpu = componentDAO.save(new ProcessadorControllerStrategy().getComponent(server.getSerialServer()));
      List<ComponentModel> discos = new ArrayList<>();
      new DiscoControllerStrategy().getComponents(server.getSerialServer())
              .forEach(d -> {
                try {
                  ComponentModel save = componentDAO.save(d);
                  discos.add(save);
                } catch (Exception e) {
                  System.out.println("Houve algo de errado ao inserir disco.");
                  LOGGER.error(e.getMessage(), "components");
                  LOGGER.error(e.getMessage(), "Houve algo de errado ao inserir disco.");
                }
              });

      new Timer().scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {

          if (!serverDAO.componentExists(server) && server.getIsActive().equalsIgnoreCase("S")) {
            LOGGER.warning("Servidor Parado... Mude no site para voltar a captar dados", "components");
          } else {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:s.S");
            String now = sdf.format(date);

            ProcessDAO processDao = new ProcessDAO();
            LogProcessComponentDAO logDao = new LogProcessComponentDAO();
            System.out.println("Monitorando: " + now);
            new ProcessController()
                    .getProcessPerMemo()
                    .forEach(process -> {
                      try {

                        ProcessModel saveProcess = processDao.saveProcess(process);
                        // get logs too
                        LogComponentProcess logCpu = new LogComponentProcess(cpu, saveProcess);
                        LogComponentProcess logDisco = new LogComponentProcess(discos.get(0), saveProcess);
                        LogComponentProcess logRam = new LogComponentProcess(ram, saveProcess);

                        logDao.save(logCpu, now);
                        logDao.save(logDisco, now);
                        logDao.save(logRam, now);
                      } catch (Exception e) {
                        e.printStackTrace();
                        LOGGER.error(e.getMessage(), "components");
                      }
                    });
          }

        }
      }, 0, 1000 * 60);

    } catch (Exception e) {
      e.printStackTrace();
      LOGGER.error(e.getMessage(), "components");
      System.out.println("Houve algo de errado.");
    }
  }

}
