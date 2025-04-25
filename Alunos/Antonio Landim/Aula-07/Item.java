package entities;

public class Item {

	private Integer id;
	private String nome;
	private String tipo;
	private Double valor;
	
	public Item() {
		
	}

	public Item(Integer id, String nome, String tipo, Double valor) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String gerarDescricao() {
		return "Id: " + id 
				+ "\nNome: " + nome 
				+ "\nTipo: " + tipo 
				+ "\nValor: " + valor;
	}
	
	
	
	
}
