package sistema;

import java.util.Date;

public class Congresso extends Evento {
    public Congresso(String title, Date startDate, Date endDate, double dailyTicketPrice, int maxCapacity) {
        super(title, startDate, endDate, dailyTicketPrice, maxCapacity);
    }

    @Override
    public double calculateTicketPrice(boolean isVip) {
        return dailyTicketPrice * getEventDurationDays();
    }
}

