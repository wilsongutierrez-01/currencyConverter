package alura.courses.com.api;

import alura.courses.com.dto.Currency;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApi {
    public Currency getConversion(String baseCode, String targetCode, Double amount) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        String ApiKey = "30f14d87f0936f003a087101";

        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + ApiKey +"/pair/" + baseCode + "/" + targetCode + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException("Couldn't get API response", e);
        }
    }
}
