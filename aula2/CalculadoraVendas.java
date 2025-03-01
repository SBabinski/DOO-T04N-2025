import java.util.Scanner;

public class CalculadoraVendas {
    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("\nDigite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("\nDigite o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();

                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.println("\nO preço total da compra é: R$ " + precoTotal);
                    break;

                case 2:
                    System.out.print("\nDigite o valor pago pelo cliente: R$ ");
                    double valorPago = scanner.nextDouble();
                    System.out.print("\nDigite o valor total da compra: R$ ");
                    double valorTotalCompra = scanner.nextDouble();

                    if (valorPago >= valorTotalCompra) {
                        double troco = calcularTroco(valorPago, valorTotalCompra);
                        System.out.println("\nO troco a ser dado é: R$ " + troco);
                    } else {
                        System.out.println("\nCliente mão de vaca, o valor sugerido não cobrará os custos.");
                    }
                    break;

                case 3:
                    System.out.println("\nSaindo do programa. Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);

        scanner.close();
    }
}
