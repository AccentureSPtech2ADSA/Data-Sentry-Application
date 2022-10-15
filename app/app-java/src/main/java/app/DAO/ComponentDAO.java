/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.DAO;

import app.database.Database;
import app.looca.LoocaDisco;
import app.model.DiscoModel;
import java.util.List;
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
  
  
  
  
  
  
  
  
//  public static void main(String[] args) {
//    LoocaDisco ld = new LoocaDisco();
//    List<DiscoModel> discos = ld.pegarListaDiscos();
//    
//    ComponentDAO dao = new ComponentDAO();
//    System.out.println("Executando...");
////    Looca looca = new Looca();
//    System.out.println(discos.get(0).getTamanhoDiscoFormatado());
//    for (DiscoModel disco : discos) {
//      System.out.println(disco);
//      int dado = dao.insertDisco(disco);
//      System.out.println(dado);
//    }
//    
//  }
}
