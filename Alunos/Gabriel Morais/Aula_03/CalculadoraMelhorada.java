package fag;
import java.util.Scanner;

public class CalculadoraMelhorada {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String historicoVendas = "";

        int opcao;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Exibir Histórico de Vendas");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {        
                case 1:
                    calcularPrecoTotal(sc);
                    break;

                case 2:
                    calcularTroco(sc);
                    break;

                case 3:
                    historicoVendas += registrarVenda(sc) + "\n";
                    break;

                case 4:
                    exibirHistoricoVendas(historicoVendas);
                    break;

                case 5:
                    System.out.println("Encerrando.");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (opcao != 5);

        sc.close();
    }

    public static void calcularPrecoTotal(Scanner sc) {
        System.out.println("Digite a quantidade de plantas: ");
        int totalPlantas = sc.nextInt();

        System.out.println("Valor unitário de cada planta: ");
        double valorUn = sc.nextDouble();

        double valorTotal = totalPlantas * valorUn;
        if (totalPlantas > 10) {
            valorTotal *= 0.95;
            System.out.printf("Desconto aplicado! Novo valor total: R$ %.2f\n", valorTotal);
        } else {
            System.out.printf("O valor total da compra é de: R$ %.2f\n", valorTotal);
        }
    }

    public static void calcularTroco(Scanner sc) {
        System.out.println("Valor a pagar: ");
        double valorPagar = sc.nextDouble();

        System.out.println("Valor pago pelo cliente: ");
        double valorPago = sc.nextDouble();

        double troco = valorPago - valorPagar;

        if (troco < 0) {
            System.out.println("Valor insuficiente, faltam R$ " + Math.abs(troco));
        } else {
            System.out.printf("O troco é: R$ %.2f\n", troco);
        }
    }

    public static String registrarVenda(Scanner sc) {
        System.out.println("Digite a quantidade de plantas vendidas: ");
        int quantidade = sc.nextInt();

        System.out.println("Digite o preço unitário de cada planta: ");
        double precoUnitario = sc.nextDouble();

        double valorTotal = quantidade * precoUnitario;
        if (quantidade > 10) {
            valorTotal *= 0.95;
        }

        return "Venda registrada: " + quantidade + " plantas, valor total: R$ " + valorTotal;
    }

    public static void exibirHistoricoVendas(String historicoVendas) {
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("\nHistórico de Vendas:");
            System.out.println(historicoVendas);
        }
    }
}
