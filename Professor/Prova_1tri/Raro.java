public class Raro extends Livro {
    String explicacao;
    
    public Raro(String titulo, String autor, String explicacao) {
        super(titulo, autor);
        this.explicacao = explicacao;
    }

    public boolean podeSerEmprestado() {
        return false;
    }

}
