package atividades;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Definição da classe Produto
// Esta classe representa um produto com nome e preço,
// servindo de base para as atividades 4 e 5.
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

    // Sobrescrita do método toString para exibir informações do produto de forma legível.
    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", preco=" + String.format("R$ %.2f", preco) + // Formata o preço para o padrão monetário brasileiro
               '}';
    }
}

// Classe principal que conterá a lógica para todas as atividades.
public class Main {

    // Método principal, ponto de entrada da aplicação.
    public static void main(String[] args) {

        // --- ATIVIDADE 1 ---
        // Objetivo: Filtrar números pares de uma lista de inteiros.
        System.out.println("//ATV1: Filtragem de números pares");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println("Lista original de números: " + numeros);

        // Utiliza a Stream API para processar a lista:
        // 1. stream(): Converte a lista em um fluxo de dados.
        // 2. filter(n -> n % 2 == 0): Aplica um predicado para selecionar apenas os números pares.
        // 3. collect(Collectors.toList()): Coleta os elementos filtrados em uma nova lista.
        List<Integer> numerosPares = numeros.stream()
                                           .filter(numero -> numero % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("Números pares resultantes: " + numerosPares);
        System.out.println("------------------------------------");

        // --- ATIVIDADE 2 ---
        // Objetivo: Converter uma lista de nomes para letras maiúsculas.
        System.out.println("\n//ATV2: Conversão de nomes para maiúsculas");
        List<String> nomes = Arrays.asList("roberto", "josé", "caio", "vinicius");
        System.out.println("Nomes originais: " + nomes);

        // Utiliza a Stream API para transformar cada nome:
        // 1. stream(): Converte a lista de nomes em um fluxo.
        // 2. map(String::toUpperCase): Aplica a função toUpperCase a cada nome no fluxo.
        //    (String::toUpperCase é uma Method Reference, equivalente a nome -> nome.toUpperCase())
        // 3. collect(Collectors.toList()): Coleta os nomes transformados em uma nova lista.
        List<String> nomesMaiusculos = nomes.stream()
                                          .map(String::toUpperCase)
                                          .collect(Collectors.toList());
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);
        System.out.println("------------------------------------");

        // --- ATIVIDADE 3 ---
        // Objetivo: Contar a frequência de cada palavra única em uma lista de strings.
        System.out.println("\n//ATV3: Contagem da frequência de palavras únicas");
        List<String> palavras = Arrays.asList("se", "talvez", "hoje", "sábado", "se", "quarta", "sábado");
        System.out.println("Lista de palavras original: " + palavras);

        // Utiliza a Stream API para agrupar e contar as palavras:
        // 1. stream(): Converte a lista de palavras em um fluxo.
        // 2. collect(Collectors.groupingBy(...)): Agrupa os elementos do fluxo.
        //    - O primeiro argumento (palavra -> palavra) define a chave de agrupamento (a própria palavra).
        //    - O segundo argumento (Collectors.counting()) define como os valores de cada grupo são agregados (contando as ocorrências).
        Map<String, Long> contagemPalavras = palavras.stream()
                                                    .collect(Collectors.groupingBy(
                                                             palavra -> palavra,
                                                             Collectors.counting()
                                                    ));
        System.out.println("Contagem de cada palavra: " + contagemPalavras);
        System.out.println("------------------------------------");

        // --- ATIVIDADE 4 ---
        // Objetivo: Filtrar produtos com preço superior a R$ 100,00.
        // A classe Produto foi definida no início deste arquivo.
        System.out.println("\n//ATV4: Filtragem de produtos por preço");
        // Criação de uma lista de objetos Produto com valores "hard coded".
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook Gamer", 5500.00),
            new Produto("Mousepad", 89.90),
            new Produto("Teclado Mecânico", 450.00),
            new Produto("Monitor Ultrawide", 1250.75),
            new Produto("Cadeira Gamer", 99.99)
        );
        System.out.println("Lista original de produtos:");
        produtos.forEach(System.out::println); // Imprime cada produto usando o método toString da classe Produto.

        // Utiliza a Stream API para filtrar os produtos:
        // 1. stream(): Converte a lista de produtos em um fluxo.
        // 2. filter(produto -> produto.getPreco() > 100.00): Seleciona produtos com preço maior que 100.
        // 3. collect(Collectors.toList()): Coleta os produtos filtrados em uma nova lista.
        List<Produto> produtosCaros = produtos.stream()
                                             .filter(produto -> produto.getPreco() > 100.00)
                                             .collect(Collectors.toList());
        System.out.println("\nProdutos com preço maior que R$ 100,00:");
        produtosCaros.forEach(System.out::println);
        System.out.println("------------------------------------");

        // --- ATIVIDADE 5 ---
        // Objetivo: Calcular a soma total dos preços de todos os produtos da lista anterior.
        System.out.println("\n//ATV5: Soma do valor total dos produtos");
        // Reutiliza a lista 'produtos' definida na ATV4.

        // Utiliza a Stream API para somar os preços:
        // 1. stream(): Converte a lista de produtos em um fluxo.
        // 2. mapToDouble(Produto::getPreco): Extrai o atributo 'preco' de cada objeto Produto,
        //    resultando em um DoubleStream (um fluxo especializado para doubles).
        // 3. sum(): Calcula a soma de todos os valores no DoubleStream.
        double somaTotalProdutos = produtos.stream()
                                         .mapToDouble(Produto::getPreco)
                                         .sum();
        System.out.println("Soma do valor total de todos os produtos: " + String.format("R$ %.2f", somaTotalProdutos));
        System.out.println("------------------------------------");

        // --- ATIVIDADE 6 ---
        // Objetivo: Ordenar uma lista de strings pelo tamanho da palavra, da menor para a maior.
        System.out.println("\n//ATV6: Ordenação de strings por tamanho");
        List<String> linguagens = Arrays.asList("Java", "Python", "C", "JavaScript", "Ruby");
        System.out.println("Lista original de linguagens: " + linguagens);

        // Utiliza a Stream API para ordenar as strings:
        // 1. stream(): Converte a lista de linguagens em um fluxo.
        // 2. sorted(Comparator.comparingInt(String::length)): Ordena o fluxo.
        //    - Comparator.comparingInt(String::length) cria um comparador que compara as strings
        //      com base no inteiro retornado por String::length (o comprimento da string).
        // 3. collect(Collectors.toList()): Coleta as strings ordenadas em uma nova lista.
        List<String> linguagensOrdenadasPorTamanho = linguagens.stream()
                                                             .sorted(Comparator.comparingInt(String::length))
                                                             .collect(Collectors.toList());
        System.out.println("Linguagens ordenadas por tamanho (menor para maior): " + linguagensOrdenadasPorTamanho);
        System.out.println("------------------------------------");
    }
}