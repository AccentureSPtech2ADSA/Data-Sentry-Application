
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
        //System.out.println(looca.getSistema());
        //System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getSerial());
        //System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getModelo());
        //System.out.println(looca.getGrupoDeDiscos().getDiscos().get(1).getNome());
        
        System.out.println(looca.getGrupoDeProcessos());
        System.out.println(looca.getGrupoDeProcessos().getProcessos());
        
    } 
}
