
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Atv1();
        Atv2();
        Atv3();
        Atv4();
        Atv5();
        Atv6();
    }

    public static void Atv1() {
        ArrayList<Integer> Numeros = new ArrayList<>();
        Numeros.add(1);
        Numeros.add(2);
        Numeros.add(3);
        Numeros.add(4);
        Numeros.add(5);
        Numeros.add(6);
        Numeros.add(7);
        Numeros.add(8);
        Numeros.add(9);
        Numeros.add(10);

        Numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(System.out::println);
    }

    public static void Atv2() {
        ArrayList<String> pessoas = new ArrayList<>();
        pessoas.add("roberto");
        pessoas.add("josé");
        pessoas.add("caio");
        pessoas.add("vinicius");

        pessoas.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public static void Atv3() {
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("se");
        palavras.add("talvez");
        palavras.add("hoje");
        palavras.add("sábado");
        palavras.add("se");
        palavras.add("quarta");
        palavras.add("sábado");

        palavras.stream();
        Map<String, Long> frequencia = palavras.stream()
                .collect(Collectors.groupingBy(palavra -> palavra, Collectors.counting()));

        Map<String, Long> repetidas = frequencia.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        repetidas.forEach((palavra, count)
                -> System.out.println("Palavra: " + palavra + ", Repeticoes: " + count));
    }

    public static void Atv4() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Red Label", 120.0));
        produtos.add(new Produto("Smirnoff", 50.0));
        produtos.add(new Produto("Jack Daniel's", 200.0));
        produtos.add(new Produto("Velho Barreiro", 19.90));

        produtos.stream()
                .filter(produto -> produto.getPreco() > 100.0)
                .map(produto -> produto.getNome() + " - R$ " + produto.getPreco())
                .forEach(System.out::println);
    }

    public static void Atv5() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Red Label", 120.0));
        produtos.add(new Produto("Smirnoff", 50.0));
        produtos.add(new Produto("Jack Daniel's", 200.0));
        produtos.add(new Produto("Velho Barreiro", 19.90));

        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Total dos produtos: R$ " + total);
    }

    public static void Atv6() {
        ArrayList<String> linguagens = new ArrayList<>();
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("JavaScript");
        linguagens.add("Ruby");

        linguagens.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList())
                .forEach(System.out::println);
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
