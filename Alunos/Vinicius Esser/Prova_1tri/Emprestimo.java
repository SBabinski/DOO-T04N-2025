package BibliotecaPub;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.livro.setDisponivel(false);
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
        this.livro.setDisponivel(true);
    }

    public double calcularMulta() {
        if (dataDevolucao == null) return 0;
        long dias = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
        if (dias > 7) {
            return (dias - 7) * 3.50;
        }
        return 0;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

