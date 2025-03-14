
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

		int opcao;

		do {
			System.out.println("\n===== Menu =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {		
            case 1:
            	calcularPrecoTotal(sc);
            	break;

            case 2:
            	calcularTroco(sc);
            	break;

            case 3:
            	System.out.println("Encerrando.");
            	break;

            default:
            	System.out.println("Opcão inválida, tente novamente!");


            }
       } while (opcao != 3);



		sc.close();

	}

	public static void calcularPrecoTotal(Scanner sc) {
		System.out.println("Digite a quantidade de plantas: ");
		int totalPlantas = sc.nextInt();

		System.out.println("Valor unitário de cada planta: ");
		double valorUn = sc.nextDouble();

		double valorTotal = totalPlantas * valorUn;

		System.out.printf("O valor total da compra é de: R$ %.2f\n", valorTotal);
	}

	public static void calcularTroco(Scanner sc) {
		System.out.println("Valor a pagar: ");
		double valorPagar = sc.nextDouble();

		System.out.println("Valor pago pelo cliente: ");
		double valorPago = sc.nextDouble();

		double troco = valorPago - valorPagar;

		if(troco < 0) {
			System.out.println("Valor insuficiente, faltam R$ "+ Math.abs(troco));
		}else {
			System.out.printf("O troco é: R$ %.2f\n", troco);
		}
	}

	}