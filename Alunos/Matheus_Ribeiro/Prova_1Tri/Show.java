package sistema;

import java.util.Date;

public class Show extends Evento {
    private static final double VIP_EXTRA_CHARGE = 1.5;
    private static final double VIP_PERCENTAGE = 0.1;
    private int vipCount = 0;

    public Show(String title, Date startDate, Date endDate, double dailyTicketPrice, int maxCapacity) {
        super(title, startDate, endDate, dailyTicketPrice, maxCapacity);
    }

    public boolean registerClient(Cliente client, boolean isVip) {
        if (isVip) {
            if (vipCount < maxCapacity * VIP_PERCENTAGE) {
                vipCount++;
                return super.registerClient(client);
            }
            return false;
        }
        return super.registerClient(client);
    }

    @Override
    public double calculateTicketPrice(boolean isVip) {
        double base = dailyTicketPrice * getEventDurationDays();
        return isVip ? base * VIP_EXTRA_CHARGE : base;
    }
}

