package src.Mappers;

import src.Entities.Budget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BudgetMapper
{
    public static List<Budget> TxtToEntity(List<String> lines)
    {
         List<Budget> budgets = new ArrayList<Budget>();
         lines.forEach(line -> {
                String[] data = line.split(";");
                Budget budget = new Budget(new BigDecimal(data[0]),Integer.parseInt(data[1]));
                budget.setTotal(new BigDecimal(data[2]));
                budgets.add(budget);
         });
            return budgets;
    }


}
