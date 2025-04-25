package BibliotecaPub;

public class LivroRaro extends Livro {
    private String motivoRaridade;

    public LivroRaro(String titulo, String autor, String motivoRaridade) {
        super(titulo, autor);
        this.motivoRaridade = motivoRaridade;
        this.setDisponivel(false);  
    }

    @Override
    public boolean podeSerEmprestado() {
        return false; 
    }

    @Override
    public String getDescricao() {
        return "Livro raro: " + motivoRaridade;
    }
}
