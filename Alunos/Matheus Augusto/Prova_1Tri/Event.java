package Prova_1tri;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private String id;
    private String name;
    private String description;
    private List<String> dates;
    private double dailyTicketPrice;
    private int maxParticipants;
    private List<String> participants;

    public Event(String id, String name, String description, List<String> dates, 
                 double dailyTicketPrice, int maxParticipants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dates = new ArrayList<>(dates);
        this.dailyTicketPrice = dailyTicketPrice;
        this.maxParticipants = maxParticipants;
        this.participants = new ArrayList<>();
    }

    public abstract double calculateTicketPrice(int days, boolean isVip);

    public boolean hasAvailableSpots() {
        return participants.size() < maxParticipants;
    }

    public boolean addParticipant(String clientId) {
        if (hasAvailableSpots()) {
            participants.add(clientId);
            return true;
        }
        return false;
    }

    public boolean isParticipating(String clientId) {
        return participants.contains(clientId);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDates() {
        return new ArrayList<>(dates);
    }

    public double getDailyTicketPrice() {
        return dailyTicketPrice;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public int getAvailableSpots() {
        return maxParticipants - participants.size();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dates=" + dates +
                ", dailyTicketPrice=" + dailyTicketPrice +
                ", maxParticipants=" + maxParticipants +
                ", availableSpots=" + getAvailableSpots() +
                '}';
    }
}
