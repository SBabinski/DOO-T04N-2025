import java.util.*;
import java.util.stream.Collectors;

class Venda {
    int quantidade;
    double precoUnitario;
    double valorTotal;
    double desconto;
    String data;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, String data) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Quantidade: " + quantidade + ", Preço Unitário: R$ " + String.format("%.2f", precoUnitario) +
               ", Valor Total: R$ " + String.format("%.2f", valorTotal) + ", Desconto: R$ " + String.format("%.2f", desconto);
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
    double[] salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new double[] {salarioBase, salarioBase * 1.1, salarioBase * 1.2};
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return Arrays.stream(salarioRecebido).average().orElse(0);
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

    public void apresentarse() {
        System.out.println("Loja: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }
}

public class CalculadoraVendas {
    private static final double DESCONTO_ESPECIAL = 0.05;
    private static final Map<String, List<Venda>> registroVendas = new HashMap<>();
    private static Loja loja = new Loja("Dona gbrl", "Dona Gabrielinha LTDA", "00.000.000/0001-00", "Cidade Jardim", "Centro", "Rua das Flores");

    public static double calcularPrecoTotal(int quantidade, double precoUnitario, String data) {
        double precoTotal = quantidade * precoUnitario;
        double desconto = 0.0;

        if (quantidade > 10) {
            desconto = precoTotal * DESCONTO_ESPECIAL;
            precoTotal -= desconto;
        }

        registrarVenda(quantidade, precoUnitario, precoTotal, desconto, data);
        return precoTotal;
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }

    public static void registrarVenda(int quantidade, double precoUnitario, double valorTotal, double desconto, String data) {
        registroVendas.putIfAbsent(data, new ArrayList<>());
        registroVendas.get(data).add(new Venda(quantidade, precoUnitario, valorTotal, desconto, data));
    }

    public static void exibirRegistroVendas() {
        System.out.println("\nRegistro de Vendas:");
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            for (String data : registroVendas.keySet()) {
                System.out.println("Data: " + data);
                for (Venda venda : registroVendas.get(data)) {
                    System.out.println(venda);
                }
            }
        }
    }

    public static void buscarVendasPorData(String data) {
        System.out.println("\nVendas do dia " + data + ":");
        if (registroVendas.containsKey(data)) {
            for (Venda venda : registroVendas.get(data)) {
                System.out.println(venda);
            }
        } else {
            System.out.println("Nenhuma venda registrada para esta data.");
        }
    }

    public static void buscarVendasPorMes(String mesAno) {
        System.out.println("\nVendas do mês " + mesAno + ":");
        List<Venda> vendasDoMes = registroVendas.values().stream()
            .flatMap(List::stream)
            .filter(venda -> venda.data.substring(3).equals(mesAno))
            .collect(Collectors.toList());

        if (vendasDoMes.isEmpty()) {
            System.out.println("Nenhuma venda registrada para este mês.");
        } else {
            vendasDoMes.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("\nMenu:");
                System.out.println("[1] - Calcular Preço Total");
                System.out.println("[2] - Calcular Troco");
                System.out.println("[3] - Exibir Registro de Vendas");
                System.out.println("[4] - Buscar Vendas por Data");
                System.out.println("[5] - Buscar Vendas por Mês");
                System.out.println("[6] - Cadastrar Cliente");
                System.out.println("[7] - Cadastrar Vendedor");
                System.out.println("[8] - Exibir Informações da Loja");
                System.out.println("[9] - Sair");
                System.out.print("Escolha uma opção: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, digite um número válido.");
                    scanner.next();
                }
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("\nDigite a data da venda (DD/MM/AAAA): ");
                        String data = scanner.nextLine();
                        System.out.print("Digite a quantidade de plantas: ");
                        int quantidade = scanner.nextInt();
                        System.out.print("Digite o preço unitário da planta: ");
                        double precoUnitario = scanner.nextDouble();
                        double precoTotal = calcularPrecoTotal(quantidade, precoUnitario, data);
                        System.out.printf("O preço total da compra, com descontos aplicados, é: R$ %.2f\n", precoTotal);
                    }
                    case 2 -> {
                        System.out.print("Digite o valor pago pelo cliente: R$ ");
                        double valorPago = scanner.nextDouble();
                        System.out.print("Digite o valor total da compra: R$ ");
                        double valorTotalCompra = scanner.nextDouble();

                        if (valorPago >= valorTotalCompra) {
                            double troco = calcularTroco(valorPago, valorTotalCompra);
                            System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
                        } else {
                            System.out.println("Valor insuficiente. O cliente precisa pagar o valor total da compra.");
                        }
                    }
                    case 3 -> exibirRegistroVendas();
                    case 4 -> {
                        System.out.print("Digite a data (DD/MM/AAAA) para buscar as vendas: ");
                        buscarVendasPorData(scanner.nextLine());
                    }
                    case 5 -> {
                        System.out.print("Digite o mês e ano (MM/AAAA) para buscar as vendas: ");
                        buscarVendasPorMes(scanner.nextLine());
                    }
                    case 6 -> {
                        System.out.print("Nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();
                        System.out.print("Bairro: ");
                        String bairro = scanner.nextLine();
                        System.out.print("Rua: ");
                        String rua = scanner.nextLine();
                        loja.clientes.add(new Cliente(nome, idade, cidade, bairro, rua));
                        System.out.println("Cliente cadastrado com sucesso!");
                    }
                    case 7 -> {
                        System.out.print("Nome do vendedor: ");
                        String nome = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();
                        System.out.print("Bairro: ");
                        String bairro = scanner.nextLine();
                        System.out.print("Rua: ");
                        String rua = scanner.nextLine();
                        System.out.print("Salário base: ");
                        double salarioBase = scanner.nextDouble();
                        loja.vendedores.add(new Vendedor(nome, idade, loja.nomeFantasia, cidade, bairro, rua, salarioBase));
                        System.out.println("Vendedor cadastrado com sucesso!");
                    }
                    case 8 -> {
                        loja.apresentarse();
                        System.out.println("Clientes cadastrados: " + loja.contarClientes());
                        System.out.println("Vendedores cadastrados: " + loja.contarVendedores());
                    }
                    case 9 -> System.out.println("Saindo do programa.");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 9);
        }
    }
}