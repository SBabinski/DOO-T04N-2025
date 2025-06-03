package fag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // ================== ATV1 ==================
        System.out.println("=== ATV1 ===");
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Digite 8 números inteiros:");
        for (int i = 0; i < 8; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int num = scanner.nextInt();
            numeros.add(num);
        }

        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());

        System.out.println("Números pares: " + pares);

        // ================== ATV2 ==================
        System.out.println("\n=== ATV2 ===");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");

        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());

        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);
        
     // ================== ATV3 ==================
        System.out.println("\n=== ATV3 ===");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> frequencia = palavras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        frequencia.forEach((palavra, count) -> 
            System.out.println(palavra + ": " + count));
        
     // ================== ATV4 ==================
        System.out.println("\n=== ATV4 ===");
        List<Produto> produtos = Arrays.asList(
            new Produto("Camiseta", 79.90),
            new Produto("Tênis", 250.00),
            new Produto("Boné", 120.00),
            new Produto("Meias", 25.00)
        );

        List<Produto> produtosCaros = produtos.stream()
                                             .filter(p -> p.getPreco() > 100)
                                             .collect(Collectors.toList());

        System.out.println("Produtos com preço maior que R$100:");
        produtosCaros.forEach(System.out::println);
        
     // ================== ATV5 ==================
        System.out.println("\n=== ATV5 ===");
        double somaTotal = produtos.stream()
                                  .mapToDouble(Produto::getPreco)
                                  .sum();

        System.out.println("Valor total dos produtos: R$ " + somaTotal);
        
     // ================== ATV6 ==================
        System.out.println("\n=== ATV6 ===");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> linguagensOrdenadas = linguagens.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());

        System.out.println("Linguagens ordenadas pelo tamanho: " + linguagensOrdenadas);




        scanner.close();
    }
 
    static class Produto {
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
            return nome + " - R$ " + preco;
        }
    }

}

