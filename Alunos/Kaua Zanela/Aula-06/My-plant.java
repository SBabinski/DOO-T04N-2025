import java.util.ArrayList;

class Vendedor {
    String nome;
    int idade;
    Loja loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    ArrayList<Double> salarioRecebido = new ArrayList<>();

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
      
        salarioRecebido.add(1500.0);
        salarioRecebido.add(1600.0);
        salarioRecebido.add(1700.0);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.nomeFantasia);
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
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void contarClientes() {
        System.out.println("Total de clientes: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Total de vendedores: " + vendedores.size());
    }

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
}

public class MyPlant {
    public static void main(String[] args) {
        Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.658/0001-90", "Florianópolis", "Jardim Aurora", "Rua das Rosas");

        Vendedor v1 = new Vendedor("Lucas", 24, loja, "Florianópolis", "Jardim Aurora", "Rua Morais", 1780);
        Vendedor v2 = new Vendedor("Maria", 30, loja, "Florianópolis", "Jardim Aurora", "Rua Da Costa", 1490);

        Cliente c1 = new Cliente("João", 45, "Florianópolis", "Centro", "Rua Carlos");
        Cliente c2 = new Cliente("Ana", 27, "Florianópolis", "Costa Rica", "Rua Pedregulho");

        loja.adicionarVendedor(v1);
        loja.adicionarVendedor(v2);
        loja.adicionarCliente(c1);
        loja.adicionarCliente(c2);

        loja.apresentarse();
        loja.contarClientes();
        loja.contarVendedores();

        v1.apresentarse();
        System.out.println("Média de salário: R$" + v1.calcularMedia());
        System.out.println("Bônus: R$" + v1.calcularBonus());

        c1.apresentarse();
    }
}
