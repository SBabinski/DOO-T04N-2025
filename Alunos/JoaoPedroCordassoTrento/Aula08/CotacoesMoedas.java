package aula_java_web01;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class CotacoesMoedas {
    public static void main(String[] args) throws Exception {
        String[] listaDeUrls = {"https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL",
                        "https://economia.awesomeapi.com.br/json/daily/USD-BRL/2", 
                        "https://economia.awesomeapi.com.br/json/daily/USD-BRL/?start_date=20240520&end_date=20240525",
                        "https://economia.awesomeapi.com.br/USD-BRL/5"};

        for (String irl : listaDeUrls) {
            HttpClient client = HttpClient.newHttpClient();
            URI url = new URI(irl);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("URL: " + request.uri());
                System.out.println("Método: " + request.method());
                System.out.println("Status: " + response.statusCode());
                System.out.println("Resposta: " + response.body() + "\n\n");
            } else {
                System.out.println("Erro: " + response.statusCode());
            }
        }
    }
}
