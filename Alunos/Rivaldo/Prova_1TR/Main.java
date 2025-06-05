import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Evento> eventos;
    private ArrayList<Cliente> clientes;

    public Main() {
        eventos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente);
    }

    public void cadastrarEvento(String nome, String dataInicio, String dataFim, double valorDiario, int numeroMaximoClientes, boolean isShow) {
        Evento evento;
        if (isShow) {
            evento = new EventoShow(nome, dataInicio, dataFim, valorDiario, numeroMaximoClientes);
        } else {
            evento = new EventoCongresso(nome, dataInicio, dataFim, valorDiario, numeroMaximoClientes);
        }
        eventos.add(evento);
        System.out.println("Evento cadastrado: " + evento);
    }

    public void comprarIngresso(String cpf, int eventoId, int dias, boolean isVIP) {
        Cliente cliente = buscarClientePorCpf(cpf);
        Evento evento = buscarEventoPorId(eventoId);
        if (cliente != null && evento != null) {
            if (evento.adicionarParticipante()) {
                double valorIngresso = evento.calcularValorIngresso(dias, isVIP);
                if (valorIngresso > 0) {
                    Ingresso ingresso = new Ingresso(cliente, evento, dias, isVIP, valorIngresso);
                    cliente.adicionarIngresso(ingresso);
                    System.out.println("Ingresso comprado para " + evento);
                }
            } else {
                System.out.println("Não há vagas disponíveis para este evento.");
            }
        } else {
            System.out.println("Cliente ou Evento não encontrados.");
        }
    }

    public void usarIngresso(String cpf, int eventoId) {
        Cliente cliente = buscarClientePorCpf(cpf);
        Evento evento = buscarEventoPorId(eventoId);
        if (cliente != null && evento != null) {
            cliente.usarIngresso(evento);
        } else {
            System.out.println("Cliente ou Evento não encontrados.");
        }
    }

    private Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    private Evento buscarEventoPorId(int id) {
        if (id >= 0 && id < eventos.size()) {
            return eventos.get(id);
        }
        return null;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Comprar Ingresso");
            System.out.println("4. Listar Eventos");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Usar Ingresso");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    cadastrarCliente(nomeCliente, cpfCliente);
                    break;
                case 2:
                    System.out.print("Digite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite a data de início (dd/mm): ");
                    String dataInicio = scanner.nextLine();
                    System.out.print("Digite a data de fim (dd/mm): ");
                    String dataFim = scanner.nextLine();
                    System.out.print("Digite o valor diário do ingresso: ");
                    double valorDiario = scanner.nextDouble();
                    System.out.print("Digite o número máximo de clientes: ");
                    int numeroMaximo = scanner.nextInt();
                    System.out.print("É um show? (true/false): ");
                    boolean isShow = scanner.nextBoolean();
                    cadastrarEvento(nomeEvento, dataInicio, dataFim, valorDiario, numeroMaximo, isShow);
                    break;
                case 3:
                    System.out.println("Eventos disponíveis:");
                    for (int i = 0; i < eventos.size(); i++) {
                        Evento evento = eventos.get(i);
                        System.out.println("ID: " + i + " | " + evento);
                    }
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCompra = scanner.nextLine();
                    System.out.print("Digite o ID do evento (começando de 0): ");
                    int eventoIdCompra = scanner.nextInt();
                    System.out.print("Digite o número de dias para o ingresso: ");
                    int dias = scanner.nextInt();
                    System.out.print("Você quer ingresso VIP? (true/false): ");
                    boolean isVIPCompra = scanner.nextBoolean();
                    comprarIngresso(cpfCompra, eventoIdCompra, dias, isVIPCompra);
                    break;
                case 4:
                    System.out.println("Eventos cadastrados:");
                    for (int i = 0; i < eventos.size(); i++) {
                        Evento evento = eventos.get(i);
                        System.out.println("ID: " + i + " | " + evento);
                    }
                    break;
                case 5:
                    System.out.println("Clientes cadastrados:");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente + " | Ingressos: ");
                        for (Ingresso ingresso : cliente.getIngressos()) {
                            System.out.println(ingresso);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfUso = scanner.nextLine();
                    System.out.print("Digite o ID do evento (começando de 0): ");
                    int eventoIdUso = scanner.nextInt();
                    usarIngresso(cpfUso, eventoIdUso);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.exibirMenu();
    }
}
