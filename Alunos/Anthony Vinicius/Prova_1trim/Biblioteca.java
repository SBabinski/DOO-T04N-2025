package bibliotecapub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Livro buscarLivroPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;  
    }

    public boolean emprestarLivro(String titulo, Cliente cliente) {
        Livro livro = buscarLivroPorTitulo(titulo);
        if (livro instanceof LivroComum && !livro.isEmprestado()) {
            livro.setEmprestado(true);
            emprestimos.add(new Emprestimo(livro, cliente, new Date()));
            return true;
        }
        return false;
    }

    public boolean devolverLivro(String titulo) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getLivro().getTitulo().equalsIgnoreCase(titulo) && emp.getLivro().isEmprestado()) {
                Date dataDevolucao = new Date();
                long diferencaMillis = dataDevolucao.getTime() - emp.getDataEmprestimo().getTime();
                long diasDeAtraso = diferencaMillis / (1000 * 60 * 60 * 24);

                if (diasDeAtraso > 7) {
                    double multa = diasDeAtraso * 3.50;
                    System.out.println("Multa por atraso: R$ " + multa);
                }

                emp.getLivro().setEmprestado(false);
                return true;
            }
        }
        return false;
    }

    public boolean verificarDisponibilidadeEmprestimo(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        return livro instanceof LivroComum && !livro.isEmprestado();
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
