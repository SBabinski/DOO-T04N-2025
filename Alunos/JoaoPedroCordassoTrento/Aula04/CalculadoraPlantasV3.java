package aula04;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraPlantasV3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean menu = true;
		Funcoes funcao = new Funcoes();
		
		while(menu) {
			System.out.println("[1] Calcular Preço Total \n[2] Calcular Troco \n[3] Registro de Vendas \n[4] Sair \nSua Escolha: ");
			int esc = scan.nextInt();
			
			switch(esc) {
				case 1:
					funcao.fazerUmaVenda();
					break;
					
				case 2:
					funcao.calcularTroco();
					break;
				case 3:
					funcao.exibirRelatorioVendas();
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
