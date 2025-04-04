package aula04;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
	
	public static Scanner scan = new Scanner(System.in);
	
	ArrayList<Venda> registroDeVendas = new ArrayList<>();
	
	public void fazerUmaVenda() {
		System.out.println("Insira o numero do mês (1 = janeiro, 2 = fevereiro...):");
		int mes = scan.nextInt();
		System.out.println("Insira o numero do do dia de hoje:");
		int dia = scan.nextInt();
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
		Venda venda = new Venda(qtdaPlantas, precoPlanta, desconto, precoTotal, mes, dia);
		registroDeVendas.add(venda);
	}
	
	public void calcularTroco() {
		System.out.println("Qual o valor total: ");
		double preco = scan.nextDouble();
		System.out.println("Qual o valor recebido: ");
		double recebido = scan.nextDouble();
		System.out.println("R$" + (recebido-preco) + " de troco");
	}
	
	public void exibirRelatorioVendas() {
		boolean menu = true;
		while(menu) {
			System.out.println("[1] Todas as Vendas \n[2] Vendas no mês \n[3] Vendas no dia \n[4] Sair:");
			int esc = scan.nextInt();
			switch(esc) {
				case 1:
					for (Venda venda : registroDeVendas) {
						System.out.println(venda);
					}
					break;
					
				case 2:
					System.out.println("Insira o numero do mês que deseja pesquisar:");
					int mes = scan.nextInt();
					for (Venda venda : registroDeVendas) {
						if(mes == venda.getMesVenda()) {
							System.out.println(venda);
						}
					}
					break;
					
				case 3:
					System.out.println("Insira o numero do mês que deseja pesquisar:");
					int mes2 = scan.nextInt();
					System.out.println("Insira o numero do dia que deseja pesquisar:");
					int dia = scan.nextInt();
					for (Venda venda : registroDeVendas) {
						if((mes2 == venda.getMesVenda()) && (dia == venda.getDiaVenda())) {
							System.out.println(venda);
						}
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
