package src.Entities.Person;

import src.Entities.ValueObjects.Address;
import src.Entities.Store;
import src.Interfaces.IPresentate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
// pq da classe absrata? com ela consigo criar atributos e métodos padrões que todos os funcionários vão precisar ter ou fazer
// e assim eu garanto que ninguém vai tentar instanciar um funcionário
public abstract class Employee implements IPresentate {
    public String name;
    public int age;
    public Store store;
    public Address address;
    public BigDecimal baseSalary;
    private final ArrayList<BigDecimal> recivedSalary = new ArrayList<>();

    public Employee(String name, int age, Store store, Address address, BigDecimal recivedSalary, BigDecimal baseSalary) {
        this.name = name;
        this.age = age;
        this.store = store;
        this.address = address;
        this.recivedSalary.add(recivedSalary);
        this.baseSalary = baseSalary;
    }

    public Employee setBaseSalary(BigDecimal salary) {
        this.recivedSalary.add(salary);
        return this;
    }

    // Método que calcula a média dos salários com RoundingMode
    public BigDecimal calculateAverage() {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal salary : this.recivedSalary) {
            sum = sum.add(salary);
        }

        return recivedSalary.isEmpty()
                ? BigDecimal.ZERO
                : sum.divide(new BigDecimal(recivedSalary.size()), 2, RoundingMode.HALF_UP);
    }

    // Método abstrato para cálculo de bônus
    public abstract BigDecimal calculateBonus();

    public String presentate() {
        return "Nome: " + this.name + " | Idade: " + this.age + " | Loja: " + this.store.razaoSocial;
    }
}
