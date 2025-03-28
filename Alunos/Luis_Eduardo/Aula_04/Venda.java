package luis;

public class Venda {
	private int quantidade;
	private float valorTotal;
	private float desconto;
	private int mesVenda;
	private int diaVenda;

	public Venda(int quantidade, float valorTotal, float desconto, int mesVenda, int diaVenda) {
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.desconto = desconto;
		this.mesVenda = mesVenda;
		this.diaVenda = diaVenda;
	}

	public int getMesVenda() {
		return mesVenda;
	}

	public int getDiaVenda() {
		return diaVenda;
	}

	@Override
	public String toString() {
		return "Data: " + diaVenda + "/" + mesVenda +
				" | Quantidade: " + quantidade +
				" | Total: R$" + String.format("%.2f", valorTotal) +
				" | Desconto: R$" + String.format("%.2f", desconto);
	}
}
