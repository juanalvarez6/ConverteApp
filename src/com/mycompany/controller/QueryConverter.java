package com.mycompany.controller;

import com.google.gson.Gson;
import com.mycompany.model.ConverterData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryConverter {
    public static ConverterData getConverter(String baseCode, String targetCode){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/d414a45d059d1271f672a0e6/pair/"
                +baseCode+"/"
                +targetCode);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ConverterData.class);
        }catch (IOException | InterruptedException e){
            throw new RuntimeException("No se pudo realizar la conversión");
        }
    }
}
