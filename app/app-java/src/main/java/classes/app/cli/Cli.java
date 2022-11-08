package classes.app.cli;

public class Cli {

  private CliStrategy console;

  public Cli() {
    console = new ConsoleCliStrategy();
    if (!console.hasConsole()) {
      console = new DebugCliStrategy();
    }
  }

  public Boolean hasConsole() {
    return console.hasConsole();
  }

  public CliStrategy getConsole() {
    return console;
  }

  public boolean welcome() {
    System.out.println("Olá! Seja bem vindo ao sistema Datasentry!");
    System.out.println("Você como usuário " + System.getenv("USERNAME") + " deve anteriormente ter cadastrado \num hospital no nosso site http://datasentry.sysnet.net, correto? (Y/N)");
    String resposta = console.readLine();
    if (resposta.equalsIgnoreCase("Y")) {
      System.out.println("Perfeito! Vamos seguir com o processo!");
      return true;
    }else{
      System.out.println("Eita!! Você acabou pulando um passo aqui.");
      System.out.println("Você precisa antes cadastrar seu hospital em nosso sistema! \nCom isso poderemos prosseguir");

      return false;
    }
  }

}
