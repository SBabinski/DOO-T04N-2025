package entities;
 
 public class Vendas {
 	private int quantidade;
 	private double valorTotal;
 	private double descontoAplicado;
 	
 	
 	public Vendas(int quantidade, double valorTotal, double descontoAplicado) {
 		this.quantidade = quantidade;
 		this.valorTotal = valorTotal;
 		this.descontoAplicado = descontoAplicado;
 	}
 
 
 	@Override
 	public String toString() {
 		return "Quantidade: " + quantidade + "\nValor total: " + valorTotal + "\nDesconto aplicado: "
 				+ descontoAplicado;
 	}
 	
 	
 	
 }