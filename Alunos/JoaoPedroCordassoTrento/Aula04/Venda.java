package aula04;

public class Venda {
	
	private int qtdaPlantas;
	private double precoPlanta;
	private double desconto;
	private double precoTotal;
	private int mesVenda;
	private int diaVenda;
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
	public int getMesVenda() {
		return mesVenda;
	}
	public void setMesVenda(int mesVenda) {
		this.mesVenda = mesVenda;
	}
	public int getDiaVenda() {
		return diaVenda;
	}
	public Venda(int qtdaPlantas, double precoPlanta, double desconto, double precoTotal, int mesVenda, int diaVenda) {
		super();
		this.qtdaPlantas = qtdaPlantas;
		this.precoPlanta = precoPlanta;
		this.desconto = desconto;
		this.precoTotal = precoTotal;
		this.mesVenda = mesVenda;
		this.diaVenda = diaVenda;
	}
	public Venda() {
		super();
	}
	@Override
	public String toString() {
		return "Venda [Quantidade de Plantas = " + qtdaPlantas + ", Preço da Planta = R$" + precoPlanta + ", Desconto = " + desconto
				+ "%, Preço Total = R$" + precoTotal + ", Data da Venda = " + diaVenda + "/" + mesVenda + "]";
	}
	
	

}
