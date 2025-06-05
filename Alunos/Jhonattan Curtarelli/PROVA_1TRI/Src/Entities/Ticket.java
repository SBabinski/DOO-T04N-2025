package Src.Entities;

import Src.Enums.TicketType;

import java.math.BigDecimal;

public class Ticket {
    public int id;
    public Customer Customer;
    public Event Event;
    public TicketType TicketType;
    public boolean isUsed = false;
    public BigDecimal price;
    public Ticket(int id,Customer Customer, Event Event, TicketType TicketType) {
        this.id = id;
        this.Customer = Customer;
        this.Event = Event;
        this.TicketType = TicketType;
        this.price = Event.getTotal();
    }

    @Override
    public String toString() {
        return "--------------------------------------\n" +
                "ID: " + this.id + "\n" +
                "Nome: " + this.Customer.name + "\n" +
                "Email: " + this.Customer.email + "\n" +
                "Telefone: " + this.Customer.phone + "\n" +
                "Data de nascimento: " + this.Customer.birthday + "\n" +
                "Evento: " + this.Event.name + "\n" +
                "Tipo de ingresso: " + this.TicketType + "\n"
                + "Preço: " + this.price + "\n"
                + "Usado: " + this.isUsed + "\n" ;
    }
}
