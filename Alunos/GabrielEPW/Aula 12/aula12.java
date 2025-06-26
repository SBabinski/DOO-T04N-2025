import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidade = entrada.nextLine();

        try {
            String chave = "COLOQUE A CHAVE"; // professor, não sei se tem um jeito melhor de proteger a Key, então tirei a minha
            String urlApi = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" 
                          + cidade + "?unitGroup=metric&key=" + chave + "&include=current";

            URL url = new URL(urlApi);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String linha;
            StringBuilder resposta = new StringBuilder();
            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();

            String dados = resposta.toString();

            String temp = entre(dados, "\"temp\":", ",");
            String tempMax = entre(dados, "\"tempmax\":", ",");
            String tempMin = entre(dados, "\"tempmin\":", ",");
            String umidade = entre(dados, "\"humidity\":", ",");
            String condicao = entre(dados, "\"conditions\":\"", "\"");
            String vento = entre(dados, "\"windspeed\":", ",");
            String chuva = entre(dados, "\"precip\":", ",");

            ClimaObj clima = new ClimaObj();
            clima.temperaturaAtual = temp;
            clima.temperaturaMaxima = tempMax;
            clima.temperaturaMinima = tempMin;
            clima.umidade = umidade;
            clima.condicao = condicao;
            clima.vento = vento;
            clima.precipitacao = chuva;

            clima.exibir();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        entrada.close();
    }

    public static String entre(String texto, String inicio, String fim) {
        int pos1 = texto.indexOf(inicio);
        if (pos1 == -1) return "";      
        int pos2 = texto.indexOf(fim, pos1 + inicio.length());
        if (pos2 == -1) return "";
        return texto.substring(pos1 + inicio.length(), pos2);
    }
}
