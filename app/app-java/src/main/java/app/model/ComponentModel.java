package app.model;

public class ComponentModel {

  private String serial;
  private String model;
  private String brand;
  private Double maxUse;
  private String fkServer;
  private ComponentTypeEnum componentType;

  public Double getMaxUseFormated(){
     return Double.valueOf(String.format("%.2f", this.maxUse).replace(",","."));
  }
  public String getFkServer() {
    return fkServer;
  }

  public void setFkServer(String fkServer) {
    this.fkServer = fkServer;
  }

  
  public Double getMaxUse() {
    return maxUse;
  }

  public void setMaxUse(Double maxUse) {
    this.maxUse = maxUse;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public ComponentTypeEnum getComponentType() {
    return componentType;
  }

  public void setComponentType(ComponentTypeEnum componentType) {
    this.componentType = componentType;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ComponentModel = [\n");
    sb.append("    Serial : ").append(serial);
    sb.append("\n    Model : ").append(model);
    sb.append("\n    Brand : ").append(brand);
    sb.append("\n    MaxUse : ").append(maxUse);
    sb.append("\n    FkServer : ").append(fkServer);
    sb.append("\n    ComponentType : ").append(componentType.getDescricao());
    sb.append("\n],\n");
    return sb.toString();
  }
  
}
