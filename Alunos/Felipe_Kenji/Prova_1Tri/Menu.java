import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEventos gerenciador = new GerenciadorEventos();
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = null;  
        Evento evento = null;

        while (true) {
            System.out.println("Bem vindo ao gerenciador de eventos.");
            System.out.println("1. Cadastrar cliente;");
            System.out.println("2. Criar evento;");
            System.out.println("3. Listar eventos;");
            System.out.println("4. Comprar ingresso para evento;");
            System.out.println("5. Ver valor dos ingressos;");
            System.out.println("6. Sair;");
        
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    Cliente cliente = new Cliente(nome);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado.");
                }

                case 2 -> {
                    System.out.println("Escolha o tipo de evento:");
                    System.out.println("1. Show. \n2. Congresso.");
                    int tipoEvento = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite a quantidade de dias do evento: ");
                    int dias = scanner.nextInt();
                    System.out.print("Digite o valor diário do ingresso: ");
                    double valorDiario = scanner.nextDouble();
                    System.out.print("Digite o número de vagas do evento: ");
                    int vagas = scanner.nextInt();

                    if (tipoEvento == 1) {
                        Evento show = new Show(nomeEvento, dias, valorDiario, vagas);
                        gerenciador.adicionarEvento(show);
                        System.out.println("Show criado.");
                    } else if (tipoEvento == 2) {
                        Evento congresso = new Congresso(nomeEvento, dias, valorDiario, vagas);
                        gerenciador.adicionarEvento(congresso);
                        System.out.println("Congresso criado com sucesso!");
                    } else {
                        System.out.println("Tipo de evento inválido.");
                    }
                }

                case 3 -> {
                    System.out.println("\nEventos Disponíveis:");
                    gerenciador.listarEventos();
                }

                case 4 -> {
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
                        break;
                    }
                
                    System.out.println("Escolha o cliente para comprar ingresso:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println((i + 1) + ". " + clientes.get(i).getNome());
                    }
                    int clienteEscolhido = scanner.nextInt();
                    scanner.nextLine();
                
                    if (clienteEscolhido < 1 || clienteEscolhido > clientes.size()) {
                        System.out.println("Cliente inválido.");
                        break;
                    }
                
                    cliente1 = clientes.get(clienteEscolhido - 1); 
                    System.out.println("Você escolheu o cliente: " + cliente1.getNome());
                
                    System.out.println("Escolha o evento para comprar ingresso:");
                    gerenciador.listarEventos();
                    System.out.print("Digite o nome do evento: ");
                    String eventoEscolhido = scanner.nextLine();
                    evento = null;  
                    for (Evento e : gerenciador.getEventos()) {
                        if (e.getNome().equalsIgnoreCase(eventoEscolhido)) {
                            evento = e;
                            break;
                        }
                    }
                    if (evento != null) {
                        System.out.println("Você deseja ingresso VIP? (1. Sim / 2. Não)");
                        int escolhaIngresso = scanner.nextInt();
                        scanner.nextLine();
                
                        if (escolhaIngresso == 1) {
                            if (evento.comprarIngressoVIP()) {
                                System.out.println("Ingresso VIP comprado com sucesso!");
                            } else {
                                System.out.println("Não há vagas VIP disponíveis.");
                            }
                        } else if (escolhaIngresso == 2) {
                            if (gerenciador.comprarIngresso(cliente1, evento)) {
                                System.out.println("Ingresso normal comprado com sucesso!");
                            } else {
                                System.out.println("Evento sem vagas ou evento não encontrado.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                }

                case 5 -> {
                    if (evento != null) {
                        double valor = gerenciador.calcularValorIngresso(evento, cliente1);  
                        System.out.println("O valor do ingresso é: " + valor);
                    } else {
                        System.out.println("Escolha um evento primeiro.");
                    }
                    break;
                }

                case 6 -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
