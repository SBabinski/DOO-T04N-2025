
import java.util.Scanner;

public class Calculadora3Melhoria {

    private static RegistroVendas registroVendas = new RegistroVendas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean menu = true;

        while (menu) {
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registro de Vendas");
            System.out.println("[4] - Salvar Vendas");
            System.out.println("[5] - Buscar Vendas");
            System.out.println("[6] - Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    calcularPrecoTotal();
                    break;
                case 2:
                    calcularTroco();
                    break;
                case 3:
                    registroVendas.exibirRegistroVendas();
                    break;
                case 4:
                    salvarVendasPorDiaMes();
                    break;
                case 5:
                    buscarVendasPorMesDia();
                    break;
                case 6:
                    menu = false;
                    break;
                default:
                    System.out.println("Erro! Digite uma opção válida!");
            }
        }
    }

    public static void calcularPrecoTotal() {
        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade de produtos: ");
        int quantidade = scanner.nextInt();

        char desconto = '0';
        if (quantidade > 10) {
            preco = preco * 0.95;
            System.out.println("Desconto de 5% aplicado!");
            desconto = '5';
        }

        double total = preco * quantidade;
        System.out.println("O preço total é: " + total);

        Venda venda = new Venda(total, quantidade, desconto);
        registroVendas.adicionarVenda(venda);
    }

    public static void calcularTroco() {
        System.out.println("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.println("Digite o valor pago: ");
        double pago = scanner.nextDouble();
        double troco = pago - valor;
        System.out.println("O troco é: " + troco);
    }

    public static void salvarVendasPorDiaMes() {
        System.out.println("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.println("Digite o dia (1-31): ");
        int dia = scanner.nextInt();
        System.out.println("Digite a quantidade de vendas: ");
        int quantidade = scanner.nextInt();

        registroVendas.salvarVendasPorDiaMes(mes, dia, quantidade);
        System.out.println("Vendas salvas com sucesso!");
    }

    public static void buscarVendasPorMesDia() {
        System.out.println("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        System.out.println("Digite o dia (1-31): ");
        int dia = scanner.nextInt();

        int vendas = registroVendas.buscarVendasPorMesDia(mes, dia);
        System.out.println("Vendas no dia " + dia + "/" + mes + ": " + vendas);
    }
}
