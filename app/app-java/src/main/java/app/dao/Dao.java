package app.dao;

import app.database.Database;
import app.database.MyJdbcTemplate;

public abstract class Dao {
  
  protected MyJdbcTemplate conn;

  public Dao() {
    this.conn = (MyJdbcTemplate) Database.getConn();
  }

}
