package fag;

public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarSe() {
        System.out.printf("[Cliente] Nome: %s | Idade: %d\n", getNome(), getIdade());
    }
}