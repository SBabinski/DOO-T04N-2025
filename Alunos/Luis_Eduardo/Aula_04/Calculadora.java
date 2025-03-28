package luis;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
	public static Scanner scan = new Scanner(System.in);
	public static List<Venda> historicoVendas = new ArrayList<>();
	public static int mes, dia;

	public static void main(String[] args) {
		System.out.println("Em que mês estamos? (1-12)");
	    mes = scan.nextInt();
	    while (mes < 1 || mes > 12) {
	        System.out.println("Mês inválido! Insira um valor entre 1 e 12:");
	        mes = scan.nextInt();
	    }
	    System.out.println("Em que dia estamos? (1-31)");
	    dia = scan.nextInt();
	    while (dia < 1 || dia > 31) {
	        System.out.println("Dia inválido! Insira um valor entre 1 e 31:");
	        dia = scan.nextInt();
	    }

		boolean menu = true;
		while (menu) {
			System.out.println("\nO que deseja fazer?\n"
					+ "|1| Calcular preço total\n"
					+ "|2| Calcular troco\n"
					+ "|3| Histórico de vendas\n"
					+ "|4| Consultar vendas por data\n"
					+ "|5| Sair");
			System.out.print("Escolha uma opção: ");
			int escolha = scan.nextInt();

			switch (escolha) {
				case 1:
					calcularPreco();
					break;
				case 2:
					calcularTroco();
					break;
				case 3:
					consultarHistorico();
					break;
				case 4:
					consultarVendaPorDia();
					break;
				case 5:
					System.out.println("Saindo...");
					menu = false;
					break;
				default:
					System.out.println("Escolha inválida. Tente novamente.");
					break;
			}
		}
	}

	public static void calcularPreco() {
		System.out.println("\n=== Calculadora de preço total ===");
		System.out.print("Insira a quantidade de plantas compradas: ");
		int quantidade = scan.nextInt();
		System.out.print("Insira o valor unitário das plantas: ");
		float valorPlanta = scan.nextFloat();

		float valorTotal = quantidade * valorPlanta;
		float desconto = 0;

		if (quantidade > 10) {
			desconto = valorTotal * 0.05f;
			valorTotal -= desconto;
			System.out.println("Desconto de 5% aplicado!");
		}
	

		System.out.printf("O valor total a pagar é: R$ %.2f\n\n", valorTotal);

		Venda novaVenda = new Venda(quantidade, valorTotal, desconto, mes, dia);
		historicoVendas.add(novaVenda);
	}

	public static void calcularTroco() {
		System.out.println("\n=== Cálculo de Troco ===");
		System.out.print("Insira o valor recebido pelo cliente: ");
		float valorPago = scan.nextFloat();
		System.out.print("Insira o valor total da compra: ");
		float valorTotal = scan.nextFloat();
		
		if (valorPago < valorTotal) {
			System.out.println("Está faltando dinheiro");
		} else {
			float troco = valorPago - valorTotal;
			System.out.printf("O valor do troco é: R$ %.2f\n\n", troco);
		}
		
		
	}

	public static void consultarHistorico() {
		System.out.println("\n=== Histórico de Vendas ===");
		if (historicoVendas.isEmpty()) {
			System.out.println("Nenhuma venda registrada.");
		} else {
			for (Venda venda : historicoVendas) {
				System.out.println(venda);
			}
		}
	}

	public static void consultarVendaPorDia() {
		System.out.println("\nDigite o número do mês que deseja pesquisar (1-12):");
	    int mesBusca = scan.nextInt();
	    while (mesBusca < 1 || mesBusca > 12) {
	        System.out.println("Mês inválido! Insira um valor entre 1 e 12:");
	        mesBusca = scan.nextInt();
	    }
	    System.out.println("Digite o número do dia que deseja pesquisar (1-31):");
	    int diaBusca = scan.nextInt();
	    while (diaBusca < 1 || diaBusca > 31) {
	        System.out.println("Dia inválido! Insira um valor entre 1 e 31:");
	        diaBusca = scan.nextInt();
	    }

		boolean vendasEncontradas = false;
		for (Venda venda : historicoVendas) {
			if (venda.getMesVenda() == mesBusca && venda.getDiaVenda() == diaBusca) {
				System.out.println(venda);
				vendasEncontradas = true;
			}
		}

		if (!vendasEncontradas) {
			System.out.println("Nenhuma venda encontrada para essa data.");
		}
	}
}
