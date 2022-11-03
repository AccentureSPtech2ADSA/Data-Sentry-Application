
package classes.app.cli;

import java.io.Console;

public class ConsoleCliStrategy extends CliStrategy{
  private final Console console;
  public ConsoleCliStrategy(){
    console = System.console();
  }
  @Override
  public String readLine() {
    return console.readLine();
  }

  @Override
  public String readPass() {
    return new String(console.readPassword());
  }

  @Override
  public Boolean hasConsole() {
    return console != null;
  }
  
}
