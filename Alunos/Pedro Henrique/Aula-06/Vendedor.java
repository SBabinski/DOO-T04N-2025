package grande_loja;

public class Vendedor {
	  String nome;
	    int idade;
	    String loja;
	    String cidade;
	    String bairro;
	    String rua;
	    double salarioBase;
	    double[] salarioRecebido = {2000.0, 2100.0, 2200.0};

	    public void apresentarse() {
	        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
	    }

	    public double calcularMedia() {
	        double soma = 0;
	        for (double salario : salarioRecebido) {
	            soma += salario;
	        }
	        return soma / salarioRecebido.length;
	    }

	    public double calcularBonus() {
	        return salarioBase * 0.2;
	    }
}
