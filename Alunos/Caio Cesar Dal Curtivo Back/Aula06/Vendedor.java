public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salariosBase;
    private double[] salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, double[] salariosRecebidos) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salariosBase = salarioBase;
        this.salariosRecebidos = salariosRecebidos;
    }

    public void printando() {
        System.out.println("Nome: "+nome+"\nIdade: "+idade+"\nLoja: "+loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return soma / salariosRecebidos.length;
    }

    public double calcularBonus() {
        return salariosBase * 0.2;
    }
}
