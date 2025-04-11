package dev.mhproject.service;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final String urlApi;
    private final HttpClient client;

    public ApiService() {
        // Carga las variables del archivo .env ubicado en la raíz del proyecto
        Dotenv dotenv = Dotenv.configure()
                .directory("./") // busca en la raíz
                .ignoreIfMissing() // no lanza error si no existe
                .load();

        this.urlApi = dotenv.get("URL_API");
        this.client = HttpClient.newHttpClient();
    }

    public String obtenerTasas(String monedaBase) throws IOException, InterruptedException {
        // Ejemplo: URL_API=https://api.exchangerate-api.com/v4/latest/
        String endpoint = urlApi + monedaBase;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body(); // Devuelve la respuesta en crudo (JSON)
    }
}
