import java.time.LocalDate;

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
