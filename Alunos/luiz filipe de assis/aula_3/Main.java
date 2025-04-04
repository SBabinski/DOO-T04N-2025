import java.util.ArrayList;
import java.util.Scanner;

class Venda {
	int quantidade;
	float valor, total, totalComDesconto;

	Venda(int quantidade, float valor) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.total = quantidade * valor;
		this.totalComDesconto = quantidade >= 10 ? total * 0.95f : total;
	}

	public String toString() {
		String resultado = "\nQtd: " + quantidade + "\nValor: R$" + String.format("%.2f", valor) +
		                   "\nTotal sem desconto: R$" + String.format("%.2f", total);
		if (quantidade >= 10) {
			resultado += "\nDesconto de 5% aplicado!" +
			             "\nTotal com desconto: R$" + String.format("%.2f", totalComDesconto);
		}
		return resultado;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Venda> vendas = new ArrayList<>();
		int escolha;

		do {
			System.out.println("\n1 - Registrar Venda\n2 - Exibir Vendas\n3 - Sair");
			escolha = scanner.nextInt();

			if (escolha == 1) {
				System.out.print("Quantidade: ");
				int quantidade = scanner.nextInt();
				System.out.print("Valor: ");
				float valor = scanner.nextFloat();
				vendas.add(new Venda(quantidade, valor));
				System.out.println("Venda registrada!");
			} else if (escolha == 2) {
				if (vendas.isEmpty()) System.out.println("Nenhuma venda registrada.");
				else vendas.forEach(System.out::println);
			}
		} while (escolha != 3);

		System.out.println("Programa encerrado, obrigado por usar!");
		scanner.close();
	}
}