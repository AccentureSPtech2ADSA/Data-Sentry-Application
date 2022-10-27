package app.database;

public enum DatabaseData {

  MYSQL(Variables.DRIVER_MYSQL, Variables.DB_URL_MYSQL, Variables.USER),
  MSSQL(Variables.DRIVER_MSSQL, Variables.DB_URL_MSSQL, Variables.USER);
  
  private final String driver;
  private final String dbUrl;
  private final String name;
  private final String pass;

  private DatabaseData(String driver, String dbUrl, String name) {
    this.driver = driver;
    this.dbUrl = dbUrl;
    this.name = name;
    this.pass = Variables.PASS;
  }

  public String getDriver() {
    return driver;
  }

  public String getDbUrl() {
    return dbUrl;
  }

  public String getName() {
    return name;
  }

  public String getPass() {
    return pass;
  }

  private static class Variables {

    private static final String USER = "datasentry";
    private static final String DRIVER_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DRIVER_MYSQL = "";
    private static final String PASS = "#Gfgrupo1";
    private static final String DB_URL_MSSQL = "jdbc:sqlserver://;serverName=datasentry.database.windows.net;encrypt=true;trustServerCertificate=true;databaseName=datasentry";
    private static final String DB_URL_MYSQL = "jdbc:mysql://;serverName=localhost;databaseName=datasentry";
  }
}
