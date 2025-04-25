package application;
 
 
 import java.util.ArrayList;
import java.util.Scanner;

import entities.RegistroVendas;
import entities.Vendas;
 
 public class Program {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         ArrayList<Vendas> vendas = new ArrayList<>();
         ArrayList<RegistroVendas> list = new ArrayList<>();
         
         int opcao;
         do {
             System.out.println("\n===== Menu =====");
             System.out.println("[1] - Calcular Preço Total");
             System.out.println("[2] - Calcular Troco");
             System.out.println("[3] - Exibir Registro de Vendas");
             System.out.println("[4] - Salvar vendas do dia");
             System.out.println("[5] - Buscar vendas por data");
             System.out.println("[6] - sair");
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
                     registrarVendas(sc, list);
                     break;
                 case 5:
                	 buscarVendasPorData(sc, list);
                	 break;
                 case 6:
                	 System.out.println("Saindo... ");
                	 break;
                 default:
                     System.out.println("Opção inválida, tente novamente!");
             }
         } while (opcao != 6);
         
         sc.close();
     }
 
 
 	
 	public static void calcularPrecoTotal(Scanner sc, ArrayList<Vendas> vendas) {
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
 
 	    
 	    Vendas venda = new Vendas(totalPlantas, valorTotal, desconto);
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
 	
 	public static void exibirVendas(ArrayList<Vendas> vendas) {
 	    if (vendas.isEmpty()) {
 	        System.out.println("Nenhuma venda registrada.");
 	    } else {
 	        System.out.println("\n===== Registro de Vendas =====");
 	        for (Vendas venda : vendas) {
 	            System.out.println(venda);
 	        }
 	    }
 	}
 	
 	public static void registrarVendas(Scanner sc, ArrayList<RegistroVendas> list) {
 	    System.out.println("Digite o dia da venda: ");
 	    int dia = sc.nextInt();

 	    System.out.println("Digite o mês da venda: ");
 	    int mes = sc.nextInt();

 	    System.out.println("Digite a quantidade de vendas: ");
 	    int quantidade = sc.nextInt();

 	    
 	    list.add(new RegistroVendas(dia, mes, quantidade));
 	    

 	    System.out.println("Venda registrada para o dia " + dia + "/" + mes);
 	}

 	public static void buscarVendasPorData(Scanner sc, ArrayList<RegistroVendas> list) {
 	    System.out.println("Digite o dia da venda que deseja buscar: ");
 	    int dia = sc.nextInt();

 	    System.out.println("Digite o mês da venda que deseja buscar: ");
 	    int mes = sc.nextInt();

 	    boolean encontrado = false;
 	    for (RegistroVendas rv : list) {
 	        if (rv.getDia() == dia && rv.getMes() == mes) {
 	            System.out.println("Vendas no dia " + dia + "/" + mes + ": " + rv.getQuantidadeVendas());
 	            encontrado = true;
 	            break;
 	        }
 	    }

 	    if (!encontrado) {
 	        System.out.println("Nenhuma venda registrada para essa data.");
 	    }
 	}

 	
 	
 	
 }