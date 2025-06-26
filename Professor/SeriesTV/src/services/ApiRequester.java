package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequester {

    static final HttpClient client = HttpClient.newHttpClient();

    public static String getSingle(String query) {
        try {
            URI url = new URI("https://api.tvmaze.com/singlesearch/shows?q=" + query);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getMultiple(String query) {
        try {
            URI url = new URI("https://api.tvmaze.com/search/shows?q=" + query);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
