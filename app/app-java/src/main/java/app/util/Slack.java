/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author guilherme-narciso
 */
public class Slack {

  private static HttpClient CLIENT = HttpClient.newHttpClient();
  private static final String URL = "https://hooks.slack.com/services/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";

  public static void sendMessageAlerts(JSONObject content) throws IOException, InterruptedException {

    HttpRequest request = HttpRequest.newBuilder(URI.create(URL))
            .header("accept", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
            .build();

    HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
  }

}
