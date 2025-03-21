package Utils;

import src.Entities.Budget;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final List<Budget> budgets;

    public Stack() {
        this.budgets = new ArrayList<>();
    }

    public void addBudget(Budget budget) {
        this.budgets.add(budget);
    }
    public List<Budget> GetBudgets() {
        return this.budgets;
    }
}
