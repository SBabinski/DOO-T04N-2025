package Stram;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciciosStream {

    public static void main(String[] args) {
        System.out.println("Atividade 1 - Números Pares:");
        atividade1();

        System.out.println("\nAtividade 2 - Nomes em Maiúsculas:");
        atividade2();

        System.out.println("\nAtividade 3 - Contagem de Palavras:");
        atividade3();

        System.out.println("\nAtividade 4 - Produtos com preço > R$100:");
        atividade4();

        System.out.println("\nAtividade 5 - Soma do valor dos produtos:");
        atividade5();

        System.out.println("\nAtividade 6 - Ordenação por tamanho:");
        atividade6();
    }

  
    public static void atividade1() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);
    }

   
    public static void atividade2() {
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculo: " + nomesMaiusculos);
    }

 
    public static void atividade3() {
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        contagem.forEach((palavra, quantidade) -> 
            System.out.println(palavra + ": " + quantidade));
    }

   
    public static void atividade4() {
        List<Produto> produtos = getProdutos();
        List<Produto> caros = produtos.stream()
                                      .filter(p -> p.getPreco() > 100)
                                      .collect(Collectors.toList());
        caros.forEach(System.out::println);
    }

    
    public static void atividade5() {
        List<Produto> produtos = getProdutos();
        double total = produtos.stream()
                               .mapToDouble(Produto::getPreco)
                               .sum();
        System.out.println("Valor total: R$" + total);
    }

   
    public static void atividade6() {
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                                           .sorted(Comparator.comparingInt(String::length))
                                           .collect(Collectors.toList());
        System.out.println("Ordenadas por tamanho: " + ordenadas);
    }

    
    public static List<Produto> getProdutos() {
        return Arrays.asList(
            new Produto("Teclado", 120.00),
            new Produto("Mouse", 80.00),
            new Produto("Monitor", 350.00),
            new Produto("Cabo USB", 30.00)
        );
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

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}
