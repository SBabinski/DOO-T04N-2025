import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraPlantas4 {
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
                case 5:
                    consultarVendasPorDia(scanner);
                    break;
                case 6:
                    consultarVendasPorMes(scanner);
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

    private static void exibirMenu() {
        System.out.println("\n=== Calculadora de Vendas da Dona Gabrielinha ===");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Relatório de Vendas");
        System.out.println("[5] - Consultar Vendas por Dia");
        System.out.println("[6] - Consultar Vendas por Mês");
        System.out.println("[4] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Informe a quantidade da planta: ");
        int quantidade = scanner.nextInt();

        System.out.print("Informe o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        System.out.print("Informe o dia da venda (1-31): ");
        int dia = scanner.nextInt();

        System.out.print("Informe o mês da venda (1-12): ");
        int mes = scanner.nextInt();

        double total = quantidade * precoUnitario;

        double desconto = 0.0;
        if (quantidade > 10) {
            desconto = total * 0.05;  
            total -= desconto;
            System.out.printf("Desconto aplicado: R$ %.2f%n", desconto);
        }

        System.out.printf("Preço total a pagar: R$ %.2f%n", total);

        vendas.add(new Venda(quantidade, precoUnitario, total, desconto, dia, mes));
    }

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

    private static void exibirRelatorioVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            System.out.println("\n=== Relatório de Vendas ===");
            for (Venda venda : vendas) {
                System.out.printf("Quantidade: %d | Preço Unitário: R$ %.2f | Total: R$ %.2f | Desconto: R$ %.2f | Data: %02d/%02d%n",
                        venda.getQuantidade(),
                        venda.getPrecoUnitario(),
                        venda.getValorTotal(),
                        venda.getDesconto(),
                        venda.getDia(),
                        venda.getMes());
            }
        }
    }

    private static void consultarVendasPorDia(Scanner scanner) {
        System.out.print("Informe o dia (1-31) para consultar as vendas: ");
        int dia = scanner.nextInt();

        int totalVendas = 0;
        double totalValor = 0.0;
        
        for (Venda venda : vendas) {
            if (venda.getDia() == dia) {
                totalVendas += venda.getQuantidade();
                totalValor += venda.getValorTotal();
            }
        }
        
        System.out.printf("Total de vendas no dia %02d: %d unidades | Total: R$ %.2f%n", dia, totalVendas, totalValor);
    }

    private static void consultarVendasPorMes(Scanner scanner) {
        System.out.print("Informe o mês (1-12) para consultar as vendas: ");
        int mes = scanner.nextInt();

        int totalVendas = 0;
        double totalValor = 0.0;
        
        for (Venda venda : vendas) {
            if (venda.getMes() == mes) {
                totalVendas += venda.getQuantidade();
                totalValor += venda.getValorTotal();
            }
        }
        
        System.out.printf("Total de vendas no mês %02d: %d unidades | Total: R$ %.2f%n", mes, totalVendas, totalValor);
    }

    private static class Venda {
        private int quantidade;
        private double precoUnitario;
        private double valorTotal;
        private double desconto;
        private int dia;
        private int mes;

        public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, int dia, int mes) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.valorTotal = valorTotal;
            this.desconto = desconto;
            this.dia = dia;
            this.mes = mes;
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

        public int getDia() {
            return dia;
        }

        public int getMes() {
            return mes;
        }
    }
}
