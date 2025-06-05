package gerenciamento_empresa;

public class Loja {
	private String nome;
    private Endereco endereco;

    public Loja(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
}
