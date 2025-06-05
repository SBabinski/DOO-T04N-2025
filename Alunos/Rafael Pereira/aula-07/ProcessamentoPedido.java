package fag;

import java.util.*;

public class ProcessamentoPedido {
    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date vencimento,
                            Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        if (!confirmarPagamento(vencimento)) {
            System.out.println("Reserva vencida. Pedido cancelado.");
            return null;
        }
        return new Pedido(id, dataCriacao, dataPagamento, vencimento, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date vencimento) {
        return new Date().compareTo(vencimento) <= 0;
    }
}