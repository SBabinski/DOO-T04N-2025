
import java.util.Scanner;

public class Atividade_Aula_02 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean menu;
        menu = true;
        while (menu == true) {
        System.out.println("Olá, o que gostaria de fazer? \n(1) - Calcular preço total: \n(2) - Calcular troco: \n(3) - Sair.");
            int opcao = scan.nextInt();
            if (opcao == 1) {
                calcularPreco();
            }
            if (opcao == 2) {
                calcularTroco();
            }
            if (opcao == 3) {
                break;
            }
    }
}
    public static void calcularPreco() {
        scan.nextLine();
        System.out.println("Entre com o a quantidade do produto: \n");
        int quantidade = scan.nextInt();
        System.out.println("Entre com o valor do produto: \n");
        float valor = scan.nextFloat();
        float valorTotal;
        valorTotal = quantidade*valor;
        System.out.printf("O valor final é %.2f \n", valorTotal);
    }
    public static void calcularTroco() {
        scan.nextLine();
        System.out.println("Entre com o valor pago pelo cliente: \n");
        float valorPago = scan.nextFloat();
        System.out.println("Entre com o valor da compra. \n");
        float valorCompra = scan.nextFloat();
        float valorTroco;
        valorTroco = valorPago-valorCompra;
        System.out.printf("O valor do troco é %.2f. \n", valorTroco);
    }
}
