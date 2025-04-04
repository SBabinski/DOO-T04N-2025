package src.Services;

import src.Entities.Budget;
import src.Entities.Change;
import src.Repositories.CalculatorRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Calculator
{
    private final DiscountCalculator discountCalculator;
    private CalculatorRepository calculatorRepository;
    public Calculator() throws IOException {
        this.discountCalculator = new DiscountCalculator();
        this.calculatorRepository = new CalculatorRepository();
    }
    public BigDecimal CalculateTotalPrice(Budget budget) throws IOException {
        BigDecimal discountValue = this.discountCalculator.calculate(budget);
        BigDecimal result = budget.total.subtract(discountValue);
        budget.setTotal(result);
        this.calculatorRepository.SaveBudget(budget);
        return result;
    }
    public List<Budget> GetBudgetsHistory() throws IOException {
        return this.calculatorRepository.GetBudgets();
    }
    public BigDecimal CalculateChange(BigDecimal recivedPrice, BigDecimal totalPrice)
    {
        Change change = new Change(recivedPrice, totalPrice);
        return change.CalculateChange();
    }

}
