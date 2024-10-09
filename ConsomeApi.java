package br.edu.fatecpg.StreamLambda.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsomeApi {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/comments";

    public static String fazerRequisicao() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();

    }



}
