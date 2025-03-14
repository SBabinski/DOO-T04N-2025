import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3){

            System.out.println("==========MENU=========");
            System.out.println("1. Calcular preço total");
            System.out.println("2. Calcular troco");
            System.out.println("3. Sair");
            opcao = scanner.nextInt();

            switch (opcao){

                case 1:
                    System.out.println("Digite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precounitario = scanner.nextDouble();
                    double precototal = CalcularPrecoTotal(quantidade, precounitario);
                    System.out.println("O preço total da compra ficou em: R$ " + precototal);
                    break;

                case 2:
                    System.out.print("Digite o valor recebido: R$ ");
                    double valorcliente = scanner.nextDouble();
                    System.out.print("Digite o valor da compra: R$ ");
                    double valortotal = scanner.nextDouble();
                    double troco = CalcularTroco(valorcliente, valortotal);
                    if (troco < 0){

                        System.out.println("O valor recebido não é suficiente para realizar a compra");
                    }
                    else{

                        System.out.println("O troco do cliente é: R$ " + troco);
                    }
                    break;

                case 3:
                    System.out.println("Fechando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    public static double CalcularPrecoTotal(int quantidade, double precounitario){

        return quantidade * precounitario;
    }

    public static double CalcularTroco(double valorRecebido, double valorCompra)
    {
        return valorRecebido - valorCompra;
    }
}
