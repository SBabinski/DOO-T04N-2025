import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Serie> favoritos = new ArrayList<>();
    private List<Serie> assistidas = new ArrayList<>();
    private List<Serie> desejos = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Serie> getFavoritos() {
        return favoritos;
    }

    public List<Serie> getAssistidas() {
        return assistidas;
    }

    public List<Serie> getDesejos() {
        return desejos;
    }
}