package app.model;

public class ProcessModel {

  private Long id;
  private String name;
  private Double useMem;
  private Double useCpu;
  private Long useBytesDisk;
  private Long pid;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getUseMem() {
    return useMem;
  }

  public void setUseMem(Double useMem) {
    this.useMem = useMem;
  }

  public Double getUseCpu() {
    return useCpu;
  }

  public void setUseCpu(Double useCpu) {
    this.useCpu = useCpu;
  }

  public Long getUseBytesDisk() {
    return useBytesDisk;
  }

  public void setUseBytesDisk(Long useBytesDisk) {
    this.useBytesDisk = useBytesDisk;
  }

  public Long getPid() {
    return pid;
  }

  public void setPid(Long pid) {
    this.pid = pid;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ProcessModel = [");
    sb.append("\nid : ").append(id);
    sb.append("\nname : ").append(name);
    sb.append("\nuseMem : ").append(useMem);
    sb.append("\nuseCpu : ").append(useCpu);
    sb.append("\nuseBytesDisk : ").append(useBytesDisk);
    sb.append("\npid : ").append(pid);
    sb.append("\n],");
    return sb.toString();
  }

  
}
