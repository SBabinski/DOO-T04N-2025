import java.util.*;

class Venda {
    int quantidade;
    double precoUnitario;
    double desconto;
    double valorTotal;
    String data; // Formato "DD/MM"

    public Venda(int quantidade, double precoUnitario, double desconto, double valorTotal, String data) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Data: %s | Quantidade: %d | Preço Unitário: R$ %.2f | Desconto: R$ %.2f | Valor Total: R$ %.2f",
                data, quantidade, precoUnitario, desconto, valorTotal);
    }
}

public class CalculadoraPlantas {
    private static final List<Venda> registroVendas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== Calculadora de Vendas da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Ver Registro de Vendas");
            System.out.println("[4] - Buscar Vendas por Data");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");

            while (true) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir quebra de linha
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida! Digite um número.");
                    scanner.next();
                }
            }

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
                    buscarVendasPorData();
                    break;
                case 5:
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void calcularPrecoTotal() {
        try {
            System.out.print("Informe a quantidade da planta: ");
            int quantidade = scanner.nextInt();
            
            System.out.print("Informe o preço unitário da planta: ");
            double precoUnitario = scanner.nextDouble();

            scanner.nextLine(); // Consumir quebra de linha
            System.out.print("Informe a data da venda (DD/MM): ");
            String data = scanner.nextLine();

            double total = quantidade * precoUnitario;
            double desconto = (quantidade > 10) ? total * 0.05 : 0;
            total -= desconto;

            System.out.printf("Preço total com desconto (se aplicado): R$ %.2f%n", total);
            
            registroVendas.add(new Venda(quantidade, precoUnitario, desconto, total, data));

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
            scanner.next();
        }
    }

    private static void calcularTroco() {
        try {
            System.out.print("Informe o valor recebido do cliente: ");
            double valorRecebido = scanner.nextDouble();

            System.out.print("Informe o valor total da compra: ");
            double valorTotal = scanner.nextDouble();

            if (valorRecebido < valorTotal) {
                System.out.println("Valor recebido insuficiente!");
            } else {
                System.out.printf("Troco a ser dado: R$ %.2f%n", (valorRecebido - valorTotal));
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

    private static void buscarVendasPorData() {
        System.out.print("Informe a data para buscar vendas (DD/MM): ");
        String dataBuscada = scanner.nextLine();
        
        List<Venda> vendasFiltradas = new ArrayList<>();
        int totalVendas = 0;

        for (Venda venda : registroVendas) {
            if (venda.data.equals(dataBuscada)) {
                vendasFiltradas.add(venda);
                totalVendas += venda.quantidade;
            }
        }

        if (vendasFiltradas.isEmpty()) {
            System.out.println("Nenhuma venda encontrada para a data " + dataBuscada);
        } else {
            System.out.println("\n=== Vendas do dia " + dataBuscada + " ===");
            for (Venda venda : vendasFiltradas) {
                System.out.println(venda);
            }
            System.out.println("Total de plantas vendidas no dia: " + totalVendas);
        }
    }
}
