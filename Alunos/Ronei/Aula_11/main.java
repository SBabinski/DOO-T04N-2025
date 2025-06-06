import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AtividadeStreamAPI {
    public static void main(String[] args) {
        atividade01();
        atividade02();
        atividade03();
        atividade04();
        atividade05();
        atividade06();
    }

    public static void atividade01() {
        List<Integer> listaNumeros = Arrays.asList(5, 4, 9, 3, 6, 8, 2, 10, 11);

        List<Integer> numerosPares = listaNumeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Números pares: " + numerosPares);
    }

    public static void atividade02() {
        List<String> ListaNomes = Arrays.asList("roberto", "josé", "caio", "vinicius");

         ListaNomes = ListaNomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Nomes em maiúsculas: " + ListaNomes);
    }

    public static void atividade03() {
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");

        Map<String, Long> contagemPalavras = palavras.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Contagem de palavras:");
        contagemPalavras.forEach((palavra, contagem) -> 
            System.out.println(palavra + ": " + contagem));
    }

    public static void atividade04() {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 2500.00),
            new Produto("Mouse", 80.00),
            new Produto("Monitor", 750.00),
            new Produto("Caneta", 5.00)
        );

        List<Produto> produtosCaros = produtos.stream()
                .filter(p -> p.getPreco() > 100.00)
                .collect(Collectors.toList());

        System.out.println("Produtos com preço acima de R$ 100,00:");
        produtosCaros.forEach(p ->
            System.out.println(p.getNome() + " - R$ " + p.getPreco()));
    }

    public static void atividade05() {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 2500.00),
            new Produto("Mouse", 80.00),
            new Produto("Monitor", 750.00),
            new Produto("Caneta", 5.00)
        );

        double somaTotal = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();

        System.out.printf("Valor total dos produtos: R$ %.2f%n", somaTotal);
    }

    public static void atividade06() {
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");

        List<String> ordenadasPorTamanho = linguagens.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());

        System.out.println("Linguagens ordenadas por tamanho:");
        ordenadasPorTamanho.forEach(System.out::println);
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