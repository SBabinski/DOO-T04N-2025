import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double desconto;
    double valorTotal;

    public Venda(int quantidade, double precoUnitario, double desconto, double valorTotal) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return String.format("Quantidade: %d | Preço Unitário: R$ %.2f | Desconto: R$ %.2f | Valor Total: R$ %.2f",
                quantidade, precoUnitario, desconto, valorTotal);
    }
}

public class CalculadoraPlantas {
    private static final List<Venda> registroVendas = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Calculadora de Vendas da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Ver Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");

            while (true) {
                try {
                    opcao = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida! Digite um número.");
                    scanner.next();
                }
            }

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
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        try {
            System.out.print("Informe a quantidade da planta: ");
            int quantidade = scanner.nextInt();

            System.out.print("Informe o preço unitário da planta: ");
            double precoUnitario = scanner.nextDouble();

            double total = quantidade * precoUnitario;
            double desconto = 0;

            if (quantidade > 10) {
                desconto = total * 0.05;
                total -= desconto;
            }

            System.out.printf("Preço total com desconto (se aplicado): R$ %.2f%n", total);
            
            registroVendas.add(new Venda(quantidade, precoUnitario, desconto, total));

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
            scanner.next();
        }
    }

    private static void calcularTroco(Scanner scanner) {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
            scanner.next();
        }
    }

    private static void exibirRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("\n=== Registro de Vendas ===");
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }
}
