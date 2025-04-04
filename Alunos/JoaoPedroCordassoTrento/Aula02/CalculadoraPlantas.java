package aula02;

import java.util.Scanner;

public class CalculadoraPlantas {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean menu = true;
		
		while(menu)
		{
			System.out.println("[1] Calcular Preço Total \n[2] Calcular Troco \n[3] Sair \nSua Escolha: ");
			int esc = scan.nextInt();
			
			switch(esc)
			{
				case 1:
					System.out.println("Quantidade de Plantas: ");
					int qtdaPlantas = scan.nextInt();
					System.out.println("Preço da Planta: ");
					double precoPlanta = scan.nextDouble();
					System.out.println("Valor total: R$" + (qtdaPlantas*precoPlanta));
					break;
					
				case 2:
					System.out.println("Qual o valor total: ");
					double preco = scan.nextDouble();
					System.out.println("Qual o valor recebido: ");
					double recebido = scan.nextDouble();
					System.out.println("R$" + (recebido-preco) + " de troco");
					break;
					
				case 3:
					menu = false;
					break;
					
				default:
					System.out.println("Opção Invalida!");
			}
		}
		

	}

}
