package sistemamyplant;

import java.util.*;

public class ProcessaPedido {

    
    public Pedido processar(int id, ClienteMyPlant cliente, FuncionarioMyPlant vendedor, LojaMyPlant loja) {
        Date agora = new Date();
        
        Date vencimento = adicionarDias(agora, 2);
        Pedido pedido = new Pedido(id, agora, vencimento, cliente, vendedor, loja);
        pedido.adicionarItem(new Item(1, "Samambaia", "Planta", 25.90));
        pedido.adicionarItem(new Item(2, "Vaso", "Acessório", 39.90));
        return pedido;
    }

    
    private boolean confirmarPagamento(Pedido pedido) {
        Date agora = new Date();
        return agora.before(pedido.getDataVencimentoReserva());
    }

   
    public void testarPagamento(Pedido pedido) {
        if (confirmarPagamento(pedido)) {
            pedido.setDataPagamento(new Date());
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
        }
    }

  
    private Date adicionarDias(Date data, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
}
