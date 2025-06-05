import java.util.*;

public class main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Ingresso> ingressos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Sistema de Eventos ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar Evento");
            System.out.println("4. Listar Eventos");
            System.out.println("5. Comprar Ingresso");
            System.out.println("6. Utilizar Ingresso");
            System.out.println("7. Verificar Disponibilidade");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> cadastrarCliente(scanner);
                case 2 -> listarClientes();
                case 3 -> cadastrarEvento(scanner);
                case 4 -> listarEventos();
                case 5 -> comprarIngresso(scanner);
                case 6 -> utilizarIngresso(scanner);
                case 7 -> verificarDisponibilidade(scanner);
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.println("Cadastro de Cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        System.out.println("=== Lista de Clientes Cadastrados ===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente.getNome());
            }
        }
    }

    private static void cadastrarEvento(Scanner scanner) {
        System.out.println("Cadastro de Evento");
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Duração (dias): ");
        int duracaoDias = scanner.nextInt();
        System.out.print("Valor diário do ingresso: ");
        double valorDiario = scanner.nextDouble();
        System.out.print("Capacidade máxima de participantes: ");
        int capacidadeMaxima = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Tipo de evento (show/congresso): ");
        String tipo = scanner.nextLine();

        Evento evento = new Evento(nome, duracaoDias, valorDiario, capacidadeMaxima, tipo);
        eventos.add(evento);

        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos() {
        System.out.println("=== Lista de Eventos Cadastrados ===");
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            for (Evento evento : eventos) {
                System.out.println(evento);
            }
        }
    }

    private static void comprarIngresso(Scanner scanner) {
        System.out.println("Compra de Ingresso");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente))
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Nome do evento: ");
        String nomeEvento = scanner.nextLine();

        Evento evento = eventos.stream()
                .filter(e -> e.getNome().equalsIgnoreCase(nomeEvento))
                .findFirst()
                .orElse(null);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        if (ingressos.stream().filter(i -> i.getEvento().equals(evento)).count() >= evento.getCapacidadeMaxima()) {
            System.out.println("O evento atingiu a capacidade máxima.");
            return;
        }

        Ingresso ingresso = new Ingresso(cliente, evento);
        ingressos.add(ingresso);
        System.out.println("Ingresso comprado com sucesso!");
    }

    private static void utilizarIngresso(Scanner scanner) {
        System.out.println("Utilizar Ingresso");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Ingresso ingresso = ingressos.stream()
                .filter(i -> i.getCliente().getNome().equalsIgnoreCase(nomeCliente) && !i.isUtilizado())
                .findFirst()
                .orElse(null);

        if (ingresso == null) {
            System.out.println("Ingresso não encontrado ou já utilizado.");
            return;
        }

        ingresso.utilizar();
    }

    private static void verificarDisponibilidade(Scanner scanner) {
        System.out.println("Verificação de Disponibilidade");
        System.out.print("Nome do evento: ");
        String nomeEvento = scanner.nextLine();

        Evento evento = eventos.stream()
                .filter(e -> e.getNome().equalsIgnoreCase(nomeEvento))
                .findFirst()
                .orElse(null);

        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        long ingressosVendidos = ingressos.stream()
                .filter(i -> i.getEvento().equals(evento))
                .count();

        long vagasDisponiveis = evento.getCapacidadeMaxima() - ingressosVendidos;
        System.out.println("Vagas disponíveis para o evento '" + evento.getNome() + "': " + vagasDisponiveis);
    }
}
