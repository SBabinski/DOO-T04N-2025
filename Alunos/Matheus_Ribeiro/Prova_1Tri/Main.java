package sistema;

import java.util.Calendar;
import java.util.*;

public class Main {
    static List<Cliente> clients = new ArrayList<>();
    static List<Evento> events = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int opt1 = -1;
        while (opt1!= 0) {
            System.out.println("Bem vindo ao sistema! Escolha uma opção para continuar:\n"
            		+ "1. Cadastrar cliente\n"
            		+ "2. Criar evento (Show ou Congresso)\n"
            		+ "3. Listar eventos\n"
            		+ "4. Comprar ingresso\n"
            		+ "5. Utilizar ingresso\n"
            		+ "0. Sair\n");
            opt1 = scanner.nextInt();

            switch (opt1) {
            case 1:
                cadastrarCliente();
                break;

            case 2:
                criarEvento();
                break;

            case 3:
                listarEventos();
                break;

            case 4:
                comprarIngresso();
                break;

            case 5:
                usarIngresso();
                break;

            case 0:
                System.out.println("Encerrando o sistema. Até a próxima!");
                opt1 = 0;
                break;

            default:
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void cadastrarCliente() {
    	 System.out.print("Digite o nome do cliente: ");
         String name = scanner.next();
         System.out.print("Digite o email do cliente: ");
         String email = scanner.next();
         clients.add(new Cliente(name, email));
         System.out.println("Cliente cadastrado com sucesso!");
    }
      
    public static void criarEvento() {
    	try {
            System.out.print("Título do evento: ");
            String title = scanner.next();

            System.out.println("Digite a data de INÍCIO do evento:");
            System.out.print("Dia: ");
            int startDay = scanner.nextInt();
            System.out.print("Mês: ");
            int startMonth = scanner.nextInt();
            System.out.print("Ano: ");
            int startYear = scanner.nextInt();

            Calendar startCal = Calendar.getInstance();
            startCal.set(startYear, startMonth - 1, startDay);
            Date start = startCal.getTime();

            System.out.println("Digite a data de TÉRMINO do evento:");
            System.out.print("Dia: ");
            int endDay = scanner.nextInt();
            System.out.print("Mês: ");
            int endMonth = scanner.nextInt();
            System.out.print("Ano: ");
            int endYear = scanner.nextInt();

            Calendar endCal = Calendar.getInstance();
            endCal.set(endYear, endMonth - 1, endDay);
            Date end = endCal.getTime();

            System.out.print("Preço diário do ingresso: R$ ");
            double price = scanner.nextDouble();
            System.out.print("Capacidade máxima do evento: ");
            int capacity = scanner.nextInt();
            System.out.print("Tipo do evento (show/congresso): ");
            String type = scanner.next();

            if (type.equalsIgnoreCase("show")) {
                events.add(new Show(title, start, end, price, capacity));
            } else {
                events.add(new Congresso(title, start, end, price, capacity));
            }
            System.out.println("Evento criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar evento. Verifique os dados informados.");
        }

    }
    public static void listarEventos() {
        if (events.isEmpty()) {
            System.out.println("Nenhum evento cadastrado ainda.");
            return;
        }

        for (Evento e : events) {
            System.out.println(e);
        }
    }
    public static void comprarIngresso() {
        System.out.println("Selecione um evento da lista abaixo:");

        for (int i = 0; i < events.size(); i++) {
            Evento e = events.get(i);
            if (e.isAvailable()) {
                System.out.println("ID: " + (i + 1) + " - " + e.title);
            }
        }

        System.out.print("Digite o ID do evento: ");
        int eventId = scanner.nextInt() - 1;
        scanner.nextLine(); // Consome o \n que sobra

        if (eventId < 0 || eventId >= events.size()) {
            System.out.println("Evento não encontrado.");
            return;
        }
        Evento event = events.get(eventId);

        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();

        Cliente client = findClientByEmail(email);
        if (client == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("É VIP? (true/false): ");
        boolean isVip = Boolean.parseBoolean(scanner.nextLine());

        boolean success = false;
        if (event instanceof Show show) {
            success = show.registerClient(client, isVip);
        } else {
            success = event.registerClient(client);
        }

        if (success) {
        	double ticketPrice = event.calculateTicketPrice(isVip);
        	client.addIngresso(event, isVip);
            System.out.println("Ingresso comprado com sucesso! Valor: R$ " + ticketPrice);
        } else {
            System.out.println("Não foi possível comprar o ingresso (evento lotado ou VIP indisponível).");
        }
    }


    public static void usarIngresso() {
        System.out.print("Email do cliente: ");
        String email = scanner.next();

        Cliente client = findClientByEmail(email);

        if (client == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        if (client.ingressos.isEmpty()) {
            System.out.println("Este cliente não possui ingressos.");
            return;
        }

        System.out.println("\nIngressos disponíveis:");
        for (int i = 0; i < client.ingressos.size(); i++) {
            Cliente.Ingresso ingresso = client.ingressos.get(i);
            System.out.println("[" + i + "] Evento: " + ingresso.evento.title + " - Usado: " + (ingresso.isUsed ? "Sim" : "Não"));
        }

        System.out.print("Digite o número do ingresso que deseja utilizar: ");
        int escolha = scanner.nextInt();

        if (escolha >= 0 && escolha < client.ingressos.size()) {
            Cliente.Ingresso ingressoSelecionado = client.ingressos.get(escolha);
            ingressoSelecionado.usarIngresso();
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static Cliente findClientByEmail(String email) {
        for (Cliente c : clients) {
            if (c.email.equals(email)) {
                return c;
            }
        }
        return null;
    }
    public static void listarIngressosCliente() {
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();
        Cliente client = findClientByEmail(email);

        if (client != null) {
            client.listarIngressos();
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }



    public static void main(String[] args) {
        menu();
    }
}
    


        