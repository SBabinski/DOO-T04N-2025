import java.util.HashMap;
import java.util.Map;

class Venda {
    private int idVenda;
    private double valor;

    public Venda(int idVenda, double valor) {
        this.idVenda = idVenda;
        this.valor = valor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public double getValor() {
        return valor;
    }
}

class SistemaVendas {
  
    private Map<String, Integer> vendasPorDia;
 
    private Map<String, Integer> vendasPorMes;

    public SistemaVendas() {
        vendasPorDia = new HashMap<>();
        vendasPorMes = new HashMap<>();
    }

    public void salvarVenda(String data, Venda venda) {
 
        vendasPorDia.put(data, vendasPorDia.getOrDefault(data, 0) + 1);

        String mesAno = data.substring(0, 7); 
        vendasPorMes.put(mesAno, vendasPorMes.getOrDefault(mesAno, 0) + 1);
    }

    public int consultarVendasDia(String data) {
        return vendasPorDia.getOrDefault(data, 0);
    }

    public int consultarVendasMes(String mesAno) {
        return vendasPorMes.getOrDefault(mesAno, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaVendas sistema = new SistemaVendas();

        sistema.salvarVenda("2025-03-21", new Venda(1, 100.0));
        sistema.salvarVenda("2025-03-21", new Venda(2, 150.0));
        sistema.salvarVenda("2025-03-22", new Venda(3, 200.0));
        sistema.salvarVenda("2025-03-22", new Venda(4, 250.0));
        sistema.salvarVenda("2025-03-22", new Venda(5, 300.0));

        System.out.println("Vendas do dia 2025-03-21: " + sistema.consultarVendasDia("2025-03-21"));
        System.out.println("Vendas do mês 2025-03: " + sistema.consultarVendasMes("2025-03"));
    }
}
