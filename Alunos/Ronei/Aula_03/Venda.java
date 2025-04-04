package aula03;

public class Venda {
	
	private int qtdaPlantas;
	private double precoPlanta;
	private double desconto;
	private double precoTotal;
	public int getQtdaPlantas() {
		return qtdaPlantas;
	}
	public void setQtdaPlantas(int qtdaPlantas) {
		this.qtdaPlantas = qtdaPlantas;
	}
	public double getPrecoPlanta() {
		return precoPlanta;
	}
	public void setPrecoPlanta(double precoPlanta) {
		this.precoPlanta = precoPlanta;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public Venda(int qtdaPlantas, double precoPlanta, double desconto, double precoTotal) {
		super();
		this.qtdaPlantas = qtdaPlantas;
		this.precoPlanta = precoPlanta;
		this.desconto = desconto;
		this.precoTotal = precoTotal;
	}
	public Venda() {
		super();
	}
	@Override
	public String toString() {
		return "Venda [Quantidade de Plantas = " + qtdaPlantas + ", Preço da Planta = R$" + precoPlanta + ", Desconto = " + desconto
				+ "%, Preço Total = R$" + precoTotal + "]";
	}
	
	

}