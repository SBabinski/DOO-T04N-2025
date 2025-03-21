import java.util.*;

public class CalculadoraVenda {

    // Classe interna para armazenar as informações de uma venda
    static class Venda {
        int quantidade;
        double precoUnitario;
        double precoTotal;
        double desconto;
        double valorFinal;
        String dataVenda;

        public Venda(int quantidade, double precoUnitario, double precoTotal, double desconto, double valorFinal, String dataVenda) {
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
            this.precoTotal = precoTotal;
            this.desconto = desconto;
            this.valorFinal = valorFinal;
            this.dataVenda = dataVenda;
        }

        @Override
        public String toString() {
            return "Data: " + dataVenda + ", Quantidade: " + quantidade + ", Preço Total: R$ " + precoTotal + ", Desconto: R$ " + desconto
                    + ", Valor Final: R$ " + valorFinal;
        }
    }

    // Mapas para registrar as vendas por dia e mês
    private static Map<String, Integer> vendasPorDia = new HashMap<>(); // chave = data (formato: dd/MM/yyyy)
    private static Map<String, Integer> vendasPorMes = new HashMap<>(); // chave = mês (formato: MM/yyyy)
    private static List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibindo o menu
            System.out.println("==== Calculadora de Vendas ====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Histórico de Vendas");
            System.out.println("[4] - Registrar Venda por Dia");
            System.out.println("[5] - Consultar Vendas por Dia");
            System.out.println("[6] - Consultar Vendas por Mês");
            System.out.println("[7] - Sair");
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
                    exibirHistoricoVendas();
                    break;
                case 4:
                    registrarVendaPorDia(scanner);
                    break;
                case 5:
                    consultarVendasPorDia(scanner);
                    break;
                case 6:
                    consultarVendasPorMes(scanner);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 7);

        scanner.close();
    }

    // Método para calcular o preço total, com possível desconto
    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: R$ ");
        double precoUnitario = scanner.nextDouble();

        double precoTotal = quantidade * precoUnitario;

        // Aplicando desconto de 5% se a quantidade for maior que 10
        double desconto = 0;
        if (quantidade > 10) {
            desconto = precoTotal * 0.05; // 5% de desconto
            precoTotal -= desconto;
        }

        // Armazenando os dados da venda
        String dataVenda = obterDataVenda();
        Venda venda = new Venda(quantidade, precoUnitario, precoTotal, desconto, precoTotal, dataVenda);
        registroVendas.add(venda);

        // Atualizando as vendas diárias e mensais
        atualizarVendasPorDia(dataVenda);
        atualizarVendasPorMes(dataVenda);

        System.out.printf("Preço total sem desconto: R$ %.2f\n", quantidade * precoUnitario);
        System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
        System.out.printf("Valor a pagar após desconto: R$ %.2f\n", precoTotal);
    }

    // Método para atualizar as vendas por dia
    private static void atualizarVendasPorDia(String dataVenda) {
        vendasPorDia.put(dataVenda, vendasPorDia.getOrDefault(dataVenda, 0) + 1);
    }

    // Método para atualizar as vendas por mês
    private static void atualizarVendasPorMes(String dataVenda) {
        String mes = dataVenda.substring(3); // pegando "MM/yyyy"
        vendasPorMes.put(mes, vendasPorMes.getOrDefault(mes, 0) + 1);
    }

    // Método para consultar as vendas por dia
    private static void consultarVendasPorDia(Scanner scanner) {
        System.out.print("Digite a data (dd/MM/yyyy): ");
        String data = scanner.next();

        Integer vendasDia = vendasPorDia.get(data);
        if (vendasDia == null) {
            System.out.println("Nenhuma venda registrada para este dia.");
        } else {
            System.out.println("Vendas no dia " + data + ": " + vendasDia);
        }
    }

    // Método para consultar as vendas por mês
    private static void consultarVendasPorMes(Scanner scanner) {
        System.out.print("Digite o mês (MM/yyyy): ");
        String mes = scanner.next();

        Integer vendasMes = vendasPorMes.get(mes);
        if (vendasMes == null) {
            System.out.println("Nenhuma venda registrada para este mês.");
        } else {
            System.out.println("Vendas no mês " + mes + ": " + vendasMes);
        }
    }

    // Método para obter a data da venda (no formato dd/MM/yyyy)
    private static String obterDataVenda() {
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1; // Meses começam de 0
        int ano = calendar.get(Calendar.YEAR);

        return String.format("%02d/%02d/%d", dia, mes, ano);
    }

    // Método para calcular o troco
    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: R$ ");
        double valorPago = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: R$ ");
        double valorTotal = scanner.nextDouble();

        if (valorPago >= valorTotal) {
            double troco = valorPago - valorTotal;
            System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
        } else {
            System.out.println("O valor pago é insuficiente para cobrir a compra.");
        }
    }

    // Método para exibir o histórico de vendas
    private static void exibirHistoricoVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Histórico de Vendas:");
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }
}
