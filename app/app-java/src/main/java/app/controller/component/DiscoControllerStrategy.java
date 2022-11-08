package app.controller.component;

import app.model.ComponentModel;
import app.model.ComponentTypeEnum;
import com.github.britooo.looca.api.group.discos.Disco;
import java.util.ArrayList;
import java.util.List;

public class DiscoControllerStrategy extends ComponentControllerStrategy {

  @Override
  public ComponentModel getComponent(String fkServer) {
    return null;
  }

  private ComponentModel getComponent(String fkServer, Disco disco) {
    ComponentModel model = new ComponentModel();
    model.setBrand(disco.getModelo());
    model.setSerial(disco.getSerial());
    model.setModel(disco.getNome());
    model.setComponentType(ComponentTypeEnum.DISCO);
    model.setMaxUse(disco.getTamanho() * .000000001);
    model.setFkServer(fkServer);
    return model;
  }

  public List<ComponentModel> getComponents(String fkServer) {
    List<Disco> discos = looca.getGrupoDeDiscos().getDiscos();
    List<ComponentModel> models = new ArrayList<>();
    discos
            .stream()
            .forEach(disco -> {
              if (!disco.getModelo().equals("Logical Volume Group")) {
                models.add(getComponent(fkServer, disco));
              }
            });
    return models;
  }

}
