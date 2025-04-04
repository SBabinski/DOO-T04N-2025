package Plantas;

import java.util.Scanner;

public class Aula {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Scanner scanner = new Scanner(System.in);
	        int opcao;

	        do {
	            
	            System.out.println("\n--- MENU ---");
	            System.out.println("[1] - Calcular Preço Total");
	            System.out.println("[2] - Calcular Troco");
	            System.out.println("[3] - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            if (opcao == 1 || opcao == 2) {
	                realizarCalculo(scanner, opcao);
	            } else if (opcao == 3) {
	                System.out.println("Saindo...");
	            } else {
	                System.out.println("Opção inválida! Tente novamente.");
	            }
	        } while (opcao != 3);

	        scanner.close();
	    }

	   
	    public static void realizarCalculo(Scanner scanner, int opcao) {
	        if (opcao == 1) {
	            System.out.println("Quantas plantas foram vendidas?");
	            int quantidade = scanner.nextInt();
	            
	            System.out.println("Qual o valor unitário da planta?");
	            double precoUnitario = scanner.nextDouble();
	            
	            double precoTotal = quantidade * precoUnitario;
	            System.out.println("O preço total da venda é: R$ " + precoTotal);
	        } else if (opcao == 2) {
	            System.out.println("Digite o valor total da compra:");
	            double totalCompra = scanner.nextDouble();
	            
	            System.out.println("Digite o valor recebido pelo cliente:");
	            double valorRecebido = scanner.nextDouble();
	            
	            if (valorRecebido < totalCompra) {
	                System.out.println("Valor insuficiente! O cliente precisa pagar mais R$ " + (totalCompra - valorRecebido));
	            } else {
	                double troco = valorRecebido - totalCompra;
	                System.out.println("O troco ao cliente é: R$ " + troco);
	            }
	        }
	    }
	}
