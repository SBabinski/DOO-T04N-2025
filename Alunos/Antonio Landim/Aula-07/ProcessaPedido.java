package entities;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedidos processar(
        int id,
        Clientes cliente,
        Vendedor vendedor,
        Loja loja,
        List<Item> itens,
        Date dataCriacao,
        Date dataVencimentoReserva
    ) {
        Pedidos pedido = new Pedidos(
            id,
            dataCriacao,
            null, // 
            dataVencimentoReserva,
            cliente,
            vendedor,
            loja,
            itens
        );

        if (confirmarPagamento(dataVencimentoReserva)) {
            pedido.setDataPagamento(new Date()); 
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("A reserva venceu. Pagamento não confirmado.");
        }

        return pedido;
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return !hoje.after(dataVencimentoReserva); 
    }
}

