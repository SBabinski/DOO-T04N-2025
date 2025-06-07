import java.util.ArrayList;

class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, ArrayList<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
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
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    ArrayList<Vendedor> vendedores;
    ArrayList<Cliente> clientes;

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
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + cidade + ", " + bairro + ", " + rua);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> salarios = new ArrayList<>();
        salarios.add(3000.0);
        salarios.add(3200.0);
        salarios.add(3100.0);

        Vendedor vendedor = new Vendedor("Carlos", 30, "My Plant", "São Paulo", "Centro", "Rua A", 3000.0, salarios);
        Cliente cliente = new Cliente("Ana", 25, "São Paulo", "Centro", "Rua B");
        Loja loja = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-90", "São Paulo", "Centro", "Rua C");

        loja.adicionarVendedor(vendedor);
        loja.adicionarCliente(cliente);

        vendedor.apresentarse();
        System.out.println("Média dos salários: " + vendedor.calcularMedia());
        System.out.println("Bônus: " + vendedor.calcularBonus());

        cliente.apresentarse();
        loja.apresentarse();
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());
    }
}