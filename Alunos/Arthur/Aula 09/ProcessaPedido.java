import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja,
                            List<Item> itens, Date dataVencimentoReserva) {
        Date agora = new Date();

        if (!confirmarPagamento(agora, dataVencimentoReserva)) {
            System.out.println("Pagamento não confirmado. Reserva vencida.");
            return null;
        }

        return new Pedido(id, agora, agora, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date atual, Date vencimento) {
        return !atual.after(vencimento);
    }
}
