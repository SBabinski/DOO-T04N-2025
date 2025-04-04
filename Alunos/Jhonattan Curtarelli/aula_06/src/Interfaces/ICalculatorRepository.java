package src.Interfaces;

import src.Entities.Budget;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ICalculatorRepository {
    public boolean SaveBudget(Budget budget);
    public List<Budget> GetBudgets();
    public BigDecimal GetTotalSalesByDate(LocalDate date);
    public BigDecimal GetTotalsByDateInterval(LocalDate startDate, LocalDate endDate);
}
