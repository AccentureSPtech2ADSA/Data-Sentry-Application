package app.dao;

import app.controller.component.DiscoControllerStrategy;
import app.controller.component.ProcessadorControllerStrategy;
import app.controller.component.RamControllerStrategy;
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

  public ComponentDAO() {
    ComponentTypeDAO types = new ComponentTypeDAO();
    types.saveComponentTypes();
  }

  public ComponentModel save(ComponentModel component) throws Exception {
    if (componentExists(component.getSerial())) {
      System.out.println(component.getComponentType().getDescricao() + " com serial: " + component.getSerial() + " ja foi inserido.");
      component.setIdComponent(getProcessIdPerSerial(component.getSerial()));
      return component;
    }
    String querySave = String.format("INSERT INTO ComponentServer"
            + "(%s, %s, %s, %s, %s, %s) VALUES (?,?,?,?,?,?)",
            ComponentDAO.SERIAL, ComponentDAO.MODEL, ComponentDAO.BRAND,
            ComponentDAO.MAXUSE, ComponentDAO.FKSERVER, ComponentDAO.FKTYPE);

    System.out.println(String.format("Inserindo %s: ", component.getComponentType().getDescricao()));
    System.out.println(component);
    Integer res = conn.update(
            querySave,
            component.getSerial(),
            component.getModel(),
            component.getBrand(),
            component.getMaxUseFormated(),
            component.getFkServer(),
            component.getComponentType().getIdTypeComponent()
    );
    if (res > 0) {
      component.setIdComponent(getLastInsertedProcessId());
      return component;
    }
    throw new Exception("Houve algo errado.");
  }

  private Integer getLastInsertedProcessId() {
    String query = String.format("SELECT TOP 1 _idComponentServer id FROM "
            + "ComponentServer ORDER BY _idComponentServer DESC");

    List<Map<String, Object>> queryForList = conn.queryForList(query);

    return (int) queryForList.get(0).get("id");
  }

  private Integer getProcessIdPerSerial(String serial) {
    String query = String.format("SELECT TOP 1 _idComponentServer id FROM "
            + "ComponentServer WHERE serial = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);

    return (int) queryForList.get(0).get("id");
  }

  private Boolean componentExists(String serial) {
    String query = String.format("SELECT 1 FROM "
            + "ComponentServer WHERE serial = ?");

    List<Map<String, Object>> queryForList = conn.queryForList(query, serial);

    return !queryForList.isEmpty();
  }
}
