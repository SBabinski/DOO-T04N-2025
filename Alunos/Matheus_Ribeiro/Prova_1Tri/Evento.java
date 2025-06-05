package sistema;

import java.util.*;

public abstract class Evento {
    String title;
    Date startDate;
    Date endDate;
    double dailyTicketPrice;
    int maxCapacity;
    List<Cliente> participants = new ArrayList<>();

    public Evento(String title, Date startDate, Date endDate, double dailyTicketPrice, int maxCapacity) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyTicketPrice = dailyTicketPrice;
        this.maxCapacity = maxCapacity;
    }

    public long getEventDurationDays() {
        long diff = endDate.getTime() - startDate.getTime();
        return (diff / (1000 * 60 * 60 * 24)) + 1;
    }

    public boolean isAvailable() {
        return participants.size() < maxCapacity;
    }

    public boolean registerClient(Cliente client) {
        if (isAvailable()) {
            participants.add(client);
            return true;
        }
        return false;
    }

    public abstract double calculateTicketPrice(boolean isVip);

    @Override
    public String toString() {
        return title + " (" + startDate + " to " + endDate + ") - Capacity: " + maxCapacity + ", Registered: " + participants.size();
    }
}

