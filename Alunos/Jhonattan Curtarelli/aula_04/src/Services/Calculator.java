package src.Services;

import src.Entities.Budget;
import src.Entities.Change;
import src.Interfaces.ICalculatorRepository;
import src.Repositories.Stack.CalculatorRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Calculator
{
    private final DiscountCalculator discountCalculator;
    private final ICalculatorRepository calculatorRepository;
    public Calculator() {
        this.discountCalculator = new DiscountCalculator();
        this.calculatorRepository = new CalculatorRepository();
    }
    public BigDecimal CalculateTotalPrice(Budget budget) {
        BigDecimal discountValue = this.discountCalculator.calculate(budget);
        BigDecimal result = budget.total;
        if(discountValue != null)
        {
            result = budget.total.subtract(discountValue);
        }

        budget.setTotal(result);
        this.calculatorRepository.SaveBudget(budget);
        return result;
    }
    public List<Budget> GetBudgetsHistory() {
        return this.calculatorRepository.GetBudgets();
    }
    public BigDecimal CalculateChange(BigDecimal recivedPrice, BigDecimal totalPrice)
    {
        Change change = new Change(recivedPrice, totalPrice);
        return change.CalculateChange();
    }
    public BigDecimal GetTotalSalesByDate(LocalDate date)
    {
        return this.calculatorRepository.GetTotalSalesByDate(date);
    }
    public BigDecimal GetTotalsByDateInterval(LocalDate startDate, LocalDate endDate)
    {
        return this.calculatorRepository.GetTotalsByDateInterval(startDate, endDate);
    }

}
