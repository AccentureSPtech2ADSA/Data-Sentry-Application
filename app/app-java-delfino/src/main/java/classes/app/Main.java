
package classes.app;

import classes.fontes.FonteManager;
import java.awt.Font;
import javax.swing.UIManager;

public class Main {
    
    public static void main(String[] args) {
        
        
        FonteManager fontManager = new FonteManager();
        Font robotoFonteMedium = fontManager.carregarFonte("/classes.fontes/Roboto-Medium.ttf", Font.PLAIN, 13);
        UIManager.put("JLabel.font", robotoFonteMedium);
        
        new InterfaceLogin().setVisible(true);
    }
    
}
