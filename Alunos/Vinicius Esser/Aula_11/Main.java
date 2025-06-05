import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU DE ATIVIDADES COM STREAM API ====");
            System.out.println("1 - Filtrar números pares");
            System.out.println("2 - Converter nomes para maiúsculas");
            System.out.println("3 - Contar palavras repetidas");
            System.out.println("4 - Filtrar produtos com preço > R$100");
            System.out.println("5 - Somar total dos preços dos produtos");
            System.out.println("6 - Ordenar linguagens por tamanho");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opçao: ");
            opcao = scanner.nextInt();

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
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

   
    public static void atv1() {
        List<Integer> numeros = Arrays.asList(10, 3, 7, 8, 12, 21, 6, 18);
        List<Integer> pares = numeros.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);
    }

   
    public static void atv2() {
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        List<String> maiusculos = nomes.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculo: " + maiusculos);
    }

    public static void atv3() {
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        Map<String, Long> contagem = palavras.stream()
                                             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Contagem de palavras:");
        contagem.forEach((palavra, qtd) -> System.out.println(palavra + ": " + qtd));
    }

    // Lista de produtos usada nas atvs 4 e 5
    static List<Produto> produtos = Arrays.asList(
        new Produto("Celular", 1200.0),
        new Produto("Fone", 80.0),
        new Produto("Teclado", 150.0),
        new Produto("Mouse", 90.0)
    );

    
    public static void atv4() {
        List<Produto> caros = produtos.stream()
                                      .filter(p -> p.getPreco() > 100.0)
                                      .collect(Collectors.toList());
        System.out.println("Produtos com preço > R$ 100,00:");
        caros.forEach(p -> System.out.println(p.getNome() + " - R$" + p.getPreco()));
    }

   
    public static void atv5() {
        double soma = produtos.stream()
                              .mapToDouble(Produto::getPreco)
                              .sum();
        System.out.println("Soma total dos produtos: R$" + soma);
    }

   
    public static void atv6() {
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
