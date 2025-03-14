import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("O que deseja fazer?\n"
				+ "|1|Calcular Preço total\n"
				+ "|2|Calcular Troco\n"
				+ "|3|Sair\n");
		int escolha = scan.nextInt();

		
		switch (escolha) {
		case 1: {
			System.out.println("Calculadora de preço total: ");
			System.out.println("Insira a quantia de plantas compradas");
			int quantidade = scan.nextInt();
			System.out.println("insira o valor das plantas compradas");
			float valorPlanta = scan.nextFloat();
			System.out.printf("O valor total é: R$ %.2f ",(quantidade*valorPlanta));
		}case 2: {
			System.out.println();
			System.out.println("Insira o valor recebido pelo cliente");
			float valorPago = scan.nextFloat();
			System.out.println("Insira o valor total da planta");
			float valorTotal = scan.nextFloat();
			System.out.printf("O valor do troco é: R$%.2f",(valorTotal-valorPago));
		}case 3: {
			
			System.out.println();
		}
		
		default:
			System.out.println("Escolha Incorreta");
		}
		
	}
			

}