package lucas.PROVA_1TRI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EventManagementApp {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventManager manager = new EventManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistema de Eventos ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Usar Ingresso");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Nome completo: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    Cliente c = manager.cadastrarCliente(nome, cpf);
                    System.out.println("Cliente cadastrado: " + c);
                    break;

                case 2:
                    System.out.print("Tipo (1-Show, 2-Congresso): ");
                    int tipo = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome do evento: ");
                    String evNome = sc.nextLine();
                    LocalDate di = readDate("Data início (DD-MM-YYYY): ", sc);
                    LocalDate df = readDate("Data fim    (DD-MM-YYYY): ", sc);
                    System.out.print("Preço diário: ");
                    double pd = Double.parseDouble(sc.nextLine());
                    System.out.print("Capacidade: ");
                    int cap = Integer.parseInt(sc.nextLine());
                    Evento e = manager.cadastrarEvento(tipo, evNome, di, df, pd, cap);
                    System.out.println("Evento cadastrado: " + e);
                    break;

                case 3:
                    List<Evento> lista = manager.listarEventos();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum evento cadastrado.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Nome do evento: ");
                    String eventoParaComprar = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCompra = sc.nextLine();
                    System.out.print("VIP? (true/false): ");
                    boolean vip = Boolean.parseBoolean(sc.nextLine());
                    Cliente clienteCompra = manager.buscarClientePorCpf(cpfCompra);
                    Evento eventoCompra = manager.buscarEventoPorNome(eventoParaComprar);
                    if (clienteCompra == null || eventoCompra == null) {
                        System.out.println("Cliente ou evento não encontrado.");
                    } else {
                        Ingresso ing = eventoCompra.comprarIngresso(clienteCompra, vip);
                        if (ing != null) System.out.println("Ingresso comprado: " + ing);
                    }
                    break;

                case 5:
                    System.out.print("Nome do evento: ");
                    String eventoParaUsar = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfUso = sc.nextLine();
                    Evento eventoUso = manager.buscarEventoPorNome(eventoParaUsar);
                    if (eventoUso == null) {
                        System.out.println("Evento não encontrado.");
                        break;
                    }
                    Ingresso ingressoParaUsar = eventoUso.ingressos.stream()
                        .filter(i -> i.getCliente().getCpf().equals(cpfUso))
                        .findFirst()
                        .orElse(null);
                    if (ingressoParaUsar == null) {
                        System.out.println("Nenhum ingresso desse cliente para este evento.");
                    } else {
                        ingressoParaUsar.usar();
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    private static LocalDate readDate(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String txt = sc.nextLine();
            try {
                return LocalDate.parse(txt, DTF);
            } catch (DateTimeParseException ex) {
                System.out.println("Formato inválido! Ajuste para DD-MM-YYYY.");
            }
        }
    }
}



