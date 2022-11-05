package app.model;

import java.util.Date;
import java.util.List;

public class LogComponentProcess {

  private ProcessModel process;
  private ComponentModel component;
  private Date date;
  private Double usageComponent;

 

  public LogComponentProcess(ComponentModel component, ProcessModel process) {
    this.component = component;
    this.process = process;
    Double usage = 0.0;
    if (component.getComponentType() == ComponentTypeEnum.CPU) {
      usage = process.getUseCpu();
    } else if (component.getComponentType() == ComponentTypeEnum.RAM) {
      usage = process.getUseMem();
    } else if (component.getComponentType() == ComponentTypeEnum.DISCO) {
      usage = process.getUseBytesDisk() * .000000001;
    }
    this.usageComponent = usage;
  }

  public ComponentModel getComponent() {
    return component;
  }

  public void setComponent(ComponentModel component) {
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
    return List.of(
            new LogComponentProcess(this.component, this.process),
            new LogComponentProcess(this.component, this.process),
            new LogComponentProcess(this.component, this.process)
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("LogComponentProcess = [");
    sb.append("\nprocess: ").append(process);
    sb.append("\ncomponent: ").append(component);
    sb.append("\nusageComponent: ").append(usageComponent);
    sb.append(']').append(",\n");
    sb.append("-".repeat(40));
    return sb.toString();
  }

  public Double getFormatedUsage(){
    return Double.valueOf(String.format("%.3f",getUsageComponent()).replaceAll(",", "."));
  }
}
