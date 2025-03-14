import java.util.Scanner;
public class Main{
    

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }


    public static void main(String[] args) {
        boolean trigger = true;
        int quantidade;
        double precoUnitario,valorRecebido;
        Scanner scann = new Scanner(System.in);
        
        while (trigger){
            
        System.out.println("\n[1] - Calcular Preco Total\n[2] - Calcular Troco\n[3] - Sair");
        System.out.print("Sua escolha: ");
        int option = scann.nextInt();
        
        switch(option){
            case 1:
                System.out.println("Iremos calcular o preco total");
                System.out.print("Quantidade de plantas: ");
                quantidade = scann.nextInt();
                System.out.print("Preco da planta: ");
                precoUnitario = scann.nextDouble();
                double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                System.out.println("Preco Total: R$ " + precoTotal);
                break;
                
            case 2:
                System.out.println("Iremos calcular o troco");
                System.out.print("Quanto recebeu: ");
                valorRecebido = scann.nextDouble();
                System.out.print("Valor da compra: ");
                precoTotal = scann.nextDouble();
                double troco = calcularTroco(valorRecebido, precoTotal);
                System.out.println("Troco: R$ " + troco);
                break;
            case 3:
                trigger = false;
                break;
            
        }
        } 
   }

}
