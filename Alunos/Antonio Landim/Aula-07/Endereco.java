package entities;

public class Endereco {
	
	private String estado;
	private String cidade;
	private String bairro;
	private Integer numero;
	private String complemento;
	
	public Endereco() {
		
	}

	public Endereco(String estado, String cidade, String bairro, Integer numero, String complemento) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String apresentarLogradouro() {
		return "Estado: " + estado 
				+ " Cidade: " + cidade 
				+ " Bairro: " + bairro 
				+ " Número: " + numero 
				+ " Complemento: " + complemento;
	}
	
}
