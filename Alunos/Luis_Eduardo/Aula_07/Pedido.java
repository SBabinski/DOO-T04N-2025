package gabrielinha;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
    int id;
    LocalDate dataCriacao;
    LocalDate dataPagamento;
    LocalDate dataVencimentoReserva;
    Cliente cliente;
    Vendedor vendedor;
    Loja loja;
    ArrayList<Item> itens = new ArrayList<>();

    public float calcularValorTotal(){
        float total = 0;
        for (Item i : itens) {
            total += i.valor;
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Data de criação: " + dataCriacao);
        System.out.println("Itens do pedido:");
        for (Item i : itens) {
            System.out.printf("- %s: R$ %.2f\n", i.nomeItem, i.valor);
        }
        System.out.printf("Valor total: R$ %.2f\n", calcularValorTotal());
    }
}
