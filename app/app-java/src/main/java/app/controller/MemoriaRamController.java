
package app.controller;

import app.model.MemoriaRamModel;
import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;

public class MemoriaRamController {
    
    Looca looca;
    ServerController sc;
    
    public MemoriaRamController(){
        this.looca = new Looca();
        this.sc = new ServerController();
    }
    
    public MemoriaRamModel getMemoriaRam() throws IOException, ClassNotFoundException {
        String serial = "";
        String model = "Memoria Ram";
        String brand = "";
        Double memoriaTotal = Math.floor(looca.getMemoria().getTotal().doubleValue() * 0.000000001);
        String replaceVirgulaMemoriaTotal = memoriaTotal.toString().replaceAll("\\,", ".");
        String fkServer = sc.getSerialServer();
        
        return new MemoriaRamModel(serial, model, brand, replaceVirgulaMemoriaTotal, fkServer);
    }
    
}
