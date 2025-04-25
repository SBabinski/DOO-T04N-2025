import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", 123, "Rua Antônio Alves Massaneiro");
        Loja myPlant = new Loja("My Plant", "My Plant LTDA", "05.654.618/0007-10", enderecoLoja);

        Vendedor vendedor1 = new Vendedor("Ana", 28, "My Plant",
                new Endereco("PR", "Cascavel", "Centro", 101, "Rua das Plantas"), 3000.0);

        Vendedor vendedor2 = new Vendedor("Carlos", 32, "My Plant",
                new Endereco("PR", "Cascavel", "Centro", 102, "Rua das Orquídeas"), 3200.0);

        myPlant.adicionaVendedor(vendedor1);
        myPlant.adicionaVendedor(vendedor2);

        Cliente cliente1 = new Cliente("Beatriz", 25,
    new Endereco("PR", "Cascavel", "Maria Luiza", 456, "Rua Hyeda Baggio Mayer"));

Cliente cliente2 = new Cliente("João", 35,
    new Endereco("PR", "Cascavel", "Centro", 789, "Rua Afonso Pena"));


        myPlant.adicionaCliente(cliente1);
        myPlant.adicionaCliente(cliente2);

        ArrayList<Pedido> pedidos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\nMenu My Plant");
            System.out.println("1. Ver dados da loja");
            System.out.println("2. Listar vendedores");
            System.out.println("3. Listar clientes");
            System.out.println("4. Criar pedido (dados fakes)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1 -> {
                    myPlant.apresentarse();
                    myPlant.contarVendedores();
                    myPlant.contarClientes();
                }

                case 2 -> {
                    System.out.println("Vendedores");
                    for (Vendedor v : myPlant.vendedores) {
                        v.apresentarse();
                        System.out.printf("Média Salarial: R$%.2f\n", v.calcularMedia());
                        System.out.printf("Bônus: R$%.2f\n\n", v.calcularBonus());
                    }
                }

                case 3 -> {
                    System.out.println("Clientes");
                    for (Cliente c : myPlant.clientes) {
                        c.apresentarse();
                        System.out.println();
                    }
                }

                case 4 -> {
                    System.out.println("Criando pedido (fictício)");

                    Cliente cliente = myPlant.clientes.get(0);
                    Vendedor vendedor = myPlant.vendedores.get(0);

                    ArrayList<Item> itens = new ArrayList<>();
                    itens.add(new Item(1, "Vaso de Cerâmica", "Decoração", 45.00));
                    itens.add(new Item(2, "Mini Samambaia", "Planta", 29.90));

                    Date dataCriacao = new Date();
                    Date dataPagamento = new Date();
                    Date dataVencimento = new Date(System.currentTimeMillis() + 86400000);

                    ProcessaPedido processador = new ProcessaPedido();
                    Pedido novoPedido = processador.processar(
                            pedidos.size() + 1,
                            cliente,
                            vendedor,
                            myPlant,
                            itens,
                            dataCriacao,
                            dataPagamento,
                            dataVencimento
                    );

                    if (novoPedido != null) {
                        pedidos.add(novoPedido);
                        novoPedido.gerarDescricaoVenda();
                        System.out.println("Pedido criado com sucesso!\n");
                    } else {
                        System.out.println("Falha: Pagamento não confirmado. Reserva vencida.\n");
                    }
                }

                case 5 -> System.out.println("Encerrando o sistema. Até logo!");

                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}
