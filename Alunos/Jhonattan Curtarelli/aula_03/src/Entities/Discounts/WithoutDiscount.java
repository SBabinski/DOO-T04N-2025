package src.Entities.Discounts;

import src.Entities.Budget;

import java.math.BigDecimal;

public class WithoutDiscount extends Discount
{
    public WithoutDiscount ()
    {
        super(null);
    }

    @Override
    public BigDecimal calculate(Budget value) {
        return null;
    }

}
