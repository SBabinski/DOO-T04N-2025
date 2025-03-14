package gabrielinha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lojagabrielinha {

    static class Venda {
        int quantidade;
        double valorVenda;
        double desconto;

        Venda(int quantidade, double valorVenda, double desconto) {
            this.quantidade = quantidade;
            this.valorVenda = valorVenda;
            this.desconto = desconto;
        }

        @Override
        public String toString() {
            return "Quantidade: " + quantidade + ", Valor Venda: R$ " + String.format("%.2f", valorVenda) + ", Desconto: R$ " + String.format("%.2f", desconto);
        }
    }

    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--- Menu ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Quantidade da planta: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço unitário da planta: ");
                    double preco = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, preco);
                    double desconto = (quantidade > 10) ? precoTotal * 0.05 : 0;
                    double valorFinal = precoTotal - desconto;
                    System.out.printf("Preço total: R$ %.2f\n", valorFinal);
                    if (desconto > 0) {
                        System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
                    }
                    registroVendas.add(new Venda(quantidade, valorFinal, desconto));
                    break;

                case 2:
                    System.out.print("Valor recebido: ");
                    double valorRecebido = scanner.nextDouble();
                    System.out.print("Valor total da compra: ");
                    double valorCompra = scanner.nextDouble();
                    double troco = calcularTroco(valorRecebido, valorCompra);
                    if (troco >= 0) {
                        System.out.printf("Troco: R$ %.2f\n", troco);
                    } else {
                        System.out.println("Valor insuficiente!");
                    }
                    break;

                case 3:
                    System.out.println("--- Registro de Vendas ---");
                    if (registroVendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda venda : registroVendas) {
                            System.out.println(venda);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        } while (opcao != 4);
        scanner.close();
    }

    public static double calcularPrecoTotal(int quantidade, double preco) {
        return quantidade * preco;
    }

    public static double calcularTroco(double valorRecebido, double valorCompra) {
        return valorRecebido - valorCompra;
    }
}
