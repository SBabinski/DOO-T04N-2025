package entities;

public class Clientes {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Clientes(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
        System.out.println("Endereço: " + endereco.apresentarLogradouro());
    }
}

