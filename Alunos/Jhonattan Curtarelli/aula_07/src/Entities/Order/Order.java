package src.Entities.Order;


import src.Entities.Person.Customer;
import src.Entities.Person.Seller;
import src.Entities.Store;
import src.Enums.OrderStatus;
import src.Interfaces.IPresentate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements IPresentate
{
    public String id;
    public LocalDate createdAt;
    public LocalDate reservationExpiredAt;
    public Customer customer;
    public Seller seller;
    public Store store;
    public OrderStatus status;
    private ArrayList<Item> items = new ArrayList<Item>();
    private BigDecimal total;
    public Order (LocalDate createdAt, LocalDate reservationExpiredAt, Customer customer, Seller seller, Store store)
    {
        this.createdAt = createdAt;
        this.reservationExpiredAt = reservationExpiredAt;
        this.customer = customer;
        this.seller = seller;
        this.store = store;
    }


    // método que calcula o total do pedido percorrendo todos os itens e pegando o valor
    public BigDecimal calculateTotal()
    {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : items)
        {
            total = total.add(item.value);
        }
        return total;
    }
    public Order setTotal(BigDecimal total)
    {
        this.total = total;
        return this;
    }
    public BigDecimal getTotal()
    {
        return this.total;
    }
    public Order addItem(Item item)
    {
        this.items.add(item);
        return this;
    }
    public Order removeItem(Item item)
    {
        this.items.remove(item);
        return this;
    }
    public ArrayList<Item> getItems()
    {
        return this.items;
    }
    @Override
    public String presentate() {
        return "--------------------------------------\n" +
                "ID: " + this.id + "\n" +
                "Created At: " + this.createdAt + "\n" +
                "Reservation Expired At: " + this.reservationExpiredAt + "\n" +
                "Customer: " + this.customer.presentate() + "\n" +
                "Seller: " + this.seller.presentate() + "\n" +
                "Store: " + this.store.presentate() + "\n" +
                "Status: " + this.status.toString() + "\n" +
                "Total: " + this.total.toString() + "\n";

    }
}
