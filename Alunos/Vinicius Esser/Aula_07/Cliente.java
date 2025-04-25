package Aula_07;

public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereço endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
