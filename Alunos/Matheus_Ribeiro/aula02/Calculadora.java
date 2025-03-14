package system;

import java.util.Scanner;
import java.math.*;

public class Calculadora {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		sistema();
	}
	public static void sistema() {
		int choice = 0;
		System.out.println("Bem vindo! Escolha uma opção para continuar:");
		while(choice != 3) {
		 System.out.println("1. Calcular Total");
         System.out.println("2. Calcular Troco");
         System.out.println("3. Sair");
         choice = scan.nextInt();
         switch (choice) {
		case 1: {
			calculoTotal();
			break;
		}
		case 2: {
			calculoTroco();
			break;
		}
		case 3: {
			System.out.println("Até logo!");
			break;
		}
		default: {
			System.out.println("Opção inválida, tente novamente.");
			break;
		}
         }
	}}
	private static void calculoTroco() {
		System.out.println("Digite o valor pago pelo cliente:");
		float pagClient = scan.nextFloat();
		System.out.println("Digite o valor total da compra:");
		float valTotal = scan.nextFloat();
		float result = pagClient-valTotal;
		if (result == 0) {
			System.out.println("Sem troco!");
		} else if (result<0) {
			System.out.println("O cliente ainda precisa pagar R$:" + Math.abs(result));
		} else {
			System.out.println("O troco ficou R$: " + result);
		}
		
	}
	private static void calculoTotal() {
		System.out.println("Digite a quantidade do produto:");
		int quant = scan.nextInt();
		System.out.println("Digite o valor do produto:");
		float value = scan.nextFloat();
		float total = quant*value;
		System.out.println("O total ficou R$: " + total);
	}
	

}
