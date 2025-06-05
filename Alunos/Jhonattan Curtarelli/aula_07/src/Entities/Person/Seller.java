package src.Entities.Person;

import src.Entities.ValueObjects.Address;
import src.Entities.Store;

import java.math.BigDecimal;

public class Seller extends Employee
{


    public Seller(String name, int age, Store store, Address address, BigDecimal recivedSalary, BigDecimal baseSalary) {
        super(name, age, store, address, recivedSalary, baseSalary);
    }

    @Override
    public BigDecimal calculateBonus() {
        return this.baseSalary.multiply(new BigDecimal("0.2"));
    }
}
