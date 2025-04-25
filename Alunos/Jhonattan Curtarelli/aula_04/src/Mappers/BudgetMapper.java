package src.Mappers;

import src.Entities.Order.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BudgetMapper
{
    public static List<Order> TxtToEntity(List<String> lines)
    {
         List<Order> orders = new ArrayList<Order>();
         lines.forEach(line -> {
                String[] data = line.split(";");
                Order order = new Order(new BigDecimal(data[0]),Integer.parseInt(data[1]));
                order.setTotal(new BigDecimal(data[2]));
                orders.add(order);
         });
            return orders;
    }


}
