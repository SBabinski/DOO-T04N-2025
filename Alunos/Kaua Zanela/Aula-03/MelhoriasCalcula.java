import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
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

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + " | Preço Unitário: R$ " + precoUnitario +
               " | Valor Total: R$ " + valorTotal + " | Desconto Aplicado: R$ " + desconto;
    }
}

public class Calculadora {
    private static List<Venda> vendas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== Calculadora da Dona Gabrielinha =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Registrar e Mostrar Vendas");
            System.out.println("[3] - Calcular Troco");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    mostrarVendas();
                    break;
                case 3:
                    calcularTroco();
                    break;
                case 4:
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }

    public static void calcularPrecoTotal() {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double valorTotal = quantidade * precoUnitario;
        double desconto = 0.0;

        if (quantidade > 10) {
            desconto = valorTotal * 0.05;
            valorTotal -= desconto;
            System.out.println("Desconto de 5% aplicado!");
        }

        System.out.printf("O preço total da compra é: R$ %.2f%n", valorTotal);

        // Registrar venda
        vendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
    }

    public static void mostrarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            System.out.println("\n===== Registro de Vendas =====");
            for (Venda venda : vendas) {
                System.out.println(venda);
            }
        }
    }

    public static void calcularTroco() {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido >= valorTotal) {
            double troco = valorRecebido - valorTotal;
            System.out.printf("O troco a ser dado ao cliente é: R$ %.2f%n", troco);
        } else {
            System.out.println("O valor recebido é insuficiente para pagar a compra!");
        }
    }
}
