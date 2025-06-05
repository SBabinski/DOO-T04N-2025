import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private List<Evento> ingressosComprados;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.ingressosComprados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void adicionarIngresso(Evento evento) {
        ingressosComprados.add(evento);
    }

    public boolean possuiIngresso(Evento evento) {
        return ingressosComprados.contains(evento);
    }
}
