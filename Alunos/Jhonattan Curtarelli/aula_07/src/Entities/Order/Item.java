package src.Entities.Order;

import src.Interfaces.IPresentate;

import java.math.BigDecimal;

public class Item implements IPresentate {
    public String id;
    public String name;
    public String description;
    public BigDecimal value;
    public Item(String id, String name, String description, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    @Override
    public String presentate() {
        return "ID: " + this.id + "\n" +
                "Name: " + this.name + "\n" +
                "Description: " + this.description + "\n" +
                "Value: " + this.value;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
                "Name: " + this.name + "\n" +
                "Description: " + this.description + "\n" +
                "Value: " + this.value;
    }
}
