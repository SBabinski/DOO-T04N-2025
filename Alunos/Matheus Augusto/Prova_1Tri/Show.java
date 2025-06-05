package Prova_1tri;

import java.util.ArrayList;
import java.util.List;

public class Show extends Event {
    private double vipTicketPremium;
    private int vipSpots;
    private List<String> vipParticipants;

    public Show(String id, String name, String description, List<String> dates, 
                double dailyTicketPrice, int maxParticipants, double vipTicketPremium) {
        super(id, name, description, dates, dailyTicketPrice, maxParticipants);
        this.vipTicketPremium = vipTicketPremium;
        this.vipSpots = (int) Math.ceil(maxParticipants * 0.1);
        this.vipParticipants = new ArrayList<>();
    }

    @Override
    public double calculateTicketPrice(int days, boolean isVip) {
        double basePrice = super.getDailyTicketPrice() * days;
        return isVip ? basePrice + (vipTicketPremium * days) : basePrice;
    }

    public boolean hasVipAvailableSpots() {
        return vipParticipants.size() < vipSpots;
    }

    public boolean addVipParticipant(String clientId) {
        if (hasVipAvailableSpots()) {
            vipParticipants.add(clientId);
            return super.addParticipant(clientId);
        }
        return false;
    }

    public boolean isVipParticipant(String clientId) {
        return vipParticipants.contains(clientId);
    }

    public int getVipSpots() {
        return vipSpots;
    }

    public int getAvailableVipSpots() {
        return vipSpots - vipParticipants.size();
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", dates=" + super.getDates() +
                ", dailyTicketPrice=" + super.getDailyTicketPrice() +
                ", maxParticipants=" + super.getMaxParticipants() +
                ", availableSpots=" + super.getAvailableSpots() +
                ", vipTicketPremium=" + vipTicketPremium +
                ", vipSpots=" + vipSpots +
                ", availableVipSpots=" + getAvailableVipSpots() +
                '}';
    }
}
