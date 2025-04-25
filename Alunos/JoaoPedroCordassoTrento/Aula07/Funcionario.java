import java.util.Arrays;

public class Funcionario {
    private int idLojaFuncionario;
    private String nome;
    private int idade;
    private Loja loja;
    private Endereco endereco;
    private double salarioBase;
    private double salarioRecebido[] = new double[3];

    public int getidLojaFuncionario() {
        return idLojaFuncionario;
    }
    public void setidLojaFuncionario(int idLojaFuncionario) {
        this.idLojaFuncionario = idLojaFuncionario;
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
    public Loja getLoja() {
        return loja;
    }
    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }
    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }
    public Funcionario() {
        super();
    }
    public Funcionario(int idLojaFuncionario, String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        this.idLojaFuncionario = idLojaFuncionario;
        this.nome = nome; 
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }
    @Override
    public String toString() {
        return "Id Loja: " + getidLojaFuncionario() + 
           ", Nome: " + getNome() + 
           ", Idade: " + getIdade() + 
           ", Loja: " + loja.getNomeFantasia() + 
           ", Endereco: " + getEndereco() +  
           ", Salário Base: " + getSalarioBase() + 
           ", Salário Recebido: " + Arrays.toString(getSalarioRecebido());
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " tenho " + idade + " anos de idade e trabalho na loja " + loja.getNomeFantasia());
    }
    public double calcularBonus() {
        double bonus = getSalarioBase();
        return bonus;
    }
    public double calcularMedia() {
        double media = 0;
        for(int i=0; i<3; i++) {
            media += salarioRecebido[i];
        }
        media = media / 3;
        return media;
    }

}