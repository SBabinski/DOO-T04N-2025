import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Desconto {
    static Scanner scan = new Scanner(System.in);
    public static List<String> registroVenda = new ArrayList<String>();
    public static void main(String[] args) {
        boolean menu;
        menu = true;
        while (menu == true) {
        System.out.println("Olá, o que gostaria de fazer? \n(1) - Calcular preço total: \n(2) - Calcular troco: \n(3) - Visualizar registro de vendas: \n(4) - Sair.");
            int opcao = scan.nextInt();
            if (opcao == 1) {
                calcularPreco();
            }
            if (opcao == 2) {
                calcularTroco();
            }
            if (opcao == 3) {
                registroVendas();
            }
            if (opcao == 4) {
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
        float desconto = 0;
        if (quantidade > 10) {
            desconto = valorTotal * 0.05f;
            valorTotal = (valorTotal - desconto);
        }
        System.out.printf("O valor final é %.2f \n", valorTotal);
        String venda = String.format("Quantidade : %d | Total: R$%.2f | Desconto: R$%.2f\n", quantidade, valorTotal, desconto);
        registroVenda.add(venda);
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
    public static void registroVendas() {
        if(registroVenda.isEmpty()) {
            System.out.println("Nenhuma venda foi feita.\n");
        }   else {
            for (String venda : registroVenda) {
                System.out.println(venda);
                System.out.println();
            }
        }
    }    
}
