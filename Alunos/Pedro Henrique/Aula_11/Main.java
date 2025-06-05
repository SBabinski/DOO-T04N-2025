package streamapi;

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
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU DE ATIVIDADES:");
            System.out.println("1 - Filtrar números pares");
            System.out.println("2 - Converter nomes para maiúsculas");
            System.out.println("3 - Contar palavras na lista");
            System.out.println("4 - Filtrar produtos com preço > R$ 100");
            System.out.println("5 - Somar preço total dos produtos");
            System.out.println("6 - Ordenar linguagens por tamanho");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    atv1();
                    break;
                case 2:
                    atv2();
                    break;
                case 3:
                    atv3();
                    break;
                case 4:
                    atv4();
                    break;
                case 5:
                    atv5();
                    break;
                case 6:
                    atv6();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ATV1 - Filtrar números pares
    public static void atv1() {
        List<Integer> numeros = Arrays.asList(3, 12, 5, 8, 13, 4, 20, 7);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);
    }

    // ATV2 - Converter nomes para maiúsculas
    public static void atv2() {
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> maiusculos = nomes.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculo: " + maiusculos);
    }

    // ATV3 - Contar palavras
    public static void atv3() {
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Contagem de palavras: " + contagem);
    }

    // ATV4 - Filtrar produtos com preço > 100
    public static void atv4() {
        List<Produto> produtos = getProdutos();
        List<Produto> caros = produtos.stream()
                                      .filter(p -> p.getPreco() > 100.0)
                                      .collect(Collectors.toList());
        System.out.println("Produtos com preço > R$100: ");
        caros.forEach(System.out::println);
    }

    // ATV5 - Somar preço total dos produtos
    public static void atv5() {
        List<Produto> produtos = getProdutos();
        double total = produtos.stream()
                               .mapToDouble(Produto::getPreco)
                               .sum();
        System.out.println("Soma total dos produtos: R$" + total);
    }

    // ATV6 - Ordenar linguagens por tamanho
    public static void atv6() {
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                                           .sorted(Comparator.comparingInt(String::length))
                                           .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + ordenadas);
    }

    // Lista hard coded para Atv4 e Atv5
    public static List<Produto> getProdutos() {
        return Arrays.asList(
            new Produto("Notebook", 3500.0),
            new Produto("Mouse", 50.0),
            new Produto("Teclado", 150.0),
            new Produto("Monitor", 900.0)
        );
    }
}