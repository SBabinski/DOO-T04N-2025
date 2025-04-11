package aula07;

import java.time.LocalDate;
import java.util.List;

public class ProcessaPedido {
    public Pedido processar(int id, LocalDate dataCriacao, LocalDate dataPagamento, LocalDate dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        if (confirmarPagamento(dataVencimentoReserva)) {
            return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        } else {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
            return null;
        }
    }

    private boolean confirmarPagamento(LocalDate dataVencimentoReserva) {
        return LocalDate.now().isBefore(dataVencimentoReserva) || LocalDate.now().isEqual(dataVencimentoReserva);
    }
}

