import java.util.*;

class Endereco {
    String estado, cidade, bairro, rua, complemento;
    int numero;

    Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    String apresentarLogradouro() {
        return rua + ", " + numero + " - " + bairro + ", " + cidade + ", " + estado + " (" + complemento + ")";
    }
}

abstract class Pessoa {
    String nome;
    int idade;
    Loja loja;
    Endereco endereco;

    Pessoa(String nome, int idade, Loja loja, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
    }

    void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        if (loja != null) System.out.println("Loja: " + loja.nomeFantasia);
    }
}

class Vendedor extends Pessoa {
    float salarioBase;
    float[] salarioRecebido = {2800.00f, 2900.00f, 3000.00f};

    Vendedor(String nome, int idade, Loja loja, Endereco endereco, float salarioBase) {
        super(nome, idade, loja, endereco);
        this.salarioBase = salarioBase;
    }

    float calcularMedia() {
        float soma = 0;
        for (float s : salarioRecebido) soma += s;
        return soma / salarioRecebido.length;
    }

    float calcularBonus() {
        return salarioBase * 0.2f;
    }
}

class Gerente extends Pessoa {
    float salarioBase;
    float[] salarioRecebido = {4500.00f, 4600.00f, 4700.00f};

    Gerente(String nome, int idade, Loja loja, Endereco endereco, float salarioBase) {
        super(nome, idade, loja, endereco);
        this.salarioBase = salarioBase;
    }

    float calcularMedia() {
        float soma = 0;
        for (float s : salarioRecebido) soma += s;
        return soma / salarioRecebido.length;
    }

    float calcularBonus() {
        return salarioBase * 0.35f;
    }
}

class Cliente extends Pessoa {
    Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, null, endereco);
    }
}

class Loja {
    String nomeFantasia, razaoSocial, cnpj;
    Endereco endereco;
    ArrayList<Vendedor> vendedores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    void adicionaVendedor(Vendedor v) { vendedores.add(v); }
    void adicionaCliente(Cliente c) { clientes.add(c); }

    int contarClientes() { return clientes.size(); }
    int contarVendedores() { return vendedores.size(); }

    void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: \n" + endereco.apresentarLogradouro());
    }
}

class Item {
    int id;
    String nome, tipo;
    float valor;

    Item(int id, String nome, String tipo, float valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    void gerarDescricao() {
        System.out.printf("ID: %d | Nome: %s | Tipo: %s | Valor: R$%.2f\n", id, nome, tipo, valor);
    }
}

class Pedido {
    int id;
    Date dataCriacao, dataPagamento, dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens;

    Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
           Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    float calcularValorTotal() {
        float total = 0;
        for (Item i : itens) total += i.valor;
        return total;
    }

    String gerarDescricaoVenda() {
        return "Pedido criado em: " + dataCriacao + ", Valor total: R$" + String.format("%.2f", calcularValorTotal());
    }
}

class ProcessaPedido {
    Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        Date agora = new Date();
        Date vencimento = new Date(agora.getTime() + 3 * 24 * 60 * 60 * 1000L);
        Date pagamento = new Date();

        Pedido pedido = new Pedido(id, agora, pagamento, vencimento, cliente, vendedor, loja, itens);

        if (confirmarPagamento(pedido)) {
            return pedido;
        } else {
            System.out.println("Pagamento não confirmado: reserva vencida.");
            return null;
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date agora = new Date();
        return !agora.after(pedido.dataVencimentoReserva);
    }
}

public class Main {
    public static void main(String[] args) {
        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", "Rua Paraná", 100, "Loja principal");
        Loja myPlant = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-99", enderecoLoja);

        Endereco enderecoVendedor = new Endereco("PR", "Cascavel", "Coqueiral", "Rua das Palmeiras", 45, "Casa");
        Vendedor vendedor1 = new Vendedor("Carlos Silva", 30, myPlant, enderecoVendedor, 2800.00f);
        myPlant.adicionaVendedor(vendedor1);

        Endereco enderecoCliente = new Endereco("PR", "Cascavel", "Pacaembu", "Rua das Rosas", 32, "Apartamento 301");
        Cliente cliente1 = new Cliente("Mariana Oliveira", 25, enderecoCliente);
        myPlant.adicionaCliente(cliente1);

        Endereco enderecoGerente = new Endereco("PR", "Cascavel", "Neva", "Rua dos Girassóis", 77, "Prédio Administrativo");
        Gerente gerente1 = new Gerente("Ana Souza", 40, myPlant, enderecoGerente, 4500.00f);

        Item item1 = new Item(1, "Vaso Decorativo", "Decoração", 40.50f);
        Item item2 = new Item(2, "Fertilizante", "Jardinagem", 43.90f);
        ArrayList<Item> itens = new ArrayList<>(Arrays.asList(item1, item2));

        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = processaPedido.processar(1, cliente1, vendedor1, myPlant, itens);

        System.out.println("========== DADOS DA LOJA ==========");
        myPlant.apresentarse();
        System.out.println("\nTotal de clientes: " + myPlant.contarClientes());
        System.out.println("Total de vendedores: " + myPlant.contarVendedores());

        System.out.println("\n========== DADOS DO VENDEDOR ==========");
        vendedor1.apresentarse();
        System.out.printf("Média salarial: R$%.2f\n", vendedor1.calcularMedia());
        System.out.printf("Bônus: R$%.2f\n", vendedor1.calcularBonus());

        System.out.println("\n========== DADOS DO CLIENTE ==========");
        cliente1.apresentarse();

        System.out.println("\n========== DADOS DO GERENTE ==========");
        gerente1.apresentarse();
        System.out.printf("Média salarial: R$%.2f\n", gerente1.calcularMedia());
        System.out.printf("Bônus: R$%.2f\n", gerente1.calcularBonus());

        if (pedido != null) {
            System.out.println("\n========== DADOS DO PEDIDO ==========");
            System.out.println(pedido.gerarDescricaoVenda());
        }
    }
}
