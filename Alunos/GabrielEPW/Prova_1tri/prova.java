import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

class Clientee {
    private String id;
    private String name;
    private String email;

    public Clientee(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

abstract class Evento {
    protected String id;
    protected String name;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int maxCapacity;
    protected double dailyTicketPrice;
    protected List<Ticket> ticketsSold;

    public Evento(String name, LocalDate startDate, LocalDate endDate, int maxCapacity, double dailyTicketPrice) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxCapacity = maxCapacity;
        this.dailyTicketPrice = dailyTicketPrice;
        this.ticketsSold = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public abstract boolean hasVipArea();

    public abstract double getVipTicketPrice();

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getDailyTicketPrice() {
        return dailyTicketPrice;
    }

    public List<Ticket> getTicketsSold() {
        return ticketsSold;
    }

    public boolean isDateValid(LocalDate date) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}

class Show extends Evento {
    private int vipCapacity;

    public Show(String name, LocalDate startDate, LocalDate endDate, int maxCapacity, double dailyTicketPrice) {
        super(name, startDate, endDate, maxCapacity, dailyTicketPrice);
        this.vipCapacity = (int) (maxCapacity * 0.1);
    }

    @Override
    public boolean hasVipArea() {
        return true;
    }

    @Override
    public double getVipTicketPrice() {
        return dailyTicketPrice * 1.5;
    }

    public int getVipCapacity() {
        return vipCapacity;
    }
}

class Congresso extends Evento {
    public Congresso(String name, LocalDate startDate, LocalDate endDate, int maxCapacity, double dailyTicketPrice) {
        super(name, startDate, endDate, maxCapacity, dailyTicketPrice);
    }

    @Override
    public boolean hasVipArea() {
        return false;
    }

    @Override
    public double getVipTicketPrice() {
        return 0;
    }
}

class Ticket {
    private String id;
    private Clientee clientee;
    private Evento evento;
    private LocalDate date;
    private boolean isVip;
    private boolean used;

    public Ticket(Clientee clientee, Evento evento, LocalDate date, boolean isVip) {
        this.id = UUID.randomUUID().toString();
        this.clientee = clientee;
        this.evento = evento;
        this.date = date;
        this.isVip = isVip;
        this.used = false;
    }

    public String getId() {
        return id;
    }

    public Clientee getClient() {
        return clientee;
    }

    public Evento getEvent() {
        return evento;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isVip() {
        return isVip;
    }

    public boolean isUsed() {
        return used;
    }

    public void useTicket() {
        this.used = true;
    }

    public double calculatePrice() {
        return isVip ? evento.getVipTicketPrice() : evento.getDailyTicketPrice();
    }
}

class configeventotodo {
    private List<Clientee> clientees;
    private List<Evento> eventos;
    private Map<String, Ticket> tickets;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;

    public configeventotodo() {
        this.clientees = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.tickets = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void comeca() {
        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Eventos ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Evento");
            System.out.println("3. Listar Eventos");
            System.out.println("4. Comprar Ingresso");
            System.out.println("5. Utilizar Ingresso");
            System.out.println("6. Calcular Preço do Ingresso");
            System.out.println("7. Verificar Disponibilidade");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (option) {
                case 1:
                    registrarcliente();
                    break;
                case 2:
                    registrarevento();
                    break;
                case 3:
                    listaevento();
                    break;
                case 4:
                    comprarticket();
                    break;
                case 5:
                    ticket();
                    break;
                case 6:
                    calculadoraticket();
                    break;
                case 7:
                    checkAvailability();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void registrarcliente() {
        System.out.print("Nome do cliente: ");
        String name = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();
        Clientee clientee = new Clientee(name, email);
        clientees.add(clientee);
        System.out.println("Cliente cadastrado com ID: " + clientee.getId());
    }

    private void registrarevento() {
        System.out.print("Tipo de evento (1 - Show, 2 - Congresso): ");
        int type;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tipo inválido.");
            return;
        }

        System.out.print("Nome do evento: ");
        String name = scanner.nextLine();
        System.out.print("Data de início (dd/MM/yyyy): ");
        LocalDate startDate;
        try {
            startDate = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }
        System.out.print("Data de término (dd/MM/yyyy): ");
        LocalDate endDate;
        try {
            endDate = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }
        System.out.print("Capacidade máxima: ");
        int maxCapacity;
        try {
            maxCapacity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Capacidade inválida.");
            return;
        }
        System.out.print("Preço do ingresso diário: ");
        double dailyTicketPrice;
        try {
            dailyTicketPrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Preço inválido.");
            return;
        }

        if (type == 1) {
            Show show = new Show(name, startDate, endDate, maxCapacity, dailyTicketPrice);
            eventos.add(show);
            System.out.println("Show cadastrado com ID: " + show.getId());
        } else if (type == 2) {
            Congresso congresso = new Congresso(name, startDate, endDate, maxCapacity, dailyTicketPrice);
            eventos.add(congresso);
            System.out.println("Congresso cadastrado com ID: " + congresso.getId());
        } else {
            System.out.println("Tipo de evento inválido.");
        }
    }

    private void listaevento() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }
        System.out.println("\nLista de Eventos:");
        for (Evento evento : eventos) {
            String type = evento instanceof Show ? "Show" : "Congresso";
            System.out.printf("ID: %s | %s - %s (%s a %s, Capacidade: %d, Ingresso: R$%.2f)\n",
                    evento.getId(), type, evento.getName(), evento.getStartDate().format(dateFormatter),
                    evento.getEndDate().format(dateFormatter), evento.getMaxCapacity(), evento.getDailyTicketPrice());
            if (evento.hasVipArea()) {
                System.out.printf("  Área VIP: R$%.2f (Capacidade: %d)\n",
                        evento.getVipTicketPrice(), ((Show) evento).getVipCapacity());
            }
        }
    }

    private void comprarticket() {
        System.out.print("ID do cliente: ");
        String clientId = scanner.nextLine();
        System.out.print("ID do evento: ");
        String eventId = scanner.nextLine();
        System.out.print("Data do ingresso (dd/MM/yyyy): ");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }
        System.out.print("Área VIP? (s/n): ");
        boolean isVip = scanner.nextLine().toLowerCase().startsWith("s");

        Clientee clientee = fimcliente(clientId);
        Evento evento = fimevento(eventId);

        if (clientee == null || evento == null) {
            System.out.println("Cliente ou evento não encontrado.");
            return;
        }

        if (!evento.isDateValid(date)) {
            System.out.println("Data inválida para o evento.");
            return;
        }

        if (!isAvailable(evento, date, isVip)) {
            System.out.println("Não há vagas disponíveis.");
            return;
        }

        if (isVip && !evento.hasVipArea()) {
            System.out.println("Este evento não possui área VIP.");
            return;
        }

        Ticket ticket = new Ticket(clientee, evento, date, isVip);
        evento.getTicketsSold().add(ticket);
        tickets.put(ticket.getId(), ticket);
        System.out.printf("Ingresso comprado! ID: %s | Valor: R$%.2f\n", ticket.getId(), ticket.calculatePrice());
    }

    private void ticket() {
        System.out.print("ID do ingresso: ");
        String ticketId = scanner.nextLine();
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Ingresso não encontrado.");
            return;
        }

        if (ticket.isUsed()) {
            System.out.println("Ingresso já foi utilizado.");
            return;
        }

        ticket.useTicket();
        System.out.println("Ingresso utilizado com sucesso!");
    }

    private void calculadoraticket() {
        System.out.print("ID do evento: ");
        String eventId = scanner.nextLine();
        System.out.print("Área VIP? (s/n): ");
        boolean isVip = scanner.nextLine().toLowerCase().startsWith("s");

        Evento evento = fimevento(eventId);
        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        double price = isVip && evento.hasVipArea() ? evento.getVipTicketPrice() : evento.getDailyTicketPrice();
        System.out.printf("Preço do ingresso: R$%.2f\n", price);
    }

    private void checkAvailability() {
        System.out.print("ID do evento: ");
        String eventId = scanner.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine(), dateFormatter);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }
        System.out.print("Área VIP? (s/n): ");
        boolean isVip = scanner.nextLine().toLowerCase().startsWith("s");

        Evento evento = fimevento(eventId);
        if (evento == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        if (!evento.isDateValid(date)) {
            System.out.println("Data inválida para o evento.");
            return;
        }

        long ticketsForDate = evento.getTicketsSold().stream()
                .filter(t -> t.getDate().equals(date) && t.isVip() == isVip)
                .count();

        int capacity = isVip && evento instanceof Show ? ((Show) evento).getVipCapacity() : evento.getMaxCapacity();
        System.out.printf("Vagas disponíveis: %d de %d\n", capacity - ticketsForDate, capacity);
    }

    private Clientee fimcliente(String clientId) {
        return clientees.stream()
                .filter(c -> c.getId().equals(clientId))
                .findFirst()
                .orElse(null);
    }

    private Evento fimevento(String eventId) {
        return eventos.stream()
                .filter(e -> e.getId().equals(eventId))
                .findFirst()
                .orElse(null);
    }

    private boolean isAvailable(Evento evento, LocalDate date, boolean isVip) {
        long ticketsForDate = evento.getTicketsSold().stream()
                .filter(t -> t.getDate().equals(date) && t.isVip() == isVip)
                .count();

        if (isVip && evento instanceof Show) {
            return ticketsForDate < ((Show) evento).getVipCapacity();
        }
        return ticketsForDate < evento.getMaxCapacity();
    }

    public static void main(String[] args) {
        configeventotodo system = new configeventotodo();
        system.comeca();
    }
}
