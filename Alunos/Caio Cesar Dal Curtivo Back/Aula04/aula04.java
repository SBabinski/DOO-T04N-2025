import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class aula04 {
    Scanner scan = new Scanner(System.in);
    List<String> vendasDiarias = new ArrayList<>();
    List<String> historicoVendas = new ArrayList<>();

    public double calcPreco() {
        System.out.println("Digite a quantidade de plantas a serem compradas:");
        int qnt = scan.nextInt();
        System.out.println("Digite quanto custa cada planta:");
        double preco = scan.nextDouble();

        double total;
        double desconto = 0;
        if (qnt > 10) {
            desconto = (preco * qnt) * 0.05;
            total = (preco * qnt) - desconto;
        } else {
            total = preco * qnt;
        }

        registrarVenda(qnt, preco, desconto, total);

        return total;
    }

    public double troco() {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scan.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorCompra = scan.nextDouble();
        return valorRecebido - valorCompra;
    }

    public void registrarVenda(int quantidade, double preco, double desconto, double total) {
        System.out.print("Digite o dia da venda (DD): ");
        String dia = scan.next();
        System.out.print("Digite o mês da venda (MM): ");
        String mes = scan.next();

        String data = dia + "/" + mes;
        vendasDiarias.add(data + " | Qtd: " + quantidade);

        String registro = "Qtd: " + quantidade + " | Preço Unitário: " + preco +
                " | Desconto: " + desconto + " | Total: " + total + " | Data: " + data;
        historicoVendas.add(registro);

        System.out.println("Venda registrada com sucesso!");
    }

    public void mostrarHistoricoVendas() {
        System.out.println("\n=== Histórico de Vendas ===");
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada ainda.");
        } else {
            for (String venda : historicoVendas) {
                System.out.println(venda);
            }
        }
    }

    public void buscarVendasPorData() {
        System.out.print("Digite o dia da venda (DD): ");
        String dia = scan.next();
        System.out.print("Digite o mês da venda (MM): ");
        String mes = scan.next();

        String dataBusca = dia + "/" + mes;
        int totalVendas = 0;

        for (String venda : vendasDiarias) {
            if (venda.startsWith(dataBusca)) {
                String[] detalhes = venda.split("\\|");
                String qtdStr = detalhes[1].trim().split(":")[1].trim();
                totalVendas += Integer.parseInt(qtdStr);
            }
        }

        System.out.println("Total de vendas em " + dataBusca + ": " + totalVendas + " unidades.");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        aula04 sistema = new aula04();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Mostrar Histórico de Vendas");
            System.out.println("[4] - Buscar Vendas por Data");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    double total = sistema.calcPreco();
                    System.out.println("Total a pagar: R$" + total);
                    break;
                case 2:
                    double troco = sistema.troco();
                    System.out.println("Troco: R$" + troco);
                    break;
                case 3:
                    sistema.mostrarHistoricoVendas();
                    break;
                case 4:
                    sistema.buscarVendasPorData();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
