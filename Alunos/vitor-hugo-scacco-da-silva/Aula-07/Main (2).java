import java.util.*;

class Endereco {
    String estado, cidade, bairro, numero, complemento;
    Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }
    void apresentarLogradouro() {
        System.out.println(cidade + ", " + bairro + ", " + numero + ", " + complemento + ", " + estado);
    }
}

class Pessoa {
    String nome;
    int idade;
    Endereco endereco;
    Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }
}

class Vendedor extends Pessoa {
    String loja;
    Vendedor(String nome, int idade, Endereco endereco, String loja) {
        super(nome, idade, endereco);
        this.loja = loja;
    }
}

class Cliente extends Pessoa {
    Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }
}

class Gerente extends Pessoa {
    String loja;
    String cidade, bairro, rua;
    double salarioBase;
    List<Double> salarioRecebido;
    Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        super(nome, idade, null);
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(3000.0, 3200.0, 3100.0);
    }
    void apresentarse() {
        System.out.println(nome + ", " + idade + ", " + loja);
    }
    double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(d -> d).average().orElse(0);
    }
    double calcularBonus() {
        return salarioBase * 0.35;
    }
}

class Item {
    int id;
    String nome, tipo;
    double valor;
    Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }
    void gerarDescricao() {
        System.out.println(id + ", " + nome + ", " + tipo + ", R$" + valor);
    }
}

class Pedido {
    int id;
    Date criacao, pagamento, vencimento;
    Cliente cliente;
    Vendedor vendedor;
    String loja;
    List<Item> itens;
    Pedido(int id, Date criacao, Date pagamento, Date vencimento, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        this.id = id;
        this.criacao = criacao;
        this.pagamento = pagamento;
        this.vencimento = vencimento;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }
    double calcularValorTotal() {
        return itens.stream().mapToDouble(i -> i.valor).sum();
    }
    void gerarDescricaoVenda() {
        System.out.println("Data: " + criacao + ", Total: R$" + calcularValorTotal());
    }
}

class ProcessaPedido {
    Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens, Date vencimento) {
        Date agora = new Date();
        Date pagamento = confirmarPagamento(vencimento) ? agora : null;
        return new Pedido(id, agora, pagamento, vencimento, cliente, vendedor, loja, itens);
    }
    private boolean confirmarPagamento(Date vencimento) {
        return new Date().before(vencimento);
    }
}

class Main {
    public static void main(String[] args) {
        Endereco e = new Endereco("SP", "São Paulo", "Centro", "123", "Apto 1");
        Cliente c = new Cliente("João", 30, e);
        Vendedor v = new Vendedor("Maria", 28, e, "Loja Central");
        List<Item> itens = Arrays.asList(new Item(1, "Planta A", "Ornamental", 100), new Item(2, "Planta B", "Frutífera", 150));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date vencimento = cal.getTime();
        Pedido p = new ProcessaPedido().processar(1, c, v, "Loja Central", itens, vencimento);
        p.gerarDescricaoVenda();
    }
}