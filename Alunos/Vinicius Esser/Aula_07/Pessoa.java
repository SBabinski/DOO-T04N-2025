package Aula_07;

public abstract class Pessoa {
    String nome;
    int idade;
    Endereço endereco;

    public Pessoa(String nome, int idade, Endereço endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public abstract void apresentarse();
}
