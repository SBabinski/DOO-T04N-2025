import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double valorTotal;
    double desconto;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Preço Unitário: R$ " + String.format("%.2f", precoUnitario) +
               ", Valor Total: R$ " + String.format("%.2f", valorTotal) + ", Desconto: R$ " + String.format("%.2f", desconto);
    }
}

public class CalculadoraVendas {
    private static final double DESCONTO_ESPECIAL = 0.05;
    private static final List<Venda> registroVendas = new ArrayList<>();

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        double precoTotal = quantidade * precoUnitario;
        double desconto = 0.0;
        
        if (quantidade > 10) {
            desconto = precoTotal * DESCONTO_ESPECIAL;
            precoTotal -= desconto;
        }
        
        registrarVenda(quantidade, precoUnitario, precoTotal, desconto);
        return precoTotal;
    }

    public static double calcularTroco(double valorPago, double valorTotal) {
        return valorPago - valorTotal;
    }

    public static void registrarVenda(int quantidade, double precoUnitario, double valorTotal, double desconto) {
        registroVendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
    }

    public static void exibirRegistroVendas() {
        System.out.println("\nRegistro de Vendas:");
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada até o momento.");
        } else {
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite a quantidade de plantas: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, insira um número inteiro válido.");
                        scanner.next();
                    }
                    int quantidade = scanner.nextInt();

                    System.out.print("Digite o preço unitário da planta: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, insira um valor numérico válido.");
                        scanner.next();
                    }
                    double precoUnitario = scanner.nextDouble();

                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.printf("O preço total da compra, com descontos aplicados, é: R$ %.2f\n", precoTotal);
                    break;

                case 2:
                    System.out.print("Digite o valor pago pelo cliente: R$ ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, insira um valor numérico válido.");
                        scanner.next();
                    }
                    double valorPago = scanner.nextDouble();

                    System.out.print("Digite o valor total da compra: R$ ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, insira um valor numérico válido.");
                        scanner.next();
                    }
                    double valorTotalCompra = scanner.nextDouble();

                    if (valorPago >= valorTotalCompra) {
                        double troco = calcularTroco(valorPago, valorTotalCompra);
                        System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
                    } else {
                        System.out.println("Valor insuficiente. O cliente precisa pagar o valor total da compra.");
                    }
                    break;

                case 3:
                    exibirRegistroVendas();
                    break;

                case 4:
                    System.out.println("Saindo do programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
