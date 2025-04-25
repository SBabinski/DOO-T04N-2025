package fag;

import java.util.*;

class Venda {
    int quantidade;
    double precoUnitario;
    double total;
    double desconto;
    String data;

    public Venda(int quantidade, double precoUnitario, double total, double desconto, String data) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.total = total;
        this.desconto = desconto;
        this.data = data;
    }
}

public class Aula4 {
    private static final Map<String, List<Venda>> registroVendas = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Exibir Registro de Vendas");
            System.out.println("[3] - Calcular Troco");
            System.out.println("[4] - Buscar Vendas por Data");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    exibirRegistroVendas();
                    break;
                case 3:
                    calcularTroco(scanner);
                    break;
                case 4:
                    buscarVendasPorData(scanner);
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
    
    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Digite a data da venda (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        
        double total = quantidade * precoUnitario;
        double desconto = 0;
        
        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
        }
        
        Venda venda = new Venda(quantidade, precoUnitario, total, desconto, data);
        registroVendas.computeIfAbsent(data, k -> new ArrayList<>()).add(venda);
        
        System.out.printf("O preço total da compra é: R$ %.2f\n", total);
        if (desconto > 0) {
            System.out.printf("Desconto aplicado: R$ %.2f\n", desconto);
        }
    }
    
    public static void exibirRegistroVendas() {
        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
            return;
        }
        
        System.out.println("\n=== Registro de Vendas ===");
        for (String data : registroVendas.keySet()) {
            System.out.println("Data: " + data);
            for (Venda venda : registroVendas.get(data)) {
                System.out.printf("Quantidade: %d, Preço Unitário: R$ %.2f, Total: R$ %.2f, Desconto: R$ %.2f\n",
                        venda.quantidade, venda.precoUnitario, venda.total, venda.desconto);
            }
        }
    }
    
    public static void buscarVendasPorData(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Digite a data para busca (dd/MM/yyyy): ");
        String data = scanner.nextLine();
        
        if (!registroVendas.containsKey(data)) {
            System.out.println("Nenhuma venda encontrada para essa data.");
            return;
        }
        
        System.out.println("\n=== Vendas do dia " + data + " ===");
        for (Venda venda : registroVendas.get(data)) {
            System.out.printf("Quantidade: %d, Preço Unitário: R$ %.2f, Total: R$ %.2f, Desconto: R$ %.2f\n",
                    venda.quantidade, venda.precoUnitario, venda.total, venda.desconto);
        }
    }
    
    public static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();
        
        if (valorRecebido < valorTotal) {
            System.out.println("Valor insuficiente! O cliente precisa pagar mais.");
        } else {
            double troco = valorRecebido - valorTotal;
            System.out.printf("O troco a ser dado é: R$ %.2f\n", troco);
        }
    }
}
