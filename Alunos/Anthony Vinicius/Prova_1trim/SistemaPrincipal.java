package bibliotecapub;

import java.util.Scanner;

public class SistemaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n1. Cadastrar cliente");
            System.out.println("2. Cadastrar livro");
            System.out.println("3. Buscar livro por título");
            System.out.println("4. Buscar livro por autor");
            System.out.println("5. Realizar empréstimo");
            System.out.println("6. Realizar devolução");
            System.out.println("7. Verificar disponibilidade de empréstimo");
            System.out.println("Escolha (0 para sair): ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    biblioteca.cadastrarCliente(new Cliente(nomeCliente));
                    break;

                case 2:
                    System.out.println("1. Livro Comum");
                    System.out.println("2. Livro Raro");
                    System.out.print("Escolha o tipo de livro: ");
                    int tipoLivro = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();

                    if (tipoLivro == 1) {
                        biblioteca.cadastrarLivro(new LivroComum(titulo, autor));
                    } else if (tipoLivro == 2) {
                        System.out.print("Digite a explicação do livro raro: ");
                        String explicacao = scanner.nextLine();
                        biblioteca.cadastrarLivro(new LivroRaro(titulo, autor, explicacao));
                    }
                    break;

                case 3:
                    System.out.print("Digite o título do livro: ");
                    String tituloBusca = scanner.nextLine();
                    Livro livroTitulo = biblioteca.buscarLivroPorTitulo(tituloBusca);
                    if (livroTitulo != null) {
                        System.out.println(livroTitulo);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o autor do livro: ");
                    String autorBusca = scanner.nextLine();
                    Livro livroAutor = biblioteca.buscarLivroPorAutor(autorBusca);
                    if (livroAutor != null) {
                        System.out.println(livroAutor);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o título do livro para emprestar: ");
                    String tituloEmprestimo = scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String nomeClienteEmprestimo = scanner.nextLine();
                    Cliente clienteEmprestimo = biblioteca.buscarClientePorNome(nomeClienteEmprestimo);

                    if (clienteEmprestimo != null && biblioteca.emprestarLivro(tituloEmprestimo, clienteEmprestimo)) {
                        System.out.println("Empréstimo realizado com sucesso.");
                    } else {
                        System.out.println("Não foi possível realizar o empréstimo.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o título do livro para devolver: ");
                    String tituloDevolucao = scanner.nextLine();
                    if (biblioteca.devolverLivro(tituloDevolucao)) {
                        System.out.println("Devolução realizada com sucesso.");
                    } else {
                        System.out.println("Não foi possível realizar a devolução.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o título do livro para verificar disponibilidade: ");
                    String tituloDisponibilidade = scanner.nextLine();
                    boolean disponivel = biblioteca.verificarDisponibilidadeEmprestimo(tituloDisponibilidade);
                    if (disponivel) {
                        System.out.println("O livro está disponível para empréstimo.");
                    } else {
                        System.out.println("O livro não está disponível para empréstimo.");
                    }
                    break;

                case 0:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
