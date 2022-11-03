
package classes.app.cli;

public abstract class CliStrategy {
  public abstract String readLine();
  public abstract String readPass();
  public abstract Boolean hasConsole();
}
