import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Date dataVencimentoReserva,
                           Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        Pedido pedido = new Pedido(id, dataCriacao, dataVencimentoReserva, cliente, vendedor, loja, itens);
        if (confirmarPagamento(pedido)) {
            pedido.setDataPagamento(new Date());
        }
        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        return !hoje.after(pedido.getDataVencimentoReserva());
    }
}
