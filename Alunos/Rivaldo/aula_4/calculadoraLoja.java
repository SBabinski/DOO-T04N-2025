import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Integer> vendasDiarias = new HashMap<>();
    private static Map<String, Integer> vendasMensais = new HashMap<>();

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        return quantidade * precoUnitario;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static double aplicarDesconto(double precoTotal, int quantidade) {
        if (quantidade > 10) {
            return precoTotal * 0.95;  
        }
        return precoTotal;
    }

    public static void registrarVenda(int quantidade, double precoUnitario, double precoTotal, double precoComDesconto, String data) {
        System.out.println("\nRegistro de Venda:");
        System.out.println("Quantidade de plantas: " + quantidade);
        System.out.println("Preço unitário: R$ " + precoUnitario);
        System.out.println("Preço total: R$ " + precoTotal);
        if (quantidade > 10) {
            System.out.println("Desconto aplicado de 5%!");
            System.out.println("Preço com desconto: R$ " + precoComDesconto);
        }

        vendasDiarias.put(data, vendasDiarias.getOrDefault(data, 0) + quantidade);

        String mes = data.substring(0, 7); 
        vendasMensais.put(mes, vendasMensais.getOrDefault(mes, 0) + quantidade);
    }

    public static void buscarVendasDia(String data) {
        int vendasDia = vendasDiarias.getOrDefault(data, 0);
        System.out.println("Quantidade de vendas no dia " + data + ": " + vendasDia);
    }

    public static void buscarVendasMes(String mes) {
        int vendasMes = vendasMensais.getOrDefault(mes, 0);
        System.out.println("Quantidade de vendas no mês " + mes + ": " + vendasMes);
    }

    public static void main(String[] args) {
        boolean trigger = true;
        int quantidade;
        double precoUnitario, valorRecebido;
        String data;
        Scanner scann = new Scanner(System.in);
        
        while (trigger) {
            System.out.println("\n[1] - Calcular Preco Total\n[2] - Calcular Troco\n[3] - Registrar Venda\n[4] - Buscar Vendas por Dia\n[5] - Buscar Vendas por Mês\n[6] - Sair");
            System.out.print("Sua escolha: ");
            int option = scann.nextInt();
            
            switch (option) {
                case 1:
                    System.out.println("Iremos calcular o preço total");
                    System.out.print("Quantidade de plantas: ");
                    quantidade = scann.nextInt();
                    System.out.print("Preço da planta: ");
                    precoUnitario = scann.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    precoTotal = aplicarDesconto(precoTotal, quantidade);
                    System.out.println("Preço Total (com ou sem desconto): R$ " + precoTotal);
                    break;
                
                case 2:
                    System.out.println("Iremos calcular o troco");
                    System.out.print("Quanto recebeu: ");
                    valorRecebido = scann.nextDouble();
                    System.out.print("Valor da compra: ");
                    precoUnitario = scann.nextDouble();
                    double troco = calcularTroco(valorRecebido, precoUnitario);
                    System.out.println("Troco: R$ " + troco);
                    break;

                case 3:
                    System.out.println("Iremos registrar a venda");
                    System.out.print("Quantidade de plantas: ");
                    quantidade = scann.nextInt();
                    System.out.print("Preço da planta: ");
                    precoUnitario = scann.nextDouble();
                    System.out.print("Data da venda (formato YYYY-MM-DD): ");
                    data = scann.next();
                    double precoTotalVenda = calcularPrecoTotal(quantidade, precoUnitario);
                    double precoComDesconto = aplicarDesconto(precoTotalVenda, quantidade);
                    registrarVenda(quantidade, precoUnitario, precoTotalVenda, precoComDesconto, data);
                    break;

                case 4:
                    System.out.print("Digite a data do dia para buscar vendas (formato YYYY-MM-DD): ");
                    data = scann.next();
                    buscarVendasDia(data);
                    break;

                case 5:
                    System.out.print("Digite o mês para buscar vendas (formato YYYY-MM): ");
                    String mes = scann.next();
                    buscarVendasMes(mes);
                    break;

                case 6:
                    trigger = false;
                    break;
            }
        }
        scann.close();
    }
}
