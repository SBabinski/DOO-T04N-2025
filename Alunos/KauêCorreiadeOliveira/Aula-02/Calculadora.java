import java.util.Scanner;


public class Calculadora {

    public static Scanner scanner = new Scanner(System.in);
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
                           [3] - Sair""");

            int valorMenu = scanner.nextInt();

            switch (valorMenu) {
                case 1 -> precoTotal();
                case 2 -> troco();
                case 3 -> menuEntrada = false;
                default -> System.out.println("valor invalido!");
            }

        }
    }

    public static void precoTotal() {
        System.out.println("Entre com a quantidade\n");
        int quantidade = scanner.nextInt();
        System.out.println("digite o valor da planta\n");
        float valorPlanta = scanner.nextInt();

        float resultado = quantidade * valorPlanta;

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
}
