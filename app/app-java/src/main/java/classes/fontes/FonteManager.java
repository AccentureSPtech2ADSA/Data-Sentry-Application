
package classes.fontes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class FonteManager {
    
    public Font carregarFonte(String caminhoFonte, int tipoFonte, int tamanhoFonte){
        
        Font fonteParaOApp = null;
        
        try {
            
            fonteParaOApp = Font.createFont(
                    Font.TRUETYPE_FONT, 
                    getClass().getResourceAsStream(caminhoFonte)
            ).deriveFont(tipoFonte, tamanhoFonte);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (FontFormatException ex){
            ex.printStackTrace();
        }
        
        return fonteParaOApp;
    }
    
}
