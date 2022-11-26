package app.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyJdbcTemplate extends JdbcTemplate {

  private List<JdbcTemplate> templates = new ArrayList<>();

  public MyJdbcTemplate(List<JdbcTemplate> templates) {
    this.templates = templates.stream().filter(t -> t != null).collect(Collectors.toList());
  }

  @Override
  public List<Map<String, Object>> queryForList(String sql) throws DataAccessException {
    return templates.get(0).queryForList(sql);
  }
  
  @Override
  public int update(String sql, Object... args) {
      return templates.get(0).update(sql, args);
  }

  public int updateAws(String sql, boolean aws, Object... args) {
    if (templates.size() > 1) {
      return aws
              ? templates.get(1).update(sql, args)
              : templates.get(0).update(sql, args);
    }
    System.out.println("Sem AWS conectada");
    return -1;
  }

  @Override
  public List<Map<String, Object>> queryForList(String sql, Object... args) throws DataAccessException {
    return templates.get(0).queryForList(sql, args);
  }

  public List<Map<String, Object>> queryForList(String sql, Boolean aws, Object... args) throws DataAccessException {
    List<Map<String, Object>> listAzure = templates.get(0).queryForList(sql, args);
    if (templates.size() >= 1) {
      List<Map<String, Object>> listAws = templates.get(1).queryForList(sql, args);
      return aws ? listAws : listAzure;
    }
    return listAzure;
  }

//  public List<Map<String, Object>> queryForList(String sql, boolean aws) throws DataAccessException {
//    List<Map<String, Object>> listAzure = templates.get(0).queryForList(sql);
//    List<Map<String, Object>> listAws = templates.get(1).queryForList(sql);
//    if (listAzure.size() > listAws.size()) {
//      if (sql.toLowerCase().contains("from")) {
//        String[] split = sql.split(" ");
//        String table = null;
//
//        for (int i = 0; i < split.length; i++) {
//          if (split[i].equalsIgnoreCase("from")) {
//            table = split[i + 1];
//          }
//        }
//        System.out.println(table);
//        if (table != null) {
//          List<String> fields = new ArrayList<>();
//          fields.addAll(listAzure.get(0).keySet());
//          String paramsToInsertInTable = fields.toString().replaceAll("\\[", "").replaceAll("\\]", "");
//          for (int i = 0; i < listAzure.size(); i++) {
//            
//            Map<String, Object> map = listAzure.get(i);
//            List<String> values = new ArrayList<>();
//            for (int j = 0; j < map.size(); j++) {
//              values.add(map.get(fields.get(j)).toString());
//            }
//            SqlParameterSource namedParameters = new MapSqlParameterSource();
//            String valuesToInsertInTable = values.stream()
//                    .map(item->"'"+item+"'")
//                    .collect(Collectors.joining(", "));
//            
//            System.out.println(valuesToInsertInTable);
//
//            String querySelect = String.format(
//                    "INSERT INTO %s VALUES (%s) values (%s);",
//                    table,
//                    paramsToInsertInTable,
//                    valuesToInsertInTable
//            );
//
//            templates.get(1).update(querySelect);
//
////            fields.add(map.keySet().toString());
//          }
////          System.out.println(map);
//        }
//      }
//
//    }
//    return aws ? listAws : listAzure;
//  }
//  public static void main(String[] args) {
//    MyJdbcTemplate db = new MyJdbcTemplate(List.of(
//            new JdbcTemplate(azure.getDatasource()),
//            new JdbcTemplate(docker.getDatasource())
//    ));
//
//    List<Map<String, Object>> queryForList = db.queryForList("Select * from Hospital", true);
//
//    queryForList
//            .stream()
//            .forEach(System.out::println);
//  }
}
