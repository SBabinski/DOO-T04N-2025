package Aula12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java1 {
    private static final String URL_API = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";

    public static void main(String[] args) {
        String chaveApi = System.getenv("API_KEY"); // Necessário adicionar a variável de ambiente, Run Config> Environment > ADD > API_KEY > sua api key
//        String chaveApi = ""; 

        if (chaveApi == null || chaveApi.isEmpty()) {
            System.out.println("Erro: variável de ambiente API_KEY não encontrada. Tente definir a chave da API manualmente no código.");
            return;
        }

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidade = entrada.nextLine();
        entrada.close();

        try {
            String url = URL_API + URLEncoder.encode(cidade, StandardCharsets.UTF_8) + "?unitGroup=metric&lang=pt&key=" + chaveApi;
            String resposta = requisitarHttp(url);
            if (resposta == null) {
                System.out.println("Não foi possível obter os dados do clima.");
                return;
            }
            exibirDadosClima(resposta);
        } catch (Exception e) {
            System.out.println("Erro ao buscar informações do clima: " + e.getMessage());
        }
    }

    private static String requisitarHttp(String urlStr) throws Exception {
        URL url = new URI(urlStr).toURL();
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        int codigoResposta = conexao.getResponseCode();
        if (codigoResposta != 200) {
            return null;
        }

        BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String linha;
        StringBuilder conteudo = new StringBuilder();

        while ((linha = leitor.readLine()) != null) {
            conteudo.append(linha);
        }

        leitor.close();
        conexao.disconnect();
        return conteudo.toString();
    }

    private static void exibirDadosClima(String json) {
        String enderecoResolvido = extrairTexto(json, "\"resolvedAddress\":\"([^\"]+)\"");
        String jsonHoje = extrairPrimeiroObjeto(json);

        if (jsonHoje == null) {
            System.out.println("Dados do dia atual não encontrados.");
            return;
        }

        double temperatura = extrairNumero(jsonHoje, "\"temp\":([0-9.\\-]+)");
        double temperaturaMaxima = extrairNumero(jsonHoje, "\"tempmax\":([0-9.\\-]+)");
        double temperaturaMinima = extrairNumero(jsonHoje, "\"tempmin\":([0-9.\\-]+)");
        double umidade = extrairNumero(jsonHoje, "\"humidity\":([0-9.\\-]+)");
        String condicoes = extrairTexto(jsonHoje, "\"conditions\":\"([^\"]+)\"");
        double precipitacao = extrairNumero(jsonHoje, "\"precip\":([0-9.\\-]+)");
        double ventoVelocidade = extrairNumero(jsonHoje, "\"windspeed\":([0-9.\\-]+)");
        double ventoDirecao = extrairNumero(jsonHoje, "\"winddir\":([0-9.\\-]+)");

        System.out.println("\nClima para: " + enderecoResolvido);
        System.out.printf("Temperatura atual: %.1f°C%n", temperatura);
        System.out.printf("Temperatura máxima: %.1f°C%n", temperaturaMaxima);
        System.out.printf("Temperatura mínima: %.1f°C%n", temperaturaMinima);
        System.out.printf("Umidade do ar: %.0f%%%n", umidade);
        System.out.println("Condição do tempo: " + condicoes);
        if (precipitacao > 0) {
            System.out.printf("Precipitação: %.1f mm%n", precipitacao);
        } else {
            System.out.println("Precipitação: 0 mm");
        }
        System.out.printf("Vento: %.1f km/h, direção %.0f°%n", ventoVelocidade, ventoDirecao);
    }

    private static double extrairNumero(String texto, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(texto);
        if (matcher.find()) {
            try {
                return Double.parseDouble(matcher.group(1));
            } catch (NumberFormatException e) {
                return Double.NaN;
            }
        }
        return Double.NaN;
    }

    private static String extrairTexto(String texto, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(texto);
        return matcher.find() ? matcher.group(1) : "-";
    }

    private static String extrairPrimeiroObjeto(String texto) {
        Matcher matcher = Pattern.compile("\"days\":\\[(\\{[^}]*+})").matcher(texto);
        return matcher.find() ? matcher.group(1) : null;
    }
}