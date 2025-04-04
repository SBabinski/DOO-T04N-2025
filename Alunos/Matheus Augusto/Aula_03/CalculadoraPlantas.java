import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double valorVenda;
    private double descontoAplicado;

    public Venda(int quantidade, double precoUnitario) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorVenda = calcularPrecoTotal();
        this.descontoAplicado = calcularDesconto();
    }

    private double calcularPrecoTotal() {
        return quantidade * precoUnitario;
    }

    private double calcularDesconto() {
        if (quantidade > 10) {
            return valorVenda * 0.05;
        }
        return 0;
    }

    public double getPrecoFinal() {
        return valorVenda - descontoAplicado;
    }

    @Override
    public String toString() {
        return String.format("Quantidade: %d, Preço Unitário: R$ %.2f, Valor Venda: R$ %.2f, Desconto: R$ %.2f, Preço Final: R$ %.2f",
                quantidade, precoUnitario, valorVenda, descontoAplicado, getPrecoFinal());
    }
}

class RegistroVendas {
    private List<Venda> vendas;

    public RegistroVendas() {
        vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void exibirRegistro() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("===== Registro de Vendas =====");
            for (Venda venda : vendas) {
                System.out.println(venda);
            }
        }
    }
}

public class CalculadoraPlantas {
    private static RegistroVendas registroVendas = new RegistroVendas();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("====== Calculadora - Loja de Plantas ======");
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
                    registroVendas.exibirRegistro();
                    break;
                case 4:
                    System.out.println("Obrigado por usar a calculadora da Dona Gabrielinha!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        } while (opcao != 4);

        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        Venda venda = new Venda(quantidade, precoUnitario);
        registroVendas.adicionarVenda(venda);

        System.out.printf("Preço Final: R$ %.2f%n", venda.getPrecoFinal());
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();

        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido < valorTotal) {
            System.out.println("O valor recebido é insuficiente!");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.printf("Troco a ser dado: R$ %.2f%n", troco);
        }
    }
}
