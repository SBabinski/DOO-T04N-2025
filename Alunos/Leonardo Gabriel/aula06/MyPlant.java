import java.util.ArrayList;
import java.util.List;

class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double... salarios) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        for (double salario : salarios) {
            this.salarioRecebido.add(salario);
        }
        // Garante que haja pelo menos três lançamentos de salário
        while (this.salarioRecebido.size() < 3) {
            this.salarioRecebido.add(0.0); // Adiciona valores padrão caso menos de três sejam fornecidos
        }
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        if (salarioRecebido.isEmpty()) {
            return 0;
        }
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
    List<Vendedor> vendedores;
    List<Cliente> clientes;

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
        this.vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public int contarClientes() {
        return this.clientes.size();
    }

    public int contarVendedores() {
        return this.vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public List<Vendedor> getVendedores() {
        return this.vendedores;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }
}

public class MyPlantSystem {
    public static void main(String[] args) {
        // Criando a loja
        Loja lojaCentral = new Loja("My Plant Centro", "My Plant Comércio de Plantas LTDA", "XX.XXX.XXX/0001-XX", "Cascavel", "Centro", "Rua Paraná, 123");

        // Criando vendedores
        Vendedor vendedor1 = new Vendedor("Ana Silva", 25, lojaCentral.nomeFantasia, lojaCentral.cidade, lojaCentral.bairro, lojaCentral.rua, 1500.00, 1550.00, 1600.00, 1580.00);
        Vendedor vendedor2 = new Vendedor("Pedro Oliveira", 30, lojaCentral.nomeFantasia, lojaCentral.cidade, lojaCentral.bairro, lojaCentral.rua, 1800.00, 1850.00, 1900.00);
        lojaCentral.adicionarVendedor(vendedor1);
        lojaCentral.adicionarVendedor(vendedor2);

        // Criando clientes
        Cliente cliente1 = new Cliente("Maria Souza", 40, lojaCentral.cidade, "São Cristóvão", "Rua Santa Catarina, 456");
        Cliente cliente2 = new Cliente("João Pereira", 22, lojaCentral.cidade, "Neva", "Avenida Brasil, 789");
        lojaCentral.adicionarCliente(cliente1);
        lojaCentral.adicionarCliente(cliente2);

        // Testando os métodos
        System.out.println("--- Informações da Loja ---");
        lojaCentral.apresentarse();
        System.out.println("Número de clientes: " + lojaCentral.contarClientes());
        System.out.println("Número de vendedores: " + lojaCentral.contarVendedores());
        System.out.println("\n--- Informações dos Vendedores ---");
        for (Vendedor vendedor : lojaCentral.getVendedores()) {
            vendedor.apresentarse();
            System.out.println("Média salarial: R$" + String.format("%.2f", vendedor.calcularMedia()));
            System.out.println("Bônus: R$" + String.format("%.2f", vendedor.calcularBonus()));
            System.out.println("---");
        }
        System.out.println("\n--- Informações dos Clientes ---");
        for (Cliente cliente : lojaCentral.getClientes()) {
            cliente.apresentarse();
            System.out.println("---");
        }
    }
}