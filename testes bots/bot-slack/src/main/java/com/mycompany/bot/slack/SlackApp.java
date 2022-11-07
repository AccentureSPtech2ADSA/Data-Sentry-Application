
package com.mycompany.bot.slack;

import java.io.IOException;
import org.json.JSONObject;

public class SlackApp {
    
    public static void main(String[] args) throws IOException, InterruptedException{
        
        JSONObject jsonPar = new JSONObject();       
        JSONObject jsonNaoPar = new JSONObject();

        jsonPar.put("text", "Numero par");        
        jsonNaoPar.put("text", "Numero impar");

        
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Slack.enviarMensagem(jsonPar);
            }else{
                Slack.enviarMensagem(jsonNaoPar);
            }
        }
        
    }
    
}
