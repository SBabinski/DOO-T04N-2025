package Src.Enums;

public enum TicketType {
    NORMAL(0),
    VIP(1);


    private int value;

    TicketType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
