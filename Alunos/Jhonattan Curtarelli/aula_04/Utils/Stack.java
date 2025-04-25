package Utils;

import src.Entities.Order.Order;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final List<Order> orders;

    public Stack() {
        this.orders = new ArrayList<>();
    }

    public void addBudget(Order order) {
        this.orders.add(order);
    }
    public List<Order> GetBudgets() {
        return this.orders;
    }
}
