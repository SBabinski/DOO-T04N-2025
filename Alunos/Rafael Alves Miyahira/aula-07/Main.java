import java.util.*;

class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.printf("Endereço: %s, %s, %s, %s, %s\n", bairro, cidade, estado, numero, complemento);
    }
}

abstract class Pessoa {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarSe() {
        System.out.printf("Nome: %s, Idade: %d\n", nome, idade);
        endereco.apresentarLogradouro();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}

class Vendedor extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private double[] salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    public void apresentarSe() {
        super.apresentarSe();
        System.out.printf("Loja: %s\n", loja.getNomeFantasia());
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

    public double getSalarioBase() {
        return salarioBase;
    }
}

class Gerente extends Vendedor {
    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    @Override
    public double calcularBonus() {
        return super.calcularBonus() + getSalarioBase() * 0.15;  // Bônus maior para o gerente
    }
}

class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarSe() {
        super.apresentarSe();
    }
}

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void contarClientes() {
        System.out.printf("Total de Clientes: %d\n", clientes.size());
    }

    public void contarVendedores() {
        System.out.printf("Total de Vendedores: %d\n", vendedores.size());
    }

    public void apresentarse() {
        System.out.printf("Loja: %s, CNPJ: %s\n", nomeFantasia, cnpj);
        endereco.apresentarLogradouro();
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}

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
        System.out.printf("ID: %d, Nome: %s, Tipo: %s, Valor: %.2f\n", id, nome, tipo, valor);
    }

    public double getValor() {
        return valor;
    }
}

class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
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
        System.out.printf("Pedido ID: %d, Data de criação: %s, Valor Total: %.2f\n", id, dataCriacao, calcularValorTotal());
    }
}

class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        return pedido;
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date dataAtual = new Date();
        return dataAtual.before(dataVencimentoReserva);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        Loja loja = new Loja("My Plant", "Razão Social My Plant", "12.345.678/0001-99", new Endereco("SP", "São Paulo", "Centro", "123", "Perto da praça"));
        Cliente cliente = new Cliente("Carlos", 30, new Endereco("SP", "São Paulo", "Vila Progredir", "456", ""));
        Vendedor vendedor = new Vendedor("João", 28, loja, new Endereco("SP", "São Paulo", "Centro", "789", ""), 2500.0, new double[]{2000.0, 2200.0, 2400.0});
        Gerente gerente = new Gerente("Maria", 35, loja, new Endereco("SP", "São Paulo", "Vila Progredir", "101", ""), 5000.0, new double[]{4000.0, 4200.0, 4400.0});

        Item item1 = new Item(1, "Planta A", "Planta", 50.0);
        Item item2 = new Item(2, "Planta B", "Planta", 30.0);
        List<Item> itensPedido = Arrays.asList(item1, item2);
        Date dataCriacao = new Date();
        Date dataPagamento = new Date();
        Date dataVencimentoReserva = new Date(System.currentTimeMillis() + 86400000L);  // Reserva válida por 1 dia

        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = processaPedido.processar(1, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itensPedido);
        
        pedidos.add(pedido);

        System.out.println("Pedido processado:");
        pedido.gerarDescricaoVenda();

        sc.close();
    }
}
