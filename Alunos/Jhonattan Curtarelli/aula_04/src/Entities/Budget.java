package src.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Budget
{
    public BigDecimal value;
    public int items;
    public BigDecimal total;
    public LocalDate budgetDate;

    public Budget(BigDecimal value,int items)
    {
        this.items = items;
        this.value = value;
        this.total = value.multiply(new BigDecimal(items));
        this.budgetDate = LocalDate.now();    
    }
    public Budget(
        BigDecimal value, 
        int items,
        LocalDate  budgetDate
    )
    {
        this.items = items;
        this.value = value;
        this.total = value.multiply(new BigDecimal(items));
        this.budgetDate = budgetDate;
    }

    public BigDecimal getValue()
    {
        return value;
    }
    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }
    public String getDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.budgetDate.format(formatter);
    }
}
