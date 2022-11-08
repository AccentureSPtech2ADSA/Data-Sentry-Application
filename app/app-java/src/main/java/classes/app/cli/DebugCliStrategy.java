package classes.app.cli;

import java.util.Scanner;

public class DebugCliStrategy extends CliStrategy{
  private final Scanner console;
  public DebugCliStrategy(){
    console = new Scanner(System.in);
  }
  @Override
  public String readLine() {
    return console.nextLine();
  }

  @Override
  public String readPass() {
    return readLine();
  }

  @Override
  public Boolean hasConsole() {
    return console != null;
  }
  
}
