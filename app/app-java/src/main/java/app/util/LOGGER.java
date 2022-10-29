package app.util;

import java.io.BufferedWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LOGGER {

  private static File fileInstalation = new File("file_instalation.txt");
  private static File fileAlerts;

  public static void info(String info) {
    String append = getDate() + " - Info - " + info;
    LOGGER.atualizarArquivoInstalacao(append);
  }

  public static void error(String error) {
    String append = getDate() + " - Error - " + error;
    LOGGER.atualizarArquivoInstalacao(append);
  }

  public static void warning(String warning) {
    String append = getDate() + " - Warning - " + warning;
    LOGGER.atualizarArquivoInstalacao(append);
  }

  private static void atualizarArquivoInstalacao(String append) {
    // escreve no arquivo
    try {
      if (fileInstalation.exists() && !fileInstalation.isDirectory()) {
        fileInstalation = new File("file_instalation.txt");
      }
      System.out.println("Atualizando o arquivo");

      FileWriter writer = new FileWriter(LOGGER.fileInstalation, true);
      BufferedWriter buff = new BufferedWriter(writer);
      buff.write(append);

      buff.close();
      writer.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  public static String getDate() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    return "\n" + dateFormat.format(date);
  }

}
