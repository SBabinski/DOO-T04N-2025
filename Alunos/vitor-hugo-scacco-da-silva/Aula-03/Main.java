import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Venda {
        int quantidade;
        double precoUnitario, valorTotal, desconto;

        public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Venda> vendas = new ArrayList<>();

        while (true) {
            System.out.println("\n[1] Calcular e Registrar Venda");
            System.out.println("[2] Calcular Troco");
            System.out.println("[3] Exibir Vendas");
            System.out.println("[4] Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                System.out.print("Preço Unitário: ");
                double precoUnitario = scanner.nextDouble();
                double valorTotal = quantidade * precoUnitario;
                double desconto = quantidade > 10 ? valorTotal * 0.05 : 0;
                valorTotal -= desconto;

                System.out.println("Valor Total: R$ " + valorTotal);
                if (desconto > 0) System.out.println("Desconto: R$ " + desconto);

                vendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
            } else if (opcao == 2) {
                System.out.print("Valor Pago: ");
                double pago = scanner.nextDouble();
                System.out.print("Valor Total: ");
                double total = scanner.nextDouble();
                System.out.println("Troco: R$ " + (pago - total));
            } else if (opcao == 3) {
                for (Venda v : vendas) {
                    System.out.printf("Qtd: %d, Preço: R$ %.2f, Total: R$ %.2f, Desconto: R$ %.2f\n",
                            v.quantidade, v.precoUnitario, v.valorTotal, v.desconto);
                }
            } else if (opcao == 4) {
                break;
            }
        }

        scanner.close();
    }
}

