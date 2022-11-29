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
    return -1;
  }

  @Override
  public List<Map<String, Object>> queryForList(String sql, Object... args) throws DataAccessException {
    return templates.get(0).queryForList(sql, args);
  }

  public List<Map<String, Object>> queryForList(String sql, Boolean aws, Object... args) throws DataAccessException {
    List<Map<String, Object>> listAzure = templates.get(0).queryForList(sql, args);
    if (templates.size() > 1) {
      List<Map<String, Object>> listAws = templates.get(1).queryForList(sql, args);
      return aws ? listAws : listAzure;
    }
    return listAzure;
  }

}
