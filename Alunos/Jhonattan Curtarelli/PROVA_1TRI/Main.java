import Src.Controllers.GenericController;
import Src.Entities.Customer;
import Src.Entities.Event;
import Src.Entities.Ticket;
import Src.Enums.TicketType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main{

    /**
     * Cleitinho, um coordenador de eventos, precisa de um novo sistema para gerenciar os eventos e os participantes, pois o atual foi desenvolvido em Pascal e os dinossauros já estão extintos, portanto não há ninguém para dar manutenção.
     * Para resolver esse problema, desenvolva uma pequena aplicação em Java que atenda aos seguintes requisitos:
     * -----------------------------------------------------------------------------------------------
     * Cadastro de cliente.
     * Cadastro de evento (eventos podem durar vários dias, o valor do ingresso do evento deverá ser diário, existem dois tipos de evento shows e congressos; a única diferença é que shows tem área VIP com 10% das vagas do evento e o ingresso na área VIP é mais caro.
     * Listar eventos.
     * Comprar ingresso do evento.
     * Utilizar ingresso em evento.
     * Calcular valor do ingresso, respeitando regra de diárias.
     * Verificar a disponibilidade de participação em um evento (um evento deverá ter um número máximo de clientes).
     */

    // listas com registros em tempo de execução
    private static final List<Customer> customerList = new ArrayList<>();
    private static final List<Event> eventList = new ArrayList<>();
    private static final List<Ticket> ticketList = new ArrayList<>();
    public static void menu()
    {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Random random = new Random();



        System.out.println("Bem-vindo ao sistema de eventos!");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Cadastrar evento");
        System.out.println("3. Listar eventos");
        System.out.println("4. Comprar ingresso");
        System.out.println("5. Utilizar ingresso");
        System.out.println("6. Calcular valor do ingresso");
        System.out.println("7. Verificar disponibilidade de participação");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
        int option = 0;
        try {
            option = Integer.parseInt(sc.next());
            switch(option)
            {
                case 1:
                    System.out.println("Cadastrar cliente");
                    System.out.print("Digite o nome do cliente: ");
                    String name = sc.next();
                    System.out.print("Digite o email do cliente: ");
                    String email = sc.next();
                    System.out.print("Digite o telefone do cliente: ");
                    String phone = sc.next();
                    System.out.print("Digite a data de nascimento do cliente (dd/MM/yyyy): ");
                    String birthday = sc.next();

                    Customer customer = GenericController.createCustomer(
                            random.nextInt(100000),
                            name,
                            email,
                            phone,
                            LocalDate.parse(birthday, formatter)
                    );
                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println(customer.toString());
                    customerList.add(customer);

                    menu();
                    break;
                case 2:
                    System.out.println("Cadastrar evento");
                    System.out.print("Digite o nome do evento: ");
                    String eventName = sc.next();
                    System.out.print("Digite a duração do evento em dias: ");
                    int durationDays = sc.nextInt();
                    System.out.print("Digite o valor do ingresso por dia: ");
                    double dayPrice = sc.nextDouble();
                    System.out.print("Digite o tipo do evento (0 - SHOW, 1 - CONGRESSO): ");
                    int eventType = sc.nextInt();
                    System.out.print("Digite o número de vagas do evento: ");
                    int vacancies = sc.nextInt();
                    Event event = GenericController.createEvent(
                            random.nextInt(100000),
                            eventName,
                            durationDays,
                            BigDecimal.valueOf(dayPrice),
                            eventType == 0 ? Src.Enums.EventType.SHOW : Src.Enums.EventType.CONGRESS,
                            vacancies
                    );
                    System.out.println("Evento cadastrado com sucesso!");
                    System.out.println(event.toString());
                    eventList.add(event);
                    menu();

                    break;
                case 3:
                    System.out.println("Listar eventos");
                    GenericController.listEvent(eventList);
                    menu();

                    break;
                case 4:
                    System.out.println("Comprar ingresso");
                    System.out.print("Digite o id do cliente: ");
                    int customerId = sc.nextInt();
                    System.out.print("Digite o id do evento: ");
                    int eventId = sc.nextInt();
                    System.out.print("Digite o tipo do ingresso (0 - VIP, 1 - COMUM): ");
                    int ticketType = sc.nextInt();
                    Customer customer1 = null;
                    // buscar o cliente na lista
                    for (Customer c : customerList) {
                        if (c.id == customerId) {
                            customer1 = c;
                            break;
                        }
                    }
                    if (customer1 == null) {
                        System.out.println("Cliente não encontrado!");
                        menu();
                    }
                    Event event1 = null;
                    // buscar o evento na lista
                    for (Event e : eventList) {
                        if (e.id == eventId) {
                            event1 = e;
                            break;
                        }
                    }
                    if (event1 == null) {
                        System.out.println("Evento não encontrado!");
                        menu();
                    }
                    if (event1!=null && event1.vacancies <= 0) {
                        System.out.println("Evento sem vagas!");
                        menu();
                    }
                    if (event1!=null && event1.vacanciesVip <= 0 && ticketType == 0) {
                        System.out.println("Evento sem vagas VIP!");
                        menu();
                    }
                    Ticket ticket = GenericController.createTicket(
                            random.nextInt(100000),
                            customer1,
                            event1,
                            ticketType == 0 ? Src.Enums.TicketType.VIP : TicketType.NORMAL
                    );
                    System.out.println("Ingresso comprado com sucesso!");
                    System.out.println(ticket.toString());
                    ticketList.add(ticket);

                    menu();

                    break;
                case 5:
                    System.out.println("Utilizar ingresso");
                    System.out.print("Digite o id do ingresso: ");
                    int ticketId = sc.nextInt();
                    Ticket ticket1 = null;
                    // buscar o ingresso na lista
                    for (Ticket t : ticketList) {
                        if (t.id == ticketId) {
                            ticket1 = t;
                            break;
                        }
                    }
                    if (ticket1 == null) {
                        System.out.println("Ingresso não encontrado!");
                        menu();
                    }
                    System.out.print("Digite o id do evento: ");
                    int eventId1 = sc.nextInt();
                    Event event2 = null;
                    // buscar o evento na lista
                    for (Event e : eventList) {
                        if (e.id == eventId1) {
                            event2 = e;
                            break;
                        }
                    }
                    if (event2 == null) {
                        System.out.println("Evento não encontrado!");
                        menu();
                    }
                    if (event2!=null && event2.vacancies <= 0) {
                        System.out.println("Evento sem vagas!");
                        menu();
                    }
                    if (event2 != null && event2.vacanciesVip <= 0) {
                        assert ticket1 != null;
                        if (ticket1.TicketType == TicketType.VIP) {
                            System.out.println("Evento sem vagas VIP!");
                            menu();
                        }
                    }
                    assert ticket1 != null;
                    if (ticket1.isUsed) {
                        System.out.println("Ingresso já utilizado!");
                        menu();
                    }
                    GenericController.useTicket(ticket1);
                    System.out.println("Ingresso utilizado com sucesso!");
                    System.out.println(ticket1.toString());
                    menu();

                    break;
                case 6:
                    System.out.println("Calcular valor do ingresso");
                    System.out.print("Digite o id do ingresso: ");
                    int ticketId1 = sc.nextInt();
                    Ticket ticket2 = null;
                    // buscar o ingresso na lista
                    for (Ticket t : ticketList) {
                        if (t.id == ticketId1) {
                            ticket2 = t;
                            break;
                        }
                    }
                    if (ticket2 == null) {
                        System.out.println("Ingresso não encontrado!");
                        menu();
                    }
                    assert ticket2 != null;
                    System.out.print("O valor do ingresso é: " + ticket2.price);

                    menu();

                    break;
                case 7:
                    System.out.println("Verificar disponibilidade de participação");
                    System.out.print("Digite o id do evento: ");
                    int eventId2 = sc.nextInt();
                    Event event3 = null;
                    // buscar o evento na lista
                    for (Event e : eventList) {
                        if (e.id == eventId2) {
                            event3 = e;
                            break;
                        }
                    }
                    if (event3 == null) {
                        System.out.println("Evento não encontrado!");
                        menu();
                    }
                    assert event3 != null;
                    if (event3.vacancies <= 0) {
                        System.out.println("Evento sem vagas!");
                    } else {
                        System.out.println("Evento com vagas!");
                    }
                    menu();

                    break;
                case 8:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    menu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Tente novamente.");
            menu();
        }


    }
    public static void main(String[] args) {
        menu();
    }
}
