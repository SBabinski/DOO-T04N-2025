
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner enterScanner = new Scanner(System.in);
		
		int escolha = 3;
		
		do {
			System.out.println(" [1] - Calcular Preço Total ");
			System.out.println(" [2] - Calcular Troco ");
			System.out.println(" [3] - Sair ");
			escolha = enterScanner.nextInt();
			
			if(escolha == 1) {
				System.out.println("Digite a quantidade: ");
				int quant = enterScanner.nextInt();
				
				System.out.println("Digite o valor: ");
				float valor = enterScanner.nextFloat();
				
				float c = quant * valor;
				
				System.out.printf("\nValor final: %.2f%n\n", c);
				
			}
			
			if(escolha == 2) {
				System.out.println("Digite o valor da compra: ");
				float valorc = enterScanner.nextFloat();
				
				System.out.println("Digite o valor recebido: ");
				float valorr = enterScanner.nextFloat();
				
				float troco = valorr - valorc;
				
				System.out.printf("\nO troco será: %.2f%n\n", troco);
			}
		} while(escolha != 3);
		
		System.out.println("\nPrograma encerrado, obrigado por usar!");
        enterScanner.close();

	}
}