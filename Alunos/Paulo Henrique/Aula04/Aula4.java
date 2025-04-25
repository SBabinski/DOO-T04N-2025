import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Aula4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Calculadora da Dona Gabrielinha ===");
            System.out.println("1. Calcular valor da compra");
            System.out.println("2. Consultar vendas registradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Calculadora.executar();
                    break;
                case 2:
                    RegistroVendas.consultarVendas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}

class Venda {
    private int quantidade;
    private double precoUnitario;
    private double valorTotal;
    private double desconto;

    public Venda(int quantidade, double precoUnitario) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        double subtotal = quantidade * precoUnitario;
        desconto = (quantidade > 10) ? subtotal * 0.05 : 0;
        valorTotal = subtotal - desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    @Override
    public String toString() {
        return "Quantidade: " + quantidade +
               ", Preço Unitário: R$" + precoUnitario +
               ", Desconto: R$" + desconto +
               ", Valor Total: R$" + valorTotal;
    }

    public String toCsv() {
        return quantidade + "," + precoUnitario + "," + desconto + "," + valorTotal;
    }
}

class RegistroVendas {
    private static final String ARQUIVO_VENDAS = "vendas.csv";

    public static void registrarVenda(Venda venda) {
        try (FileWriter fw = new FileWriter(ARQUIVO_VENDAS, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(venda.toCsv());
            System.out.println("Venda registrada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao registrar venda: " + e.getMessage());
        }
    }

    public static void consultarVendas() {
        try {
            File file = new File(ARQUIVO_VENDAS);
            if (!file.exists()) {
                System.out.println("Nenhuma venda registrada ainda.");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            List<Venda> vendas = new ArrayList<>();

            while (fileScanner.hasNextLine()) {
                String linha = fileScanner.nextLine();
                String[] dados = linha.split(",");
                int quantidade = Integer.parseInt(dados[0]);
                double precoUnitario = Double.parseDouble(dados[1]);
                double desconto = Double.parseDouble(dados[2]);
                double valorTotal = Double.parseDouble(dados[3]);

                Venda venda = new Venda(quantidade, precoUnitario);
                System.out.println(venda);
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao consultar as vendas: " + e.getMessage());
        }
    }
}

class Calculadora {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de plantas compradas: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();

        Venda venda = new Venda(quantidade, precoUnitario);
        System.out.println("\nResumo da Compra:");
        System.out.println(venda);

        RegistroVendas.registrarVenda(venda);
    }
}
