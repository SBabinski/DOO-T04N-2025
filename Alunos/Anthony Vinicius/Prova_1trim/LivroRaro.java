package bibliotecapub;

public class LivroRaro extends Livro {
    private String explicacao;

    public LivroRaro(String titulo, String autor, String explicacao) {
        super(titulo, autor);
        this.explicacao = explicacao;
    }

    public String getExplicacao() {
        return explicacao;
    }

    @Override
    public boolean podeSerEmprestado() {
        return false;
    }

    @Override
    public String toString() {
        return "[Raro] " + getTitulo() + " - " + getAutor() + " | Raro por: " + explicacao;
    }
}
