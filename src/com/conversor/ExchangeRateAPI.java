package com.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {
    private static final String API_KEY = "4aff81670774b137e91ff8a7"; // Reemplaza con tu API key
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public static double getTasaCambio(String monedaDestino) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            return jsonObject.getAsJsonObject("conversion_rates")
                    .get(monedaDestino)
                    .getAsDouble();

        } catch (Exception e) {
            System.err.println("Error al obtener tasa de cambio: " + e.getMessage());
            return -1;
        }
    }
}