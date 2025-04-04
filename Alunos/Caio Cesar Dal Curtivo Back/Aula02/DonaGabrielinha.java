package Aula02;
import java.util.Scanner;
public class DonaGabrielinha {
    Scanner scan = new Scanner(System.in);
    double precoTotal = 0;
    public double calcPreco() {
        System.out.println("Digite a quantidade de plantas a serem compradas:");
        double qnt = scan.nextDouble();
        System.out.println("Digite quanto custa cada planta:");
        double preco = scan.nextDouble();
        return preco*qnt;
    }
    public double troco() {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scan.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scan.nextDouble();
        double troco = valorRecebido - valorCompra;
        return valorRecebido-valorCompra;
    }
}
