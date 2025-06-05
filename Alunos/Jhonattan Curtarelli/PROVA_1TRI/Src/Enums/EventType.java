package Src.Enums;

public enum EventType {
    SHOW(0),
    CONGRESS(1);

    private final int value;

    EventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
