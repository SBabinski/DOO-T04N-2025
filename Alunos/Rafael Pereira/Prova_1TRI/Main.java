package fag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SistemadoEvento sistema = new SistemadoEvento();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA BLACKCAT DO CLEITINHO ==="); // Tem um local de eventos na minha cidade que se chama Gato Preto, ai coloquei o nome de BlackCat só por conta do nome mesmo
            System.out.println("\n1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Listar Eventos Detalhados");
            System.out.println("5. Comprar Ingresso");
            System.out.println("6. Calcular Valor do Ingresso");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, cpfCliente);
                    sistema.adicionarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");  
                    break;

                case 2:
                    
                    System.out.print("Digite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite a duração (em dias) do evento: ");
                    int duracao = scanner.nextInt();
                    System.out.print("Digite o preço por dia do ingresso: ");
                    double precoDia = scanner.nextDouble();
                    System.out.print("Digite a capacidade do evento: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Escolha o tipo de evento:");
                    System.out.println("1. Show");
                    System.out.println("2. Congresso");
                    int tipoEvento = scanner.nextInt();
                    scanner.nextLine();  

                    Evento evento = null;
                    if (tipoEvento == 1) {
                        System.out.print("Digite o adicional VIP (ex: 0.1 para 10%): ");
                        double adicionalVip = scanner.nextDouble();
                        evento = new Show(nomeEvento, duracao, precoDia, capacidade, adicionalVip);
                    } else {
                        evento = new Congresso(nomeEvento, duracao, precoDia, capacidade);
                    }
                    sistema.cadastrarEvento(evento);
                    System.out.println("Evento cadastrado com sucesso!");  
                    break;

                case 3:
                    sistema.listarEventos();
                    break;

                case 4:
                    sistema.listarEventosDetalhados();
                    break;

                case 5:
                    
                    System.out.print("Digite o nome do evento: ");
                    nomeEvento = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    cpfCliente = scanner.nextLine();
                    Cliente clienteComprar = sistema.buscarClientePorCpf(cpfCliente);
                    if (clienteComprar != null) {
                    	System.out.print("Ingresso VIP? (sim/nao): ");
                    	String respostaVip = scanner.nextLine().trim().toLowerCase();
                    	boolean vip = respostaVip.equals("sim");

                        boolean comprado = sistema.comprarIngresso(nomeEvento, clienteComprar, vip);
                        if (comprado) {
                            System.out.println("Ingresso comprado com sucesso!");
                        } else {
                            System.out.println("Falha na compra do ingresso.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 6:
                    
                    System.out.print("Digite o nome do evento: ");
                    nomeEvento = scanner.nextLine();
                    System.out.print("Ingresso VIP? (sim/não): ");
                    String respostaVip = scanner.nextLine().trim().toLowerCase();
                    boolean vipIngresso = respostaVip.equals("sim");

                    double valorIngresso = sistema.calcularValorIngresso(nomeEvento, vipIngresso);
                    System.out.println("Valor do ingresso: R$" + valorIngresso);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
