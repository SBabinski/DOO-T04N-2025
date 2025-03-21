package src.Entities;

import java.math.BigDecimal;

public class Change
{
    private BigDecimal recivedPrice;
    private BigDecimal totalPrice;
    public Change(BigDecimal recivedPrice, BigDecimal totalPrice)
    {
        this.recivedPrice = recivedPrice;
        this.totalPrice = totalPrice;
    }
    public BigDecimal CalculateChange()
    {
        return recivedPrice.subtract(totalPrice);
    }
}
