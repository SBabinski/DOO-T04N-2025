import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {

        // ATV1 - Filtrar números pares de uma lista
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("// ATV1 - Números pares: " + pares);

        // ATV2 - Converter nomes para letras maiúsculas
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("// ATV2 - Nomes em maiúsculo: " + nomesMaiusculos);

        // ATV3 - Contar palavras únicas
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("// ATV3 - Contagem de palavras:");
        contagem.forEach((palavra, qtd) -> System.out.println(palavra + ": " + qtd));

        // ATV4 - Filtrar produtos com preço maior que R$ 100,00
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 2500.00),
            new Produto("Teclado", 90.00),
            new Produto("Mouse", 45.00),
            new Produto("Monitor", 800.00)
        );
        List<Produto> caros = produtos.stream()
                                      .filter(p -> p.getPreco() > 100)
                                      .collect(Collectors.toList());
        System.out.println("// ATV4 - Produtos com preço > R$ 100:");
        caros.forEach(p -> System.out.println(p.getNome() + " - R$" + p.getPreco()));

        // ATV5 - Soma total dos preços dos produtos
        double somaTotal = produtos.stream()
                                   .mapToDouble(Produto::getPreco)
                                   .sum();
        System.out.println("// ATV5 - Soma total dos produtos: R$" + somaTotal);

        // ATV6 - Ordenar palavras por tamanho
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                                           .sorted(Comparator.comparingInt(String::length))
                                           .collect(Collectors.toList());
        System.out.println("// ATV6 - Linguagens ordenadas por tamanho: " + ordenadas);
    }
}

// Classe Produto para ATV4 e ATV5
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
