import java.util.ArrayList;

class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    double[] salarioRecebido = {3000.0, 3200.0, 3100.0};

    void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    double calcularMedia() {
        double soma = 0;
        for (double s : salarioRecebido) {
            soma += s;
        }
        return soma / salarioRecebido.length;
    }

    double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    void apresentarse() {
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
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    void contarClientes() {
        System.out.println("Quantidade de clientes: " + clientes.size());
    }

    void contarVendedores() {
        System.out.println("Quantidade de vendedores: " + vendedores.size());
    }

    void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        loja.nomeFantasia = "Versátil";
        loja.razaoSocial = "Versátil Comércio de Plantas Ltda";
        loja.cnpj = "00.000.000/0001-00";
        loja.cidade = "São Paulo";
        loja.bairro = "Centro";
        loja.rua = "Rua das Flores";

        Vendedor v1 = new Vendedor();
        v1.nome = "João";
        v1.idade = 30;
        v1.loja = loja.nomeFantasia;
        v1.cidade = "São Paulo";
        v1.bairro = "Vila Mariana";
        v1.rua = "Rua A";
        v1.salarioBase = 3000.0;

        Vendedor v2 = new Vendedor();
        v2.nome = "Maria";
        v2.idade = 28;
        v2.loja = loja.nomeFantasia;
        v2.cidade = "São Paulo";
        v2.bairro = "Mooca";
        v2.rua = "Rua B";
        v2.salarioBase = 3200.0;

        Cliente c1 = new Cliente();
        c1.nome = "Carlos";
        c1.idade = 40;
        c1.cidade = "São Paulo";
        c1.bairro = "Liberdade";
        c1.rua = "Rua C";

        Cliente c2 = new Cliente();
        c2.nome = "Ana";
        c2.idade = 35;
        c2.cidade = "São Paulo";
        c2.bairro = "Pinheiros";
        c2.rua = "Rua D";

        loja.vendedores.add(v1);
        loja.vendedores.add(v2);
        loja.clientes.add(c1);
        loja.clientes.add(c2);

        loja.apresentarse();
        loja.contarClientes();
        loja.contarVendedores();

        v1.apresentarse();
        System.out.println("Média Salarial: " + v1.calcularMedia());
        System.out.println("Bônus: " + v1.calcularBonus());

        v2.apresentarse();
        System.out.println("Média Salarial: " + v2.calcularMedia());
        System.out.println("Bônus: " + v2.calcularBonus());

        c1.apresentarse();
        c2.apresentarse();
    }
}
