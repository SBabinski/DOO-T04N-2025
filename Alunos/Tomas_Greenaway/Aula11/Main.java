import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Atv1
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 10, 13, 14);
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Pares: " + pares);

        // Atv2
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);

        // Atv3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println("Contagem de palavras: " + contagem);

        // Atv4
        List<Produto> produtos = Arrays.asList(
            new Produto("Monitor", 120.0),
            new Produto("Teclado", 80.0),
            new Produto("Mouse", 40.0),
            new Produto("HD", 150.0)
        );
        List<Produto> caros = produtos.stream().filter(p -> p.getPreco() > 100.0).collect(Collectors.toList());
        System.out.println("Produtos acima de 100: " + caros);

        // Atv5
        double soma = produtos.stream().mapToDouble(Produto::getPreco).sum();
        System.out.println("Soma dos preços: " + soma);

        // Atv6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println("Ordenadas por tamanho: " + ordenadas);
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return nome + " - R$" + preco;
    }
}
