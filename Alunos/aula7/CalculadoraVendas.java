import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

class Endereco {
    String estado, cidade, bairro, rua, numero, complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", Nº " + numero + ", " + complemento + " - " + bairro + ", " + cidade + " - " + estado);
    }
}

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
    }
}

class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }
}

class Vendedor extends Pessoa {
    public Vendedor(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }
}

class Gerente extends Pessoa {
    String loja;
    double salarioBase;
    List<Double> salarioRecebido;

    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(4000.0, 4200.0, 4500.0);
    }

    public void apresentarSe() {
        System.out.println("Gerente: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Item {
    int id;
    String nome;
    String tipo;
    double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("Item [" + id + "] - " + nome + " (" + tipo + ") - R$ " + valor);
    }
}

class ProcessaPedido{

    static void processar(Cliente cliente, Vendedor vendedor, String my_Plant__SP, List<Item> itens, Date dataPagamento, Date dataVencimento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private String loja;
    private List<Item> itens;

    public ProcessaPedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {

        if (cliente == null || vendedor == null || loja == null || itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para criação do pedido.");
        }

        if (dataPagamento.before(dataCriacao)) {
            throw new IllegalArgumentException("Data de pagamento não pode ser anterior à data de criação.");
        }

        if (dataVencimentoReserva.before(dataCriacao)) {
            throw new IllegalArgumentException("Data de vencimento da reserva não pode ser anterior à data de criação.");
        }

        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = new ArrayList<>(itens); // cópia defensiva
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(item -> item.valor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println(this);
        System.out.println("Itens do pedido:");
        itens.forEach(Item::gerarDescricao);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Pedido #" + id +
               "\nCriado em: " + sdf.format(dataCriacao) +
               "\nPagamento: " + sdf.format(dataPagamento) +
               "\nReserva até: " + sdf.format(dataVencimentoReserva) +
               "\nCliente: " + cliente.nome +
               "\nVendedor: " + vendedor.nome +
               "\nLoja: " + loja +
               "\nValor total: R$ " + String.format("%.2f", calcularValorTotal());
    }

    // Getters, se precisar
    public int getId() {
        return id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
}

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
        return "Data: " + data + ", Quantidade: " + quantidade + ", Preço Unitário: R$ " +
                String.format("%.2f", precoUnitario) + ", Valor Total: R$ " +
                String.format("%.2f", valorTotal) + ", Desconto: R$ " +
                String.format("%.2f", desconto);
    }
}

public class CalculadoraVendas {
    private static final double DESCONTO_ESPECIAL = 0.05;
    private static final Map<String, List<Venda>> registroVendas = new HashMap<>();

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
                System.out.println("[6] - Sair");
                System.out.println("[7] - Criar Pedido (com dados fakes)");
                System.out.print("Escolha uma opção: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, digite um número válido.");
                    scanner.next();
                }
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 ->  {
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
                    case 4 ->  {
                        System.out.print("Digite a data (DD/MM/AAAA) para buscar as vendas: ");
                        buscarVendasPorData(scanner.nextLine());
                    }

                    case 5 ->   {
                        System.out.print("Digite o mês e ano (MM/AAAA) para buscar as vendas: ");
                        buscarVendasPorMes(scanner.nextLine());
                    }

                    case 6 -> System.out.println("Saindo do programa.");
                    case 7 ->   {
                        // Criar pedido fake
                        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Av. Brasil", "100", "Bloco B");
                        Cliente cliente = new Cliente("Alice", 28, endereco);
                        Vendedor vendedor = new Vendedor("Carlos", 30, endereco);
                        List<Item> itens = Arrays.asList(
                                new Item(1, "Orquídea", "Flor", 35.0),
                                new Item(2, "Samambaia", "Folhagem", 22.5)
                        );

                        Calendar calendar = Calendar.getInstance();
                        Date dataPagamento = calendar.getTime();
                        calendar.add(Calendar.DATE, 3);
                        Date dataVencimento = calendar.getTime();

                        ProcessaPedido.processar(cliente, vendedor, "My Plant - SP", itens, dataPagamento, dataVencimento);
                    }

                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 6);
        }
    }
}