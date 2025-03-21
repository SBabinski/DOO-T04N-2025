package src.Repositories.Stack;

import Utils.Stack;
import src.Entities.Budget;

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
    public boolean SaveBudget(Budget budget) {
        this.stack.addBudget(budget);
        return true;
    }

    @Override
    public List<Budget> GetBudgets() {
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
