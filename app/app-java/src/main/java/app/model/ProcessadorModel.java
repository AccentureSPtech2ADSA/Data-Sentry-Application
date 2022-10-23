
package app.model;

public class ProcessadorModel {
    
    private String serial;
    private String model;
    private String brand;
    private String maxUse;
    private String fkServer;

    public ProcessadorModel(String serial, String model, String brand, String maxUse, String fkServer) {
        this.serial = serial;
        this.model = model;
        this.brand = brand;
        this.maxUse = maxUse;
        this.fkServer = fkServer;
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

    public String getMaxUse() {
        return maxUse;
    }

    public void setMaxUse(String maxUse) {
        this.maxUse = maxUse;
    }

    public String getFkServer() {
        return fkServer;
    }

    public void setFkServer(String fkServer) {
        this.fkServer = fkServer;
    }
    
}
