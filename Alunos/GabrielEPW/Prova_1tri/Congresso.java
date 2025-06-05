import java.time.LocalDate;

class Congresso extends Evento {
    public Congresso(String name, LocalDate startDate, LocalDate endDate, int maxCapacity, double dailyTicketPrice) {
        super(name, startDate, endDate, maxCapacity, dailyTicketPrice);
    }

    @Override
    public boolean hasVipArea() {
        return false;
    }

    @Override
    public double getVipTicketPrice() {
        return 0;
    }
}