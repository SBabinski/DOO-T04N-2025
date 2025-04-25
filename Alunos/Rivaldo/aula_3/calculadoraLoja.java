import java.util.Scanner;

public class Main {

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static double aplicarDesconto(double precoTotal, int quantidade) {
        if (quantidade > 10) {
            return precoTotal * 0.95;  
        }
        return precoTotal;
    }

    public static void registrarVenda(int quantidade, double precoUnitario, double precoTotal, double precoComDesconto) {
        System.out.println("\nRegistro de Venda:");
        System.out.println("Quantidade de plantas: " + quantidade);
        System.out.println("Preço unitário: R$ " + precoUnitario);
        System.out.println("Preço total: R$ " + precoTotal);
        if (quantidade > 10) {
            System.out.println("Desconto aplicado de 5%!");
            System.out.println("Preço com desconto: R$ " + precoComDesconto);
        }
    }

    public static void main(String[] args) {
        boolean trigger = true;
        int quantidade;
        double precoUnitario, valorRecebido;
        Scanner scann = new Scanner(System.in);
        
        while (trigger) {
            System.out.println("\n[1] - Calcular Preco Total\n[2] - Calcular Troco\n[3] - Registrar Venda\n[4] - Sair");
            System.out.print("Sua escolha: ");
            int option = scann.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Iremos calcular o preço total");
                    System.out.print("Quantidade de plantas: ");
                    quantidade = scann.nextInt();
                    System.out.print("Preço da planta: ");
                    precoUnitario = scann.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    precoTotal = aplicarDesconto(precoTotal, quantidade);
                    System.out.println("Preço Total (com ou sem desconto): R$ " + precoTotal);
                    break;
                
                case 2:
                    System.out.println("Iremos calcular o troco");
                    System.out.print("Quanto recebeu: ");
                    valorRecebido = scann.nextDouble();
                    System.out.print("Valor da compra: ");
                    precoUnitario = scann.nextDouble();
                    double troco = calcularTroco(valorRecebido, precoUnitario);
                    System.out.println("Troco: R$ " + troco);
                    break;

                case 3:
                    System.out.println("Iremos registrar a venda");
                    System.out.print("Quantidade de plantas: ");
                    quantidade = scann.nextInt();
                    System.out.print("Preço da planta: ");
                    precoUnitario = scann.nextDouble();
                    double precoTotalVenda = calcularPrecoTotal(quantidade, precoUnitario);
                    double precoComDesconto = aplicarDesconto(precoTotalVenda, quantidade);
                    registrarVenda(quantidade, precoUnitario, precoTotalVenda, precoComDesconto);
                    break;

                case 4:
                    trigger = false;
                    break;
            }
        }
        scann.close();
    }
}
