package Prova_1tri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, Client> clients;
    private Map<String, Event> events;
    private Map<String, Ticket> tickets;

    public EventManager() {
        this.clients = new HashMap<>();
        this.events = new HashMap<>();
        this.tickets = new HashMap<>();
    }

    public void registerClient(String id, String name, String email) {
        if (!clients.containsKey(id)) {
            clients.put(id, new Client(id, name, email));
        }
    }

    public Client getClient(String id) {
        return clients.get(id);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    public void createEvent(Event event) {
        if (!events.containsKey(event.getId())) {
            events.put(event.getId(), event);
        }
    }

    public Event getEvent(String id) {
        return events.get(id);
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events.values());
    }

    public Ticket buyTicket(String eventId, String clientId, int days, boolean isVip) {
        Event event = events.get(eventId);
        if (event == null) return null;
    
        if (isVip && event instanceof Show) {
            Show show = (Show) event;
            if (show.getAvailableVipSpots() <= 0) {
                return null;
            }
        } else if (event.getAvailableSpots() <= 0) {
            return null;
        }
    
        double price = event.calculateTicketPrice(days, isVip);
        String ticketId = "TKT-" + System.currentTimeMillis();
        Ticket ticket = new Ticket(ticketId, eventId, clientId, days, isVip, price);

        if (isVip && event instanceof Show) {
            ((Show) event).addVipParticipant(clientId);
        } else {
            event.addParticipant(clientId);
        }
    
        tickets.put(ticketId, ticket);
        return ticket;
    }

    public boolean useTicket(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null && !ticket.isUsed()) {
            ticket.markAsUsed();
            return true;
        }
        return false;
    }

    public Ticket getTicket(String ticketId) {
        return tickets.get(ticketId);
    }

    public List<Ticket> getClientTickets(String clientId) {
        List<Ticket> clientTickets = new ArrayList<>();
        for (Ticket ticket : tickets.values()) {
            if (ticket.getClientId().equals(clientId)) {
                clientTickets.add(ticket);
            }
        }
        return clientTickets;
    }
}
