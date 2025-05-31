import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- Aula11 ----");
        System.out.println("Lista de Atividades");

        // Atividade 1
        // Código Abaixo
        System.out.println("\n--- Atividade 1 ---");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números originais: " + numeros);
        System.out.println("Números pares: " + numerosPares);
        System.out.println();

        // Atividade 2
        // Código Abaixo
        System.out.println("--- Atividade 2 ---");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nomes originais: " + nomes);
        System.out.println("Nomes maiúsculos: " + nomesMaiusculos);
        System.out.println();

        // Atividade 3
        // Código Abaixo
        System.out.println("--- Atividade 3 ---");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagemPalavras = palavras.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("Lista de palavras: " + palavras);
        System.out.println("Contagem de palavras: " + contagemPalavras);
        System.out.println();

        // Atividade 4
        // Código Abaixo
        System.out.println("--- Atividade 4 ---");
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 1500.00),
                new Produto("Mouse", 50.00),
                new Produto("Teclado Mecânico", 250.00),
                new Produto("Monitor", 800.00),
                new Produto("Webcam", 120.00)
        );

        List<Produto> produtosCaros = produtos.stream()
                .filter(p -> p.getPreco() > 100.00)
                .collect(Collectors.toList());
        System.out.println("Todos os produtos:");
        produtos.forEach(System.out::println);
        System.out.println("Produtos com preço maior que R$ 100,00:");
        produtosCaros.forEach(System.out::println);
        System.out.println();

        // Atividade 5
        // Código Abaixo
        System.out.println("--- Atividade 5 ---");
        double somaTotalProdutos = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Soma total dos preços dos produtos: R$ " + String.format("%.2f", somaTotalProdutos));
        System.out.println();

        // Atividade 6
        // Código Abaixo
        System.out.println("--- Atividade 6 ---");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> linguagensOrdenadas = linguagens.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
        System.out.println("Linguagens originais: " + linguagens);
        System.out.println("Linguagens ordenadas por tamanho: " + linguagensOrdenadas);
        System.out.println();
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + String.format("%.2f", preco) +
                '}';
    }
}
