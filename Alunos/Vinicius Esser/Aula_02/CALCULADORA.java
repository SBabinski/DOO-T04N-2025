package gabrielinha;
import java.util.Scanner;

public class CALCULADORA {

	

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

	   
	    public static void calcularPrecoTotal(Scanner scanner) {
	        System.out.print("Digite a quantidade da planta: ");
	        int quantidade = scanner.nextInt();

	        System.out.print("Digite o preço unitário da planta: ");
	        double precoUnitario = scanner.nextDouble();

	        double total = quantidade * precoUnitario;
	        System.out.println("Preço total da compra: R$ " + total);
	    }

	    
	    public static void calcularTroco(Scanner scanner) {
	        System.out.print("Digite o valor recebido do cliente: ");
	        double valorRecebido = scanner.nextDouble();

	        System.out.print("Digite o valor total da compra: ");
	        double valorCompra = scanner.nextDouble();

	        if (valorRecebido < valorCompra) {
	            System.out.println("Erro: O valor recebido é menor que o valor da compra!");
	        } else {
	            double troco = valorRecebido - valorCompra;
	            System.out.println("Troco a ser dado: R$ " + troco);
	        }
	    }
	}
