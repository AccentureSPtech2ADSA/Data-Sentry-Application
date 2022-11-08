package app.database;

import org.springframework.jdbc.core.JdbcTemplate;

public class Database {

  private static JdbcTemplate conn = null;
  public static Ambiente ambiente = Ambiente.AZURE_CLOUD;
  
  public static JdbcTemplate getConn() {
    
    if (conn == null) {
      try {
        conn = new JdbcTemplate(ambiente.getDatasource());
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Houve algum erro ao conectar no ambiente " + ambiente);
      }
    }
    return conn;
  }

}
