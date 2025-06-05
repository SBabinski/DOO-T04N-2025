
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Eventos do Cleitinho ---");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar show");
            System.out.println("3. Cadastrar congresso");
            System.out.println("4. Listar todos os eventos");
            System.out.println("5. Comprar ingresso");
            System.out.println("6. Usar ingresso");
            System.out.println("7. Listar clientes cadastrados");
            System.out.println("8. Listar shows");
            System.out.println("9. Listar congressos");
            System.out.println("10. Verificar disponibilidade de ingressos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    sistema.cadastrarCliente(nomeCliente, cpf);
                    break;
                case 2:
                    System.out.print("Nome do show: ");
                    String nomeShow = sc.nextLine();
                    System.out.print("Duração em dias: ");
                    int diasShow = sc.nextInt();
                    System.out.print("Valor diário: ");
                    double valorShow = sc.nextDouble();
                    System.out.print("Capacidade total: ");
                    int capacidadeShow = sc.nextInt();
                    sc.nextLine();
                    sistema.cadastrarShow(nomeShow, diasShow, valorShow, capacidadeShow);
                    break;
                case 3:
                    System.out.print("Nome do congresso: ");
                    String nomeCong = sc.nextLine();
                    System.out.print("Duração em dias: ");
                    int diasCong = sc.nextInt();
                    System.out.print("Valor diário: ");
                    double valorCong = sc.nextDouble();
                    System.out.print("Capacidade total: ");
                    int capacidadeCong = sc.nextInt();
                    sc.nextLine();
                    sistema.cadastrarCongresso(nomeCong, diasCong, valorCong, capacidadeCong);
                    break;
                case 4:
                    sistema.listarEventos();
                    break;
                case 5:
                    System.out.print("Nome do cliente: ");
                    String nomeCli = sc.nextLine();
                    System.out.print("Nome do evento: ");
                    String nomeEvt = sc.nextLine();
                    System.out.print("Ingresso VIP? (true/false): ");
                    boolean vip = sc.nextBoolean();
                    sc.nextLine();
                    sistema.comprarIngresso(nomeCli, nomeEvt, vip);
                    break;
                case 6:
                    System.out.print("Nome do cliente: ");
                    String cliUsa = sc.nextLine();
                    System.out.print("Nome do evento: ");
                    String evtUsa = sc.nextLine();
                    sistema.usarIngresso(cliUsa, evtUsa);
                    break;
                case 7:
                    sistema.listarClientes();
                    break;
                case 8:
                    sistema.listarShows();
                    break;
                case 9:
                    sistema.listarCongressos();
                    break;
                case 10:
                    System.out.print("Nome do evento: ");
                    String nomeDisp = sc.nextLine();
                    sistema.verificarDisponibilidadeEvento(nomeDisp);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}



