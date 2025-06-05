package fag;

import java.util.*;

public class Menu {
    private static final List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========= Sistema My Plant =========");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Vendedor");
            System.out.println("3. Criar Loja");
            System.out.println("4. Criar Pedido (Fake)");
            System.out.println("5. Exibir Loja");
            System.out.println("6. Testar Gerente");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    calcularPrecoTotalComDesconto(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirRegistroVendas();
                    break;
                case 4:
                    buscarVendasPorData(scanner);
                    break;
                case 5:
                    criarPedidoFake();
                    break;
                case 6:
                    System.out.println("\n--- TESTANDO GERENTE ---");
                    Endereco enderecoGerente = new Endereco("PR", "Curitiba", "Centro", 101, "Sala 2");
                    Gerente gerente = new Gerente("Gabriela", 45, enderecoGerente, 7000.0, "Loja MyPlant Centro");
                    gerente.apresentarSe();
                    enderecoGerente.apresentarLogradouro();
                    System.out.printf("Média salarial: R$ %.2f\n", gerente.calcularMedia());
                    System.out.printf("Bônus: R$ %.2f\n", gerente.calcularBonus());
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado por utilizar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void calcularPrecoTotalComDesconto(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double total = quantidade * precoUnitario;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
            System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
        }

        System.out.printf("Total a pagar: R$ %.2f\n", total);

        pedidos.add(new Pedido(new Date(), quantidade, total, desconto));
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido < valorTotal) {
            System.out.println("Valor insuficiente! O cliente precisa pagar mais.");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
        }
    }

    private static void exibirRegistroVendas() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Pedido p : pedidos) {
                if (p.getQuantidade() > 0) {
                    System.out.printf("Data: %s | Quantidade: %d | Total: R$ %.2f | Desconto: R$ %.2f\n",
                            p.getDataCriacao(), p.getQuantidade(), p.getValorTotal(), p.getDesconto());
                } else {
                    System.out.printf("[Pedido] %s | Total: R$ %.2f\n",
                            p.getDataCriacao(), p.calcularValorTotal());
                }
            }
        }
    }

    private static void buscarVendasPorData(Scanner scanner) {
        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt();

        int totalVendas = 0;
        for (Pedido p : pedidos) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(p.getDataCriacao());
            int diaPedido = cal.get(Calendar.DAY_OF_MONTH);
            int mesPedido = cal.get(Calendar.MONTH) + 1;

            if (dia == diaPedido && mes == mesPedido) {
                totalVendas++;
            }
        }

        System.out.println("Total de vendas: " + totalVendas);
    }

    private static void criarPedidoFake() {
        Endereco endereco = new Endereco("PR", "Curitiba", "Centro", 100, "Loja 1");

        Cliente cliente = new Cliente("Ana", 28, endereco);
        Vendedor vendedor = new Vendedor("Carlos", 35, endereco, 3000.0, "My Plant Centro");

        Loja loja = new Loja("My Plant", "My Plant LTDA", "12345678000190", endereco);
        loja.adicionarCliente(cliente);
        loja.adicionarVendedor(vendedor);

        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Samambaia", "Planta", 50.0));
        itens.add(new Item(2, "Vaso Cerâmico", "Acessório", 30.0));

        Date agora = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(agora);
        calendar.add(Calendar.DATE, 2);
        Date vencimento = calendar.getTime();

        ProcessamentoPedido processador = new ProcessamentoPedido();
        Pedido novoPedido = processador.processar(1, agora, agora, vencimento, cliente, vendedor, loja, itens);
        pedidos.add(novoPedido);
    }
}
