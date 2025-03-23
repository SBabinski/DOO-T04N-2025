import java.math.BigDecimal;
import java.util.Scanner;

public class CalculadoraPlantas {
    public static void calculaPrecoTotal(Scanner sc)
    {
        System.out.println("Insira a quantidade da planta referida");
        int quantidade = sc.nextInt();
        System.out.println("Insira o preço da planta referida");
        BigDecimal preco = sc.nextBigDecimal();
        System.out.println("Quantidade: " + quantidade + " Preço: " + preco);
        System.out.println("O Preço total é: R$ " + preco.multiply(new BigDecimal(quantidade)));
    }
    public static void calculaTroco(Scanner sc)
    {
        System.out.println("Insira o valor recebido");
        BigDecimal valorRecebido = sc.nextBigDecimal();
        System.out.println("Insira o valor total");
        BigDecimal valorTotal = sc.nextBigDecimal();
        System.out.println("Valor Recebido: R$ " + valorRecebido + " Valor Total: R$ " + valorTotal);
        System.out.println("O troco é: R$ " + valorRecebido.subtract(valorTotal));
    }
    public static void menu (Scanner sc)
    {
        System.out.println(
                "------------------------ MENU ------------------------\n" +
                "1 - Calcular Preço Total\n" +
                "2 - Calcular Troco\n" +
                "3 - Sair\n"
        );
        int option = sc.nextInt();

        switch(option)
        {
            case 1:
                calculaPrecoTotal(sc);
                menu(sc);
                break;
            case 2:
                System.out.println("Calcular Preço Total");
                calculaTroco(sc);
                menu(sc);
                break;
            case 3:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida");
                menu(sc);
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }
}
