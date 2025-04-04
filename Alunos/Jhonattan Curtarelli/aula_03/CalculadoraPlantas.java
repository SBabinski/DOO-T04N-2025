import src.Entities.Budget;
import src.Services.Calculator;
import src.Services.DiscountCalculator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CalculadoraPlantas {
    private Calculator calculator;
    private Scanner sc = new Scanner(System.in);
    public CalculadoraPlantas() throws IOException {
        this.calculator = new Calculator();
    }
    public void CalculateTotalPrice()
    {
        System.out.println("Insira a quantidade da planta referida");
        int quantity = sc.nextInt();
        System.out.println("Insira o preço da planta referida");
        BigDecimal price = sc.nextBigDecimal();
        try{
            BigDecimal totalPrice = this.calculator.CalculateTotalPrice(
                    new Budget(price, quantity)
            );
            System.out.println("Quantidade: " + quantity + " Preço: " + price);
            System.out.println(
                    "O Preço total é: R$ " +
                            totalPrice
            );
        } catch (Exception e) {
            System.out.println(e.getMessage() + " - " + e.getCause());
        }
    }
    public void CalculateChange()
    {
        System.out.println("Insira o valor recebido");
        BigDecimal recivedPrice = sc.nextBigDecimal();
        System.out.println("Insira o valor total");
        BigDecimal totalPrice = sc.nextBigDecimal();

        BigDecimal change = this.calculator.CalculateChange(recivedPrice, totalPrice);

        System.out.println("Valor Recebido: R$ " + recivedPrice + " Valor Total: R$ " + totalPrice);
        System.out.println("O troco é: R$ " + change);
    }
    public void GetBudgetsHistory()
    {
        try{
            List<Budget> budgets = this.calculator.GetBudgetsHistory();
            System.out.println("Histórico de orçamentos");
            for (Budget budget : budgets)
            {
                System.out.println(
                        "Quantidade: " + budget.items +
                                " Preço: R$ " + budget.getValue() +
                                " Total: R$ " + budget.total
                );
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " - " + e.getCause());
        }
    }
    public void menu ()
    {
        System.out.println(
                "------------------------ MENU ------------------------\n" +
                        "1 - Calcular Preço Total\n" +
                        "2 - Calcular Troco\n" +
                        "3 - Buscar histórico de orçamentos\n" +
                        "4 - Sair\n"
        );
        int option = sc.nextInt();

        switch(option)
        {
            case 1:
                this.CalculateTotalPrice();
                Menu();
                break;
            case 2:
                System.out.println("Calcular Preço Total");
                this.CalculateChange();
                Menu();
                break;
            case 3:
                this.GetBudgetsHistory();
                Menu();
                break;
            case 4:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida");
                Menu();
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        CalculadoraPlantas calc = new CalculadoraPlantas();
        calc.Menu();
    }
}
