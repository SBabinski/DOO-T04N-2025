import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoEventos {
    List<Cliente> clientes;
    List<Evento> eventos;
    List<Ingresso> ingressosVendidos;
    Scanner scanner;

    public SistemaGerenciamentoEventos() {
        this.clientes = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.ingressosVendidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarCliente() {
        System.out.println("--- Cadastro de Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado!");
    }

    public void cadastrarEvento() {
        System.out.println("--- Cadastro de Evento ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Duração em dias: ");
        int duracao = scanner.nextInt();
        System.out.print("Valor do ingresso por dia: R$");
        double valorDiario = scanner.nextDouble();
        System.out.print("Capacidade máxima: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Tipo (SHOW/CONGRESSO): ");
        String tipo = scanner.nextLine().toUpperCase();

        Evento evento = null;
        if (tipo.equals("SHOW")) {
            evento = new Show(nome, duracao, valorDiario, capacidade);
        } else if (tipo.equals("CONGRESSO")) {
            evento = new Congresso(nome, duracao, valorDiario, capacidade);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        eventos.add(evento);
        System.out.println("Evento cadastrado!");
    }

    public void listarEventos() {
        System.out.println("--- Lista de Eventos ---");
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (Evento evento : eventos) {
            evento.exibirDetalhes();
            System.out.println("---");
        }
    }

    public void comprarIngresso() {
        System.out.println("--- Comprar Ingresso ---");
        if (clientes.isEmpty() || eventos.isEmpty()) {
            System.out.println("Cadastre clientes e eventos primeiro.");
            return;
        }

        System.out.println("Clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("[" + i + "] " + clientes.get(i).getNome());
        }
        System.out.print("Selecione o cliente: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine();
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        Cliente cliente = clientes.get(clienteIndex);

        System.out.println("Eventos:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println("[" + i + "] " + eventos.get(i).getNome() + " (Vagas: " + (eventos.get(i).getCapacidadeMaxima() - eventos.get(i).getParticipantesAtuais()) + ")");
        }
        System.out.print("Selecione o evento: ");
        int eventoIndex = scanner.nextInt();
        scanner.nextLine();
        if (eventoIndex < 0 || eventoIndex >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }
        Evento evento = eventos.get(eventoIndex);

        if (!evento.verificarDisponibilidade()) {
            System.out.println("Evento lotado!");
            return;
        }

        boolean areaVip = false;
        if (evento instanceof Show) {
            System.out.print("Área VIP? (S/N): ");
            String resposta = scanner.nextLine().toUpperCase();
            areaVip = resposta.equals("S");
        }

        double valorFinal = evento.calcularValorIngresso(areaVip);
        evento.adicionarParticipante();
        Ingresso ingresso = new Ingresso(cliente, evento);
        ingressosVendidos.add(ingresso);
        System.out.println("Ingresso comprado para " + cliente.getNome() + " no evento " + evento.getNome() + ". Valor: R$" + String.format("%.2f", valorFinal));
    }

    public void utilizarIngresso() {
        System.out.println("--- Utilizar Ingresso em Evento ---");
        if (clientes.isEmpty() || eventos.isEmpty() || ingressosVendidos.isEmpty()) {
            System.out.println("Não há clientes, eventos ou ingressos vendidos.");
            return;
        }

        System.out.println("Clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("[" + i + "] " + clientes.get(i).getNome());
        }
        System.out.print("Selecione o cliente: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        Cliente cliente = clientes.get(clienteIndex);

        System.out.println("Eventos:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println("[" + i + "] " + eventos.get(i).getNome());
        }
        System.out.print("Selecione o evento: ");
        int eventoIndex = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        if (eventoIndex < 0 || eventoIndex >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }
        Evento evento = eventos.get(eventoIndex);

        boolean possuiIngresso = false;
        for (Ingresso ingresso : ingressosVendidos) {
            if (ingresso.getCliente() == cliente && ingresso.getEvento() == evento) {
                possuiIngresso = true;
                break;
            }
        }

        if (possuiIngresso) {
            System.out.println(cliente.getNome() + " possui ingresso para o evento " + evento.getNome() + ".");
        } else {
            System.out.println(cliente.getNome() + " não possui ingresso para o evento " + evento.getNome() + ".");
        }
    }

    public static void main(String[] args) {
        SistemaGerenciamentoEventos sistema = new SistemaGerenciamentoEventos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Utilizar Ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    sistema.cadastrarCliente();
                    break;
                case 2:
                    sistema.cadastrarEvento();
                    break;
                case 3:
                    sistema.listarEventos();
                    break;
                case 4:
                    sistema.comprarIngresso();
                    break;
                case 5:
                    sistema.utilizarIngresso();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}