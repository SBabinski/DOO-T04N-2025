import java.util.*;

class Venda {
    int quantidade;
    double precoUnitario;
    double valorTotal;
    double desconto;
    int dia;
    int mes;

    public Venda(int quantidade, double precoUnitario, double valorTotal, double desconto, int dia, int mes) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.dia = dia;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Dia: " + dia + "/" + mes + ", Quantidade: " + quantidade + ", Preço Unitário: " + precoUnitario + ", Valor Total: " + valorTotal + ", Desconto: " + desconto;
    }
}

public class CalculadoraPlantas {
    private static final double DESCONTO_ESPECIAL = 0.05;
    private static List<Venda> registroVendas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    exibirRegistroVendas();
                    break;
                case 4:
                    buscarVendasPorDiaEMes();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("\n--- Calculadora Dona Gabrielinha ---");
        System.out.println("[1] - Calcular Preço Total");
        System.out.println("[2] - Calcular Troco");
        System.out.println("[3] - Exibir Registro de Vendas");
        System.out.println("[4] - Buscar Vendas por Dia e Mês");
        System.out.println("[5] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void calcularPrecoTotal() {
        System.out.print("Digite o dia da venda: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês da venda: ");
        int mes = scanner.nextInt();
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário: ");
        double precoUnitario = scanner.nextDouble();

        double valorTotal = quantidade * precoUnitario;
        double desconto = 0.0;
        if (quantidade > 10) {
            desconto = valorTotal * DESCONTO_ESPECIAL;
            valorTotal -= desconto;
        }

        System.out.println("Valor total: R$ " + valorTotal);
        registroVendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto, dia, mes));
    }

    private static void calcularTroco() {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();

        if (valorRecebido < valorTotal) {
            System.out.println("Valor insuficiente!");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.println("Troco: R$ " + troco);
        }
    }

    private static void exibirRegistroVendas() {
        System.out.println("\n--- Registro de Vendas ---");
        for (Venda venda : registroVendas) {
            System.out.println(venda);
        }
    }

    private static void buscarVendasPorDiaEMes() {
        System.out.print("Digite o dia para buscar: ");
        int diaBusca = scanner.nextInt();
        System.out.print("Digite o mês para buscar: ");
        int mesBusca = scanner.nextInt();

        int totalVendas = 0;
        for (Venda venda : registroVendas) {
            if (venda.dia == diaBusca && venda.mes == mesBusca) {
                totalVendas += venda.quantidade;
            }
        }
        System.out.println("Total de vendas no dia " + diaBusca + "/" + mesBusca + ": " + totalVendas);
    }
}
