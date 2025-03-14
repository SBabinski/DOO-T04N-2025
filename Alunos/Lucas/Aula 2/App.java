package Alunos.lucasmendonca.Aula_02;

import java.util.Scanner;

public class App {

    /**
     * Método principal que permite a escolha das funções da calculadora.
     * 
     * @param scanner Scanner
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                case 2:
                    calcularTroco(scanner);
                case 3:
                    System.out.println("Saindo");
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    /**
     * Calcula o preço total de acordo com a quantidade e o preço unitário da
     * planta.
     * 
     * @param scanner Scanner
     */
    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double total = quantidade * precoUnitario;
        System.out.printf("Preço total da compra: R$ %.2f\n", total);
    }

    /**
     * Calcula o troco do cliente de acordo com o valor recebido e o valor total da
     * compra.
     * 
     * @param scanner Scanner
     */
    public static void calcularTroco(Scanner scanner) {
        System.out.print("Valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido < valorTotal) {
            System.out.println("Valor insuficiente");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.printf("Troco a ser devolvido: R$ %.2f\n", troco);
        }
    }
}
