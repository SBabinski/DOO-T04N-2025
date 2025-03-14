import java.util.Scanner;

public class aula2 {

    public static void main(String[] args) {
        Scanner enterScanner = new Scanner(System.in);
        boolean trigger = true;
        int escolha;
        float valor;
        int quantidade;
        float troco;
        float valorPago, totalCompra;

        while (trigger) {
            
            System.out.println("[1] Para calcular preço total");
            System.out.println("[2] Cálculo de troco");
            System.out.println("[3] EXIT");
            System.out.print("Escolha uma opção: ");

            
            escolha = enterScanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor do produto: ");
                    valor = enterScanner.nextFloat();
                    System.out.print("Quantidade do produto: ");
                    quantidade = enterScanner.nextInt();

                    
                    float precoTotal = valor * quantidade;
                    System.out.println("Preço total: R$" + precoTotal);
                    break;

                case 2:
                    System.out.print("Digite o valor total da compra: ");
                    totalCompra = enterScanner.nextFloat();
                    System.out.print("Digite o valor pago pelo cliente: ");
                    valorPago = enterScanner.nextFloat();

                    
                    if (valorPago >= totalCompra) {
                        troco = valorPago - totalCompra;
                        System.out.println("Troco: R$" + troco);
                    } else {
                        System.out.println("Valor insuficiente! Falta R$" + (totalCompra - valorPago));
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    trigger = false;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        }
        
    }
}

