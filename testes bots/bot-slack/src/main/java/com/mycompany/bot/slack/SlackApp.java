
package com.mycompany.bot.slack;

import java.io.IOException;
import org.json.JSONObject;

public class SlackApp {
    
    public static void main(String[] args) throws IOException, InterruptedException{
        
        JSONObject json = new JSONObject();
        
        json.put("text", "Hello World!");
        Slack.enviarMensagem(json);
        
    }
    
}
