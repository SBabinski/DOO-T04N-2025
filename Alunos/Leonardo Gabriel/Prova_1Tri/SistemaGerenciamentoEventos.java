package prova_1tri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoEventos {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Ingresso> ingressos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gerenciamento de Eventos ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Utilizar Ingresso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarEvento();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    comprarIngresso();
                    break;
                case 5:
                    utilizarIngresso();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarEvento() {
        System.out.println("\n--- Cadastro de Evento ---");
        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();
        System.out.print("Capacidade máxima: ");
        int capacidade = scanner.nextInt();
        System.out.print("Valor do ingresso diário: R$");
        double valorDiario = scanner.nextDouble();
        System.out.print("Duração em dias: ");
        int duracaoDias = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Tipo do evento (show/congresso): ");
        String tipo = scanner.nextLine().toLowerCase();

        Evento evento;
        if (tipo.equals("show")) {
            evento = new Show(nome, capacidade, valorDiario, duracaoDias);
        } else if (tipo.equals("congresso")) {
            evento = new Congresso(nome, capacidade, valorDiario, duracaoDias);
        } else {
            System.out.println("Tipo de evento inválido.");
            return;
        }

        eventos.add(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos() {
        System.out.println("\n--- Lista de Eventos ---");
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i));
        }
    }

    private static void comprarIngresso() {
        System.out.println("\n--- Comprar Ingresso ---");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
            return;
        }
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        System.out.println("Clientes cadastrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        System.out.print("Selecione o número do cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir a quebra de linha
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        Cliente cliente = clientes.get(clienteIndex);

        System.out.println("\nEventos disponíveis:");
        listarEventos();
        System.out.print("Selecione o número do evento: ");
        int eventoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir a quebra de linha
        if (eventoIndex < 0 || eventoIndex >= eventos.size()) {
            System.out.println("Evento inválido.");
            return;
        }
        Evento evento = eventos.get(eventoIndex);

        if (!evento.verificarDisponibilidade()) {
            System.out.println("O evento " + evento.getNome() + " está lotado.");
            return;
        }

        boolean areaVip = false;
        if (evento instanceof Show && ((Show) evento).getVagasVipDisponiveis() > 0) {
            System.out.print("Deseja comprar ingresso para a área VIP? (sim/não): ");
            String respostaVip = scanner.nextLine().toLowerCase();
            areaVip = respostaVip.equals("sim");
            if (areaVip && ((Show) evento).getVagasVipDisponiveis() == 0) {
                System.out.println("As vagas VIP para este show estão esgotadas.");
                areaVip = false;
            }
        }

        double valorIngresso = evento.calcularValorIngresso(areaVip);
        System.out.println("Valor total do ingresso: R$" + String.format("%.2f", valorIngresso));
        System.out.print("Confirmar compra? (sim/não): ");
        String confirmar = scanner.nextLine().toLowerCase();

        if (confirmar.equals("sim")) {
            Ingresso ingresso = new Ingresso(cliente, evento, areaVip);
            evento.adicionarIngresso(ingresso);
            ingressos.add(ingresso);
            System.out.println("Ingresso comprado com sucesso!");
            System.out.println(ingresso);
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    private static void utilizarIngresso() {
        System.out.println("\n--- Utilizar Ingresso ---");
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso comprado.");
            return;
        }

        System.out.println("Ingressos comprados:");
        for (int i = 0; i < ingressos.size(); i++) {
            System.out.println((i + 1) + ". " + ingressos.get(i));
        }
        System.out.print("Selecione o número do ingresso a ser utilizado: ");
        int ingressoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir a quebra de linha

        if (ingressoIndex < 0 || ingressoIndex >= ingressos.size()) {
            System.out.println("Ingresso inválido.");
            return;
        }

        Ingresso ingresso = ingressos.get(ingressoIndex);

        if (ingresso.isUtilizado()) {
            System.out.println("Este ingresso já foi utilizado.");
        } else {
            ingresso.marcarUtilizado();
            System.out.println("Ingresso utilizado com sucesso para o evento: " + ingresso.getEvento().getNome());
        }
    }
}