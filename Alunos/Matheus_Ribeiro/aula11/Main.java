package main;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        // ATV1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + evenNumbers);

        // ATV2
        List<String> names = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculo: " + upperNames);

        // ATV3
        List<String> words = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("Contagem de palavras: " + wordCount);

        // ATV4
        List<Product> products = Arrays.asList(
                new Product("TV", 150.0),
                new Product("Mouse", 50.0),
                new Product("Notebook", 2500.0),
                new Product("Teclado", 120.0)
        );
        List<Product> expensiveProducts = products.stream()
                .filter(p -> p.getPrice() > 100.0)
                .collect(Collectors.toList());
        System.out.println("Produtos com preço > R$100: " + expensiveProducts);

        // ATV5
        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Valor total dos produtos: R$" + totalPrice);

        // ATV6
        List<String> langs = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> sortedLangs = langs.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + sortedLangs);
    }
}
