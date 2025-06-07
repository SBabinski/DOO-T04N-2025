package fag;

import java.util.*;
import java.util.stream.*;

class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String toString() {
        return nome + " - R$ " + preco;
    }
}

public class Main {
    public static void main(String[] args) {

        // ATV1
        System.out.println("// ATV1");
        var numeros = List.of(1, 2, 3, 4, 10, 15, 20, 22);
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // ATV2
        System.out.println("\n// ATV2");
        var nomes = List.of("roberto", "josé", "caio", "vinicius");
        nomes.stream().map(String::toUpperCase).forEach(System.out::println);

        // ATV3
        System.out.println("\n// ATV3");
        var palavras = List.of("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        palavras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .forEach((p, c) -> System.out.println(p + ": " + c));

        // ATV4
        System.out.println("\n// ATV4");
        var produtos = List.of(
                new Produto("Celular", 1500),
                new Produto("Mouse", 80),
                new Produto("Teclado", 120),
                new Produto("Carregador", 50)
        );
        produtos.stream().filter(p -> p.preco > 100).forEach(System.out::println);

        // ATV5
        System.out.println("\n// ATV5");
        double total = produtos.stream().mapToDouble(p -> p.preco).sum();
        System.out.println("Total: R$ " + total);

        // ATV6
        System.out.println("\n// ATV6");
        var linguagens = List.of("Java", "Python", "C", "JavaScript", "Ruby");
        linguagens.stream()
                  .sorted(Comparator.comparingInt(String::length))
                  .forEach(System.out::println);
    }
}