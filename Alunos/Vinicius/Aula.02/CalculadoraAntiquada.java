import java.util.Scanner;

public class CalculadoraAntiquada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Cálculo de preço total \n2- Calculo de troco \n3- Sair"); 
        int opcao = scanner.nextInt();
        
        switch (opcao) {
            case 1:
            System.out.println("Digite a quantidade de plantas: ");
            int n1 = scanner.nextInt();
        
            System.out.println("Digite o valor das plantas: ");
            int n2 = scanner.nextInt();
        
            System.out.println("Valor total: " + n1 * n2);
                break;
        
            case 2:
            System.out.println("Digite o valor pago pelo cliente: ");
            n2 = scanner.nextInt();

            System.out.println("Digite o valor total da compra: ");
            n1 = scanner.nextInt();

            if (n2 >= n1) {
                n2 = n2 - n1;
                System.out.println("É necessário troco de " + n2);
            } else {
                n1 = n1 - n2;
                System.out.println("Cliente ainda está devendo " + n1);
            } break;

            case 3:
            System.out.println("Saindo");
            default: 
            System.out.println("Opção inválida: Saindo");
                break; }
}
}
