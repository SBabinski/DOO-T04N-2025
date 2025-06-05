package Src.Entities;

import java.time.LocalDate;
// não vou validar os campos. mas eu criaria uma classe
// só para representar o email e outra para o phone, com a validação dentro

public class Customer {
    public int id;
    public String name;
    public String email;
    public String phone;
    public LocalDate birthday;

    public Customer(int id,LocalDate birthday, String email, String name, String phone) {
        this.id = id;
        this.birthday = birthday;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "--------------------------------------\n" +
                "ID: " + this.id + "\n" +
                "Nome: " + this.name + "\n" +
                "Email: " + this.email + "\n" +
                "Telefone: " + this.phone + "\n" +
                "Data de nascimento: " + this.birthday + "\n";
    }
}
