package gerenciamento_empresa;

public class Funcionario {

	 protected String nome;
	    protected int idade;
	    protected String loja;
	    protected Endereco endereco;
	    protected double salarioBase;
	    protected double[] salarioRecebido;

	    public Funcionario(String nome, int idade, String loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
	        this.nome = nome;
	        this.idade = idade;
	        this.loja = loja;
	        this.endereco = endereco;
	        this.salarioBase = salarioBase;
	        this.salarioRecebido = salarioRecebido;
	    }

	    public double calcularBonus() {
	        return 0.0;
	    }
}
