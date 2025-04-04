import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MelhoriaCalculadora {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Integer> quantidadeVendidas = new ArrayList<>();
    public static List<Double> registroDeVendas = new ArrayList<>();
    public static List<Character> registroDesconto = new ArrayList<>();

    public static void main(String[] args) {
        menu();

    }
    
    public static void menu() {
        Boolean menuEntrada = true;
        while(menuEntrada) {
            System.out.println("qual voce deseja  selecionar \n");
            System.out.println("""
                           [1] - Calcular Preco Total 
                           [2] - Calcular Troco 
                           [3] - Registro de vendas
                           [4] - sair""");

            int valorMenu = scanner.nextInt();

            switch (valorMenu) {
                case 1 -> precoTotal();
                case 2 -> troco();
                case 3 -> registroVendas();
                case 4 -> menuEntrada = false;
                default -> System.out.println("valor invalido!");
            }

        }
    }

    public static void precoTotal() {
        System.out.println("Entre com a quantidade\n");
        int quantidade = scanner.nextInt();
        quantidadeVendidas.add(quantidade);
        System.out.println("digite o valor da planta\n");
        double valorPlanta = scanner.nextInt();

        if(quantidade > 10 ) {
            valorPlanta = valorPlanta * 0.95;
            registroDesconto.add('5');

        }else {
            registroDesconto.add('0');
        }

        double resultado = quantidade * valorPlanta;
        registroDeVendas.add(resultado);

        System.out.println("O valor a ser pago: " + resultado + "\n");

    }

    public static void troco() {
        System.out.println("coloque o valor recebido do cliente\n");
        float valorCliente = scanner.nextFloat();
        System.out.println("digite o valor a ser pago!");
        float valorPago = scanner.nextFloat();

        if(valorCliente < valorPago) {
            System.out.println("não foi possivel calcular o troco, DINHEIRO INSUFICIENTE!");

        }else {
            float trocoValor = valorCliente - valorPago;
            System.out.println("o troco a ser devolvido: " + trocoValor + "\n");

        }
    }

    public static void registroVendas() {
        System.out.println("Registro de Vendas:");

    int tamanho = Math.min(Math.min(quantidadeVendidas.size(), registroDeVendas.size()), registroDesconto.size());

    for (int i = 0; i < tamanho; i++) {
        System.out.println("\nVenda " + (i + 1) + ":");
        System.out.println("Quantidade: " + quantidadeVendidas.get(i));
        System.out.println("Valor: R$ " + registroDeVendas.get(i));
        System.out.println("Desconto: " + registroDesconto.get(i) + "%");
    }

    }
}
