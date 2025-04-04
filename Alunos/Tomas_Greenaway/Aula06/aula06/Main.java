import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Loja loja = new Loja("My Plant", "My Plant LTDA", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores");
        Vendedor vendedor = new Vendedor("Gabrielinha", 30, "My Plant", "São Paulo", "Centro", "Rua das Flores", 3000);
        Cliente cliente = new Cliente("Carlos", 25, "São Paulo", "Centro", "Rua das Flores");

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Informações da Loja");
            System.out.println("2 - Informações do Vendedor");
            System.out.println("3 - Informações do Cliente");
            System.out.println("4 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    loja.apresentarse();
                    break;
                case 2:
                    vendedor.apresentarse();
                    System.out.println("Média de salários: " + vendedor.calcularMedia());
                    System.out.println("Bônus: " + vendedor.calcularBonus());
                    break;
                case 3:
                    cliente.apresentarse();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
