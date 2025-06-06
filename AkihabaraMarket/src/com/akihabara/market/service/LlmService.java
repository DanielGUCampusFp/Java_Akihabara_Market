package com.akihabara.market.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.io.FileInputStream;

import com.google.gson.*;

public class LlmService {
    public String sugerirNombreProducto(String tipo, String franquicia) {
        try {
            Properties props = new Properties();
            
            props.load(new FileInputStream("config.properties"));
            String KEY = props.getProperty("OPENROUTER_API_KEY");
            
            String prompt = "Sugiere un nombre llamativo y original para un producto otaku del tipo " + tipo + " basado en la franquicia " + franquicia + " PERO SOLO RESPONDE EL NOMBRE , NO DIGAS NADA MAS, NI ESPERO QUE TE GUSTE NI NADA, SOLO EL NOMBRE Y NO INDIQUES QUE ES EL NOMBRE, SOLO RESPONDE CON EL NOMBRE";

            String apiKey = KEY;
            
            HttpClient client = HttpClient.newHttpClient();
            
            
            JsonObject message = new JsonObject();
            message.addProperty("role", "user");
            message.addProperty("content", prompt);


            JsonArray messages = new JsonArray();
            messages.add(message);


            JsonObject body = new JsonObject();
            body.addProperty("model", "mistralai/mistral-7b-instruct:free");
            body.add("messages", messages);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://openrouter.ai/api/v1/chat/completions"))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                    .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            // Extraer el texto generado
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            String resultado = json
                    .getAsJsonArray("choices")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content")
                    .getAsString();


            return resultado;
        } catch (Exception e) {
            System.out.println("Error al comunicar con OpenRouter: " + e.getMessage());
            return null;
        }
    }
}