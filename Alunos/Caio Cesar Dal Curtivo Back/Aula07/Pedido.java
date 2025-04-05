package Aula07;
public class Pedido {
    int id;
    String dataCriacao, dataPagamento, dataVencimentoReserva;
    String cliente, vendedor, loja;
    Item item1, item2, item3;

    Pedido(int id, String dataCriacao, String dataPagamento, String dataVencimentoReserva, String cliente,
           String vendedor, String loja, Item item1, Item item2, Item item3) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    double calcularValorTotal() {
        return item1.valor + item2.valor + item3.valor;
    }

    void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + ", Valor Total: " + calcularValorTotal());
    }

    void gerarDescricaoItens() {
        System.out.println("\nITENS DO PEDIDO");
        item1.gerarDescricao();
        item2.gerarDescricao();
        item3.gerarDescricao();
    }

    void gerarDescricaoPedido() {
        System.out.println("\nDESCRIÇÃO DO PEDIDO");
        System.out.println("Pedido ID: " + id);
        System.out.println("Cliente: " + cliente + ", Vendedor: " + vendedor + ", Loja: " + loja);
        System.out.println("Data de Criação: " + dataCriacao + ", Data de Pagamento: " + dataPagamento + ", Data de Vencimento da Reserva: " + dataVencimentoReserva);
        System.out.println("Valor Total: " + calcularValorTotal());
    }
}
