package app.model;

public class ServerModel {

  private String _serialServer;
  private String isActive = "A";
  private String description;
  private Integer fkHospital;

  public ServerModel(String _serialServer, String description, Integer fkHospital) {
    this._serialServer = _serialServer;
    this.description = description;
    this.fkHospital = fkHospital;
  }

  public String getSerialServer() {
    return _serialServer;
  }

  public void setSerialServer(String _serialServer) {
    this._serialServer = _serialServer;
  }

  public String getIsActive() {
    return isActive;
  }

  public void setIsActive(String isActive) {
    this.isActive = isActive;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getFkHospital() {
    return fkHospital;
  }

  public void setFkHospital(Integer fkHospital) {
    this.fkHospital = fkHospital;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ServerModel = [");
    sb.append("\n    _serialServer : ").append(_serialServer);
    sb.append("\n    IsActive : ").append(isActive);
    sb.append("\n    Description : ").append(description);
    sb.append("\n    FkHospital : ").append(fkHospital);
    sb.append("\n],\n");
    return sb.toString();
  }

}
