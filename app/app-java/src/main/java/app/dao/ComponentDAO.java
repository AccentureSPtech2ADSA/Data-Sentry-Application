package app.dao;

import app.model.ComponentModel;
import app.util.LOGGER;
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
    ComponentModel exists = componentExists(component);
    if (exists != null) {
      String msg = component.getComponentType().getDescricao() + " com serial: " + component.getSerial() + " ja foi inserido.";
      component.setIdComponent(exists.getIdComponent());
      System.out.println(msg);
      LOGGER.info(msg, "components");
      return component;
    }
    return setComponent(component);
  }

  private ComponentModel setComponent(ComponentModel component) throws Exception {
    String querySave = String.format("INSERT INTO ComponentServer"
            + "(%s, %s, %s, %s, %s, %s) VALUES (?,?,?,?,?,?)",
            ComponentDAO.SERIAL, ComponentDAO.MODEL, ComponentDAO.BRAND,
            ComponentDAO.MAXUSE, ComponentDAO.FKSERVER, ComponentDAO.FKTYPE);

    System.out.println(String.format("Inserindo %s: ", component.getComponentType().getDescricao()));
    String msg = String.format("Inserindo %s: ", component.getComponentType().getDescricao());
    LOGGER.info(msg, "components");
    System.out.println(component);
    int res = conn.update(
            querySave,
            component.getSerial(),
            component.getModel(),
            component.getBrand(),
            component.getMaxUseFormated(),
            component.getFkServer(),
            component.getComponentType().getIdTypeComponent());
    if (res > 0) {
      component.setIdComponent(getLastInsertedComponentId());
      setComponentAws(component);
      return component;
    }
    LOGGER.error("Houve algo errado ao inserir componente.", "components");
    throw new Exception("Houve algo errado.");
  }

  private ComponentModel setComponentAws(ComponentModel component) throws Exception {
    ComponentModel exists = componentExists(component, true);
    String querySave = String.format("INSERT INTO ComponentServer"
            + "(_idComponentServer, %s, %s, %s, %s, %s, %s) VALUES (?,?,?,?,?,?,?)",
            ComponentDAO.SERIAL, ComponentDAO.MODEL, ComponentDAO.BRAND,
            ComponentDAO.MAXUSE, ComponentDAO.FKSERVER, ComponentDAO.FKTYPE);

    System.out.println("Set Component in AWS");

    int res = conn.updateAws(
            querySave,
            true,
            component.getIdComponent(),
            component.getSerial(),
            component.getModel(),
            component.getBrand(),
            component.getMaxUseFormated(),
            component.getFkServer(),
            component.getComponentType().getIdTypeComponent());

    return component;
  }

  private Integer getLastInsertedComponentId() {
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

  private ComponentModel componentExists(ComponentModel c, boolean aws) {
    String query = String.format("SELECT TOP 1 _idComponentServer id FROM ComponentServer cs WHERE serial = "
            + "? AND fkServer = ? OR cs.maxUse = "
            + "? AND fkServer = ? AND model = 'RAM'");
    List<Map<String, Object>> list = null;
    list = aws ? conn.queryForList(
            query,
            true,
            c.getSerial(),
            c.getFkServer(),
            c.getMaxUseFormated(),
            c.getFkServer()
    )
            : conn.queryForList(
                    query,
                    c.getSerial(),
                    c.getFkServer(),
                    c.getMaxUseFormated(),
                    c.getFkServer()
            );
    if (!list.isEmpty()) {
      Integer id = (int) list.get(0).get("id");
      c.setIdComponent(id);
      return c;
    }
    return c;
  }

  private ComponentModel componentExists(ComponentModel c) throws Exception {
    String query = String.format("SELECT TOP 1 _idComponentServer id FROM ComponentServer cs WHERE serial = "
            + "? AND fkServer = ? OR cs.maxUse = "
            + "? AND fkServer = ? AND model = 'RAM'");

    List<Map<String, Object>> listAzure = conn.queryForList(
            query,
            c.getSerial(),
            c.getFkServer(),
            c.getMaxUseFormated(),
            c.getFkServer()
    );

    if (!listAzure.isEmpty()) {

      Integer id = (int) listAzure.get(0).get("id");
      c.setIdComponent(id);

      List<Map<String, Object>> listAws = conn.queryForList(
              query, true,
              c.getSerial(),
              c.getFkServer(),
              c.getMaxUseFormated(),
              c.getFkServer()
      );
      if (listAws.isEmpty()) {
        setComponentAws(c);
      }

      return c;
    }
    return null;
  }
}
