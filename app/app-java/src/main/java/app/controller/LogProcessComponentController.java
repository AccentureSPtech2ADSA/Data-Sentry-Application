package app.controller;

import app.model.ComponentModel;
import app.model.LogComponentProcess;
import app.model.ProcessModel;
import java.util.ArrayList;
import java.util.List;

public class LogProcessComponentController {

  public List<LogComponentProcess> getLogsPerMemo(List<ProcessModel> processes, ComponentModel ram, ComponentModel cpu, ComponentModel disco) {
    List<LogComponentProcess> logs = new ArrayList<>();

    processes
            .forEach(proccess -> {
              LogComponentProcess ramLog = new LogComponentProcess(ram, proccess);
              LogComponentProcess cpuLog = new LogComponentProcess(cpu, proccess);
              LogComponentProcess discoLog = new LogComponentProcess(disco, proccess);
              
              logs.add(ramLog);
              logs.add(cpuLog);
              logs.add(discoLog);
            });
    return logs;
  }

}
