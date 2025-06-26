import java.time.LocalDate;

public class Emprestimo {
    static int countId = 1;
    int id;
    Cliente cliente;
    Livro livro;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    float multa;

    public Emprestimo(Cliente cliente, Livro livro, LocalDate dataEmprestimo) {
        this.id = countId;
        this.cliente = cliente;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
        this.multa = 0;
        countId++;
    }

    public void calcularMulta() {
        float multa = 0;
        long dias = java.time.temporal.ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
        if (dias > 7) {
            multa = (float) (3.50 * (dias - 7));
        }
        this.multa = multa;
    }

    @Override
    public String toString() {
        return 
            "ID: " + id +
            "\nCliente: " + cliente.nome +
            "\nLivro: " + livro.titulo + " - Autor: " + livro.autor +
            "\nData de Emprestimo: " + dataEmprestimo +
            "\nData de Devolução: " + dataDevolucao +
            "\nMulta: " + multa;
    }
}
