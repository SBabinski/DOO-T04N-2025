import java.util.*;
import java.util.stream.*;

public class Aula11 {

    public static void main(String[] args) {

        System.out.println("// Atividade1");
        List<Integer> numeros = Arrays.asList(3, 8, 12, 5, 7, 2, 10, 15, 18);
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        System.out.println("\n// Atividade2");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculo: " + nomesMaiusculos);

        System.out.println("\n// Atividade3");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println("Contagem de palavras: " + contagem);

        System.out.println("\n// Atividade4");
        List<Produto> produtos = Arrays.asList(
                new Produto("Raquete", 1500.00),
                new Produto("Bola", 20.00),
                new Produto("Corda", 300.00),
                new Produto("Grip", 25.00)
        );
        List<Produto> produtosCaros = produtos.stream()
                .filter(p -> p.getPreco() > 100.00)
                .collect(Collectors.toList());
        System.out.println("Produtos de preço > R$100,00:");
        produtosCaros.forEach(p -> System.out.println(p.getNome() + "- R$" + p.getPreco()));

        System.out.println("\n// Atividade5");
        double somaTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Soma total dos preços: R$" + somaTotal);

        System.out.println("\n// Atividade6");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        List<String> ordenadas = linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho: " + ordenadas);
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

