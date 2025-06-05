import java.time.LocalDate;
import java.util.UUID;

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
