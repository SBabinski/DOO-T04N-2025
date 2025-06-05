import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco endereco = new Endereco("São Paulo", "Centro", "Rua das Flores, 123");

        Loja loja = new Loja("My Plant", "My Plant Ltda.", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores, 123");

        Vendedor vendedor1 = new Vendedor("Carlos Silva", 30, "My Plant", endereco, 3000.0);
        Vendedor vendedor2 = new Vendedor("Ana Souza", 28, "My Plant", endereco, 2800.0);
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);

        Cliente cliente1 = new Cliente("José Pereira", 45, endereco);
        Cliente cliente2 = new Cliente("Maria Oliveira", 34, endereco);
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        Gerente gerente = new Gerente("Luciana Ramos", 40, "My Plant", endereco, 6000.0);

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ver dados da loja");
            System.out.println("2. Listar vendedores e clientes");
            System.out.println("3. Criar pedido com dados fake");
            System.out.println("4. Ver dados do gerente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    loja.apresentarse();
                    break;

                case 2:
                    loja.contarVendedores();
                    loja.contarClientes();
                    vendedor1.apresentarse();
                    vendedor2.apresentarse();
                    cliente1.apresentarse();
                    cliente2.apresentarse();
                    break;

                case 3:
                    List<Item> itens = new ArrayList<>();
                    itens.add(new Item(1, "Vaso de Planta", "Decoração", 150.0));
                    itens.add(new Item(2, "Semente de Girassol", "Jardinagem", 15.0));

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, 2);

                    ProcessaPedido processador = new ProcessaPedido();
                    Pedido pedido = processador.processar(1, cliente1, vendedor1, "My Plant", itens, cal.getTime());

                    if (pedido != null) {
                        pedido.gerarDescricaoVenda();
                    } else {
                        System.out.println("Pedido não pôde ser processado.");
                    }
                    break;

                case 4:
                    gerente.apresentarse();
                    System.out.println("Média salarial: R$" + gerente.calcularMedia());
                    System.out.println("Bônus: R$" + gerente.calcularBonus());
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
