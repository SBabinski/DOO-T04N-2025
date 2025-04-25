package entities;

public class Cliente {
	private String nome;
	private int idade;
	private String cidade;
	private String bairro;
	private String rua;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String apresentarse() {
		return "Nome: " + nome + "Idade: " + idade;
	}
	
	
	
}
