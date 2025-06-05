package prova;

public class Cliente {
    String nome;
    String idade;

    public Cliente(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
