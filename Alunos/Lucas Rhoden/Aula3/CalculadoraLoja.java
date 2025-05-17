import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraLoja {
    private static List<String> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n📊 Calculadora Dona Gabrielinha");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
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
                    exibirRegistroVendas();
                    break;
                case 4:
                    System.out.println("Saindo... Até logo! 🌱");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;
        double desconto = (quantidade > 10) ? precoTotal * 0.05 : 0;
        double precoFinal = precoTotal - desconto;

        System.out.println("💰 Preço total da venda: R$ " + precoTotal);
        if (desconto > 0) {
            System.out.println("🎉 Desconto aplicado: R$ " + desconto);
            System.out.println("💲 Valor final com desconto: R$ " + precoFinal);
        }

        registroVendas.add("Venda: " + quantidade + " plantas | Valor: R$ " + precoTotal + " | Desconto: R$ " + desconto);
    }

    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scanner.nextDouble();

        if (valorRecebido < valorCompra) {
            System.out.println("❌ Valor insuficiente! O cliente precisa pagar mais.");
        } else {
            double troco = valorRecebido - valorCompra;
            System.out.println("💸 Troco a ser dado ao cliente: R$ " + troco);
        }
    }

    public static void exibirRegistroVendas() {
        System.out.println("\n📜 Registro de Vendas:");
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            registroVendas.forEach(System.out::println);
        }
    }
}
