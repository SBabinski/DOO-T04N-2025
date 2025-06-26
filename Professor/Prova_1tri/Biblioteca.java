import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    Scanner scanner = Main.getScanner();

    public void cadastrarCliente() {
        System.out.println("-- Cadastro de Cliente --");
        this.scanner.nextLine();
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("------------------------");
    }

    public void cadastrarLivro() {
        System.out.println("-- Cadastro de Livro --");
        scanner.nextLine();
        System.out.print("Digite o tipo de livro (1 - Comum, 2 - Raro) : ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        switch (tipo) {
            case 1:  
                Livro livro = new Livro(titulo, autor);
                livros.add(livro);
                break;
            case 2:                
                System.out.println("Digite a explicação do livro:");
                String explicacao = scanner.nextLine();
                Raro livroRaro = new Raro(titulo, autor, explicacao);
                livros.add(livroRaro);
                break;
            default:
                System.out.println("Tipo inválido!");
                cadastrarLivro();
                break;
        }
        scanner.nextLine();
        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("------------------------");
    }

    public void buscarPorTitulo() {
        scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        for (Livro livro : livros) {
            if (livro.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Livro encontrado: ");
                System.out.println(livro);
                return;
            }else{
                System.out.println("Nenhum livro com esse titulo!");
            }
        }
    }

    public void buscarPorAutor() {
        scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        for (Livro livro : livros) {
            if (livro.autor.equalsIgnoreCase(autor)) {
                System.out.println("Livro encontrado: ");
                System.out.println(livro);
                return;
            }else{
                System.out.println("Nenhum livro com esse autor!");
            }
        }
    }

    public void realizarEmprestimo() {
        scanner.nextLine();
        System.out.println("-- Empréstimo de Livros --");
        listarClientes();
        System.out.print("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = buscarClientePorId(idCliente);
        scanner.nextLine();
        listarLivros();
        System.out.print("Digite o ID do Livro: ");
        int idLivro = scanner.nextInt();
        Livro livro = buscarLivroPorId(idLivro);
        if (livro.emprestado) {
            System.out.println("Livro não disponível!");
            return;
        }
        scanner.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Digite a data de empréstimo (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        LocalDate dataEmprestimo = LocalDate.parse(data, formato);
        Emprestimo emprestimo = new Emprestimo(cliente, livro, dataEmprestimo);
        emprestimos.add(emprestimo);
        emprestimo.livro.emprestado = true;
        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("------------------------");  
    }

    public void realizarDevolucao() {
        scanner.nextLine();
        System.out.println("-- Devolução de Livros --");
        listarEmprestimos();
        System.out.print("Digite o ID do seu empréstimo: ");
        int id = scanner.nextInt();
        Emprestimo emprestimo = buscarEmprestimoPorId(id);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        scanner.nextLine();
        System.out.print("Digite a data de devolução (dd/MM/yyyy): ");
        String dataDeDevolucao = scanner.nextLine();
        LocalDate dataDevolucao = LocalDate.parse(dataDeDevolucao, formato);
        emprestimo.dataDevolucao = dataDevolucao;
        emprestimo.calcularMulta();
        emprestimo.livro.emprestado = false;
        System.out.println("Devolução realizada com sucesso!");
        System.out.println(emprestimo);
        if (emprestimo.multa > 0) {
            System.out.println("Atenção! Houve uma multa por atraso de R$" + emprestimo.multa);
        }
        System.out.println("------------------------");
    }

    public void listarClientes() {
        System.out.println("-- Clientes --");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println("----");
        }
        System.out.println("------------");
    }

    public void listarLivros() {
        System.out.println("-- Livros --");
        for (Livro livro : livros) {
            System.out.println(livro);
            System.out.println("----");
        }
        System.out.println("------------");
    }

    public void listarEmprestimos() {
        System.out.println("-- Empréstimos --");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
            System.out.println("----");
        }
        System.out.println("------------");
    }

    public Cliente buscarClientePorId(int id) {
        Cliente clienteSelecionado = null;
        for (Cliente cliente : clientes) {
            if (cliente.id == id) {
                clienteSelecionado = cliente;
            }
        }
        return clienteSelecionado;
    }

    public Livro buscarLivroPorId(int id) {
        Livro livroSelecionado = null;
        for (Livro livro : livros) {
            if (livro.id == id) {
                livroSelecionado = livro;
            }
        }
        return livroSelecionado;
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        Emprestimo emprestimoSelecionado = null;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.id == id) {
                emprestimoSelecionado = emprestimo;
            }
        }
        return emprestimoSelecionado;
    }
}
