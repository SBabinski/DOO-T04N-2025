import java.util.ArrayList;

// Classe Vendedor
class Vendedor {
    String nome;
    int idade;
    Loja loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    ArrayList<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        // Lançamentos de salário fixos para exemplo
        this.salarioRecebido.add(2500.0);
        this.salarioRecebido.add(2600.0);
        this.salarioRecebido.add(2550.0);
    }

    public void apresentarse() {
        System.out.println("Vendedor:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        if (loja != null) {
            System.out.println("Loja: " + loja.nomeFantasia);
        } else {
            System.out.println("Loja: Não atribuída");
        }
        System.out.println();
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return salarioRecebido.size() > 0 ? soma / salarioRecebido.size() : 0;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

// Classe Cliente
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
        System.out.println("Cliente:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println();
    }
}

// Classe Loja
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

    public void adicionaVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.println("Loja:");
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
        System.out.println();
    }
}

// Classe principal para testes
public class MyPlantSistema {
    public static void main(String[] args) {
        // Criando uma loja
        Loja loja = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores");

        // Criando vendedores
        Vendedor vendedor1 = new Vendedor("Gabriel", 30, loja, "São Paulo", "Centro", "Rua Verde", 2500.0);
        Vendedor vendedor2 = new Vendedor("Maria", 28, loja, "São Paulo", "Centro", "Rua Azul", 2600.0);

        // Adicionando vendedores à loja
        loja.adicionaVendedor(vendedor1);
        loja.adicionaVendedor(vendedor2);

        // Criando clientes
        Cliente cliente1 = new Cliente("João", 40, "São Paulo", "Centro", "Rua Rosa");
        Cliente cliente2 = new Cliente("Ana", 35, "São Paulo", "Vila Mariana", "Rua Amarela");

        // Adicionando clientes à loja
        loja.adicionaCliente(cliente1);
        loja.adicionaCliente(cliente2);

        // Apresentações
        loja.apresentarse();

        vendedor1.apresentarse();
        System.out.println("Média Salarial: R$" + vendedor1.calcularMedia());
        System.out.println("Bônus: R$" + vendedor1.calcularBonus());
        System.out.println();

        vendedor2.apresentarse();
        System.out.println("Média Salarial: R$" + vendedor2.calcularMedia());
        System.out.println("Bônus: R$" + vendedor2.calcularBonus());
        System.out.println();

        cliente1.apresentarse();
        cliente2.apresentarse();

        // Contagem
        System.out.println("Total de Vendedores: " + loja.contarVendedores());
        System.out.println("Total de Clientes: " + loja.contarClientes());
    }
}
