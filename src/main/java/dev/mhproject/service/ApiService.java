package dev.mhproject.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.mhproject.model.dto.CurrencyDTO;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final String urlApi;
    private final HttpClient client;

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    Gson countries = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    
    /**
     * busca y carga la variable de entorno
     * en la variable global de la Clase
     * tambien carga el cliente HttpClient
     */
    public ApiService() {

        Dotenv dotenv = Dotenv.configure()
                .directory("./")
                .ignoreIfMissing()
                .load();

        this.urlApi = dotenv.get("URL_API");
        this.client = HttpClient.newHttpClient();
    }

    /**
     * realiza el request y la response de la api
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CurrencyDTO loadExchangeRates() throws IOException, InterruptedException {

        String endpoint = urlApi;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        CurrencyDTO currency = gson.fromJson(json, CurrencyDTO.class);
        return currency;
    }
}
