package classes.app.cli;

import app.controller.UserSingleton;
import app.dao.UserDAO;
import app.model.UserModel;

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
  }

  public String getEmail() {
    return email;
  }

  public String getPass() {
    return pass;
  }
  
  public static void doLogin(LoginCli cli) {
    cli.readEmail();
    cli.readPassword();

    UserDAO userDao = new UserDAO();
    UserModel user = userDao.login(cli.getEmail(), cli.getPass());
    UserSingleton.user = user;
    if (user.getFkHospital() != null && user.getFkHospital() > 0) {
      // segue o processo
      PostLoginCli.exec(user);
    } else {
      doLogin(cli);
    }
  }
}
