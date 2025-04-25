package Aula_07;

import java.util.*;

public class SistemaMyPlant {
    public static void main(String[] args) {
        Endereço endereco = new Endereço("PR", "Curitiba", "Centro", "123", "Loja 1");

        Cliente cliente = new Cliente("Gabrielinha", 35, endereco);
        Vendedor vendedor = new Vendedor("Carlos", 28, "My Plant Central", endereco, 2000);
        Item item1 = new Item(1, "Vaso Decorado", "Decoração", 80.0);
        Item item2 = new Item(2, "Samambaia", "Planta", 45.0);

        List<Item> itens = Arrays.asList(item1, item2);
        Loja loja = new Loja("My Plant", "My Plant LTDA", "00.000.000/0001-00", endereco,
                Arrays.asList(vendedor), Arrays.asList(cliente));

        ProcessaPedido processador = new ProcessaPedido();
        Date hoje = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(hoje);
        c.add(Calendar.DATE, 2);
        Date vencimento = c.getTime();

        Pedido pedido = processador.processar(1, hoje, hoje, vencimento, cliente, vendedor, loja, itens);


        if (pedido != null) {
            pedido.gerarDescricaoVenda();
        }
    }
}
