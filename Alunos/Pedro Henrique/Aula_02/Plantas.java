package calculadora;
import java.util.Scanner;

public class Plantas {

	

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcao;

	        do {
	            System.out.println("Menu:");
	            System.out.println("[1] - Calcular Preço Total");
	            System.out.println("[2] - Calcular Troco");
	            System.out.println("[3] - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    System.out.print("Quantidade de plantas: ");
	                    int quantidade = scanner.nextInt();
	                    System.out.print("Preço unitário: ");
	                    double preco = scanner.nextDouble();
	                    System.out.println("Preço total: " + (quantidade * preco));
	                    break;
	                case 2:
	                    System.out.print("Valor pago: ");
	                    double pago = scanner.nextDouble();
	                    System.out.print("Valor da compra: ");
	                    double total = scanner.nextDouble();
	                    System.out.println("Troco: " + (pago - total));
	                    break;
	                case 3:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida!");
	            }
	        } while (opcao != 3);

	        scanner.close();
	    }
	}
