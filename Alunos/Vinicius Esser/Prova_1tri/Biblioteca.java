package BibliotecaPub;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Livro buscarPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean realizarEmprestimo(String titulo, Cliente cliente) {
        Livro livro = buscarPorTitulo(titulo);
        if (livro != null && livro.isDisponivel() && livro.podeSerEmprestado()) {
            Emprestimo emprestimo = new Emprestimo(livro, cliente);
            emprestimos.add(emprestimo);
            return true;
        }
        return false;
    }

    public double devolverLivro(String titulo) {
        Livro livro = buscarPorTitulo(titulo);
        if (livro != null) {
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getLivro().equals(livro) && !livro.isDisponivel()) {
                    emprestimo.devolver();
                    return emprestimo.calcularMulta();
                }
            }
        }
        return 0;
    }

    public String verificarDisponibilidade(String titulo) {
        Livro livro = buscarPorTitulo(titulo);
        if (livro != null) {
            if (livro.isDisponivel()) {
                return "O livro está disponível para empréstimo.";
            } else {
                if (livro instanceof LivroRaro) {
                    return "O livro raro não está disponível. Motivo: " + ((LivroRaro) livro).getDescricao();
                } else {
                    return "O livro não está disponível no momento.";
                }
            }
        } else {
            return "Livro não encontrado!";
        }
    }
}
