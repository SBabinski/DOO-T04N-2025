
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Criar pedido");

        int opcao = sc.nextInt();
        if (opcao == 1) {
            Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Av. Paulista", "1000", "Apto 101");
            Cliente cliente = new Cliente("João", 30, endereco);
            Vendedor vendedor = new Vendedor("Carlos", 40, "Loja A", endereco, 3500.0);
            Loja loja = new Loja("Loja A", "Loja A LTDA", "00.000.000/0001-00", "São Paulo", "Centro", "Av. Paulista");

            ArrayList<Item> itens = new ArrayList<>();
            itens.add(new Item(1, "Vaso de Planta", "Decoração", 50.0));
            itens.add(new Item(2, "Terra Adubada", "Jardim", 30.0));

            ProcessaPedido processador = new ProcessaPedido();
            Pedido pedido = processador.processar(1, new Date(), new Date(),
                    new Date(System.currentTimeMillis() + 86400000),
                    cliente, vendedor, loja, itens);

            if (pedido != null) {
                pedido.gerarDescricaoVenda();
            }
        }
    }
}
