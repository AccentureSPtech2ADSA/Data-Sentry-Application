package app.database;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database {

  private static JdbcTemplate conn = null;
  public static Ambiente azure = Ambiente.AZURE_CLOUD;
  public static Ambiente docker = Ambiente.DOCKER_LOCAL;
  public static Ambiente local = Ambiente.LOCAL_MSSQL;

  public static JdbcTemplate getConn() {

    if (conn == null) {
      try {

        conn = new MyJdbcTemplate(getListJdbcTemplates());

      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Houve algum erro ao conectar no ambiente");
      }
    }
    return conn;
  }

  private static List<JdbcTemplate> getListJdbcTemplates() {
    BasicDataSource datasourceAzure = azure.getDatasource();
//    BasicDataSource datasourceAws = azure.getDatasource();
    BasicDataSource datasourceLocal = local.getDatasource();
    List<JdbcTemplate> templates = new ArrayList<>();
    if (datasourceAzure != null) {
      templates.add(new JdbcTemplate(datasourceAzure));
    }
//    if (datasourceAws != null) {
//      templates.add(new JdbcTemplate(datasourceAws));
//    }
    if (datasourceLocal != null) {
      templates.add(new JdbcTemplate(datasourceLocal));
    }

    return templates;
  }

}
