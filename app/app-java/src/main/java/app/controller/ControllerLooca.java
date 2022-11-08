package app.controller;

import com.github.britooo.looca.api.core.Looca;

public abstract class ControllerLooca {
  protected Looca looca;

  public ControllerLooca() {
    looca = new Looca();
  }
}
