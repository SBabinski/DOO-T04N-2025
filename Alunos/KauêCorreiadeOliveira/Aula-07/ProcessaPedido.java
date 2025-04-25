import java.util.ArrayList;
import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens,
                            Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva) {
        if (!confirmarPagamento(dataVencimentoReserva)) {
            System.out.println(" Não foi possível processar o pedido: reserva vencida.");
            return null;

        }

        Pedido novoPedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva,
                cliente, vendedor, loja, itens);

        System.out.println(" Pedido processado com sucesso!");
        novoPedido.gerarDescricaoVenda();

        return novoPedido;
    }

    private boolean confirmarPagamento(Date dataVencimentoReserva) {
        Date dataAtual = new Date();
        return !dataAtual.after(dataVencimentoReserva); 
    }
}

