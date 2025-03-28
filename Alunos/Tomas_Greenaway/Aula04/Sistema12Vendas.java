import java.util.Scanner;

public class Sistema12Vendas {

    private static int[] vendasDiarias = new int[31];
    private static int[] vendasPorMes = new int[12];
    
    public static void salvarVendas(String data, int quantidade) {
        String[] partesData = data.split("/");
        int dia = Integer.parseInt(partesData[0]) - 1;
        int mes = Integer.parseInt(partesData[1]) - 1;
        
        vendasDiarias[dia] += quantidade;
        vendasPorMes[mes] += quantidade;
    }

    public static int buscarVendasPorDia(String data) {
        String[] partesData = data.split("/");
        int dia = Integer.parseInt(partesData[0]) - 1;
        return vendasDiarias[dia];
    }

    public static int buscarVendasPorMes(int mes) {
        return vendasPorMes[mes - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Perguntar ao usuário quantas vendas foram feitas
        System.out.print("Digite a data (dd/MM/yyyy) para registrar as vendas: ");
        String data = scanner.nextLine();
        
        System.out.print("Quantas vendas foram feitas nesse dia? ");
        int quantidadeVendas = scanner.nextInt();
        
        // Salvar as vendas
        salvarVendas(data, quantidadeVendas);
        
        // Consultar as vendas do dia informado
        System.out.println("Vendas em " + data + ": " + buscarVendasPorDia(data));
        
        // Consultar vendas do mês
        String[] partesData = data.split("/");
        int mes = Integer.parseInt(partesData[1]);
        System.out.println("Vendas no mês " + mes + ": " + buscarVendasPorMes(mes));
        
        scanner.close();
    }
}
