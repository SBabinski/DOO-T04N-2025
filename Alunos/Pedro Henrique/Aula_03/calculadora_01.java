package calculadora_01;

import java.util.ArrayList;
import java.util.Scanner;

public class calculadora_01 {
	    static ArrayList<String> registroVendas = new ArrayList<>();

	    public static double calcularTotal(double preco, int quantidade) {
	        double total = preco * quantidade;
	        if (quantidade > 10) {
	            total *= 0.95; // Aplica 5% de desconto
	            registroVendas.add("Quantidade: " + quantidade + " | Preço: " + preco + " | Desconto aplicado");
	        } else {
	            registroVendas.add("Quantidade: " + quantidade + " | Preço: " + preco + " | Sem desconto");
	        }
	        return total;
	    }

	    public static void mostrarVendas() {
	        System.out.println("\nRegistro de Vendas:");
	        for (String venda : registroVendas) {
	            System.out.println(venda);
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcao;

	        do {
	            System.out.println("\nMenu da Dona Gabrielinha");
	            System.out.println("1 - Calcular Total da Compra");
	            System.out.println("2 - Exibir Registro de Vendas");
	            System.out.println("3 - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    System.out.print("Informe o preço da planta: ");
	                    double preco = scanner.nextDouble();
	                    System.out.print("Informe a quantidade: ");
	                    int quantidade = scanner.nextInt();
	                    double total = calcularTotal(preco, quantidade);
	                    System.out.printf("Valor total: R$ %.2f\n", total);
	                    break;
	                case 2:
	                    mostrarVendas();
	                    break;
	                case 3:
	                    System.out.println("Saindo do sistema...");
	                    break;
	                default:
	                    System.out.println("Opção inválida! Tente novamente.");
	            }
	        } while (opcao != 3);

	        scanner.close();
	    }
	}
