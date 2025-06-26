public class Livro {
    static int countId = 1;
    int id;
    String titulo;
    String autor;
    boolean emprestado;

    public Livro(String titulo, String autor) {
        this.id = countId;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
        countId++;
    }

    public boolean podeSerEmprestado() {
        return true;
    }

    @Override
    public String toString() {
        return 
            "ID: " + id +
            "\nTítulo: " + titulo +
            "\nAutor: " + autor +
            "\nEmprestado: " + (emprestado ? "Sim" : "Não");
    }

}
