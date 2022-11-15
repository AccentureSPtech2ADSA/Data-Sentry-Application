package app.util;

import java.io.BufferedWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LOGGER {

//------------------------ Instances Files
 
  private static File logComponents = new File("log_components.txt");
  private static File logUsers = new File("log_users.txt");

  
//------------------------ Methods for a type Log & Insertion a type File
//--- Append Information
  public static void info(String info, String typeFile) {
    String append = getDate() + " - Info - " + info;
    
    if (typeFile.equals("users")){
        LOGGER.atualizarArquivoLogUsers(append);
        
    } else if (typeFile.equals("components")){
        LOGGER.atualizarArquivoLogComponents(append); 
        
    } else {
        System.out.println("Tipo do arquivo não específicado");
    }
  }

//--- Append Error
  public static void error(String error, String typeFile) {
    String append = getDate() + " - Error - " + error;
    if (typeFile.equals("users")){
        LOGGER.atualizarArquivoLogUsers(append);
        
    } else if (typeFile.equals("components")){
        LOGGER.atualizarArquivoLogComponents(append); 
        
    } else {
        System.out.println("Tipo do arquivo não específicado");
    }
  }

//--- Append Warning
  public static void warning(String warning, String typeFile) {
    String append = getDate() + " - Warning - " + warning;
    if (typeFile.equals("users")){
        LOGGER.atualizarArquivoLogUsers(append);
        
    } else if (typeFile.equals("components")){
        LOGGER.atualizarArquivoLogComponents(append); 
        
    } else {
        System.out.println("Tipo do arquivo não específicado");
    }
  }

//------------------- Logs of the Components (Insertion in file)
  
  private static void atualizarArquivoLogComponents(String append) {
    // escreve no arquivo
    try {
      if (logComponents.exists() && !logComponents.isDirectory()) {
        logComponents = new File("log_components.txt");
      }
      System.out.println("Atualizando o arquivo de components");

      FileWriter writer = new FileWriter(LOGGER.logComponents, true);
      BufferedWriter buff = new BufferedWriter(writer);
      buff.write(append);

      buff.close();
      writer.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
//------------------- Logs of the Users (Insertion in file)
  
  private static void atualizarArquivoLogUsers(String append) {
    // escreve no arquivo
    try {
      if (logUsers.exists() && !logUsers.isDirectory()) {
        logUsers = new File("log_users.txt");
      }
      System.out.println("Atualizando o arquivo de users");

      FileWriter writer = new FileWriter(LOGGER.logUsers, true);
      BufferedWriter buff = new BufferedWriter(writer);
      buff.write(append);

      buff.close();
      writer.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  
//-------------------- Get Date and Hour
  
  public static String getDate() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    return "\n" + dateFormat.format(date);
  }
  
  
    

}
