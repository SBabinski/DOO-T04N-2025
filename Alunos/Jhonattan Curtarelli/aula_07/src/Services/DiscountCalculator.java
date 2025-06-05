package src.Services;

import src.Entities.Order.Order;
import src.Entities.Discounts.Discount;
import src.Entities.Discounts.DiscountForMoreThan10Items;
import src.Entities.Discounts.WithoutDiscount;

import java.math.BigDecimal;

public class DiscountCalculator
{
    public BigDecimal calculate(Order order)
    {
        Discount discountChain = new DiscountForMoreThan10Items(new WithoutDiscount());
        return discountChain.calculate(order);
    }
}
