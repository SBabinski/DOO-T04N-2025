import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, String cliente, String vendedor, String loja) {
        Date hoje = new Date();
        Date vencimento = new Date(hoje.getTime() + 2 * 24 * 60 * 60 * 1000); // 2 dias depois

        Pedido pedido = new Pedido(id, hoje, null, vencimento, cliente, vendedor, loja);

        pedido.adicionarItem(new Item(1, "Camiseta", "Roupa", 59.90));
        pedido.adicionarItem(new Item(2, "Tênis", "Calçado", 199.90));

        if (confirmarPagamento(pedido)) {
            pedido.dataPagamento = hoje;
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida. Não foi possível processar o pagamento.");
        }

        return pedido;
    }

    private boolean confirmarPagamento(Pedido pedido) {
        Date agora = new Date();
        return agora.before(pedido.dataVencimentoReserva);
    }
}
