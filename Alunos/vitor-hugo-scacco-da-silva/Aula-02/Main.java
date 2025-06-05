import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

        
        double quantidade, precoUnitario, valorPago, valorTotal;

        while (true) {
           
            System.out.println("Escolha uma opção:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Sair");

            int opcao = scanner.nextInt(); 

            
            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite a quantidade da planta: ");
                    quantidade = scanner.nextDouble();
                    System.out.print("Digite o preço unitário da planta: ");
                    precoUnitario = scanner.nextDouble();
                    valorTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.println("O preço total da venda é: " + valorTotal);
                    break;

                case 2:
                    
                    System.out.print("Digite o valor pago pelo cliente: ");
                    valorPago = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    valorTotal = scanner.nextDouble();
                    double troco = calcularTroco(valorPago, valorTotal);
                    System.out.println("O troco a ser dado é: " + troco);
                    break;

                case 3:
                    
                    System.out.println("Saindo do programa...");
                    scanner.close(); 
                    return; 

                default:
                    
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    
    public static double calcularPrecoTotal(double quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

   
    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }
}