package src.Repositories.Stack;

import Utils.Stack;
import src.Entities.Order.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CalculatorRepository implements src.Interfaces.ICalculatorRepository {
    private final Stack stack;
    public CalculatorRepository(
    ) {
        this.stack = new Stack();
    }
    @Override
    public boolean SaveBudget(Order order) {
        this.stack.addBudget(order);
        return true;
    }

    @Override
    public List<Order> GetBudgets() {
        return stack.GetBudgets();
    }
    @Override
    public BigDecimal  GetTotalSalesByDate(LocalDate date) {
            return this.stack.GetBudgets().stream()
            .filter(budget -> budget.budgetDate.equals(date)) 
            .map(budget -> budget.total) 
            .reduce(BigDecimal.ZERO, BigDecimal::add); 
    }
    @Override
    public BigDecimal GetTotalsByDateInterval(LocalDate startDate, LocalDate endDate) {
        return this.stack.GetBudgets().stream()
            .filter(budget -> budget.budgetDate.isAfter(startDate) && budget.budgetDate.isBefore(endDate)) 
            .map(budget -> budget.total) 
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
