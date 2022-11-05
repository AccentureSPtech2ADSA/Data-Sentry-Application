package app.database;

import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public enum Ambiente {
  DOCKER_LOCAL(DatabaseData.MYSQL, "LOCAL"),
  AZURE_CLOUD(DatabaseData.MSSQL, "PROD");
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
      if(dbData == DatabaseData.MYSQL){
        System.out.println("Nao foi possivel conectar com o banco de dados MYSQL no Docker.");
        System.out.println("Sem banco de dados conectado :/");
        return null;
      }
      System.out.println("Nao foi possivel conectar com o banco de dados SQL Server na Azure.");
      dbData = DatabaseData.MYSQL;
      System.out.println("Tentando acessar o banco de dados MYSQL no Docker... ");
      return getDatasource();
    }

    return dataSource;
  }

}