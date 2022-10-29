package app.controller.component;

import app.model.ComponentModel;
import app.model.ComponentTypeEnum;
import com.github.britooo.looca.api.group.memoria.Memoria;

public class RamControllerStrategy extends ComponentControllerStrategy {

  private Memoria ram;
  public RamControllerStrategy(){
    ram = looca.getMemoria();
  }
  @Override
  public ComponentModel getComponent(String fkServer) {
    ComponentModel model = new ComponentModel();
    model.setBrand("Generic");
    model.setComponentType(ComponentTypeEnum.RAM);
    model.setModel("RAM");
    model.setFkServer(fkServer);
    model.setSerial(String.valueOf(ram.hashCode()));
    model.setMaxUse(ram.getTotal() * 0.000000001);
    return model;
  }
}
