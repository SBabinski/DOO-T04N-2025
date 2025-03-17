
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MelhoriasCalculadora {

    static List<Double> registroVendas = new ArrayList<>();
    static List<Integer> plantas = new ArrayList<>();
    static List<Character> desconto = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registro de Vendas");
            System.out.println("[4] - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    precoTotal();
                    break;
                case 2:
                    troco();
                    break;
                case 3:
                    RegistroVendas();
                    break;
                case 4:
                    menu = false;
                    break;
                default:
                    System.out.println("Erro! Digite uma opção válida!");
            }
        }
    }

    public static void precoTotal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade de produtos: ");
        int quantidade = scanner.nextInt();

        if (quantidade > 10) {
            preco = preco * 0.95;
            System.out.println("Desconto de 5% aplicado!");
            desconto.add('5');
        } else {
            desconto.add('0');
        }

        double total = preco * quantidade;
        System.out.println("O preço total é: " + total);
        registroVendas.add(total);
        plantas.add(quantidade);
    }

    public static void troco() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.println("Digite o valor pago: ");
        double pago = scanner.nextDouble();
        double troco = pago - valor;
        System.out.println("O troco é: " + troco);
    }

    public static void RegistroVendas() {
        System.out.println("Registro de Vendas: ");
        for (int i = 0; i < registroVendas.size() && i < plantas.size() && i < desconto.size(); i++) {
            System.out.println("Venda " + (i + 1) + ": " + registroVendas.get(i)
                    + " - Plantas: " + plantas.get(i) + " - Desconto: " + desconto.get(i) + "%");
        }
    }
}
