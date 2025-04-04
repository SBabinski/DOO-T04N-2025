import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        this.salarioRecebido.add(salarioBase);
        this.salarioRecebido.add(salarioBase * 1.1);
        this.salarioRecebido.add(salarioBase * 1.2);
    }

    public void apresentarSe() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
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

    public void apresentarSe() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
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

    public void apresentarSe() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + cidade + ", " + bairro + ", " + rua);
    }
}

public class SistemaLoja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da loja: ");
        String nomeLoja = scanner.nextLine();
        System.out.print("Digite a razão social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("Digite o CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String cidadeLoja = scanner.nextLine();
        System.out.print("Digite o bairro: ");
        String bairroLoja = scanner.nextLine();
        System.out.print("Digite a rua: ");
        String ruaLoja = scanner.nextLine();

        Loja loja = new Loja(nomeLoja, razaoSocial, cnpj, cidadeLoja, bairroLoja, ruaLoja);

        System.out.print("Digite o nome do vendedor: ");
        String nomeVendedor = scanner.nextLine();
        System.out.print("Digite a idade do vendedor: ");
        int idadeVendedor = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o salário base: ");
        double salarioBase = scanner.nextDouble();
        scanner.nextLine(); 

        Vendedor vendedor1 = new Vendedor(nomeVendedor, idadeVendedor, nomeLoja, cidadeLoja, bairroLoja, ruaLoja, salarioBase);
        loja.adicionarVendedor(vendedor1);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idadeCliente = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a cidade do cliente: ");
        String cidadeCliente = scanner.nextLine();
        System.out.print("Digite o bairro do cliente: ");
        String bairroCliente = scanner.nextLine();
        System.out.print("Digite a rua do cliente: ");
        String ruaCliente = scanner.nextLine();

        Cliente cliente1 = new Cliente(nomeCliente, idadeCliente, cidadeCliente, bairroCliente, ruaCliente);
        loja.adicionarCliente(cliente1);

        loja.apresentarSe();
        System.out.println("Total de Vendedores: " + loja.contarVendedores());
        System.out.println("Total de Clientes: " + loja.contarClientes());

        vendedor1.apresentarSe();
        System.out.println("Média Salarial: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        cliente1.apresentarSe();

        scanner.close();
    }
}
