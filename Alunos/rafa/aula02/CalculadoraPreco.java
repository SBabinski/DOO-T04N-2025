import java.util.Scanner;

public class CalculadoraPreco {
    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        
        double precoTotal = quantidade * precoUnitario;
        System.out.printf("Preço Total: R$ %.2f%n", precoTotal);
    }
}