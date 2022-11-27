package app.dao;

import app.model.UserModel;
import app.util.LOGGER;
import java.util.List;
import java.util.Map;

public class UserDAO extends Dao {

  public UserModel login(String email, String senha) {
    UserModel user = new UserModel();
    String query = "EXEC sp_loginUser ?, ?";
    List<Map<String, Object>> queryForList = conn.queryForList(query, email, senha);

    if (!queryForList.isEmpty()) {
      queryForList
              .forEach(map -> {

                String name = (String) map.get("name");
                System.out.println("Login efetuado com sucesso");
                LOGGER.info("Login efetuado com sucesso", "users");
                String msg_welcome = "Seja bem vindo(a) " + name;
                System.out.println(msg_welcome);
                LOGGER.info(msg_welcome, "users");
                Integer id = (int) map.get("id");
                Integer fkHospital = (int) map.get("fkHospital");

                user.setIdUser(id);
                user.setName(name);
                user.setFkHospital(fkHospital);
                user.setEmail(email);

              });
    } else {
      System.out.println("Email e senha incorretos.");
      LOGGER.warning("Email e senha incorretos.", "users");
    }
    
    return user;
  }

}
