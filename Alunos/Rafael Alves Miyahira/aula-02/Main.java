import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, quantidade;
        double preco, pagamento = 0, dinheiroCliente, troco;

        while (true) {
            System.out.printf("[1] - Calcular Preço Total\n[2] - Calcular Troco\n[3] - Sair\n");
            x = sc.nextInt();

            if (x == 1) {
                System.out.printf("Qual a quantidade de plantas que o cliente irá comprar?\n");
                quantidade = sc.nextInt();
                System.out.printf("Qual o preço da planta?\n");
                preco = sc.nextDouble();
                pagamento = quantidade * preco;
            }

            else if (x == 2) {
                if (pagamento == 0) {
                    System.out.println("Primeiro, calcule o preço total das plantas.");
                } else {
                    System.out.printf("Quantos reais vai dar para o pagamento?\n");
                    dinheiroCliente = sc.nextDouble();
                    if (dinheiroCliente < pagamento) {
                        System.out.printf("Você não tem dinheiro suficiente para realizar o pagamento!\n");
                    } else {
                        troco = dinheiroCliente - pagamento;
                        System.out.printf("O seu troco é de %.2f reais! Muito obrigado!\n", troco);
                    }
                }
            }

            else if (x == 3) {
                System.out.println("Saindo... Até logo! E volte sempre!");
                break;
            }


        }

        sc.close();
    }
}