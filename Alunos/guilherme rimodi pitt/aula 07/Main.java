import java.util.ArrayList;
import java.util.List;

class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private double[] salarioRecebido; 

    public Gerente(String nome, int idade, String loja, double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public double calcularMediaSalarios() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: R$ " + valor);
    }

    public double getValor() {
        return valor;
    }
}

class Pedido {
    private int id;
    private String dataCriacao;
    private List<Item> itens;

    public Pedido(int id, String dataCriacao) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoPedido() {
        System.out.println("ID do Pedido: " + id);
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Valor Total: R$ " + calcularValorTotal());
    }
}

public class Main {
    public static void main(String[] args) {

        double[] salarios = {3000.0, 3500.0, 4000.0};
        Gerente gerente = new Gerente("Carlos Silva", 40, "Loja Central", 5000.0, salarios);

        gerente.apresentar();
        System.out.println("Média dos Salários: R$ " + gerente.calcularMediaSalarios());
        System.out.println("Bônus: R$ " + gerente.calcularBonus());
        System.out.println();

        Item item1 = new Item(1, "Produto A", "Categoria 1", 150.0);
        Item item2 = new Item(2, "Produto B", "Categoria 2", 250.0);

        Pedido pedido = new Pedido(1, "2025-04-10");
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        pedido.gerarDescricaoPedido();
    }
}
