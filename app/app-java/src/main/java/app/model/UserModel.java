package app.model;

public class UserModel {

  private Integer _idUser;
  private Integer fkHospital;
  private String name;
  private String email;

  public Integer getIdUser() {
    return _idUser;
  }

  public void setIdUser(Integer _idUser) {
    this._idUser = _idUser;
  }

  public Integer getFkHospital() {
    return fkHospital;
  }

  public void setFkHospital(Integer fkHospital) {
    this.fkHospital = fkHospital;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("UserModel = [");
    sb.append("\n    _idUser=").append(_idUser);
    sb.append("\n    fkHospital=").append(fkHospital);
    sb.append("\n    name=").append(name);
    sb.append("\n    email=").append(email);
    sb.append("\n],\n");
    return sb.toString();
  }

}
