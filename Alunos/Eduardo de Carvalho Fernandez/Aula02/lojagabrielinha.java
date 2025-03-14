package gabrielinha;

import java.util.Scanner;

public class lojagabrielinha {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcao;
	        
	        do {
	            System.out.println("--- Menu ---");
	            System.out.println("[1] - Calcular Preço Total");
	            System.out.println("[2] - Calcular Troco");
	            System.out.println("[3] - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    System.out.print("Quantidade da planta: ");
	                    int quantidade = scanner.nextInt();
	                    System.out.print("Preço unitário da planta: ");
	                    double preco = scanner.nextDouble();
	                    double precoTotal = calcularPrecoTotal(quantidade, preco);
	                    System.out.printf("Preço total: R$ %.2f\n", precoTotal);
	                    break;
	                
	                case 2:
	                    System.out.print("Valor recebido: ");
	                    double valorRecebido = scanner.nextDouble();
	                    System.out.print("Valor total da compra: ");
	                    double valorCompra = scanner.nextDouble();
	                    double troco = calcularTroco(valorRecebido, valorCompra);
	                    if (troco >= 0) {
	                        System.out.printf("Troco: R$ %.2f\n", troco);
	                    } else {
	                        System.out.println("Valor insuficiente!");
	                    }
	                    break;
	                
	                case 3:
	                    System.out.println("Encerrando o programa...");
	                    break;
	                
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
	            }
	            System.out.println();
	        } while (opcao != 3);
	        scanner.close();
	    }

	    public static double calcularPrecoTotal(int quantidade, double preco) {
	        return quantidade * preco;
	    }

	    public static double calcularTroco(double valorRecebido, double valorCompra) {
	        return valorRecebido - valorCompra;
	    }
	}
