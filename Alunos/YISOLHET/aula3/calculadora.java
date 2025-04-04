import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraVenda {

    // Classe interna para armazenar as informações de uma venda
    static class Venda {
        int quantidade;
        double precoUnitario;
        double precoTotal;
        double desconto;
        double valorFinal;

        public Venda(int quantidade, double precoUnitario, double precoTotal, double desconto, double valorFinal) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.precoTotal = precoTotal;
            this.desconto = desconto;
            this.valorFinal = valorFinal;
        }

        @Override
        public String toString() {
            return "Quantidade: " + quantidade + ", Preço Total: R$ " + precoTotal + ", Desconto: R$ " + desconto
                    + ", Valor Final: R$ " + valorFinal;
        }
    }

    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibindo o menu
            System.out.println("==== Calculadora de Vendas ====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Histórico de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirHistoricoVendas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    // Método para calcular o preço total, com possível desconto
    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: R$ ");
        double precoUnitario = scanner.nextDouble();
        
        double precoTotal = quantidade * precoUnitario;

        // Aplicando desconto de 5% se a quantidade for maior que 10
        double desconto = 0;
        if (quantidade > 10) {
            desconto = precoTotal * 0.05; // 5% de desconto
            precoTotal -= desconto;
        }

        // Armazenando os dados da venda
        Venda venda = new Venda(quantidade, precoUnitario, precoTotal, desconto, precoTotal);
        registroVendas.add(venda);

        System.out.printf("Preço total sem desconto: R$ %.2f\n", quantidade * precoUnitario);
        System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
        System.out.printf("Valor a pagar após desconto: R$ %.2f\n", precoTotal);
    }

    // Método para calcular o troco
    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: R$ ");
        double valorPago = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: R$ ");
        double valorTotal = scanner.nextDouble();

        if (valorPago >= valorTotal) {
            double troco = valorPago - valorTotal;
            System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
        } else {
            System.out.println("O valor pago é insuficiente para cobrir a compra.");
        }
    }

    // Método para exibir o histórico de vendas
    private static void exibirHistoricoVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Histórico de Vendas:");
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }
}
