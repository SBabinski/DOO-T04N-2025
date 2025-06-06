import java.util.*;
import java.util.stream.Collectors;

// Classe Produto para as atividades 4 e 5
class Produto {
    String nome;
    double preco;

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

public class Main {
    public static void main(String[] args) {
        // ATV1 - Filtrar números pares
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> pares = numeros.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("ATV1 - Números pares: " + pares);

        // ATV2 - Converter nomes para maiúsculas
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("ATV2 - Nomes em maiúsculas: " + nomesMaiusculos);

        // ATV3 - Contar palavras únicas
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagemPalavras = palavras.stream()
            .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println("ATV3 - Contagem de palavras: " + contagemPalavras);

        // ATV4 - Filtrar produtos com preço > 100
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 2500.00),
            new Produto("Mouse", 80.00),
            new Produto("Teclado", 150.00),
            new Produto("Monitor", 450.00)
        );
        List<Produto> produtosCaros = produtos.stream()
            .filter(p -> p.getPreco() > 100.00)
            .collect(Collectors.toList());
        System.out.println("ATV4 - Produtos com preço > R$100:");
        produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$" + p.getPreco()));

        // ATV5 - Soma total dos produtos
        double somaTotal = produtos.stream()
            .mapToDouble(Produto::getPreco)
            .sum();
        System.out.println("ATV5 - Soma total dos produtos: R$" + somaTotal);

        // ATV6 - Ordenar por tamanho da palavra
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> linguagensOrdenadas = linguagens.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
        System.out.println("ATV6 - Linguagens ordenadas por tamanho: " + linguagensOrdenadas);
    }
}
