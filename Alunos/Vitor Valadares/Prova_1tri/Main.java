package prova1tri;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
    	DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SistemaEventos sistema = new SistemaEventos();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = sc.nextLine();
                    sistema.cadastrarCliente(nomeCliente, cpfCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do evento: ");
                    String nomeEvento = sc.nextLine();
                    System.out.print("Data de início (dd/MM/yyyy): ");
                    LocalDate inicio = LocalDate.parse(sc.nextLine(), formatoBR);  
                    System.out.print("Data de fim (dd/MM/yyyy): ");
                    LocalDate fim = LocalDate.parse(sc.nextLine(), formatoBR);  
                    System.out.print("Preço por diária: ");
                    double preco = sc.nextDouble();
                    System.out.print("Capacidade total: ");
                    int capacidade = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Tipo de evento (1 - Show | 2 - Congresso): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Valor adicional VIP: ");
                        double adicionalVIP = sc.nextDouble();
                        sistema.cadastrarShow(nomeEvento, inicio, fim, preco, capacidade, adicionalVIP);
                        System.out.println("Show cadastrado com sucesso!");
                    } else {
                        sistema.cadastrarCongresso(nomeEvento, inicio, fim, preco, capacidade);
                        System.out.println("Congresso cadastrado com sucesso!");
                    }
                    break;

                case 3:
                    sistema.listarEventos();
                    break;

                case 4:
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();

                    System.out.println("Selecione o evento:");
                    sistema.listarEventosComIndice();
                    System.out.print("Digite o número do evento: ");
                    int indiceEvento = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Ingresso VIP? (s/n): ");
                    boolean vip = sc.nextLine().equalsIgnoreCase("s");

                    Evento eventoSelecionado = sistema.getEventoPorIndice(indiceEvento);

                    if (eventoSelecionado != null) {
                        boolean sucesso = false;
                        if (eventoSelecionado instanceof Show && vip) {
                            sucesso = ((Show) eventoSelecionado).comprarVIP(new Cliente("TEMP", cpf)); 
                            
                            sucesso = eventoSelecionado.adicionarParticipante(new Cliente("TEMP", cpf));
                        }

                        if (sucesso) {
                            System.out.println("Ingresso comprado com sucesso!");
                        } else {
                            System.out.println("Erro ao comprar ingresso (verifique disponibilidade ou tipo de ingresso).");
                        }
                    } else {
                        System.out.println("Evento inválido.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
