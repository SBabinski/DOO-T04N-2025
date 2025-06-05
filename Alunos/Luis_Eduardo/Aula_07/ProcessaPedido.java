package gabrielinha;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProcessaPedido{

    public Pedido processar(Cliente cliente, Vendedor
     vendedor, Loja loja, ArrayList<Item> itens){
        Pedido pedido = new Pedido();
        pedido.id = (int) (Math.random() * 1000);
        pedido.dataCriacao = LocalDate.now();
        pedido.dataVencimentoReserva = pedido.dataCriacao.plusDays(3);
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.loja = loja;
        pedido.itens = itens;

        if (confirmarPagamento(pedido)){
            pedido.dataPagamento = LocalDate.now();
            System.out.println("Pagamento confirmado");
        } else {
            System.out.println("Pagamento não confirmado.");
        }
        return pedido;   
    }

    private boolean confirmarPagamento(Pedido pedido) {
        LocalDate hoje = LocalDate.now();
        return !hoje.isAfter(pedido.dataVencimentoReserva);
    }
}
