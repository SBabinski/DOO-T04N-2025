package fag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        // --- ATV1 ---
        System.out.println("// ATV1:");
        List<Integer> numeros = Arrays.asList(10, 15, 22, 3, 8, 7, 44, 50);
        List<Integer> pares = numeros.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());
        System.out.println(pares);

        // --- ATV2 ---
        System.out.println("\n// ATV2:");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());
        System.out.println(nomesMaiusculos);

        // --- ATV3 ---
        System.out.println("\n// ATV3:");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(contagem);

        // --- ATV4 ---
        System.out.println("\n// ATV4:");
        List<Produto> produtos = Arrays.asList(
            new Produto("Camiseta", 79.90),
            new Produto("Tênis", 250.00),
            new Produto("Boné", 50.00),
            new Produto("Jaqueta", 150.00)
        );
        List<Produto> produtosCaros = produtos.stream()
                                             .filter(p -> p.getPreco() > 100.0)
                                             .collect(Collectors.toList());
        produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

        // --- ATV5 ---
        System.out.println("\n// ATV5:");
        double somaTotal = produtos.stream()
                                  .mapToDouble(Produto::getPreco)
                                  .sum();
        System.out.println("Preço total: R$ " + somaTotal);

        // --- ATV6 ---
        System.out.println("\n// ATV6:");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                                          .sorted(Comparator.comparingInt(String::length))
                                          .collect(Collectors.toList());
        System.out.println(ordenadas);
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
