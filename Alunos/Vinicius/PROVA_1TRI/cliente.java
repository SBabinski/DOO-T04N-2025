public class cliente {
    private static int contador = 1;
    private int id;
    private String nome;

    public cliente(String nome) {
        this.nome = nome;
        this.id = contador++;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID = " + id + ", nome = " + nome;
    }
}
