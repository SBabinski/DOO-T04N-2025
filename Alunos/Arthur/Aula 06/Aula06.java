import java.util.ArrayList;
import java.util.List;

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(2500.0);
        this.salarioRecebido.add(2700.0);
        this.salarioRecebido.add(2800.0);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0.0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
    }
}

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void contarClientes() {
        System.out.println("Quantidade de clientes registrados: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Quantidade de vendedores registrados: " + vendedores.size());
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("My Plant", "My Plant Ltda.", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores, 123");

        Vendedor vendedor1 = new Vendedor("Carlos Silva", 30, "My Plant", "São Paulo", "Centro", "Rua das Flores, 123", 3000.0);
        Vendedor vendedor2 = new Vendedor("Ana Souza", 28, "My Plant", "São Paulo", "Centro", "Rua das Flores, 123", 2800.0);

        Cliente cliente1 = new Cliente("José Pereira", 45, "São Paulo", "Centro", "Rua das Flores, 123");
        Cliente cliente2 = new Cliente("Maria Oliveira", 34, "São Paulo", "Centro", "Rua das Flores, 123");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        loja.apresentarse();

        loja.contarVendedores();
        loja.contarClientes();

        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente1.apresentarse();
        cliente2.apresentarse();

        System.out.println("Média salarial de Vendedor: " + vendedor1.calcularMedia());
        System.out.println("Bônus de Vendedor: " + vendedor1.calcularBonus());
    }
}
