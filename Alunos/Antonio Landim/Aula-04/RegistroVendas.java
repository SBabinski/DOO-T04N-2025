package entities;

public class RegistroVendas {
	
	private Integer dia;
	private Integer mes;
	private Integer quantidadeVendas;
	
	

	public RegistroVendas(Integer dia, Integer mes) {
		this.dia = dia;
		this.mes = mes;
	}

	public RegistroVendas(Integer dia, Integer mes, Integer quantidadeVendas) {
		this.dia = dia;
		this.mes = mes;
		this.quantidadeVendas = quantidadeVendas;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public void setQuantidadeVendas(Integer quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}
	
	
	
	
}
