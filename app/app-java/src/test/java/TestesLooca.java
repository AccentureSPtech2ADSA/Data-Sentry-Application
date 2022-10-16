
import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class TestesLooca {

    private String serialWindows;

    public static void main(String[] args) {

        Looca looca = new Looca();
        TestesLooca tl = new TestesLooca();

        //System.out.println(looca.getSistema().getSistemaOperacional());
        //System.out.println(looca.getSistema().getArquitetura());
        //System.out.println(looca.getSistema().getFabricante());
        // System.out.println(looca.getSistema());
        //System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getSerial());
        //System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getModelo());
        //System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getNome());
        
        System.out.println(tl.getMotherboardSerialWindows());
        //System.out.println(looca.getSistema().getSistemaOperacional());

    }

    public String getMotherboardSerialWindows() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result.trim();
    }
}
