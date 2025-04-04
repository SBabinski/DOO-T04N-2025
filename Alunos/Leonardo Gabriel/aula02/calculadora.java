import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraPlantas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Calculadora de Vendas da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");

            while (true) {
                try {
                    opcao = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida! Digite um número.");
                    scanner.next(); // Limpar buffer
                }
            }

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        try {
            System.out.print("Informe a quantidade da planta: ");
            int quantidade = scanner.nextInt();
            
            System.out.print("Informe o preço unitário da planta: ");
            double precoUnitario = scanner.nextDouble();
            
            double total = quantidade * precoUnitario;
            System.out.printf("Preço total: R$ %.2f%n", total);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
            scanner.next(); // Limpar buffer
        }
    }

    private static void calcularTroco(Scanner scanner) {
        try {
            System.out.print("Informe o valor recebido do cliente: ");
            double valorRecebido = scanner.nextDouble();
            
            System.out.print("Informe o valor total da compra: ");
            double valorTotal = scanner.nextDouble();
            
            if (valorRecebido < valorTotal) {
                System.out.println("Valor recebido insuficiente!");
            } else {
                double troco = valorRecebido - valorTotal;
                System.out.printf("Troco a ser dado: R$ %.2f%n", troco);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
            scanner.next(); // Limpar buffer
        }
    }
}
