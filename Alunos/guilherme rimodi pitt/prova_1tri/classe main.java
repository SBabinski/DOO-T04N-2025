import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEvento sistema = new SistemaEvento();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n=== Menu do Sistema de Eventos ===");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar evento");
            System.out.println("3. Listar eventos");
            System.out.println("4. Comprar ingresso");
            System.out.println("5. Utilizar ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch(opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    sistema.cadastrarCliente(nomeCliente);
                    break;
                case 2:
                    System.out.print("Digite o tipo do evento (show/congresso): ");
                    String tipoEvento = scanner.nextLine();
                    System.out.print("Digite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite a data de início (yyyy-mm-dd): ");
                    String dataInicioStr = scanner.nextLine();
                    System.out.print("Digite a data de fim (yyyy-mm-dd): ");
                    String dataFimStr = scanner.nextLine();
                    System.out.print("Digite a quantidade máxima de clientes: ");
                    int maxClientes = scanner.nextInt();
                    System.out.print("Digite o valor do ingresso diário: ");
                    double valorIngressoDiario = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    LocalDate dataInicio = LocalDate.parse(dataInicioStr);
                    LocalDate dataFim = LocalDate.parse(dataFimStr);
                    
                    sistema.cadastrarEvento(tipoEvento, nomeEvento, dataInicio, dataFim, maxClientes, valorIngressoDiario);
                    break;
                case 3:
                    sistema.listarEventos();
                    break;
                case 4:
                    System.out.print("Digite o ID do cliente: ");
                    int clienteId = scanner.nextInt();
                    System.out.print("Digite o ID do evento: ");
                    int eventoId = scanner.nextInt();
                    scanner.nextLine(); // consumo do \n
                    String tipoIngresso = "Normal";
                    Evento evento = sistema.getEventoById(eventoId);
                    if(evento instanceof EventoShow) {
                        System.out.print("Deseja ingresso VIP? (s/n): ");
                        String resposta = scanner.nextLine();
                        if(resposta.equalsIgnoreCase("s")) {
                            tipoIngresso = "VIP";
                        }
                    }
                    sistema.comprarIngresso(clienteId, eventoId, tipoIngresso);
                    break;
                case 5:
                    System.out.print("Digite o ID do ingresso a ser utilizado: ");
                    int ingressoId = scanner.nextInt();
                    scanner.nextLine();
                    sistema.utilizarIngresso(ingressoId);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
