

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RegistroVendas {

    private List<Venda> vendas = new ArrayList<>();
    private Map<Integer, Map<Integer, Integer>> vendasPorDiaMes;

    public RegistroVendas() {
        this.vendas = new ArrayList<>();
        this.vendasPorDiaMes = new HashMap<>();
    }


    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void salvarVendasPorDiaMes(int mes, int dia, int quantidade) {
        vendasPorDiaMes.computeIfAbsent(mes, k -> new HashMap<>()).put(dia, quantidade);
    }

    public int buscarVendasPorMesDia(int mes, int dia) {
        return vendasPorDiaMes.getOrDefault(mes, Collections.emptyMap()).getOrDefault(dia, 0);
    }

    public void exibirRegistroVendas() {
        System.out.println("Registro de Vendas:");
        for (int i = 0; i < vendas.size(); i++) {
            System.out.println("Venda " + (i + 1) + ": " + vendas.get(i));
        }
    }
}
