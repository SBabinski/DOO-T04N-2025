package src.Entities;

public class Customer
{
    public String name;
    public int age;
    public String city;
    public String neighborhood;
    public String street;

    public String presentate()
    {
        return "Nome: "+ this.name + " Idade: " + this.age;
    }
}
