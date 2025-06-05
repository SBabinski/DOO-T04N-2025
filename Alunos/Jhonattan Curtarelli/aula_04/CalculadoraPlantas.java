import Utils.Stack;
import src.Entities.Order.Order;
import src.Services.Calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class CalculadoraPlantas {
    private Calculator calculator;
    private Scanner sc = new Scanner(System.in);
    public CalculadoraPlantas() {
        this.calculator = new Calculator();
    }
    public void CalculateTotalPrice()
    {
        System.out.println("Insira a quantidade da planta referida");
        int quantity = sc.nextInt();
        System.out.println("Insira o preço da planta referida");
        BigDecimal price = sc.nextBigDecimal();
        sc.nextLine();
        LocalDate date = GetDate();
        Order order = new Order(price, quantity, date);
        BigDecimal totalPrice = this.calculator.CalculateTotalPrice(
                order
        );

        System.out.println("Quantidade: " + quantity + " Preço: " + price + " Data: " + order.getDate());
        System.out.println(
                "O Preço total é: R$ " +
                        totalPrice
        );
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
            List<Order> orders = this.calculator.GetBudgetsHistory();
            System.out.println("Histórico de orçamentos");
            for (Order order : orders)
            {
                System.out.println(
                        "Quantidade: " + order.items +
                                " Preço: R$ " + order.getValue() +
                                " Total: R$ " + order.total +
                        " Data: " + order.getDate()
                );
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " - " + e.getCause());
        }
    }
    public LocalDate GetDate()
    {
        while (true) {
            System.out.println("Insira a data (yyyy-MM-dd):");
            String dateStr = sc.nextLine();
            try {
                return LocalDate.parse(dateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Tente novamente.");
            }
        }
    }
    public void GetTotalsByDate()
    {
        LocalDate date = GetDate();
        BigDecimal total = this.calculator.GetTotalSalesByDate(date);
        System.out.println("Total de vendas na data " + date + ": R$ " + total);
    }
    public void GetTotalsByDateInterval()
    {
        LocalDate startDate = GetDate();
        LocalDate endDate = GetDate();
        BigDecimal total = this.calculator.GetTotalsByDateInterval(startDate, endDate);
        System.out.println("Total de vendas entre " + startDate + " e " + endDate + ": R$ " + total);
    }
    public void Menu()
    {
        System.out.println(
                "------------------------ MENU ------------------------\n" +
                        "1 - Calcular Preço Total\n" +
                        "2 - Calcular Troco\n" +
                        "3 - Buscar histórico de orçamentos\n" +
                        "4 - Buscar Total pela Data\n" +
                        "5 - Buscar Total pelo intervalo de datas\n" +
                        "6 - Sair\n" 

        );
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
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
                this.GetTotalsByDate();
                Menu();
                break;
            case 5:
                this.GetTotalsByDateInterval();
                Menu();
                break;
            case 6:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida");
                Menu();
                break;
        }
        
    }
    public static void main(String[] args) {
        System.out.println(new Stack());
        CalculadoraPlantas calc = new CalculadoraPlantas();
        calc.Menu();
    }
}
