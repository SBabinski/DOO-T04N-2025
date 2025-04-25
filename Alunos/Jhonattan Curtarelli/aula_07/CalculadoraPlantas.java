import src.Entities.Order.Item;
import src.Entities.Order.Order;
import src.Entities.Order.OrderProcess;
import src.Entities.Person.Customer;
import src.Entities.Person.Seller;
import src.Entities.Store;
import src.Entities.ValueObjects.Address;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraPlantas {
    private Scanner sc = new Scanner(System.in);

    public void CreateOrder()
    {
        Customer customer = new Customer("Jhonattan",21,new Address(
                "Rua 1",
                "Bairro 1",
                "Cidade 1",
                "Estado 1",
                "12345678",
                "casa"
        ));
        Store store = new Store(
                "Loja 1",
                "Loja 1",
                new Address(
                        "Rua 2",
                        "Bairro 2",
                        "Cidade 2",
                        "Estado 2",
                        "87654321",
                        "apartamento"
                ),
                "12.177.510/0001-18"
        );
        Seller seller = new Seller(
                "Vendedor 1",
                30,
                store,
                new Address(
                        "Rua 3",
                        "Bairro 3",
                        "Cidade 3",
                        "Estado 3",
                        "12345678",
                        "casa"
                ),
                new BigDecimal(1000),
                new BigDecimal(1000)
        );



        OrderProcess orderProcess = new OrderProcess();
        Order order = orderProcess.create(LocalDate.now().plusDays(5), customer, seller, store);
        order.addItem(new Item("2", "Planta 2", "Descrição da planta 2", new BigDecimal(20)));
        order.addItem(new Item("1", "Planta 1", "Descrição da planta 1", new BigDecimal(10)));

        order.setTotal(order.calculateTotal());
        System.out.println(order.presentate());

    }
    public void Menu()
    {
        System.out.println(
                "------------------------ MENU ------------------------\n" +
                        "1 - Criar Pedido\n" +
                        "2 - Sair\n"

        );
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                this.CreateOrder();
                Menu();
                break;
            case 2:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida");
                Menu();
                break;
        }
        
    }
    public static void main(String[] args) {
        CalculadoraPlantas calc = new CalculadoraPlantas();
        calc.Menu();
    }
}
