import java.util.ArrayList;

class Vendedor {
    String nome, loja, cidade, bairro, rua;
    int idade;
    float salarioBase;
    float[] salarioRecebido = {2800.00f, 2900.00f, 3000.00f};

    Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, float salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
    }

    void apresentarse() {
        System.out.println("\nNome: " + nome + "\nIdade: " + idade + "\nLoja: " + loja);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    float calcularMedia() {
        float soma = 0;
        for (float salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    float calcularBonus() {
        return salarioBase * 0.2f;
    }
}

class Cliente {
    String nome, cidade, bairro, rua;
    int idade;

    Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    void apresentarse() {
        System.out.println("\nNome: " + nome + "\nIdade: " + idade);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

class Loja {
    String nomeFantasia, razaoSocial, cnpj, cidade, bairro, rua;
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    void adicionaVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    int contarClientes() {
        return clientes.size();
    }

    int contarVendedores() {
        return vendedores.size();
    }

    void apresentarse() {
        System.out.println("\nNome Fantasia: " + nomeFantasia + 
                           "\nCNPJ: " + cnpj + 
                           "\nEndereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class Main {
    public static void main(String[] args) {
        Loja myPlant = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-99", "Cascavel", "Centro", "Rua Paraná");

        Vendedor vendedor1 = new Vendedor("Carlos Silva", 30, "My Plant", "Cascavel", "Coqueiral", "Rua das Palmeiras", 2800.00f);
        Vendedor vendedor2 = new Vendedor("Ana Souza", 28, "My Plant", "Cascavel", "Cancelli", "Rua Manaus", 2900.00f);
        myPlant.adicionaVendedor(vendedor1);
        myPlant.adicionaVendedor(vendedor2);

        Cliente cliente1 = new Cliente("Mariana Oliveira", 25, "Cascavel", "Pacaembu", "Rua das Rosas");
        Cliente cliente2 = new Cliente("Fernando Lima", 40, "Cascavel", "Neva", "Rua dos Girassóis");
        myPlant.adicionaCliente(cliente1);
        myPlant.adicionaCliente(cliente2);

        myPlant.apresentarse();
        System.out.println("\nTotal de clientes: " + myPlant.contarClientes());
        System.out.println("Total de vendedores: " + myPlant.contarVendedores());

        vendedor1.apresentarse();
        System.out.printf("Média dos últimos salários: R$%.2f\n", vendedor1.calcularMedia());
        System.out.printf("Bônus salarial: R$%.2f\n", vendedor1.calcularBonus());

        vendedor2.apresentarse();
        System.out.printf("Média dos últimos salários: R$%.2f\n", vendedor2.calcularMedia());
        System.out.printf("Bônus salarial: R$%.2f\n", vendedor2.calcularBonus());

        cliente1.apresentarse();
        cliente2.apresentarse();
    }
}
