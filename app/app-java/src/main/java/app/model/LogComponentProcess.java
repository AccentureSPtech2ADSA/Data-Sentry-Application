package app.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LogComponentProcess {

  private ProcessModel process;
  private ComponentTypeEnum component;
  private Date date;
  private Double usageComponent;

  public LogComponentProcess(ProcessModel process) {
    this.process = process;
  }
  private LogComponentProcess(ComponentTypeEnum component) {
    this.component = component;
    Double usage = 0.0;
    switch (component) {
      case CPU:
        usage = process.getUseCpu();
        break;
      case RAM:
        usage = process.getUseMem();
        break;
      case DISCO:
        usage = process.getUseBytesDisk() * .000000001;
        break;
      default:
        System.out.println("Invalided Component");
    }

    this.usageComponent = usage;
  }

  public ComponentTypeEnum getComponent() {
    return component;
  }

  public void setComponent(ComponentTypeEnum component) {
    this.component = component;
  }

  public ProcessModel getProcess() {
    return process;
  }

  public void setProcess(ProcessModel process) {
    this.process = process;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getUsageComponent() {
    return usageComponent;
  }

  public void setUsageComponent(Double usageComponent) {
    this.usageComponent = usageComponent;
  }

  public List<LogComponentProcess> getLogsPerProcess() {
    return Arrays.asList(
            new LogComponentProcess(ComponentTypeEnum.CPU),
            new LogComponentProcess(ComponentTypeEnum.RAM),
            new LogComponentProcess(ComponentTypeEnum.DISCO)
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("LogComponentProcess{");
    sb.append("process=").append(process);
    sb.append(", component=").append(component);
    sb.append(", usageComponent=").append(usageComponent);
    sb.append('}');
    return sb.toString();
  }
  
  
}
