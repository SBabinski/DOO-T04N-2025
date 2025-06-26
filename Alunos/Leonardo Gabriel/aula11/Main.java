import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10, 12);
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("// ATV1 - Números pares: " + pares);

        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("// ATV2 - Nomes em maiúsculo: " + nomesMaiusculos);

        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println("// ATV3 - Contagem de palavras: " + contagem);

        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500.0),
                new Produto("Mouse", 80.0),
                new Produto("Teclado", 150.0),
                new Produto("Monitor", 900.0)
        );
        List<Produto> produtosCaros = produtos.stream()
                .filter(p -> p.getPreco() > 100.0)
                .collect(Collectors.toList());
        System.out.println("// ATV4 - Produtos com preço > R$100,00:");
        produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$" + p.getPreco()));

        double somaTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("// ATV5 - Soma total dos produtos: R$" + somaTotal);

        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadasPorTamanho = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("// ATV6 - Linguagens ordenadas por tamanho: " + ordenadasPorTamanho);
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
}