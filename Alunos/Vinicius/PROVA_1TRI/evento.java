import java.util.*;

public abstract class evento {
    protected int id;
    protected String nome;
    protected int duracao;
    protected Double preco;
    protected int capacidade;
    protected List<Ingresso> ingressos = new ArrayList<>();
    protected static int contador = 1;

    public evento(String nome, int duracao, Double preco, int capacidade) {
        this.nome = nome;
        this.duracao = duracao;
        this.preco = preco;
        this.capacidade = capacidade;
        this.id = contador++;
    }

    public int getId () {
        return id;
    }
    public String getNome () {
        return nome;
    }
    public int capacidade () {
        return capacidade;
    }

    public boolean disponivel () {
        return ingressos.size() < capacidade;
    }

    public abstract double calcularPreco (boolean vip);

    public boolean registrarIngresso (Ingresso ingresso) {
        if (disponivel()) {
            ingressos.add(ingresso);
            return true;
        } else {
            return false;
        }
    }

}


