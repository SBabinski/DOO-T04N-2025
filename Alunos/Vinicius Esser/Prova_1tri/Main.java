package BibliotecaPub;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

     
        while (true) {
            System.out.println("\nBem-vindo ao sistema da Biblioteca Pub!");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Buscar Livro por Título");
            System.out.println("4. Buscar Livro por Autor");
            System.out.println("5. Realizar Empréstimo");
            System.out.println("6. Realizar Devolução");
            System.out.println("7. Verificar Disponibilidade");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarCliente(biblioteca, scanner);
                    break;
                case 2:
                    cadastrarLivro(biblioteca, scanner);
                    break;
                case 3:
                    buscarPorTitulo(biblioteca, scanner);
                    break;
                case 4:
                    buscarPorAutor(biblioteca, scanner);
                    break;
                case 5:
                    realizarEmprestimo(biblioteca, scanner);
                    break;
                case 6:
                    realizarDevolucao(biblioteca, scanner);
                    break;
                case 7:
                    verificarDisponibilidade(biblioteca, scanner);
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarCliente(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        biblioteca.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.print("O livro é raro (S/N)? ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.print("Informe o motivo de raridade: ");
            String motivo = scanner.nextLine();
            Livro livroRaro = new LivroRaro(titulo, autor, motivo);
            biblioteca.cadastrarLivro(livroRaro);
            System.out.println("Livro raro cadastrado com sucesso!");
        } else {
            Livro livroComum = new LivroComum(titulo, autor);
            biblioteca.cadastrarLivro(livroComum);
            System.out.println("Livro comum cadastrado com sucesso!");
        }
    }

    private static void buscarPorTitulo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título do livro que deseja buscar: ");
        String titulo = scanner.nextLine();
        Livro livro = biblioteca.buscarPorTitulo(titulo);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro.getTitulo() + " de " + livro.getAutor());
            System.out.println("Descrição: " + livro.getDescricao());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void buscarPorAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        Livro livro = biblioteca.buscarPorAutor(autor);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro.getTitulo() + " de " + livro.getAutor());
            System.out.println("Descrição: " + livro.getDescricao());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void realizarEmprestimo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título do livro para emprestar: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = biblioteca.buscarClientePorCpf(cpf);

        if (cliente != null) {
            boolean emprestado = biblioteca.realizarEmprestimo(titulo, cliente);
            if (emprestado) {
                System.out.println("Empréstimo realizado com sucesso!");
            } else {
                System.out.println("Não foi possível realizar o empréstimo. Verifique a disponibilidade ou se o livro é raro.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void realizarDevolucao(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título do livro para devolução: ");
        String titulo = scanner.nextLine();
        double multa = biblioteca.devolverLivro(titulo);
        if (multa >= 0) {
            System.out.println("Devolução realizada com sucesso!");
            if (multa > 0) {
                System.out.println("Multa por atraso: R$ " + multa);
            }
        } else {
            System.out.println("Livro não encontrado ou não foi emprestado.");
        }
    }


    private static void verificarDisponibilidade(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o título do livro para verificar disponibilidade: ");
        String titulo = scanner.nextLine();
        String mensagem = biblioteca.verificarDisponibilidade(titulo); 
        System.out.println(mensagem);  
    }
}


