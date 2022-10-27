package app.database;

import org.apache.commons.dbcp2.BasicDataSource;

public enum Ambiente {
  DOCKER_LOCAL(DatabaseData.MYSQL),
  AZURE_CLOUD(DatabaseData.MSSQL);

  private final DatabaseData dbData;
  
  Ambiente(DatabaseData db) {
    this.dbData = db;
  }

  BasicDataSource getDatasource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(dbData.getDriver());
    dataSource.setUrl(dbData.getDbUrl());
    dataSource.setUsername(dbData.getName());
    dataSource.setPassword(dbData.getPass());
    
    return dataSource;
  }

}
