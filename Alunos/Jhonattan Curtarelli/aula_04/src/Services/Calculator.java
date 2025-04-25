package src.Services;

import src.Entities.Order.Order;
import src.Entities.Change;
import src.Interfaces.ICalculatorRepository;
import src.Repositories.Stack.CalculatorRepository;

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
    public BigDecimal CalculateTotalPrice(Order order) {
        BigDecimal discountValue = this.discountCalculator.calculate(order);
        BigDecimal result = order.total;
        if(discountValue != null)
        {
            result = order.total.subtract(discountValue);
        }

        order.setTotal(result);
        this.calculatorRepository.SaveBudget(order);
        return result;
    }
    public List<Order> GetBudgetsHistory() {
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
