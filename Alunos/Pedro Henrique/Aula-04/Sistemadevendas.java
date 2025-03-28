package Sistemadevendas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sistemadevendas{

    private Map<String, Double> vendasPorDia;
    private Map<String, Double> vendasPorMes;

    public Sistemadevendas() {
        vendasPorDia = new HashMap<>();
        vendasPorMes = new HashMap<>();
    }

    public void registrarVenda(String data, double valorVenda) {
        vendasPorDia.put(data, vendasPorDia.getOrDefault(data, 0.0) + valorVenda);
        String mes = data.split("/")[1];
        String chaveMes = "Mês " + mes;
        vendasPorMes.put(chaveMes, vendasPorMes.getOrDefault(chaveMes, 0.0) + valorVenda);
    }

    public double buscarVendasPorMes(String mes) {
        String chaveMes = "Mês " + mes;
        return vendasPorMes.getOrDefault(chaveMes, 0.0);
    }

    public double buscarVendasPorDia(String data) {
        return vendasPorDia.getOrDefault(data, 0.0);
    }

    public static void main(String[] args) {
    	Sistemadevendas sistema = new Sistemadevendas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("### MENU ###");
            System.out.println("1. Registrar Venda");
            System.out.println("2. Buscar Vendas por Mês");
            System.out.println("3. Buscar Vendas por Dia");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    System.out.print("Digite a data da venda (dd/mm/yyyy): ");
                    String data = scanner.next();
                    System.out.print("Digite o valor da venda: ");
                    double valorVenda = scanner.nextDouble();
                    sistema.registrarVenda(data, valorVenda);
                    System.out.println("Venda registrada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o mês (mm): ");
                    String mes = scanner.next();
                    double vendasMes = sistema.buscarVendasPorMes(mes);
                    System.out.println("Total de vendas no mês " + mes + ": " + vendasMes);
                    break;
                case 3:
                    System.out.print("Digite a data (dd/mm/yyyy): ");
                    String dia = scanner.next();
                    double vendasDia = sistema.buscarVendasPorDia(dia);
                    System.out.println("Total de vendas no dia " + dia + ": " + vendasDia);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(opcao != 4);

        scanner.close();
    }
}