
package app.model;

public class ServerModel {
    
    private String _serialServer;
    private String isActive;
    private String description;
    private Integer fkHospital;

    public ServerModel(String _serialServer, String description, Integer fkHospital) {
        this._serialServer = _serialServer;
        this.isActive = "A";
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
    
}
