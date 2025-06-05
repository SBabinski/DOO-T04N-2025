package src.Entities.Order;

import src.Entities.Person.Customer;
import src.Entities.Person.Seller;
import src.Entities.Store;

import java.time.LocalDate;

public class OrderProcess {
    public Order create( LocalDate reservationExpiredAt, Customer customer, Seller seller, Store store) {
        if(!confirmPayment(reservationExpiredAt)) {
            throw new IllegalArgumentException("A data de expiração não pode ser menor que a data atual");
        }
        Order order = new Order(LocalDate.now(), reservationExpiredAt, customer, seller, store);
        order.id = String.valueOf(System.currentTimeMillis());
        order.status = src.Enums.OrderStatus.PENDING;
        return order;
    }
    public void cancel(Order order) {
        order.status = src.Enums.OrderStatus.CANCELED;
    }
    public void approve(Order order) {
        order.status = src.Enums.OrderStatus.APPROVED;
    }
    //  verifica se a data de expiração é menor que a data atual
    private boolean confirmPayment(LocalDate reservationExpiredAt) {
        return !reservationExpiredAt.isBefore(LocalDate.now());
    }
}
