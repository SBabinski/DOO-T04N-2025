package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedidos {

	private Integer id;
	private Date dataCriacao;
	private Date dataPagamento;
	private Date dataVencimentoReserva;
	
	Clientes cliente;
	Vendedor vendedor;
	Loja loja;
	ArrayList<Item> itens = new ArrayList<>();
	
	public Pedidos() {
		
	}
	
	public Pedidos(Integer id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Clientes cliente,
			Vendedor vendedor, Loja loja, List<Item> itens) {
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.dataPagamento = dataPagamento;
		this.dataVencimentoReserva = dataVencimentoReserva;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.loja = loja;
		this.itens = new ArrayList<>(itens);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimentoReserva() {
		return dataVencimentoReserva;
	}

	public void setDataVencimentoReserva(Date dataVencimentoReserva) {
		this.dataVencimentoReserva = dataVencimentoReserva;
	}

	public double calcularValorTotal() {
	    double total = 0;
	    for (Item item : itens) {
	        total += item.getValor();
	    }
	    return total;
	}

	public String gerarDescricaoVenda() {
	    return "Data de criação: " + dataCriacao + "\nValor total: R$ " + calcularValorTotal();
	}

	
}
