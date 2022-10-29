package app.dao;

import app.model.ComponentModel;
import java.util.List;
import java.util.Map;
public class ComponentDAO extends Dao {

  private static final String SERIAL = "serial";
  private static final String MODEL = "model";
  private static final String BRAND = "brand";
  private static final String MAXUSE = "maxUse";
  private static final String FKSERVER = "fkServer";
  private static final String FKTYPE = "fkComponentType";

  public ComponentDAO(){
    ComponentTypeDAO types = new ComponentTypeDAO();
    types.saveComponentTypes();
  }
  
  public Integer save(ComponentModel component) {
    if(componentExists(component.getSerial())){
      System.out.println(component.getComponentType().getDescricao()+" com serial: "+ component.getSerial() + " ja foi inserido.");
      return -1;
    }
    String querySave = String.format("INSERT INTO ComponentServer"
            + "(%s, %s, %s, %s, %s, %s) VALUES (?,?,?,?,?,?)",
            ComponentDAO.SERIAL, ComponentDAO.MODEL, ComponentDAO.BRAND,
            ComponentDAO.MAXUSE, ComponentDAO.FKSERVER, ComponentDAO.FKTYPE);

    System.out.println(String.format("Inserindo %s: ", component.getComponentType().getDescricao()));
    System.out.println(component);
    return conn.update(
            querySave,
            component.getSerial(),
            component.getModel(),
            component.getBrand(),
            component.getMaxUseFormated(),
            component.getFkServer(),
            component.getComponentType().getIdTypeComponent()
    );
  }

  public Boolean componentExists(String serial) {
    String query = String.format("SELECT 1 FROM "
            + "ComponentServer WHERE serial = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);
    
    return queryForList.size() > 0;
  }

}
