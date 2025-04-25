package bibliotecapub;

import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Cliente cliente, Date dataEmprestimo) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
}
