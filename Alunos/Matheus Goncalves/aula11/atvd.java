package aula11;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map;

public class atvd {

    public static void main(String[] args) {

        // ATV1 - Filtrar números pares de uma lista
        System.out.println("// ATV1");
        List<Integer> numeros = Arrays.asList(10, 23, 45, 60, 78, 33, 90, 11);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        // ATV2 - Converter nomes para letras maiúsculas
        System.out.println("\n// ATV2");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);

        // ATV3 - Contar a ocorrência de palavras únicas
        System.out.println("\n// ATV3");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Contagem de palavras:");
        contagem.forEach((palavra, quantidade) -> System.out.println(palavra + ": " + quantidade));

        // ATV4 - Filtrar produtos com preço maior que R$ 100,00
        System.out.println("\n// ATV4");
        List<Produto> produtos = Arrays.asList(
            new Produto("Teclado", 150.0),
            new Produto("Mouse", 50.0),
            new Produto("Monitor", 500.0),
            new Produto("Cabo HDMI", 30.0)
        );

        List<Produto> produtosCaros = produtos.stream()
                                              .filter(p -> p.getPreco() > 100.0)
                                              .collect(Collectors.toList());
        System.out.println("Produtos com preço > R$ 100,00:");
        produtosCaros.forEach(p -> System.out.println(p.getNome() + " - R$ " + p.getPreco()));

        // ATV5 - Soma do valor total dos produtos
        System.out.println("\n// ATV5");
        double somaTotal = produtos.stream()
                                   .mapToDouble(Produto::getPreco)
                                   .sum();
        System.out.println("Valor total dos produtos: R$ " + somaTotal);

        // ATV6 - Ordenar palavras por tamanho (menor para maior)
        System.out.println("\n// ATV6");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadasPorTamanho = linguagens.stream()
                                                     .sorted(Comparator.comparingInt(String::length))
                                                     .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + ordenadasPorTamanho);
    }
}
