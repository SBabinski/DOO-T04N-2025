package sistema_eventos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Usar Ingresso");
            System.out.println("6. Listar Ingressos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    sistema.cadastrarCliente(nome, cpf);
                    break;

                case 2:
                    System.out.print("Tipo (1-Show / 2-Congresso): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do evento: ");
                    String nomeEvento = sc.nextLine();
                    System.out.print("Duração (dias): ");
                    int dias = sc.nextInt();
                    System.out.print("Preço diário: ");
                    double preco = sc.nextDouble();
                    System.out.print("Capacidade máxima: ");
                    int capacidade = sc.nextInt();

                    if (tipo == 1)
                        sistema.cadastrarEvento(new Show(nomeEvento, dias, preco, capacidade));
                    else
                        sistema.cadastrarEvento(new Congresso(nomeEvento, dias, preco, capacidade));
                    break;

                case 3:
                    sistema.listarEventos();
                    break;

                case 4:
                    System.out.print("CPF do cliente: ");
                    String cpfIngresso = sc.nextLine();
                    System.out.print("Nome do evento: ");
                    String eventoIngresso = sc.nextLine();
                    System.out.print("VIP? (true/false): ");
                    boolean vip = sc.nextBoolean();
                    Ingresso ing = sistema.comprarIngresso(cpfIngresso, eventoIngresso, vip);
                    if (ing != null) System.out.println("Ingresso comprado:\n" + ing);
                    break;

                case 5:
                    System.out.print("CPF do cliente: ");
                    String cpfUsar = sc.nextLine();
                    System.out.print("Nome do evento: ");
                    String nomeUsar = sc.nextLine();
                    sistema.usarIngresso(cpfUsar, nomeUsar);
                    break;

                case 6:
                    sistema.listarIngressos();
                    break;
            }
        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        sc.close();
    }
}


