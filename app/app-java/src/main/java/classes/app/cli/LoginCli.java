package classes.app.cli;

public class LoginCli extends Cli{
  private String email;
  private String pass;
  
  public void readEmail(){
    System.out.println("Digite seu email");
    email = getConsole().readLine();
  }
  public void readPassword(){
    System.out.println("Digite sua senha");
    pass = getConsole().readPass();
    System.out.println("Pass: "+ pass);
  }

  public String getEmail() {
    return email;
  }

  public String getPass() {
    return pass;
  }
}
