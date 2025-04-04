package loja.de.plantas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double valorFinal;
    private boolean descontoAplicado;
    private int dia;
    private int mes;

    public Venda(int quantidade, double precoUnitario, double valorFinal, boolean descontoAplicado, int dia, int mes) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.valorFinal = valorFinal;
        this.descontoAplicado = descontoAplicado;
        this.dia = dia;
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade + " | Preço Unitário: R$ " + String.format("%.2f", precoUnitario) +
               " | Valor Final: R$ " + String.format("%.2f", valorFinal) +
               " | Desconto Aplicado: " + (descontoAplicado ? "Sim" : "Não") +
               " | Data: " + dia + "/" + mes;
    }
}

public class CalculadoraLojaDePlantas {
    private static final double DESCONTO = 0.05;
    private static List<Venda> registroVendas = new ArrayList<>();
    private static Map<String, Integer> vendasPorData = new HashMap<>();
    private static Map<Integer, Integer> vendasPorMes = new HashMap<>(); // Mapa para vendas por mês

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registro de Vendas");
            System.out.println("[4] - Buscar Vendas por Mês e Dia");
            System.out.println("[5] - Buscar Vendas por Mês");
            System.out.println("[6] - Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirRegistroDeVendas();
                    break;
                case 4:
                    buscarVendasPorData(scanner);
                    break;
                case 5:
                    buscarVendasPorMes(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
        
        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        System.out.print("Digite o dia da venda: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês da venda: ");
        int mes = scanner.nextInt();
        
        double valorTotal = quantidade * precoUnitario;
        boolean descontoAplicado = false;
        
        if (quantidade > 10) {
            double desconto = valorTotal * DESCONTO;
            valorTotal -= desconto;
            descontoAplicado = true;
            System.out.printf("Desconto de 5%% aplicado! Valor final: R$ %.2f\n", valorTotal);
        } else {
            System.out.printf("Preço total da venda: R$ %.2f\n", valorTotal);
        }

        
        Venda novaVenda = new Venda(quantidade, precoUnitario, valorTotal, descontoAplicado, dia, mes);
        registroVendas.add(novaVenda);

        
        String chaveData = mes + "/" + dia;
        vendasPorData.put(chaveData, vendasPorData.getOrDefault(chaveData, 0) + quantidade);

        
        vendasPorMes.put(mes, vendasPorMes.getOrDefault(mes, 0) + quantidade);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido pelo cliente: R$ ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: R$ ");
        double valorTotal = scanner.nextDouble();
        
        if (valorRecebido >= valorTotal) {
            double troco = valorRecebido - valorTotal;
            System.out.printf("O troco a ser dado ao cliente é: R$ %.2f\n", troco);
        } else {
            System.out.println("O valor recebido é insuficiente para cobrir a compra.");
        }
    }

    private static void exibirRegistroDeVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("\n--- Registro de Vendas ---");
            for (Venda venda : registroVendas) {
                System.out.println(venda);
            }
        }
    }

    private static void buscarVendasPorData(Scanner scanner) {
        System.out.print("Digite o mês que deseja buscar (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o dia que deseja buscar (1-31): ");
        int dia = scanner.nextInt();

        String chaveData = mes + "/" + dia;
        int totalVendas = vendasPorData.getOrDefault(chaveData, 0);
        System.out.println("Quantidade total de vendas em " + dia + "/" + mes + ": " + totalVendas);
    }

    private static void buscarVendasPorMes(Scanner scanner) {
        System.out.print("Digite o mês que deseja buscar (1-12): ");
        int mes = scanner.nextInt();

        int totalVendasNoMes = vendasPorMes.getOrDefault(mes, 0);
        System.out.println("Quantidade total de vendas no mês " + mes + ": " + totalVendasNoMes);
    }
}
