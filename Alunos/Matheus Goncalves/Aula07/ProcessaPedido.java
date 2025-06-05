package aula07;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {
	public Pedido processar(int id, String cliente, String vendedor, String loja, List<Item> itens, Date dataVencimentoReserva) {
        Date agora = new Date();
        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println("Reserva vencida. Pedido não pode ser processado.");
            return null;
        }
        return new Pedido(id, agora, agora, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date agora = new Date();
        return !agora.after(dataVencimentoReserva);
    }
}
