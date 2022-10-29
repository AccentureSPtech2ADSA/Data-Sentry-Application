package app.controller.component;

import app.controller.ControllerLooca;
import app.model.ComponentModel;

public abstract class ComponentControllerStrategy extends ControllerLooca{

  public abstract ComponentModel getComponent(String fkServer);

}
