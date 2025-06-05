package src.Entities.Person;

import src.Entities.ValueObjects.Address;
import src.Interfaces.IPresentate;

public class Customer implements IPresentate
{
    public String name;
    public int age;
    public Address address;

    public Customer(String name, int age, Address address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String presentate()
    {
        return "Nome: "+ this.name + " Idade: " + this.age;
    }
}
