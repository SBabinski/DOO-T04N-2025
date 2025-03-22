import java.util.Scanner;
import java.util.ArrayList;

public class CalculadoraAntiquada {
    public static void main(String[] args) {
        int opcao = 0;
        int contador = 0;
        ArrayList<String> registro = new ArrayList<>();
         
        while (opcao != 4) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Cálculo de preço total \n2- Calculo de troco \n3- Registro de compras \n4- Sair"); 
        opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1:
            System.out.println("Digite a quantidade de plantas: ");
            int qtdPlantas = scanner.nextInt();
        
            System.out.println("Digite o valor das plantas: ");
            int valorPlantas = scanner.nextInt();

            if (qtdPlantas>10) {
                double valorTotal=qtdPlantas*valorPlantas;
                valorTotal *= 0.95;
                System.out.println("Valor total com desconto de 5%: " + valorTotal);
                registro.add (qtdPlantas + " plantas vendidas no valor de " + valorTotal + " com 5% de desconto.");
            } else {
                double valorTotal = qtdPlantas * valorPlantas;
            System.out.println("Valor total: " + valorTotal);
            registro.add (qtdPlantas + " plantas vendidas no valor de " + valorTotal);}
            contador += 1;
            break;
        
            case 2:
            System.out.println("Digite o valor pago pelo cliente: ");
            int n2 = scanner.nextInt();

            System.out.println("Digite o valor total da compra: ");
            int n1 = scanner.nextInt();

            if (n2 >= n1) {
                n2 = n2 - n1;
                System.out.println("É necessário troco de " + n2);
            } else {
                n1 = n1 - n2;
                System.out.println("Cliente ainda está devendo " + n1);
            } 
            break;

            case 3:
            if (contador == 0) {
                System.out.println("Nenhuma compra realizada.");
            } else {
                for (int i = 0;i < contador; i++){
                    System.out.println("Operação " + (i+1) + " = " + registro.get(i));
                }
            }
            break;

            case 4:
            System.out.println("Saindo");
            break;
            default: 
            System.out.println("Opção inválida");
             break;}
}}
}
