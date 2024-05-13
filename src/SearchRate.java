import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchRate {

    private final String keyAPI;

    public SearchRate(String keyAPI) {
        this.keyAPI = keyAPI;
    }

    public Currency search(String baseCode) {

        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + this.keyAPI + "/latest/" + baseCode);
        HttpRequest request = HttpRequest.newBuilder().uri(url).build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            return gson.fromJson(response.body(), Currency.class);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível obter os dados.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
