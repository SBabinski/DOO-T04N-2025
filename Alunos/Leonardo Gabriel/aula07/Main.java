package aula07;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void criarPedidoFake() {
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", 100, "Sala 202");
        Cliente cliente = new Cliente("Maria", 30, endereco);
        Vendedor vendedor = new Vendedor("João", 25, endereco, "Loja A");

        List<Item> itens = Arrays.asList(
            new Item(1, "Vaso de Planta", "Decoração", 50.0),
            new Item(2, "Adubo Orgânico", "Jardinagem", 20.0)
        );

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(
            1,
            LocalDate.now(),
            LocalDate.now(),
            LocalDate.of(2025, 4, 20),
            cliente,
            vendedor,
            "Loja A",
            itens
        );

        if (pedido != null) {
            pedido.gerarDescricaoVenda();
            for (Item item : itens) {
                item.gerarDescricao();
            }
            endereco.apresentarLogradouro();
        }
    }

    public static void criarPedidoManual(Scanner scanner) {
        System.out.println("\n--- Cadastro de Pedido Manual ---");

        // Endereço
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();

        Endereco endereco = new Endereco(estado, cidade, bairro, rua, numero, complemento);

        // Cliente
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Idade do Cliente: ");
        int idadeCliente = Integer.parseInt(scanner.nextLine());
        Cliente cliente = new Cliente(nomeCliente, idadeCliente, endereco);

        // Vendedor
        System.out.print("Nome do Vendedor: ");
        String nomeVendedor = scanner.nextLine();
        System.out.print("Idade do Vendedor: ");
        int idadeVendedor = Integer.parseInt(scanner.nextLine());
        System.out.print("Loja: ");
        String loja = scanner.nextLine();
        Vendedor vendedor = new Vendedor(nomeVendedor, idadeVendedor, endereco, loja);

        // Itens
        System.out.print("Quantos itens no pedido? ");
        int qtdItens = Integer.parseInt(scanner.nextLine());
        List<Item> itens = new java.util.ArrayList<>();

        for (int i = 0; i < qtdItens; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            itens.add(new Item(id, nomeItem, tipo, valor));
        }

        // Datas
        LocalDate dataCriacao = LocalDate.now();
        LocalDate dataPagamento = LocalDate.now();
        System.out.print("Data de Vencimento da Reserva (AAAA-MM-DD): ");
        LocalDate dataVencimento = LocalDate.parse(scanner.nextLine());

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(
            (int)(Math.random() * 1000),
            dataCriacao,
            dataPagamento,
            dataVencimento,
            cliente,
            vendedor,
            loja,
            itens
        );

        if (pedido != null) {
            pedido.gerarDescricaoVenda();
            for (Item item : itens) {
                item.gerarDescricao();
            }
            endereco.apresentarLogradouro();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n===== MENU MY PLANT =====");
            System.out.println("1 - Criar pedido fake");
            System.out.println("2 - Criar pedido manual");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    criarPedidoFake();
                    break;
                case "2":
                    criarPedidoManual(scanner);
                    break;
                case "0":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (!opcao.equals("0"));

        scanner.close();
    }
}

