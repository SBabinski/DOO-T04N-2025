import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String nome;
    public List<Noticia> favoritos = new ArrayList<>();
    public List<Noticia> lidas = new ArrayList<>();
    public List<Noticia> paraLerDepois = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }
}
