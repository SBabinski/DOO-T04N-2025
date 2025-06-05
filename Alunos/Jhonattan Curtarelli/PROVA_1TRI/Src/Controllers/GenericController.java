package Src.Controllers;

import Src.Entities.Customer;
import Src.Entities.Event;
import Src.Entities.Ticket;
import Src.Enums.EventType;
import Src.Enums.TicketType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class GenericController {
    /**
     * Professor vou fazer um controller genérico só por preguiça de criar um para cada entidade :>
     */
    public static Customer createCustomer(int id,String name, String email, String phone, LocalDate birthday)
    {
        return new Customer(id,birthday, email, name, phone);
    }
    public static Event createEvent(
        int id,
        String name,
        int durationDays,
        BigDecimal dayPrice,
        EventType eventType,
        int vacancies
    )
    {
        return new Event(id, name, durationDays, dayPrice, eventType, vacancies);
    }
    public static void listEvent(List<Event> events)
    {
        for (Event e : events) {
            System.out.println(e.toString());
        }
    }
    public static Ticket createTicket(
            int id,
            Customer customer,
            Event event,
            TicketType ticketType
    )
    {
        if (ticketType == TicketType.VIP && event.eventType == EventType.SHOW) {
            event.vacanciesVip--;
        } else if (ticketType == TicketType.NORMAL && event.eventType == EventType.SHOW) {
            event.vacancies--;
        }
        return new Ticket(id,customer, event, ticketType);
    }
    public static void useTicket(Ticket ticket)
    {
        ticket.isUsed = true;
    }
    public BigDecimal calculateTotalTicket(Ticket ticket)
    {
        return ticket.price;
    }

}
