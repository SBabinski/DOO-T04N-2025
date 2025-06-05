import java.util.ArrayList;

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        salarioRecebido.add(2000.00);
        salarioRecebido.add(2200.00);
        salarioRecebido.add(2100.00);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
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
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Cliente> clientes;

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

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores");

        Vendedor vendedor1 = new Vendedor("João", 30, "My Plant", "São Paulo", "Centro", "Rua das Flores", 2500.00);
        Vendedor vendedor2 = new Vendedor("Maria", 25, "My Plant", "São Paulo", "Centro", "Rua das Flores", 2800.00);

        Cliente cliente1 = new Cliente("Carlos", 40, "São Paulo", "Centro", "Rua das Flores");
        Cliente cliente2 = new Cliente("Ana", 35, "São Paulo", "Centro", "Rua das Flores");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        loja.apresentarse();

        System.out.println("\nVendedores:");
        for (Vendedor vendedor : loja.vendedores) {
            vendedor.apresentarse();
            System.out.println("Média dos salários: " + vendedor.calcularMedia());
            System.out.println("Bônus: " + vendedor.calcularBonus());
            System.out.println();
        }

        System.out.println("Clientes:");
        for (Cliente cliente : loja.clientes) {
            cliente.apresentarse();
            System.out.println();
        }

        System.out.println("Total de Vendedores: " + loja.contarVendedores());
        System.out.println("Total de Clientes: " + loja.contarClientes());
    }
}
