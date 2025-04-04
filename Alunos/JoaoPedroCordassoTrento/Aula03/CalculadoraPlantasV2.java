package aula03;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraPlantasV2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean menu = true;
		ArrayList<Venda> registroDeVendas = new ArrayList<>();
		
		while(menu) {
			System.out.println("[1] Calcular Preço Total \n[2] Calcular Troco \n[3] Registro de Vendas \n[4] Sair \nSua Escolha: ");
			int esc = scan.nextInt();
			
			switch(esc) {
				case 1:
					System.out.println("Quantidade de Plantas: ");
					int qtdaPlantas = scan.nextInt();
					System.out.println("Preço da Planta: ");
					double precoPlanta = scan.nextDouble();
					double precoTotal = qtdaPlantas*precoPlanta;
					
					double desconto = 0;
					if(qtdaPlantas >= 10) {
						desconto = 5;
						precoTotal = ((precoTotal/100)*(100-desconto));
						System.out.println("Valor total: R$" + precoTotal);
					} else {
						System.out.println("Valor total: R$" + precoTotal);	
					}
					Venda venda = new Venda(qtdaPlantas, precoPlanta, desconto, precoTotal);
					registroDeVendas.add(venda);
					break;
					
				case 2:
					System.out.println("Qual o valor total: ");
					double preco = scan.nextDouble();
					System.out.println("Qual o valor recebido: ");
					double recebido = scan.nextDouble();
					System.out.println("R$" + (recebido-preco) + " de troco");
					break;
				case 3:
					for (Venda venda2 : registroDeVendas) {
						System.out.println(venda2);
					}
					break;
					
				case 4:
					menu = false;
					break;
					
				default:
					System.out.println("Opção Invalida!");
			}
		}
		

	}

}
