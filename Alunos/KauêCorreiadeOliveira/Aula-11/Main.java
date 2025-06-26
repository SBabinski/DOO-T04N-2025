import java.util.*;
import java.util.stream.*;
import java.util.function.*;

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

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}

public class Main {
    public static void main(String[] args) {
        // atividade 1
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        System.out.println("atividade 1: " + pares + "\n");

        // atividade 2
        List<String> nomes = Arrays.asList("roberto", "jose", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("atividade 2: " + nomesMaiusculos + "\n");

        // atividade 3
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sabado", "se", "quarta", "sabado");
        Map<String, Long> contagem = palavras.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("atividade 3: " + contagem + "\n");

        // atividade 4
        List<Produto> produtos = Arrays.asList(
            new Produto("notebook", 3500.00),
            new Produto("mouse", 80.00),
            new Produto("teclado", 150.00),
            new Produto("monitor", 900.00)
        );

        List<Produto> produtosCaros = produtos.stream()
            .filter(p -> p.getPreco() > 100.00)
            .collect(Collectors.toList());
        System.out.println("atividade 4:  Produtos com preco > R$ 100,00:" + "\n");
        produtosCaros.forEach(System.out::println);

        //atividade 5
        double somaTotal = produtos.stream()
            .mapToDouble(Produto::getPreco)
            .sum();
        System.out.println("atividade 5: Soma total dos produtos: R$" + somaTotal + "\n");

        // atividade 6
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadasPorTamanho = linguagens.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
        System.out.println("atividade 6:  Linguagens ordenadas por tamanho: " + ordenadasPorTamanho + "\n");
    }
}
