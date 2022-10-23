
package app.controller;

import app.model.ProcessadorModel;
import com.github.britooo.looca.api.core.Looca;
import java.io.IOException;

public class ProcessadorController {
    
    Looca looca;
    ServerController serverController;
    
    public ProcessadorController(){
        this.looca = new Looca();
        this.serverController = new ServerController();
    }
    
    public ProcessadorModel getProcessador() throws IOException, ClassNotFoundException{
        String serial = looca.getProcessador().getId();
        String model = looca.getProcessador().getNome();
        String brand = looca.getProcessador().getFabricante();
        Double frequenciaCpu = looca.getProcessador().getFrequencia().doubleValue() * 0.000000001;
        String replaceVirgulaFrequenciaCpu = frequenciaCpu.toString().replaceAll("\\,", ".");
        String fkServer = serverController.getSerialServer();
        
        return new ProcessadorModel(serial, model, brand, replaceVirgulaFrequenciaCpu, fkServer);
    }
}
