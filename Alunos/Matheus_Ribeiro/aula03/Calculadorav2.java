package system;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Venda {//Objeto para registrar vendas
    int quantidade;
    float valorUnitario;
    float valorTotal;
    float desconto;
    
    public Venda(int quantidade, float valorUnitario, float valorTotal, float desconto) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }
}


public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List<Venda> registroVendas = new ArrayList<>(); 
	public static void main(String[] args) {
		sistema();
	}
	public static void sistema() { //Menu principal
        int choice = 0;
        System.out.println("Bem vindo! Escolha uma opção para continuar:");
        while (choice != 4) {
            System.out.println("1. Calcular Total");
            System.out.println("2. Calcular Troco");
            System.out.println("3. Ver Registro de Vendas");
            System.out.println("4. Sair");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    calculoTotal();
                    break;
                case 2:
                    calculoTroco();
                    break;
                case 3:
                    mostrarRegistroVendas();
                    break;
                case 4:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
	private static void calculoTroco() {
		System.out.println("Digite o valor pago pelo cliente:");
		float pagClient = scan.nextFloat();
		System.out.println("Digite o valor total da compra:");
		float valTotal = scan.nextFloat();
		float result = pagClient-valTotal;
		if (result == 0) {
			System.out.println("Sem troco!");
		} else if (result<0) {
			System.out.println("O cliente ainda precisa pagar R$: " + Math.abs(result));
		} else {
			System.out.println("O troco ficou R$: " + result);
		}
		
	}
	private static void calculoTotal() {
        System.out.println("Digite a quantidade do produto:");
        int quant = scan.nextInt();
        System.out.println("Digite o valor do produto:");
        float value = scan.nextFloat();
        float total = quant * value;
        float desconto = 0;
        
        if (quant > 10) {
            desconto = total * 0.05f;//f no finalzinho serve pra dizer que o valor é float 
            total -= desconto;
            System.out.println("Desconto aplicado de 5%!");
        }
        
        System.out.println("O total ficou R$: " + total);
        
        registroVendas.add(new Venda(quant, value, total, desconto));
    }
	 private static void mostrarRegistroVendas() {
	        if (registroVendas.isEmpty()) {//Olha se a lista de vendas tá vazia, se sim, retorna para o menu
	            System.out.println("Nenhuma venda foi registrada.");
	            return;
	        }
	        System.out.println("Registro de Vendas:");
	        for (int i = 0; i < registroVendas.size(); i++) {
	            Venda v = registroVendas.get(i);
	            System.out.println("Venda " + (i + 1) + ": Quantidade = " + v.quantidade + ", Valor Unitário = R$ " + v.valorUnitario + ", Total = R$ " + v.valorTotal + ", Desconto = R$ " + v.desconto);
	        }

}}
