package app.database;

import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public enum Ambiente {
  DOCKER_LOCAL(DatabaseData.MSSQL_AWS, "AWS"),
  AZURE_CLOUD(DatabaseData.MSSQL_AZURE, "PROD"),
  LOCAL_MSSQL(DatabaseData.MSSQL_LOCAL, "LOCAL");
  
  private DatabaseData dbData;
  private String ambientName;

  Ambiente(DatabaseData db, String ambient) {
    this.dbData = db;
    ambientName = ambient;
  }

  String getAmbient(){
    return this.ambientName;
  }
  BasicDataSource getDatasource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(dbData.getDriver());
    dataSource.setUrl(dbData.getDbUrl());
    dataSource.setUsername(dbData.getName());
    dataSource.setPassword(dbData.getPass());
    try {
      dataSource.getConnection();
    } catch (SQLException e) {
//      if(dbData == DatabaseData.MSSQL_AWS){
//        System.out.println("Nao foi possivel conectar com o banco de dados MSSQL_AWS no Docker.");
//        System.out.println("Sem banco de dados conectado :/");
//        return null;
//      }
//      System.out.println("Nao foi possivel conectar com o banco de dados SQL Server na Azure.");
//      dbData = DatabaseData.MSSQL_AWS;
//      System.out.println("Tentando acessar o banco de dados MSSQL_AWS no Docker... ");
//      return getDatasource();
    }

    return dataSource;
  }

}
