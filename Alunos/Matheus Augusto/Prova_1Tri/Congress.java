package Prova_1tri;

import java.util.List;

public class Congress extends Event {
    public Congress(String id, String name, String description, List<String> dates, 
                    double dailyTicketPrice, int maxParticipants) {
        super(id, name, description, dates, dailyTicketPrice, maxParticipants);
    }

    @Override
    public double calculateTicketPrice(int days, boolean isVip) {
        return super.getDailyTicketPrice() * days;
    }

    @Override
    public String toString() {
        return "Congress{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", dates=" + super.getDates() +
                ", dailyTicketPrice=" + super.getDailyTicketPrice() +
                ", maxParticipants=" + super.getMaxParticipants() +
                ", availableSpots=" + super.getAvailableSpots() +
                '}';
    }
}
