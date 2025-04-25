package service;

import entities.*;

import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println("Pagamento não confirmado. Pedido expirado.");
            return null;
        }
        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date dataAtual = new Date();
        return dataAtual.before(dataVencimentoReserva);
    }
}
