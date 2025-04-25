package aula07;

public class Vendedor extends Pessoa {
    private String loja;

    public Vendedor(String nome, int idade, Endereco endereco, String loja) {
        super(nome, idade, endereco);
        this.loja = loja;
    }

    public String getLoja() {
        return loja;
    }
}
