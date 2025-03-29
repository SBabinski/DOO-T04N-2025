import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Calculadora da Dona Gabrielinha ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    CalculadoraPreco.calcularPrecoTotal(scanner);
                    break;
                case 2:
                    CalculadoraTroco.calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo... Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}