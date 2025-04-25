package Aula_07;


import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {

        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println("Pagamento não confirmado: reserva vencida.");
            return null;
        }

        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return hoje.before(dataVencimentoReserva);
    }
}
