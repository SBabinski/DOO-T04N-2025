package prova1tri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\n1. Cadastrar cliente");
            System.out.println("2. Cadastrar evento Show");
            System.out.println("3. Cadastrar evento Congresso");
            System.out.println("4. Listar eventos");
            System.out.println("5. Comprar ingresso");
            System.out.println("6. Verificar disponibilidade do evento");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    sistema.cadastrarCliente(nomeCliente, cpfCliente);
                    break;
                case "2":
                    System.out.print("Nome do evento: ");
                    String nomeShow = scanner.nextLine();
                    System.out.print("Data de início (dd/mm/yyyy): ");
                    String inicioShow = scanner.nextLine();
                    System.out.print("Data de fim (dd/mm/yyyy): ");
                    String fimShow = scanner.nextLine();
                    System.out.print("Valor da diária: R$ ");
                    double valorDiariaShow = Double.parseDouble(scanner.nextLine());
                    System.out.print("Número máximo de vagas: ");
                    int vagasShow = Integer.parseInt(scanner.nextLine());
                    Evento show = new Show(nomeShow, inicioShow, fimShow, valorDiariaShow, vagasShow);
                    sistema.cadastrarEvento(show);
                    break;
                case "3":
                    System.out.print("Nome do evento: ");
                    String nomeCongresso = scanner.nextLine();
                    System.out.print("Data de início (dd/mm/yyyy): ");
                    String inicioCongresso = scanner.nextLine();
                    System.out.print("Data de fim (dd/mm/yyyy): ");
                    String fimCongresso = scanner.nextLine();
                    System.out.print("Valor da diária: R$ ");
                    double valorDiariaCongresso = Double.parseDouble(scanner.nextLine());
                    System.out.print("Número máximo de vagas: ");
                    int vagasCongresso = Integer.parseInt(scanner.nextLine());
                    Evento congresso = new Congresso(nomeCongresso, inicioCongresso, fimCongresso, valorDiariaCongresso, vagasCongresso);
                    sistema.cadastrarEvento(congresso);
                    break;
                case "4":
                    sistema.listarEventos();
                    break;
                case "5":
                    System.out.print("Nome do evento: ");
                    String nomeEventoCompra = scanner.nextLine();
                    Evento eventoCompra = sistema.buscarEventoPorNome(nomeEventoCompra);
                    if (eventoCompra != null) {
                        System.out.print("Nome do cliente: ");
                        String nomeClienteCompra = scanner.nextLine();
                        Cliente clienteCompra = new Cliente(nomeClienteCompra, nomeClienteCompra);  // Usando o nome como CPF temporariamente
                        System.out.print("Quantos dias de ingresso? ");
                        int dias = Integer.parseInt(scanner.nextLine());
                        sistema.comprarIngresso(eventoCompra, clienteCompra, dias);
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case "6":
                    System.out.print("Nome do evento: ");
                    String nomeEventoVerificar = scanner.nextLine();
                    Evento eventoVerificar = sistema.buscarEventoPorNome(nomeEventoVerificar);
                    if (eventoVerificar != null) {
                        System.out.println(eventoVerificar.verificarDisponibilidade() ? "Vagas disponíveis." : "Sem vagas disponíveis.");
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
            }
        } while (!opcao.equals("0"));

        scanner.close();
    }
}
