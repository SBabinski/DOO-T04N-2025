package src.Entities.Discounts;

import src.Entities.Budget;

import java.math.BigDecimal;

public class DiscountForMoreThan10Items extends Discount  {

    public DiscountForMoreThan10Items(Discount next) {
        super(next);
    }
    public BigDecimal calculate(Budget budget) {
        if (budget.items > 10) {
            return budget.total.multiply(BigDecimal.valueOf(0.05));
        }
        return next.calculate(budget);
    }
}
