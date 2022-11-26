package app.dao;

import app.model.ComponentTypeEnum;
import java.util.List;
import java.util.Map;

public class ComponentTypeDAO extends Dao {

  private Integer save(ComponentTypeEnum type) {
    if (!existsType(type)) {
      System.out.println("Inserindo Tipo de componente: " + type.getDescricao());
      String query = "INSERT INTO ComponentType(description, measuramentUnit) VALUES (?, ?)";
      return conn.update(query, type.getDescricao(), type.getUnidadeMedida());
    }
    return 1;
  }

  public String saveComponentTypes() {
    Integer ram = save(ComponentTypeEnum.RAM);
    Integer cpu = save(ComponentTypeEnum.CPU);
    Integer disco = save(ComponentTypeEnum.DISCO);

    return ram > 0 && cpu > 0 && disco > 0 ? "Tipos inseridos" : "Houve algum erro";
  }

  private Boolean existsType(ComponentTypeEnum type) {
    String query = String.format("SELECT 1 FROM "
            + "ComponentType WHERE description = ?;");

    List<Map<String, Object>> queryForList = conn.queryForList(query, type.getDescricao());

    if (!queryForList.isEmpty()) {
      List<Map<String, Object>> queryForListAws = conn.queryForList(query, true, type.getDescricao());

      if (queryForListAws.isEmpty()) {
        String queryInsert = "INSERT INTO ComponentType(description, measuramentUnit) VALUES (?, ?)";
        conn.updateAws(queryInsert, true,type.getDescricao(), type.getUnidadeMedida());
      }
    }

    return !queryForList.isEmpty();
  }

}
