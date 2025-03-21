package loja.de.plantas;

import java.util.Scanner;

public class CalculadoraLojaDePlantas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        
        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        
        double precoTotal = quantidade * precoUnitario;
        System.out.printf("O preço total da venda é: R$ %.2f\n", precoTotal);
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: R$ ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: R$ ");
        double valorTotal = scanner.nextDouble();
        
        if (valorRecebido >= valorTotal) {
            double troco = valorRecebido - valorTotal;
            System.out.printf("O troco a ser dado ao cliente é: R$ %.2f\n", troco);
        } else {
            System.out.println("O valor recebido é insuficiente para cobrir a compra.");
        }
    }
}