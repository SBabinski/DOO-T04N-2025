import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraPlantas2 {
    private static List<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirRelatorioVendas();
                    break;
                case 4:
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    // Exibir Menu
    private static void exibirMenu() {
        System.out.println("\n=== Calculadora de Vendas da Dona Gabrielinha ===");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Relatório de Vendas");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Ler opção do usuário
    private static int lerOpcao(Scanner scanner) {
        return scanner.nextInt();
    }

    // Calcular o preço total, com desconto, e registrar a venda
    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Informe a quantidade da planta: ");
        int quantidade = scanner.nextInt();

        System.out.print("Informe o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double total = quantidade * precoUnitario;

        // Verificar se há desconto
        double desconto = 0.0;
        if (quantidade > 10) {
            desconto = total * 0.05;  // Aplicar 5% de desconto no valor total
            total -= desconto;
            System.out.printf("Desconto aplicado: R$ %.2f%n", desconto);
        }

        // Exibir o preço final após o desconto (se houver)
        System.out.printf("Preço total a pagar: R$ %.2f%n", total);

        // Registrar a venda
        vendas.add(new Venda(quantidade, precoUnitario, total, desconto));
    }

    // Calcular troco e verificar se o valor recebido é suficiente
    private static void calcularTroco(Scanner scanner) {
        System.out.print("Informe o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Informe o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido < valorTotal) {
            System.out.println("Valor recebido insuficiente!");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.printf("Troco a ser dado: R$ %.2f%n", troco);
        }
    }

    // Exibir o relatório de vendas realizadas
    private static void exibirRelatorioVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            System.out.println("\n=== Relatório de Vendas ===");
            for (Venda venda : vendas) {
                System.out.printf("Quantidade: %d | Preço Unitário: R$ %.2f | Total: R$ %.2f | Desconto: R$ %.2f%n",
                        venda.getQuantidade(),
                        venda.getPrecoUnitario(),
                        venda.getValorTotal(),
                        venda.getDesconto());
            }
        }
    }

    // Classe para armazenar informações sobre a venda
    private static class Venda {
        private int quantidade;
        private double precoUnitario;
        private double valorTotal;
        private double desconto;

        public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public double getValorTotal() {
            return valorTotal;
        }

        public double getDesconto() {
            return desconto;
        }
    }
}
