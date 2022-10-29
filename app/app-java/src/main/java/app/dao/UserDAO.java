package app.dao;

import app.controller.UserController;
import app.model.UserModel;
import java.util.List;
import java.util.Map;

public class UserDAO extends Dao {

  public void login(String email, String senha) {
    UserModel user = new UserModel();
    String query = "EXEC sp_loginUser ?, ?";
    List<Map<String, Object>> queryForList = conn.queryForList(query, email, senha);

    if (!queryForList.isEmpty()) {
      queryForList
              .forEach(map -> {

                String name = (String) map.get("name");
                System.out.println("Login efetuado com sucesso");
                System.out.println("Seja bem vindo(a) "+ name);
                Integer id = (int) map.get("id");
                Integer fkHospital = (int) map.get("fkHospital");

                user.setIdUser(id);
                user.setName(name);
                user.setFkHospital(fkHospital);
                user.setEmail(email);

                UserController.USER = user;
              });
    } else {
      System.out.println("Email e senha incorretos.");
    }
  }

  public static void main(String[] args) {
    UserDAO dao = new UserDAO();
    dao.login("albert@admin.com", "admin");
  }
}
