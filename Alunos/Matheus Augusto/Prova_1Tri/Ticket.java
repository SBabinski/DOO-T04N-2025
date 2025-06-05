package Prova_1tri;

public class Ticket {
    private String id;
    private String eventId;
    private String clientId;
    private int days;
    private boolean isVip;
    private double price;
    private boolean used;

    public Ticket(String id, String eventId, String clientId, int days, boolean isVip, double price) {
        this.id = id;
        this.eventId = eventId;
        this.clientId = clientId;
        this.days = days;
        this.isVip = isVip;
        this.price = price;
        this.used = false;
    }

    public void markAsUsed() {
        this.used = true;
    }

    public String getId() {
        return id;
    }

    public String getEventId() {
        return eventId;
    }

    public String getClientId() {
        return clientId;
    }

    public int getDays() {
        return days;
    }

    public boolean isVip() {
        return isVip;
    }

    public double getPrice() {
        return price;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", eventId='" + eventId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", days=" + days +
                ", isVip=" + isVip +
                ", price=" + price +
                ", used=" + used +
                '}';
    }
}
