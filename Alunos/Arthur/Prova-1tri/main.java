import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();
        int opcao;

        do {
            System.out.println("\n=== Sistema de Eventos ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Utilizar Ingresso");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Email do cliente: ");
                    String emailCliente = scanner.nextLine();
                    sistema.cadastrarCliente(nomeCliente, emailCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Quantidade de dias: ");
                    int dias = scanner.nextInt();
                    System.out.print("Valor diário do ingresso: ");
                    double valorDiario = scanner.nextDouble();
                    System.out.print("Capacidade do evento: ");
                    int capacidade = scanner.nextInt();
                    System.out.print("É um show? (true/false): ");
                    boolean isShow = scanner.nextBoolean();
                    sistema.cadastrarEvento(nomeEvento, dias, valorDiario, capacidade, isShow);
                    break;

                case 3:
                    sistema.listarEventos();
                    break;

                case 4:
                    System.out.print("Nome do cliente: ");
                    String nomeCompra = scanner.nextLine();
                    System.out.print("Nome do evento: ");
                    String eventoCompra = scanner.nextLine();
                    System.out.print("Ingresso VIP? (true/false): ");
                    boolean isVip = scanner.nextBoolean();
                    sistema.comprarIngresso(nomeCompra, eventoCompra, isVip);
                    break;

                case 5:
                    System.out.print("Nome do cliente: ");
                    String nomeUso = scanner.nextLine();
                    System.out.print("Nome do evento: ");
                    String eventoUso = scanner.nextLine();
                    sistema.utilizarIngresso(nomeUso, eventoUso);
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
