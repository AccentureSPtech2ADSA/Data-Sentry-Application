package app.controller.component;

import app.model.ComponentModel;
import app.model.ComponentTypeEnum;
import app.model.CpuComponentModel;
import com.github.britooo.looca.api.group.processador.Processador;

public class ProcessadorControllerStrategy extends ComponentControllerStrategy {

  private Processador processador;
  public ProcessadorControllerStrategy(){
    processador = looca.getProcessador();
  }
  @Override
  public ComponentModel getComponent(String fkServer) {
    CpuComponentModel model = new CpuComponentModel();
    model.setComponentType(ComponentTypeEnum.CPU);
    model.setBrand(processador.getFabricante());
    model.setFkServer(fkServer);
    model.setModel(processador.getNome());
    model.setMaxUse(processador.getFrequencia() * .000000001);
    model.setSerial(processador.getId());
    model.setQtdNucles(processador.getNumeroCpusLogicas());
    return model;
  }
}
