import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Venda {
    int quantidade;
    double valorVenda;
    double desconto;
    int dia;
    int mes;

    public Venda(int quantidade, double valorVenda, double desconto, int dia, int mes) {
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
        this.desconto = desconto;
        this.dia = dia;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + ", Valor Total: R$ " + valorVenda + ", Desconto: R$ " + desconto + ", Data: " + dia + "/" + mes;
    }
}

public class Main {

    static ArrayList<Venda> vendas = new ArrayList<>();
    static HashMap<String, Integer> vendasPorDia = new HashMap<>();
    static HashMap<String, Integer> vendasPorMes = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {

            System.out.println("==========MENU=========");
            System.out.println("1. Calcular preço total");
            System.out.println("2. Calcular troco");
            System.out.println("3. Registrar vendas");
            System.out.println("4. Consultar vendas");
            System.out.println("5. Sair");
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
                    System.out.println("Digite a quantidade de plantas: ");
                    int quantidadeVenda = scanner.nextInt();
                    System.out.print("Digite o preço unitário da planta: ");
                    double precoUnitarioVenda = scanner.nextDouble();
                    System.out.print("Digite o dia da venda: ");
                    int diaVenda = scanner.nextInt();
                    System.out.print("Digite o mês da venda: ");
                    int mesVenda = scanner.nextInt();

                    double valorVenda = calcularPrecoTotal(quantidadeVenda, precoUnitarioVenda);
                    double desconto = 0.0;

                    if (quantidadeVenda > 10) {
                        desconto = valorVenda * 0.05;
                        valorVenda -= desconto;
                    }

                    Venda novaVenda = new Venda(quantidadeVenda, valorVenda, desconto, diaVenda, mesVenda);
                    vendas.add(novaVenda);

                    String keyDia = diaVenda + "/" + mesVenda;
                    vendasPorDia.put(keyDia, vendasPorDia.getOrDefault(keyDia, 0) + quantidadeVenda);

                    String keyMes = mesVenda + "/" + 0;
                    vendasPorMes.put(keyMes, vendasPorMes.getOrDefault(keyMes, 0) + quantidadeVenda);

                    System.out.println("Venda registrada com sucesso!");
                    System.out.println(novaVenda);
                    break;

                case 4:
                    System.out.println("Escolha o tipo de consulta:");
                    System.out.println("1. Consultar vendas por dia");
                    System.out.println("2. Consultar vendas por mês");
                    int consulta = scanner.nextInt();

                    if (consulta == 1) {
                        System.out.print("Digite o dia da venda: ");
                        int diaConsulta = scanner.nextInt();
                        System.out.print("Digite o mês da venda: ");
                        int mesConsulta = scanner.nextInt();
                        String keyDiaConsulta = diaConsulta + "/" + mesConsulta;
                        int totalDia = vendasPorDia.getOrDefault(keyDiaConsulta, 0);
                        System.out.println("Total de vendas no dia " + diaConsulta + "/" + mesConsulta + ": " + totalDia + " plantas");
                    } else if (consulta == 2) {
                        System.out.print("Digite o mês da venda: ");
                        int mesConsulta = scanner.nextInt();
                        String keyMesConsulta = mesConsulta + "/" + 0;
                        int totalMes = vendasPorMes.getOrDefault(keyMesConsulta, 0);
                        System.out.println("Total de vendas no mês " + mesConsulta + ": " + totalMes + " plantas");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 5:
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
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorCompra) {
        return valorRecebido - valorCompra;
    }
}
