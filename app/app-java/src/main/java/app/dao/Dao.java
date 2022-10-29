package app.dao;

import app.database.Database;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Dao {
  
  protected JdbcTemplate conn;

  public Dao() {
    this.conn = Database.getConn();
  }

}
