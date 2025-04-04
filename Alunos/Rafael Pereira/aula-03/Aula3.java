package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    int quantidade;
    double precoUnitario;
    double total;
    double desconto;

    public Venda(int quantidade, double precoUnitario, double total, double desconto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.total = total;
        this.desconto = desconto;
    }
}

public class Aula3 {
    private static final List<Venda> registroVendas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Exibir Registro de Vendas");
            System.out.println("[3] - Calcular Troco");
            System.out.println("[4] - Sair");
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
                    System.out.println("Saindo... Obrigado por usar a calculadora!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
        
        scanner.close();
    }
    
    public static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade da planta: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        
        double total = quantidade * precoUnitario;
        double desconto = 0;
        
        if (quantidade > 10) {
            desconto = total * 0.05;
            total -= desconto;
        }
        
        registroVendas.add(new Venda(quantidade, precoUnitario, total, desconto));
        
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
        for (int i = 0; i < registroVendas.size(); i++) {
            Venda venda = registroVendas.get(i);
            System.out.printf("Venda %d - Quantidade: %d, Preço Unitário: R$ %.2f, Total: R$ %.2f, Desconto: R$ %.2f\n",
                    i + 1, venda.quantidade, venda.precoUnitario, venda.total, venda.desconto);
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
