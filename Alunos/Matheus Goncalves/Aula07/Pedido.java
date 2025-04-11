package aula07;

import java.util.Date;
import java.util.List;

public class Pedido {
	    int id;
	    Date dataCriacao, dataPagamento, dataVencimentoReserva;
	    String cliente, vendedor, loja;
	    List<Item> itens;

	    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
	                  String cliente, String vendedor, String loja, List<Item> itens) {
	        this.id = id;
	        this.dataCriacao = dataCriacao;
	        this.dataPagamento = dataPagamento;
	        this.dataVencimentoReserva = dataVencimentoReserva;
	        this.cliente = cliente;
	        this.vendedor = vendedor;
	        this.loja = loja;
	        this.itens = itens;
	    }

	    public double calcularValorTotal() {
	        return itens.stream().mapToDouble(item -> item.valor).sum();
	    }

	    public void gerarDescricaoVenda() {
	        System.out.println("Pedido criado em: " + dataCriacao + " | Valor Total: R$ " + calcularValorTotal());
	    }
	}

