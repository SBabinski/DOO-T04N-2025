import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MelhoriaCalculadora2 {

    public static Scanner scanner = new Scanner(System.in);
    @SuppressWarnings("unchecked")
    static List<Vendas>[][] procurarVendas = new List[12][31]; 

    public static void main(String[] args) {
        inicializarMatriz();
        menu();
    }

    public static void inicializarMatriz() {
        for (int mes = 0; mes < 12; mes++) {
            for (int dia = 0; dia < 31; dia++) {
                procurarVendas[mes][dia] = new ArrayList<>();
            }
        }
    }

    public static void menu() {
        boolean menuEntrada = true;
        while (menuEntrada) {
            System.out.println("Qual opção deseja selecionar?\n");
            System.out.println("""
                    [1] - Calcular Preço Total 
                    [2] - Calcular Troco 
                    [3] - Registro de vendas
                    [4] - Procurar venda por data
                    [5] - Sair""");

            int valorMenu = scanner.nextInt();

            switch (valorMenu) {
                case 1 -> precoTotal();
                case 2 -> calcularTroco();
                case 3 -> registroVendas();
                case 4 -> exibirVendas();
                case 5 -> menuEntrada = false;
                default -> System.out.println("Valor inválido!");
            }
        }
    }

    public static void precoTotal() {
        System.out.println("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mês: ");
        int mes = scanner.nextInt();
        System.out.println("Entre com a quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o valor da planta: ");
        double valorPlanta = scanner.nextDouble();
        String desconto = "0%";

        if (quantidade > 10) {
            valorPlanta *= 0.95;
            desconto = "5%";
        }

        double resultado = quantidade * valorPlanta;
        Vendas venda = new Vendas(resultado, quantidade, desconto, dia, mes);

        procurarVendas[mes - 1][dia - 1].add(venda); 

        System.out.println("O valor a ser pago: " + resultado + "\n");
    }

    public static void calcularTroco() {
        System.out.println("Digite o valor do produto: ");
        double valorProduto = scanner.nextDouble();
        System.out.println("Digite o valor recebido do cliente: ");
        double valorCliente = scanner.nextDouble();

        double troco = valorCliente - valorProduto;

        System.out.println("O troco a ser devolvido: " + troco);
    }

    public static void registroVendas() {
        System.out.println("Registro de Vendas:");

        boolean vendasEncontradas = false;

        for (int mes = 0; mes < 12; mes++) {
            for (int dia = 0; dia < 31; dia++) {
                List<Vendas> vendasDoDia = procurarVendas[mes][dia];
                if (!vendasDoDia.isEmpty()) {
                    vendasEncontradas = true;
                    System.out.println("\nVendas registradas no dia " + (dia + 1) + " do mês " + (mes + 1) + ":");
                    for (Vendas venda : vendasDoDia) {
                        System.out.println("Quantidade: " + venda.quantidade);
                        System.out.println("Valor: R$ " + venda.preco);
                        System.out.println("Desconto: " + venda.desconto);
                        System.out.println("------------------");
                    }
                }
            }
        }

        if (!vendasEncontradas) {
            System.out.println("Nenhuma venda registrada.");
        }
    }

    public static void exibirVendas() {
        System.out.println("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mês: ");
        int mes = scanner.nextInt();

        List<Vendas> vendasDoDia = procurarVendas[mes - 1][dia - 1];

        if (!vendasDoDia.isEmpty()) {
            System.out.println("Vendas encontradas no dia " + dia + "/" + mes + ":");
            for (Vendas venda : vendasDoDia) {
                System.out.println("Quantidade: " + venda.quantidade);
                System.out.println("Valor: R$ " + venda.preco);
                System.out.println("Desconto: " + venda.desconto);
                System.out.println("------------------");
            }
        } else {
            System.out.println("Nenhuma venda encontrada para essa data.");
        }
    }
}
