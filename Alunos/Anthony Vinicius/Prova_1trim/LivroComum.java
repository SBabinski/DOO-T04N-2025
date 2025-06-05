package bibliotecapub;

public class LivroComum extends Livro {
    public LivroComum(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public boolean podeSerEmprestado() {
        return !isEmprestado();
    }
}
