package src.Entities.Discounts;

import src.Entities.Order.Order;
import java.math.BigDecimal;

public abstract class Discount {
    protected Discount next;

    public Discount(Discount next) {
        this.next = next;
    }

    public abstract BigDecimal calculate(Order value);
}
