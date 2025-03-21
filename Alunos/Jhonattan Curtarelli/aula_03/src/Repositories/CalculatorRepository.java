package src.Repositories;

import src.Entities.Budget;
import src.Mappers.BudgetMapper;
import src.Services.FileService;

import java.io.IOException;
import java.util.List;

public class CalculatorRepository
{
    private final FileService fileService;
    public CalculatorRepository() throws IOException {
        this.fileService = new FileService(null,null);
        this.fileService.CreateFile();
    }
    public void SaveBudget(Budget budget) throws IOException
    {
        this.fileService.WriteFile(budget.toString());
    }
    public List<Budget> GetBudgets() throws IOException
    {
        return BudgetMapper.TxtToEntity(
                this.fileService.ReadFile()
        );
    }
}
