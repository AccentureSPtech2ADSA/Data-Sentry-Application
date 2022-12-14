package app.controller;

import app.model.ServerModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServerController extends ControllerLooca {

  public ServerModel getServer(Integer fkHospital) throws IOException, ClassNotFoundException {
    String serial = getSerialServer();
    String description = looca.getSistema().getSistemaOperacional();

    return new ServerModel(serial, description, fkHospital);
  }

  private String getMotherboardSerialWindows() throws ClassNotFoundException {
    String serial = "";
    try {
      File file = File.createTempFile("realhowto", ".vbs");
      file.deleteOnExit();
      try (FileWriter fw = new java.io.FileWriter(file)) {
        String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                + "Set colItems = objWMIService.ExecQuery _ \n"
                + "   (\"Select * from Win32_BaseBoard\") \n"
                + "For Each objItem in colItems \n"
                + "    Wscript.Echo objItem.SerialNumber \n"
                + "    exit for  ' do the first cpu only! \n" + "Next \n";
        
        fw.write(vbs);
      }
      Process p = Runtime.getRuntime().exec(
              "cscript //NoLogo " + file.getPath());
      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = input.readLine()) != null) {
        serial += line;
      }
      input.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return serial.trim();
  }

  public String getMotherboardSerialLinux() throws SocketException {
    String firstInterface = null;
    Map<String, String> addressByNetwork = new HashMap<>();
    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
    while (networkInterfaces.hasMoreElements()) {
      NetworkInterface network = networkInterfaces.nextElement();
      byte[] bmac = network.getHardwareAddress();
      if (bmac != null) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bmac.length; i++) {
          sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));
        }
        if (sb.toString().isEmpty() == false) {
          addressByNetwork.put(network.getName(), sb.toString());
        }
        if (sb.toString().isEmpty() == false && firstInterface == null) {
          firstInterface = network.getName();
        }
      }
    }

    if (firstInterface != null) {
      return addressByNetwork.get(firstInterface).replaceAll("-", "");
    }

    return null;
  }

  public String getSerialServer() throws IOException, ClassNotFoundException {
    String os = System.getProperty("os.name");
    try {
      if (os.startsWith("Windows")) {
        return getMotherboardSerialWindows();
      } else if (os.startsWith("Linux")) {
        return getMotherboardSerialLinux();
      } else {
        System.out.println("Sistema operacional nao reconhecido " + os);
        throw new IOException("Sistema operacional nao reconhecido " + os);
      }
    } catch (IOException | ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
      throw new IOException(ex.getMessage());
    }
  }
}
