import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("==========MENU=========");
            System.out.println("1. Calcular preço total");
            System.out.println("2. Calcular troco");
            System.out.println("3. Exibir registro de vendas");
            System.out.println("4. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de plantas: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.println("O preço total da compra ficou em: R$ " + precoTotal);
                    break;

                case 2:
                    System.out.print("Digite o valor recebido: R$ ");
                    double valorCliente = scanner.nextDouble();
                    System.out.print("Digite o valor da compra: R$ ");
                    double valorTotal = scanner.nextDouble();
                    double troco = calcularTroco(valorCliente, valorTotal);
                    if (troco < 0) {
                        System.out.println("O valor recebido não é suficiente para realizar a compra");
                    } else {
                        System.out.println("O troco do cliente é: R$ " + troco);
                    }
                    break;

                case 3:
                    exibirRegistroVendas();
                    break;

                case 4:
                    System.out.println("Fechando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        double precoTotal = quantidade * precoUnitario;

        if (quantidade > 10) {
            double desconto = precoTotal * 0.05;
            precoTotal -= desconto;
            registrarVenda(quantidade, precoUnitario, precoTotal, desconto);
        } else {
            registrarVenda(quantidade, precoUnitario, precoTotal, 0);
        }
        return precoTotal;
    }

    public static void registrarVenda(int quantidade, double precoUnitario, double precoTotal, double desconto) {
        Venda venda = new Venda(quantidade, precoUnitario, precoTotal, desconto);
        registroVendas.add(venda);
    }

    public static double calcularTroco(double valorRecebido, double valorCompra) {
        return valorRecebido - valorCompra;
    }

    public static void exibirRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Registro de Vendas:");
            for (Venda venda : registroVendas) {
                System.out.println("Quantidade: " + venda.getQuantidade() + " | Preço Unitário: R$ " + venda.getPrecoUnitario()
                        + " | Valor Total: R$ " + venda.getPrecoTotal() + " | Desconto Aplicado: R$ " + venda.getDesconto());
            }
        }
    }
}

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;
    private double desconto;

    public Venda(int quantidade, double precoUnitario, double precoTotal, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public double getDesconto() {
        return desconto;
    }
}


