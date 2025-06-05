package sistema_gerenciamento;
import java.util.Scanner;
import java.util.ArrayList;

public class SistemaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de clientes e eventos
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Evento> eventos = new ArrayList<>();

        // Variável para armazenar a opção do usuário
        int opcao;

        do {
            // Menu principal
            System.out.println("\n🎟️ MENU DE EVENTOS CLEITINHO");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Utilizar Ingresso");
            System.out.println("6. Verificar Vagas Disponíveis");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Cadastrar cliente
                    System.out.println("📋 Cadastrar Cliente");
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

              
                case 2:
                    // Cadastrar evento
                    System.out.println("📅 Cadastrar Evento");
                    System.out.print("Nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Duração do evento (em dias): ");
                    int dias = scanner.nextInt();
                    System.out.print("Valor diário do ingresso: ");
                    double valorDiario = scanner.nextDouble();
                    System.out.print("Capacidade do evento: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Tipo de evento (1 - Show, 2 - Congresso): ");
                    int tipoEvento = scanner.nextInt();
                    scanner.nextLine();
                    Evento evento;
                    if (tipoEvento == 1) {
                        System.out.print("Valor do ingresso VIP: ");
                        double valorVIP = scanner.nextDouble();  // Lê o valor do ingresso VIP
                        System.out.print("Número de vagas VIP: ");
                        int vagasVIP = scanner.nextInt();  // Lê o número de vagas VIP

                        evento = new Show(nomeEvento, dias, valorDiario, capacidade, vagasVIP, valorVIP);  // Cria o evento Show
                    } else {
                        evento = new Congresso(nomeEvento, dias, valorDiario, capacidade);  // Para Congresso, não precisa de VIP
                    }
                    eventos.add(evento);
                    System.out.println("Evento cadastrado com sucesso!");
                    break;

                case 3:
                    // Listar eventos
                    System.out.println("📑 Listando todos os eventos:");
                    for (Evento e : eventos) {
                        System.out.println("Evento: " + e.getNome() + ", Vagas Disponíveis: " + e.getVagasDisponiveis());

                        // Se for um Show, exibe as informações de VIP
                        if (e instanceof Show) {
                            Show show = (Show) e;  // Faz o cast para Show
                            System.out.println("Área VIP: Vagas " + show.getVagasVIP() + " disponíveis, Valor VIP: " + show.calcularValorIngressoVIP());
                        }
                    }
                    break;

                case 4:
                    // Comprar ingresso
                    System.out.println("💳 Comprar Ingresso");
                    System.out.print("Digite o nome do cliente: ");
                    String nomeClienteCompra = scanner.nextLine();
                    Cliente clienteCompra = null;
                    for (Cliente c : clientes) {
                        if (c.getNome().equals(nomeClienteCompra)) {
                            clienteCompra = c;
                            break;
                        }
                    }

                    if (clienteCompra != null) {
                        System.out.print("Digite o nome do evento: ");
                        String nomeEventoCompra = scanner.nextLine();
                        Evento eventoCompra = null;
                        for (Evento e : eventos) {
                            if (e.getNome().equals(nomeEventoCompra)) {
                                eventoCompra = e;
                                break;
                            }
                        }

                        if (eventoCompra != null && eventoCompra.comprarIngresso(clienteCompra)) {
                            System.out.println("Ingresso comprado com sucesso!");
                        } else {
                            System.out.println("Evento não encontrado ou sem vagas disponíveis.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("🎫 Utilizar Ingresso");

                    // Pedir o nome do cliente
                    System.out.print("Digite o nome do cliente: ");
                    String nomeClienteInput = scanner.nextLine(); 
                    // Procurar cliente
                    Cliente clienteEncontrado = null;
                    for (Cliente c : clientes) { 
                        if (c.getNome().equalsIgnoreCase(nomeClienteInput)) {
                            clienteEncontrado = c;
                            break;
                        }
                    }

                    if (clienteEncontrado != null) {
                        // Pedir o nome do evento
                        System.out.print("Digite o nome do evento: ");
                        String nomeEventoInput = scanner.nextLine(); 

                        // Procurar evento
                        Evento eventoEncontrado = null;
                        for (Evento e : eventos) {  
                            if (e.getNome().equalsIgnoreCase(nomeEventoInput)) {
                                eventoEncontrado = e;
                                break;
                            }
                        }

                        if (eventoEncontrado != null) {
                            // Verificar se o cliente comprou o ingresso
                            if (eventoEncontrado.getVagasDisponiveis() < eventoEncontrado.capacidade) {
                                // Caso o evento tenha vagas e o cliente tenha ingresso
                                if (eventoEncontrado.comprarIngresso(clienteEncontrado)) {
                                    System.out.println("Ingresso utilizado com sucesso! O cliente está participando do evento.");
                                } else {
                                    System.out.println("Erro: Cliente já está participando deste evento ou não tem ingresso.");
                                }
                            } else {
                                System.out.println("Evento não tem vagas disponíveis.");
                            }
                        } else {
                            System.out.println("Evento não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 6:
                    // Verificar vagas disponíveis
                    System.out.println("🔎 Verificar Vagas Disponíveis");
                    System.out.print("Digite o nome do evento: ");
                    String nomeEventoVagas = scanner.nextLine();
                    Evento eventoVagas = null;
                    for (Evento e : eventos) {
                        if (e.getNome().equals(nomeEventoVagas)) {
                            eventoVagas = e;
                            break;
                        }
                    }

                    if (eventoVagas != null) {
                        System.out.println("Vagas disponíveis: " + eventoVagas.getVagasDisponiveis());
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 7:
                    // Sair
                    System.out.println("👋 Saindo... Valeu Cleitinho!");
                    break;

                default:
                    System.out.println("❌ Opção inválida. Tente de novo.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
