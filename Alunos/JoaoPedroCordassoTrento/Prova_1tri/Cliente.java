import java.util.ArrayList;

public class Cliente {
    private int idCliente;
    private String nome;
    private int idade;
    private ArrayList<Evento> listaDeEventosCliente = new ArrayList<>();

    public int getIdCliente() {
        return idCliente;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public ArrayList<Evento> getListaDeEventosCliente() {
        return listaDeEventosCliente;
    }

    public Cliente() {
        super();
    }
    public Cliente(int idCliente, String nome, int idade) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Idade: " + getIdade();
    }
}
