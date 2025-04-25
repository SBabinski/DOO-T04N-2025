class Clientee {
    private String id;
    private String name;
    private String email;

    public Clientee(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

abstract class Evento {
    protected String id;
    protected String name;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int maxCapacity;
    protected double dailyTicketPrice;
    protected List<Ticket> ticketsSold;

    public Evento(String name, LocalDate startDate, LocalDate endDate, int maxCapacity, double dailyTicketPrice) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxCapacity = maxCapacity;
        this.dailyTicketPrice = dailyTicketPrice;
        this.ticketsSold = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public abstract boolean hasVipArea();

    public abstract double getVipTicketPrice();

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getDailyTicketPrice() {
        return dailyTicketPrice;
    }

    public List<Ticket> getTicketsSold() {
        return ticketsSold;
    }

    public boolean isDateValid(LocalDate date) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
