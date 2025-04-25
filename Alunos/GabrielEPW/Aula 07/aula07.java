// Classe Endereco
class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + ruaCompleta());
    }

    public String ruaCompleta() {
        return "Rua Exemplo, " + numero + " - " + bairro + ", " + cidade + " - " + estado + " (" + complemento + ")";
    }
}

// Classe Pessoa
class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
}

// Cliente
class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }
}

// ===== Vendedor =====
class Vendedor extends Pessoa {
    private String loja;

    public Vendedor(String nome, int idade, Endereco endereco, String loja) {
        super(nome, idade, endereco);
        this.loja = loja;
    }
}

// Gerente
class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double[] salarioRecebido = {5000.00, 5200.00, 5100.00};

    public Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
    }

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
        return salarioBase * 0.35;
    }
}

// Item
class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("Item ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: R$" + valor);
    }

    public double getValor() {
        return valor;
    }
}

// Pedido
class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private String loja;
    private ArrayList<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, String loja, ArrayList<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + ", Valor total: R$" + calcularValorTotal());
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
}

// Processar Pedido 
class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimento, Cliente cliente, Vendedor vendedor, String loja, ArrayList<Item> itens) {
        if (!confirmarPagamento(dataVencimento)) {
            System.out.println("Pagamento não confirmado: reserva vencida.");
            return null;
        }
        return new Pedido(id, dataCriacao, dataPagamento, dataVencimento, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date dataVencimento) {
        Date hoje = new Date();
        return hoje.before(dataVencimento);
    }
}

// Menu
public class SistemaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1 - Criar pedido (dados fakes)");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            // Criar endereço
            Endereco endereco = new Endereco("SP", "São Paulo", "Centro", 123, "Loja 1");

            // Criar cliente e vendedor
            Cliente cliente = new Cliente("João", 30, endereco);
            Vendedor vendedor = new Vendedor("Carlos", 28, endereco, "Loja 1");

            // Criar itens
            ArrayList<Item> itens = new ArrayList<>();
            itens.add(new Item(1, "Placa Mãe", "Hardware", 1200.00));
            itens.add(new Item(2, "Memória RAM", "Hardware", 400.00));

            // Processar pedido
            ProcessaPedido processador = new ProcessaPedido();
            Date hoje = new Date();
            Date vencimento = new Date(hoje.getTime() + 86400000); // +1 dia
            Pedido pedido = processador.processar(1, hoje, hoje, vencimento, cliente, vendedor, "Loja 1", itens);

            if (pedido != null) {
                pedido.gerarDescricaoVenda();
            }
        }

        scanner.close();
    }
}
