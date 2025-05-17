package Aula4;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraLoja {
    private static Map<String, Integer> registroVendas = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n📊 Calculadora Dona Gabrielinha");
            System.out.println("[1] - Registrar Venda");
            System.out.println("[2] - Consultar Vendas por Dia");
            System.out.println("[3] - Consultar Vendas por Mês");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarVenda(scanner);
                    break;
                case 2:
                    consultarVendasPorDia(scanner);
                    break;
                case 3:
                    consultarVendasPorMes(scanner);
                    break;
                case 4:
                    System.out.println("Saindo... Até logo! 🌱");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void registrarVenda(Scanner scanner) {
        System.out.print("Digite o dia da venda: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês da venda: ");
        int mes = scanner.nextInt();
        System.out.print("Digite a quantidade de plantas vendidas: ");
        int quantidade = scanner.nextInt();
        
        String chave = mes + "/" + dia;
        registroVendas.put(chave, registroVendas.getOrDefault(chave, 0) + quantidade);

        System.out.println("✅ Venda registrada com sucesso!");
    }

    public static void consultarVendasPorDia(Scanner scanner) {
        System.out.print("Digite o dia da venda que deseja consultar: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês da venda que deseja consultar: ");
        int mes = scanner.nextInt();

        String chave = mes + "/" + dia;
        int vendas = registroVendas.getOrDefault(chave, 0);

        System.out.println("📅 Vendas no dia " + dia + "/" + mes + ": " + vendas + " plantas.");
    }

    public static void consultarVendasPorMes(Scanner scanner) {
        System.out.print("Digite o mês da venda que deseja consultar: ");
        int mes = scanner.nextInt();

        int totalVendas = registroVendas.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(mes + "/"))
                .mapToInt(Map.Entry::getValue).sum();

        System.out.println("📆 Total de vendas no mês " + mes + ": " + totalVendas + " plantas.");
    }
}
