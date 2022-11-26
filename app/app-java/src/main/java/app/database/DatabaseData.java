package app.database;

public enum DatabaseData {

  MSSQL_AWS(Variables.DRIVER_MSSQL, Variables.DB_URL_MSSQL_AWS, Variables.USER_AWS, Variables.PASS_AWS),
  MSSQL_AZURE(Variables.DRIVER_MSSQL, Variables.DB_URL_MSSQL_AZURE, Variables.USER_AZURE, Variables.PASS_AZURE),
  MSSQL_LOCAL(Variables.DRIVER_MSSQL, Variables.DB_URL_MSSQL_LOCAL, Variables.USER_AWS, Variables.PASS_AWS);
  
  private final String driver;
  private final String dbUrl;
  private final String name;
  private final String pass;

  private DatabaseData(String driver, String dbUrl, String name, String pass) {
    this.driver = driver;
    this.dbUrl = dbUrl;
    this.name = name;
    this.pass = pass;
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

    private static final String USER_AZURE = "datasentry";
    private static final String USER_AWS = "sa";
    private static final String DRIVER_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String PASS_AZURE = "#Gfgrupo1";    
    private static final String PASS_AWS = "Gfgrupo1";
    private static final String DB_URL_MSSQL_AZURE = "jdbc:sqlserver://;serverName=datasentry.database.windows.net;encrypt=true;trustServerCertificate=true;databaseName=datasentry";
    private static final String DB_URL_MSSQL_AWS = "jdbc:sqlserver://;serverName=datasentry.sytes.net;encrypt=true;trustServerCertificate=true;databaseName=datasentry";
    private static final String DB_URL_MSSQL_LOCAL = "jdbc:sqlserver://;serverName=localhost;encrypt=true;trustServerCertificate=true;databaseName=datasentry";
  }
}
