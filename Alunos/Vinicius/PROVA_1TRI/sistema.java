import java.util.*;

public class sistema {

    private static List<cliente> clientes = new ArrayList<>();
    private static List<evento> eventos = new ArrayList<>();
    private static List<Ingresso> ingressos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcao;
        
        do { 
            System.out.println("1- Cadastrar cliente \n" +
            "2- Cadastrar evento \n" +
            "3- Listar eventos \n" +
            "4- Comprar ingressos \n" +
            "5- Usar ingressos \n" +
            "6- Sair");
            opcao = scanner.nextInt();

        switch(opcao) {
            case 1 -> cadastrarCliente();
            case 2 -> cadastrarEvento();
            case 3 -> listarEventos();
            case 4 -> comprarIngressos();
            case 5 -> usarIngressos();
            case 6 -> System.out.println("Saindo");
            default -> System.out.println("Opção inválida");
        }
        } while (opcao != 6);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        cliente c = new cliente(nome);
        clientes.add(c);
        System.out.println("Cliente cadastrado.");
    }

    private static void cadastrarEvento() {
        System.out.println("Tipo : 1 - Show  2 - Congresso");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.println("Duração em dias: ");
        int dias = scanner.nextInt();
        System.out.println("preço diário");
        double preco = scanner.nextDouble();
        System.out.println("Capacidade: ");
        int capacidade = scanner.nextInt();

        evento e = (tipo == 1) 
        ? new show(nome, dias, preco, capacidade) 
        : new congresso(nome, dias, preco, capacidade);

        eventos.add(e);
        System.out.println("Evento cadastrado");
    }

    private static void listarEventos() {
        System.out.println("Eventos cadastrados: ");
        for (evento e : eventos) {
            System.out.println("Evento Nº " + e.getId() + "\nNome: " + e.getNome() + "\nCapacidade Total: " + e.capacidade() + "\nDisponível: " + e.disponivel());
        }
    }

    private static void comprarIngressos() {
        if (clientes.isEmpty() || eventos.isEmpty()) {
            System.out.println("Nenhum cliente ou evento cadastrado.");
            return;
        }

        listarEventos();
        System.out.println("ID do evento: ");
        int idEvento = scanner.nextInt();
        evento evento = eventos.stream().filter(e -> e.getId() == idEvento).findFirst().orElse(null);
        if (evento == null) {
            System.out.println("Evento inválido ou sem vagas.");
            return;
        }

        System.out.println("Clientes cadastrados: ");
        clientes.forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
        System.out.println("ID do cliente: ");
        int idCliente = scanner.nextInt();
        cliente cliente = clientes.stream().filter(c -> c.getId() == idCliente).findFirst().orElse(null);
        if (cliente == null) {
            System.out.println("Cliente inválido.");
            return;
        }

        boolean vip = false;
        if (evento instanceof show) {
            System.out.println("VIP? (s/n): ");
            vip = scanner.next().equalsIgnoreCase("s");
        }

        Ingresso ingresso = new Ingresso(cliente, evento, vip);
        if (evento.registrarIngresso(ingresso)) {
            ingressos.add(ingresso);
            System.out.println("Ingresso comprado.");
        } else {
            System.out.println("Evento sem vagas.");
        }
    }

    private static void usarIngressos() {
        System.out.println("nome do cliente: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        ingressos.stream()
            .filter(i -> i.toString().contains(nome))
            .forEach(System.out::println);

            for (Ingresso i : ingressos) {
                if (i.toString().contains(nome) && i.usar()) {
                    System.out.println("Ingresso usado.");
                } else {
                    System.out.println("Ingresso já usado ou inválido.");
                }
            }

    }

}
