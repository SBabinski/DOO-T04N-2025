import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        Biblioteca bibs = new Biblioteca();
        while(true){
            System.out.println("------- Menu Bibs -------\n" +
            "1 - Cadastrar Cliente\n" +
            "2 - Cadastrar Livro\n" +
            "3 - Buscar Livro por Título\n" +
            "4 - Buscar Livro por Autor\n" +
            "5 - Fazer Empréstimo\n" +
            "6 - Realizar Devolução\n" +
            "7 - Listar Livros\n" +
            "8 - Listar Clientes\n" +
            "9 - Listar Empréstimos\n" +
            "-------------------------");

            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.exit(0);
                case 1:
                bibs.cadastrarCliente();
                    break;
                case 2:
                bibs.cadastrarLivro();
                    break;
                case 3:
                bibs.buscarPorTitulo();
                    break; 
                case 4:
                bibs.buscarPorAutor();
                    break;
                case 5:
                bibs.realizarEmprestimo();
                    break;
                case 6:
                bibs.realizarDevolucao();
                    break;
                case 7:
                bibs.listarLivros();
                    break;
                case 8:
                bibs.listarClientes();
                    break;
                case 9:
                bibs.listarEmprestimos();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    public static Scanner getScanner(){
        return scanner;
    }
}
