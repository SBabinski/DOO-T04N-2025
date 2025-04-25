package entities;

public class Cliente extends Pessoa {
    public Cliente() {}

    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public String apresentarse() {
        return "Nome: " + nome + " Idade: " + idade;
    }
}
