package src.Entities;

public class Seller
{
    public String name;
    public int age;
    public Store store;
    public String neighborhood;
    public BigDecimal baseSalary;
    private BigDecimal[] recivedSalary;

    public Seller(String name, int age, Store store, String neighborhood, BigDecimal baseSalary)
    {
        this.name = name;
        this.age = age;
        this.store = store;
        this.neighborhood = neighborhood;
        this.baseSalary = baseSalary;
    }
    public Seller setBaseSalary(BigDecimal salary)
    {
        this.recivedSalary.add(salary);
        return this;
    }
    // Método que calcula a média dos salários somando todos e dividindo pela quantidade
    public BigDecimal calculateAverage()
    {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal salary : this.recivedSalary)
        {
            sum = sum.add(salary);
        }
        return sum.divide(new BigDecimal(this.recivedSalary.length));
    }
    // retorna o valor do bonus que é 20% do salário base
    public BigDecimal calculateBonus()
    {
        return this.baseSalary.multiply(new BigDecimal(0.2));
    }
    public String presentate()
    {
        return "Nome: "+ this.name + " Idade: " + this.age + "Loja " + this.store.name;
    }
}
