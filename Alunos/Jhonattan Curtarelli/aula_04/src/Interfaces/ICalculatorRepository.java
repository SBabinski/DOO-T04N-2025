package src.Interfaces;

import src.Entities.Order.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ICalculatorRepository {
    public boolean SaveBudget(Order order);
    public List<Order> GetBudgets();
    public BigDecimal GetTotalSalesByDate(LocalDate date);
    public BigDecimal GetTotalsByDateInterval(LocalDate startDate, LocalDate endDate);
}
