package gabrielinha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Endereco {
    String estado;
    String cidade;
    String bairro;
    String numero;
    String complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + bairro + ", nº " + numero + ", " + complemento + ", " + cidade + " - " + estado);
    }
}

abstract class Pessoa {
    String nome;
    int idade;
    String loja;
    Endereco endereco;

    public Pessoa(String nome, int idade, String loja, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
    }

    public abstract void apresentarse();
}

class Vendedor extends Pessoa {
    double salarioBase;
    List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade, loja, endereco);
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(2000.0, 2200.0, 2400.0);
    }

    public void apresentarse() {
        System.out.println("Vendedor: " + nome + ", " + idade + " anos, Loja: " + loja);
        endereco.apresentarLogradouro();
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Gerente extends Pessoa {
    double salarioBase;
    List<Double> salarioRecebido;

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade, loja, endereco);
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(5000.0, 5200.0, 5400.0);
    }

    public void apresentarse() {
        System.out.println("Gerente: " + nome + ", " + idade + " anos, Loja: " + loja);
        endereco.apresentarLogradouro();
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Cliente extends Pessoa {
    public Cliente(String nome, int idade, String loja, Endereco endCliente) {
		// TODO Auto-generated constructor stub
	}

	public void apresentarse() {
        System.out.println("Cliente: " + nome + ", " + idade + " anos.");
        endereco.apresentarLogradouro();
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
        System.out.println("Item [" + id + "] - " + nome + " | Tipo: " + tipo + " | Valor: R$" + valor);
    }
}

class Pedido {
    int id;
    LocalDate dataCriacao;
    LocalDate dataPagamento;
    LocalDate dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    String loja;
    List<Item> itens;

    public Pedido(int id, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens, LocalDate vencimentoReserva) {
        this.id = id;
        this.dataCriacao = LocalDate.now();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
        this.dataVencimentoReserva = vencimentoReserva;
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(item -> item.valor).sum();
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido #" + id + " criado em " + dataCriacao + " | Total: R$" + calcularValorTotal());
    }
}

class ProcessaPedido {
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens, LocalDate vencimento) {
        Pedido pedido = new Pedido(id, cliente, vendedor, loja, itens, vencimento);
        if (confirmarPagamento(pedido)) {
            pedido.dataPagamento = LocalDate.now();
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Pagamento inválido (reserva vencida).");
        }
        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        return LocalDate.now().isBefore(pedido.dataVencimentoReserva) || LocalDate.now().isEqual(pedido.dataVencimentoReserva);
    }
}

public class lojagabrielinha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Registrar Vendedor");
            System.out.println("[3] - Registrar Cliente");
            System.out.println("[4] - Registrar Gerente");
            System.out.println("[5] - Criar Pedido (dados fakes)");
            System.out.println("[6] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    double precoTotal = 12 * 10.0;
                    double desconto = (12 > 10) ? precoTotal * 0.05 : 0;
                    double valorFinal = precoTotal - desconto;
                    System.out.printf("Preço total: R$ %.2f\n", valorFinal);
                    if (desconto > 0) {
                        System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
                    }
                    break;

                case 2:
                    Endereco endVend = new Endereco("SP", "São Paulo", "Centro", "123", "Sala 1");
                    Vendedor vendedor = new Vendedor("João", 30, "My Plant", endVend, 2000.0);
                    vendedor.apresentarse();
                    System.out.printf("Média Salarial: R$ %.2f\n", vendedor.calcularMedia());
                    System.out.printf("Bônus: R$ %.2f\n", vendedor.calcularBonus());
                    break;

                case 3:
                    Endereco endCli = new Endereco("SP", "São Paulo", "Jardins", "456", "Casa");
                    Cliente cliente = new Cliente("Maria", 28, "My Plant", endCli);
                    cliente.apresentarse();
                    break;

                case 4:
                    Endereco endGer = new Endereco("SP", "São Paulo", "Comercial", "789", "Sala 5");
                    Gerente gerente = new Gerente("Carlos", 40, "My Plant", endGer, 5000.0);
                    gerente.apresentarse();
                    System.out.printf("Média Salarial: R$ %.2f\n", gerente.calcularMedia());
                    System.out.printf("Bônus: R$ %.2f\n", gerente.calcularBonus());
                    break;

                case 5:
                    Endereco endCliente = new Endereco("SP", "São Paulo", "Centro", "10", "Apto 1");
                    Cliente cliPedido = new Cliente("Lucas", 29, "My Plant", endCliente);
                    Endereco endVendedor = new Endereco("SP", "São Paulo", "Centro", "20", "Sala 2");
                    Vendedor vendPedido = new Vendedor("Fernanda", 32, "My Plant", endVendedor, 2500.0);
                    List<Item> itens = new ArrayList<>();
                    itens.add(new Item(1, "Vaso Decorado", "Jardinagem", 50.0));
                    itens.add(new Item(2, "Terra Vegetal", "Insumo", 30.0));
                    ProcessaPedido proc = new ProcessaPedido();
                    Pedido pedido = proc.processar(1, cliPedido, vendPedido, "My Plant", itens, LocalDate.now().plusDays(2));
                    pedido.gerarDescricaoVenda();
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 6);

        scanner.close();
    }
}
