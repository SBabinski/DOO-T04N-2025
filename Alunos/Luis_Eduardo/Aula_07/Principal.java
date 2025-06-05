package gabrielinha;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    static Loja loja = new Loja();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        configurarLoja();

        int opcao;
        do {
            System.out.println("\n--- Menu Loja Gabrielinha ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Vendedor");
            System.out.println("3. Adicionar Gerente");
            System.out.println("4. Contar Clientes");
            System.out.println("5. Contar Vendedores");
            System.out.println("6. Criar Pedido");
            System.out.println("7. Apresentar Loja");
            System.out.println("8. Listar Endereços");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> adicionarVendedor();
                case 3 -> adicionarGerente();
                case 4 -> loja.contarClientes();
                case 5 -> loja.contarVendedores();
                case 6 -> criarPedido();
                case 7 -> loja.apresentarse();
                case 8 -> listarEnderecos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void configurarLoja() {
        loja.nomeFantasia = "Loja Gabrielinha";
        loja.razaoSocial = "Gabrielinha Flores e Presentes LTDA";
        loja.cnpj = "74819039/0001-64";

        Endereco endereco = new Endereco();
        endereco.estado = "PE";
        endereco.cidade = "Santo Antônio";
        endereco.bairro = "Limoeiro";
        endereco.rua = "Palmeiras";
        endereco.numero = 123;
        endereco.complemento = "Próximo à praça central";

        loja.endereco = endereco;
    }

    private static void adicionarCliente() {
        Cliente cliente = new Cliente();
        System.out.print("Nome do cliente: ");
        cliente.nome = scanner.nextLine();
        System.out.print("Idade do cliente: ");
        cliente.idade = scanner.nextInt();
        scanner.nextLine();

        Endereco endereco = new Endereco();
        System.out.print("Cidade: ");
        endereco.cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        endereco.bairro = scanner.nextLine();
        System.out.print("Rua: ");
        endereco.rua = scanner.nextLine();
        endereco.estado = "PE";

        cliente.endereco = endereco;
        loja.listaClientes.add(cliente);
        cliente.apresentarse();
        cliente.endereco.apresentarLogradouro();
    }

    private static void adicionarVendedor() {
        Vendedor vendedor = new Vendedor();
        System.out.print("Nome do vendedor: ");
        vendedor.nome = scanner.nextLine();
        System.out.print("Idade do vendedor: ");
        vendedor.idade = scanner.nextInt();
        System.out.print("Salário base: ");
        vendedor.salarioBase = scanner.nextFloat();
        scanner.nextLine();
        vendedor.loja = loja.nomeFantasia;

        Endereco endereco = new Endereco();
        System.out.print("Cidade: ");
        endereco.cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        endereco.bairro = scanner.nextLine();
        System.out.print("Rua: ");
        endereco.rua = scanner.nextLine();
        endereco.estado = "PE";

        vendedor.endereco = endereco;
        loja.listaVendedores.add(vendedor);
        vendedor.apresentarse();
        vendedor.calcularMedia();
        vendedor.exibirBonus();
        vendedor.endereco.apresentarLogradouro();
    }

    private static void adicionarGerente() {
        Gerente gerente = new Gerente();
        System.out.print("Nome do gerente: ");
        gerente.nome = scanner.nextLine();
        System.out.print("Idade do gerente: ");
        gerente.idade = scanner.nextInt();
        System.out.print("Salário base: ");
        gerente.salarioBase = scanner.nextFloat();
        scanner.nextLine();
        gerente.loja = loja.nomeFantasia;

        Endereco endereco = new Endereco();
        System.out.print("Cidade: ");
        endereco.cidade = scanner.nextLine();
        System.out.print("Bairro: ");
        endereco.bairro = scanner.nextLine();
        System.out.print("Rua: ");
        endereco.rua = scanner.nextLine();
        endereco.estado = "PE";

        gerente.endereco = endereco;
        loja.listaGerentes.add(gerente);
        gerente.apresentarse();
        gerente.calcularMedia();
        gerente.exibirBonus();
        gerente.endereco.apresentarLogradouro();
    }

    private static void criarPedido() {
        if (loja.listaClientes.isEmpty() || loja.listaVendedores.isEmpty()) {
            System.out.println("É necessário ao menos um cliente e um vendedor para criar um pedido.");
            return;
        }

        Cliente cliente = loja.listaClientes.get(0);
        Vendedor vendedor = loja.listaVendedores.get(0);

        ArrayList<Item> itens = new ArrayList<>();
        Item item = new Item();
        item.id = 1;
        item.nomeItem = "Buquê de Rosas";
        item.tipo = "Flor";
        item.valor = 150.00f;
        item.gerarDescricao();
        itens.add(item);

        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(cliente, vendedor, loja, itens);

        System.out.println("\nResumo do Pedido Criado:");
        pedido.gerarDescricaoVenda();
    }

    private static void listarEnderecos() {
        for (Cliente c : loja.listaClientes) {
            c.endereco.apresentarLogradouro();
        }
        for (Vendedor v : loja.listaVendedores) {
            v.endereco.apresentarLogradouro();
        }
        for (Gerente g : loja.listaGerentes) {
            g.endereco.apresentarLogradouro();
        }
    }
}