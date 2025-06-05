package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while (true) {
            System.out.println("\n=== Menu do Sistema de Eventos ===");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar evento (show)");
            System.out.println("3. Cadastrar evento (congresso)");
            System.out.println("4. Listar eventos");
            System.out.println("5. Comprar ingresso");
            System.out.println("6. Utilizar ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, cpfCliente);
                    sistema.adicionarCliente(cliente);
                    break;

                case 2:
                    System.out.print("Nome do show: ");
                    String nomeShow = scanner.nextLine();
                    System.out.print("Duração em dias: ");
                    int duracaoShow = scanner.nextInt();
                    System.out.print("Preço diário: ");
                    double precoShow = scanner.nextDouble();
                    System.out.print("Máx. participantes: ");
                    int maxShow = scanner.nextInt();
                    scanner.nextLine();
                    sistema.cadastrarEvento(new Show(nomeShow, duracaoShow, precoShow, maxShow));
                    break;

                case 3:
                    System.out.print("Nome do congresso: ");
                    String nomeCongresso = scanner.nextLine();
                    System.out.print("Duração em dias: ");
                    int duracaoCongresso = scanner.nextInt();
                    System.out.print("Preço diário: ");
                    double precoCongresso = scanner.nextDouble();
                    System.out.print("Máx. participantes: ");
                    int maxCongresso = scanner.nextInt();
                    scanner.nextLine();
                    sistema.cadastrarEvento(new Congresso(nomeCongresso, duracaoCongresso, precoCongresso, maxCongresso));
                    break;

                case 4:
                    sistema.listarEventos();
                    break;

                case 5:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    Cliente c = sistema.buscarCliente(nome);
                    if (c == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    sistema.listarEventos();
                    System.out.print("Digite o índice do evento: ");
                    int indiceEvento = scanner.nextInt();
                    System.out.print("Ingresso VIP? (true/false): ");
                    boolean vip = scanner.nextBoolean();
                    scanner.nextLine();
                    sistema.comprarIngresso(indiceEvento, c, vip);
                    break;

                case 6:
                    System.out.print("Nome do cliente: ");
                    String nomeUsar = scanner.nextLine();
                    Cliente clienteUsar = sistema.buscarCliente(nomeUsar);
                    if (clienteUsar == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    sistema.listarEventos();
                    System.out.print("Digite o índice do evento: ");
                    int indiceUsar = scanner.nextInt();
                    scanner.nextLine();
                    sistema.utilizarIngresso(indiceUsar, clienteUsar);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
