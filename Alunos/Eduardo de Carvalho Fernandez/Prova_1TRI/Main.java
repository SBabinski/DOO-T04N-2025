package eventos;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final SistemaEventos sistema = new SistemaEventos();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            String opcao = sc.nextLine();
            switch (opcao) {
                case "1" -> cadastrarCliente();
                case "2" -> cadastrarEvento();
                case "3" -> sistema.listarEventos();
                case "4" -> comprarIngresso();
                case "5" -> usarIngresso();
                case "0" -> { sc.close(); return; }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 Cadastrar cliente");
        System.out.println("2 Cadastrar evento");
        System.out.println("3 Listar eventos");
        System.out.println("4 Comprar ingresso");
        System.out.println("5 Usar ingresso");
        System.out.println("0 Sair");
        System.out.print("Opção deseja: ");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        sistema.adicionarCliente(new Cliente(nome, idade));
        System.out.println("Cliente cadastrado.");
    }

    private static void cadastrarEvento() {
        System.out.print("Nome do evento: ");
        String nome = sc.nextLine();
        System.out.print("Tipo (show ou congresso): ");
        String tipo = sc.nextLine();
        System.out.print("Data início (anos-mes-data): ");
        LocalDate inicio = LocalDate.parse(sc.nextLine());
        System.out.print("Data fim (anos-mes-data): ");
        LocalDate fim = LocalDate.parse(sc.nextLine());
        System.out.print("Preço do dia: ");
        double preco = Double.parseDouble(sc.nextLine());
        System.out.print("Capacidade: ");
        int cap = Integer.parseInt(sc.nextLine());

        Evento evento;
        if (tipo.equalsIgnoreCase("show")) {
            evento = new Show(nome, inicio, fim, preco, cap);
        } else {
            evento = new Congresso(nome, inicio, fim, preco, cap);
        }

        sistema.adicionarEvento(evento);
        System.out.println("evento foi cadastrado.");
    }

    private static void comprarIngresso() {
        System.out.print("nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = sistema.buscarClientePorNome(nome);
        if (cliente == null) {
            System.out.println("cliente não encontrado.");
            return;
        }

        System.out.print("nome do evento: ");
        Evento evento = sistema.buscarEvento(sc.nextLine());
        if (evento == null) {
            System.out.println("evento não encontrado.");
            return;
        }

        boolean vip = evento.getTipo().equals("Show") && desejaVip();
        if (!evento.temVaga(vip)) {
            System.out.println("acabou as vagas.");
            return;
        }

        double preco = evento.calcularPreco(vip);
        evento.registrarIngresso(new Ingresso(evento, cliente, vip));
        System.out.println("ingresso comprado. Valor: R$" + preco);
    }

    private static boolean desejaVip() {
        System.out.print("deseja ingresso VIP? (s/n): ");
        return sc.nextLine().equalsIgnoreCase("s");
    }

    private static void usarIngresso() {
        System.out.print("nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("nome do evento: ");
        Evento evento = sistema.buscarEvento(sc.nextLine());

        if (evento != null && evento.ingressoPertence(nome)) {
            for (Ingresso i : evento.ingressos) {
                if (i.getCliente().getNome().equalsIgnoreCase(nome)) {
                    i.usar();
                    return;
                }
            }
        } else {
            System.out.println("Ingresso não encontrado.");
        }
    }
}
