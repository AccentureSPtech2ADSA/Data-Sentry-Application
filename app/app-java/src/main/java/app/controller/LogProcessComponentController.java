package app.controller;

import app.model.LogComponentProcess;
import app.model.ProcessModel;
import java.util.ArrayList;
import java.util.List;

public class LogProcessComponentController {

  public List<LogComponentProcess> getLogsPerMemo(List<ProcessModel> processes) {
    List<LogComponentProcess> logs = new ArrayList<>();

    processes
            .forEach(proccess -> {
              LogComponentProcess logModel = new LogComponentProcess(proccess);
              logModel.getLogsPerProcess()
                      .forEach(log -> logs.add(log));
            });
    return logs;
  }

}
