import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraMelhoriasAula4 {
    // Classe interna para representar uma venda
    static class Venda {
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
    }

    // Classe interna para representar uma venda por data (dia/mês)
    static class VendaPorData {
        int mes;
        int dia;
        int quantidadeVendida;

        public VendaPorData(int mes, int dia, int quantidadeVendida) {
            this.mes = mes;
            this.dia = dia;
            this.quantidadeVendida = quantidadeVendida;
        }
    }

    // Listas para armazenar os registros
    private static List<Venda> registroVendas = new ArrayList<>();
    private static List<VendaPorData> registroVendasPorData = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibir menu
            System.out.println("=== MENU ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Visualizar Registro de Vendas");
            System.out.println("[3] - Salvar Venda por Data (Dia/Mês)");
            System.out.println("[4] - Buscar Vendas por Data (Dia/Mês)");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    visualizarRegistroVendas();
                    break;
                case 3:
                    salvarVendaPorData(scanner);
                    break;
                case 4:
                    buscarVendasPorData(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Método para calcular o preço total com desconto especial
    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        double valorTotal = quantidade * precoUnitario;
        double desconto = 0.0;

        // Aplicar desconto especial se a quantidade for maior que 10
        if (quantidade > 10) {
            desconto = valorTotal * 0.05; // 5% de desconto
            valorTotal -= desconto;
        }

        System.out.printf("O preço total é: R$ %.2f%n", valorTotal);
        if (desconto > 0) {
            System.out.printf("Desconto aplicado: R$ %.2f%n", desconto);
        }

        // Registrar a venda
        registroVendas.add(new Venda(quantidade, precoUnitario, valorTotal, desconto));
    }

    // Método para visualizar o registro de vendas
    public static void visualizarRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        System.out.println("=== REGISTRO DE VENDAS ===");
        for (int i = 0; i < registroVendas.size(); i++) {
            Venda venda = registroVendas.get(i);
            System.out.printf("Venda %d:%n", i + 1);
            System.out.printf("  Quantidade: %d%n", venda.quantidade);
            System.out.printf("  Preço Unitário: R$ %.2f%n", venda.precoUnitario);
            System.out.printf("  Valor Total: R$ %.2f%n", venda.valorTotal);
            System.out.printf("  Desconto: R$ %.2f%n", venda.desconto);
            System.out.println();
        }
    }

    // Método para salvar uma venda por data (dia/mês)
    public static void salvarVendaPorData(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidadeVendida = scanner.nextInt();

        // Validar o mês
        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido. Insira um valor entre 1 e 12.");
            return;
        }

        // Salvar a venda
        registroVendasPorData.add(new VendaPorData(mes, dia, quantidadeVendida));
        System.out.println("Venda salva com sucesso!");
    }

    // Método para buscar vendas por data (dia/mês)
    public static void buscarVendasPorData(Scanner scanner) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();

        int totalVendas = 0;
        boolean encontrou = false;

        for (VendaPorData venda : registroVendasPorData) {
            if (venda.mes == mes && venda.dia == dia) {
                totalVendas += venda.quantidadeVendida;
                encontrou = true;
            }
        }

        if (encontrou) {
            System.out.printf("Total de vendas no dia %d/%d: %d plantas.%n", dia, mes, totalVendas);
        } else {
            System.out.printf("Nenhuma venda encontrada para o dia %d/%d.%n", dia, mes);
        }
    }
}