package Aula07;
public class ProcessaPedido {
    public void processar(Pedido pedido) {
        if (confirmarPagamento(pedido)) {
            System.out.println("Pedido processado com sucesso!");
        } else {
            System.out.println("Reserva vencida. Pedido não processado.");
        }
    }

    private boolean confirmarPagamento(Pedido pedido) {
        String dataAtual = "2025-04-05";
        return dataAtual.compareTo(pedido.dataVencimentoReserva) <= 0;
    }
}
