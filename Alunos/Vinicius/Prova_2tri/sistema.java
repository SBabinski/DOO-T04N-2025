import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private final Usuario usuario;
    private final Scanner sc = new Scanner(System.in);

    public Sistema(Usuario usuario) {
        this.usuario = usuario;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n MENU ");
            System.out.println("1. Buscar notícias");
            System.out.println("2. Ver favoritos");
            System.out.println("3. Ver lidas");
            System.out.println("4. Ver 'Para ler depois'");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> buscar();
                case 2 -> ordenarEMostrar(usuario.favoritos, "Favoritos");
                case 3 -> ordenarEMostrar(usuario.lidas, "Lidas");
                case 4 -> ordenarEMostrar(usuario.paraLerDepois, "Para ler depois");
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Inválido");
            }
        } while (opcao != 0);
    }

    private void buscar() {
        try {
            System.out.print("Palavra-chave: ");
            String termo = sc.nextLine();
            String urlStr = "https://servicodados.ibge.gov.br/api/v3/noticias/?busca=" + termo.replace(" ", "%20");
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");
            Gson gson = new Gson();
            Resposta r = gson.fromJson(new InputStreamReader(conn.getInputStream()), Resposta.class);

            if (r.items.isEmpty()) {
                System.out.println("Nenhuma notícia encontrada.");
                return;
            }

            for (int i = 0; i < r.items.size(); i++)
                System.out.println((i + 1) + ". " + r.items.get(i).titulo);

            System.out.print("Escolha para ver detalhes (0 para voltar): ");
            int esc = Integer.parseInt(sc.nextLine());
            if (esc > 0 && esc <= r.items.size()) {
                Noticia n = r.items.get(esc - 1);
                exibirDetalhes(n);

                System.out.println("\n1-Favoritar 2-Marcar como lida 3-Adicionar para ler depois");
                int a = Integer.parseInt(sc.nextLine());
                switch (a) {
                    case 1 -> usuario.favoritos.add(n);
                    case 2 -> usuario.lidas.add(n);
                    case 3 -> usuario.paraLerDepois.add(n);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void ordenarEMostrar(List<Noticia> lista, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }

        System.out.println("Como deseja ordenar?");
        System.out.println("1. Título (A-Z)");
        System.out.println("2. Data (mais recente primeiro)");
        System.out.println("3. Tipo/Categoria");
        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(sc.nextLine());

        Comparator<Noticia> comparador = switch (opcao) {
            case 2 -> Comparator.comparing(n -> n.data_publicacao == null ? "" : n.data_publicacao, Comparator.reverseOrder());
            case 3 -> Comparator.comparing(n -> n.tipo == null ? "" : n.tipo.toLowerCase());
            default -> Comparator.comparing(n -> n.titulo == null ? "" : n.titulo.toLowerCase());
        };

        lista.stream().sorted(comparador).forEach(n -> {
            System.out.println("- " + n.titulo + " (" + n.data_publicacao + ", " + n.tipo + ")");
        });
    }

    private void exibirDetalhes(Noticia n) {
        System.out.println("\n Detalhes da Notícia");
        System.out.println("Título: " + n.titulo);
        System.out.println("Introdução: " + n.introducao);
        System.out.println("Data: " + n.data_publicacao);
        System.out.println("Link: " + n.link);
        System.out.println("Tipo: " + n.tipo);
        System.out.println("Fonte: " + n.fonte);
    }

    class Resposta {
        List<Noticia> items;
    }
}
