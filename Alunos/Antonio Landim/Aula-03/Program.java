package application;


import java.util.ArrayList;
import java.util.Scanner;

import Entities.Venda;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Venda> vendas = new ArrayList<>();
        
        int opcao;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                    calcularPrecoTotal(sc, vendas);
                    break;
                case 2:
                    calcularTroco(sc);
                    break;
                case 3:
                    exibirVendas(vendas);
                    break;
                case 4:
                    System.out.println("Encerrando.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (opcao != 4);
        
        sc.close();
    }


	
	public static void calcularPrecoTotal(Scanner sc, ArrayList<Venda> vendas) {
	    System.out.println("Digite a quantidade de plantas: ");
	    int totalPlantas = sc.nextInt();

	    System.out.println("Valor unitário de cada planta: ");
	    double valorUn = sc.nextDouble();

	    double valorTotal = totalPlantas * valorUn;
	    double desconto = 0;

	    if (totalPlantas >= 10) {
	        desconto = valorTotal * 0.05;  
	        valorTotal -= desconto;
	    }

	    
	    Venda venda = new Venda(totalPlantas, valorTotal, desconto);
	    vendas.add(venda);

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
	
	public static void exibirVendas(ArrayList<Venda> vendas) {
	    if (vendas.isEmpty()) {
	        System.out.println("Nenhuma venda registrada.");
	    } else {
	        System.out.println("\n===== Registro de Vendas =====");
	        for (Venda venda : vendas) {
	            System.out.println(venda);
	        }
	    }
	}

}
