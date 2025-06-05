import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {

        // ATV1 - Filtrar números pares
        System.out.println("// ATV1");
        List<Integer> numeros = Arrays.asList(3, 8, 12, 5, 7, 10, 2, 20);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        // ATV2 - Converter nomes para maiúsculas
        System.out.println("\n// ATV2");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);

        // ATV3 - Contar palavras
        System.out.println("\n// ATV3");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Contagem de palavras: " + contagem);

        // ATV4 - Filtrar produtos com preço > R$ 100,00
        System.out.println("\n// ATV4");
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 2500.00),
            new Produto("Mouse", 80.00),
            new Produto("Teclado", 120.00),
            new Produto("Monitor", 900.00)
        );
        List<Produto> produtosCaros = produtos.stream()
                                              .filter(p -> p.getPreco() > 100.00)
                                              .collect(Collectors.toList());
        produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

        // ATV5 - Soma total dos produtos
        System.out.println("\n// ATV5");
        double soma = produtos.stream()
                              .mapToDouble(Produto::getPreco)
                              .sum();
        System.out.println("Soma total dos produtos: R$ " + soma);

        // ATV6 - Ordenar lista de linguagens por tamanho
        System.out.println("\n// ATV6");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> linguagensOrdenadas = linguagens.stream()
                                                     .sorted(Comparator.comparingInt(String::length))
                                                     .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + linguagensOrdenadas);
    }
}

// Classe Produto usada nas atividades 4 e 5
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
}
