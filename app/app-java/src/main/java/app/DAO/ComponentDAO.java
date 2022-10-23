/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.DAO;

import app.database.Database;
import app.controller.LoocaDisco;
import app.model.DiscoModel;
import org.springframework.jdbc.core.JdbcTemplate;
public class ComponentDAO {
  
  private static final String MODEL = "model";
  private static final String MAXUSE = "maxUse";
  private static final String FKSERVER = "fkServer";
  private static final String FKTYPE = "fkComponentType";
  
  
  private JdbcTemplate conn;
  public ComponentDAO(){
    conn = Database.getConn();
  }
  public Integer insertDisco(DiscoModel disco){
    String sql = String.format(
            "INSERT INTO ComponentServer (%s, %s, %s, %s)"
                    + " VALUES (?, ?, '1233', 1)",
            MODEL, MAXUSE, FKSERVER, FKTYPE);
    return conn.update(sql, disco.getNomeDisco(), disco.getTamanhoDiscoFormatado());
  }
  
}
