package app.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database {

  private static final String USER = "datasentry";
  private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private static final String PASS = "#Gfgrupo1";
    private static final String DB_URL = "jdbc:sqlserver://;serverName=datasentry.database.windows.net;encrypt=true;trustServerCertificate=true;databaseName=datasentry";

  private static JdbcTemplate conn = null;

  public static JdbcTemplate getConn() {

    if (conn == null) {
      try {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
        
        conn = new JdbcTemplate(dataSource);
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return conn;
  }
 
}
