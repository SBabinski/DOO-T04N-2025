package fag;

import java.util.*;

class Venda {
    int quantidade;
    double precoUnitario;
    double total;
    double desconto;
    String data;

    public Venda(int quantidade, double precoUnitario, double total, double desconto, String data) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.total = total;
        this.desconto = desconto;
        this.data = data;
    }
}

class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    List<Double> salarioRecebido = Arrays.asList(2500.0, 2700.0, 2600.0);

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
    }

    public void apresentarSe() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
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
    List<Vendedor> vendedores = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
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
        System.out.println("Loja: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}

public class Aula06 {
    private static final Map<String, List<Venda>> registroVendas = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema My Plant ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Exibir Registro de Vendas");
            System.out.println("[3] - Calcular Troco");
            System.out.println("[4] - Buscar Vendas por Data");
            System.out.println("[5] - Sair");
            System.out.println("[6] - Testar Sistema da Loja");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    exibirRegistroVendas();
                    break;
                case 3:
                    calcularTroco(scanner);
                    break;
                case 4:
                    buscarVendasPorData(scanner);
                    break;
                case 5:
                    System.out.println("Saindo... Obrigado por usar o sistema My Plant!");
                    break;
                case 6:
                    testarSistemaLoja();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite a data da venda (dd/MM/yyyy): ");
        String data = scanner.nextLine();

        double total = quantidade * precoUnitario;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
        }

        Venda venda = new Venda(quantidade, precoUnitario, total, desconto, data);
        registroVendas.computeIfAbsent(data, k -> new ArrayList<>()).add(venda);

        System.out.printf("O preço total da compra é: R$ %.2f\n", total);
        if (desconto > 0) {
            System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
        }
    }

    public static void exibirRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
            return;
        }

        System.out.println("\n=== Registro de Vendas ===");
        for (String data : registroVendas.keySet()) {
            System.out.println("Data: " + data);
            for (Venda venda : registroVendas.get(data)) {
                System.out.printf("Quantidade: %d, Preço Unitário: R$ %.2f, Total: R$ %.2f, Desconto: R$ %.2f\n",
                        venda.quantidade, venda.precoUnitario, venda.total, venda.desconto);
            }
        }
    }

    public static void buscarVendasPorData(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite a data para busca (dd/MM/yyyy): ");
        String data = scanner.nextLine();

        if (!registroVendas.containsKey(data)) {
            System.out.println("Nenhuma venda encontrada para essa data.");
            return;
        }

        System.out.println("\n=== Vendas do dia " + data + " ===");
        for (Venda venda : registroVendas.get(data)) {
            System.out.printf("Quantidade: %d, Preço Unitário: R$ %.2f, Total: R$ %.2f, Desconto: R$ %.2f\n",
                    venda.quantidade, venda.precoUnitario, venda.total, venda.desconto);
        }
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido < valorTotal) {
            System.out.println("Valor insuficiente! O cliente precisa pagar mais.");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
        }
    }

    public static void testarSistemaLoja() {
        Loja loja = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-99", "Curitiba", "Centro", "Rua das Flores");

        Vendedor v1 = new Vendedor("João", 30, loja.nomeFantasia, "Curitiba", "Centro", "Rua A", 2500.0);
        Vendedor v2 = new Vendedor("Maria", 28, loja.nomeFantasia, "Curitiba", "Centro", "Rua B", 2600.0);

        Cliente c1 = new Cliente("Carlos", 40, "Curitiba", "Centro", "Rua C");
        Cliente c2 = new Cliente("Ana", 35, "Curitiba", "Batel", "Rua D");

        loja.adicionarVendedor(v1);
        loja.adicionarVendedor(v2);
        loja.adicionarCliente(c1);
        loja.adicionarCliente(c2);

        loja.apresentarSe();
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());

        v1.apresentarSe();
        System.out.printf("Média de salários: R$ %.2f\n", v1.calcularMedia());
        System.out.printf("Bônus: R$ %.2f\n", v1.calcularBonus());

        c1.apresentarSe();
    }
}
