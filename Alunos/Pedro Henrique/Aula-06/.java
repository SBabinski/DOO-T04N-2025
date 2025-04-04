public class Aula06 {

    // Classe Vendedor
    static class Vendedor {
        String nome;
        int idade;
        String loja;
        String cidade;
        String bairro;
        String rua;
        double salarioBase;
        double[] salarioRecebido = {2000.0, 2100.0, 2200.0};

        public void apresentarse() {
            System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
        }

        public double calcularMedia() {
            double soma = 0;
            for (double salario : salarioRecebido) {
                soma += salario;
            }
            return soma / salarioRecebido.length;
        }

        public double calcularBonus() {
            return salarioBase * 0.2;
        }
    }

    // Classe Cliente
    static class Cliente {
        String nome;
        int idade;
        String cidade;
        String bairro;
        String rua;

        public void apresentarse() {
            System.out.println("Nome: " + nome + ", Idade: " + idade);
        }
    }

    // Classe Loja
    static class Loja {
        String nomeFantasia;
        String razaoSocial;
        String cnpj;
        String cidade;
        String bairro;
        String rua;

        Vendedor[] vendedores;
        Cliente[] clientes;

        public int contarClientes() {
            return clientes != null ? clientes.length : 0;
        }

        public int contarVendedores() {
            return vendedores != null ? vendedores.length : 0;
        }

        public void apresentarse() {
            System.out.println("Nome Fantasia: " + nomeFantasia);
            System.out.println("CNPJ: " + cnpj);
            System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
        }
    }

    // Classe Principal
    public static void main(String[] args) {
        // Criando Vendedor
        Vendedor v1 = new Vendedor();
        v1.nome = "João";
        v1.idade = 30;
        v1.loja = "My Plant Central";
        v1.cidade = "Cidade A";
        v1.bairro = "Centro";
        v1.rua = "Rua das Flores";
        v1.salarioBase = 2000.0;

        // Criando Cliente
        Cliente c1 = new Cliente();
        c1.nome = "Maria";
        c1.idade = 25;
        c1.cidade = "Cidade A";
        c1.bairro = "Centro";
        c1.rua = "Rua Verde";

        // Criando Loja
        Loja loja = new Loja();
        loja.nomeFantasia = "My Plant";
        loja.razaoSocial = "My Plant Comércio LTDA";
        loja.cnpj = "00.000.000/0001-00";
        loja.cidade = "Cidade A";
        loja.bairro = "Centro";
        loja.rua = "Rua das Plantas";

        loja.vendedores = new Vendedor[]{v1};
        loja.clientes = new Cliente[]{c1};

        // Testando os métodos
        loja.apresentarse();
        System.out.println("Total de Clientes: " + loja.contarClientes());
        System.out.println("Total de Vendedores: " + loja.contarVendedores());

        v1.apresentarse();
        System.out.println("Média Salarial: R$ " + v1.calcularMedia());
        System.out.println("Bônus: R$ " + v1.calcularBonus());

        c1.apresentarse();
    }
}
