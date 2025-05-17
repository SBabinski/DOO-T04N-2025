package Aula7;
import java.util.*;

class Endereco {
    private String estado, cidade, bairro, rua;
    private int numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println(rua + ", " + numero + " - " + bairro + ", " + cidade + " - " + estado);
        if (!complemento.isEmpty()) System.out.println("Complemento: " + complemento);
    }
}

class Loja {
    private String nomeFantasia, cnpj;
    private Endereco endereco;
    private List<Vendedor> vendedores;

    public Loja(String nomeFantasia, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void apresentarSe() {
        System.out.println("🏪 Loja: " + nomeFantasia + " | CNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }
}

class Funcionario {
    protected String nome;
    protected int idade;
    protected Loja loja;
    protected double salarioBase;
    protected List<Double> salarioRecebido;

    public Funcionario(String nome, int idade, Loja loja, double salarioBase, List<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Loja: " + loja.getNomeFantasia());
    }
}

class Vendedor extends Funcionario {
    public Vendedor(String nome, int idade, Loja loja, double salarioBase, List<Double> salarioRecebido) {
        super(nome, idade, loja, salarioBase, salarioRecebido);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Gerente extends Funcionario {
    public Gerente(String nome, int idade, Loja loja, double salarioBase, List<Double> salarioRecebido) {
        super(nome, idade, loja, salarioBase, salarioRecebido);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + " | Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}

class Item {
    private int id;
    private String nome, tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void gerarDescricao() {
        System.out.println("🛒 Item: " + id + " | Nome: " + nome + " | Tipo: " + tipo + " | Valor: R$ " + valor);
    }
}

class Pedido {
    private int id;
    private Date dataCriacao, dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println("📅 Pedido criado em: " + dataCriacao);
        System.out.println("💰 Valor total: R$ " + calcularValorTotal());
    }
}

class ProcessaPedido {
    public void processar(Pedido pedido) {
        if (confirmarPagamento(pedido)) {
            System.out.println("✅ Pedido processado com sucesso!");
        } else {
            System.out.println("❌ Falha no pagamento! Reserva vencida.");
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        return hoje.before(pedido.getDataVencimentoReserva());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n📊 Sistema My Plant");
            System.out.println("[1] - Registrar Venda");
            System.out.println("[2] - Consultar Vendas por Dia");
            System.out.println("[3] - Consultar Vendas por Mês");
            System.out.println("[4] - Criar Pedido (dados fakes)");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("🔹 Funcionalidade de registro de venda...");
                    break;
                case 2:
                    System.out.println("🔹 Consulta de vendas por dia...");
                    break;
                case 3:
                    System.out.println("🔹 Consulta de vendas por mês...");
                    break;
                case 4:
                    Pedido novoPedido = criarPedidoFake();
                    pedidos.add(novoPedido);
                    System.out.println("✅ Pedido criado com sucesso!");
                    break;
                case 5:
                    System.out.println("Saindo... Até logo! 🌱");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static Pedido criarPedidoFake() {
        Cliente cliente = new Cliente("Lucas", 30, new Endereco("PR", "Cascavel", "Centro", "Rua A", 123, ""));
        Vendedor vendedor = new Vendedor("Carlos", 28, new Loja("My Plant", "123456789", new Endereco("PR", "Cascavel", "Centro", "Rua B", 456, "")), 3000.0, Arrays.asList(3200.0, 3300.0, 3100.0));
        List<Item> itens = Arrays.asList(new Item(1, "Orquídea", "Planta", 50.0), new Item(2, "Cacto", "Planta", 30.0));

        return new Pedido(101, new Date(), new Date(System.currentTimeMillis() + 86400000), cliente, vendedor, vendedor.loja, itens);
    }
}
