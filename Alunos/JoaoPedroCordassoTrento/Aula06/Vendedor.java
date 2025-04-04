package classes;

import java.util.Arrays;

public class Vendedor {
    private int idLojaVendedor;
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private double salarioRecebido[] = new double[3];

    public int getidLojaVendedor() {
        return idLojaVendedor;
    }
    public void setidLojaVendedor(int idLojaVendedor) {
        this.idLojaVendedor = idLojaVendedor;
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
    public Vendedor() {
        super();
    }
    public Vendedor(int idLojaVendedor, String nome, int idade, Loja loja, String cidade, String bairro,
                    String rua, double salarioBase, double[] salarioRecebido) {
        this.idLojaVendedor = idLojaVendedor;
        this.nome = nome; 
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }
    @Override
    public String toString() {
        return "Id Loja: " + getidLojaVendedor() + 
           ", Nome: " + getNome() + 
           ", Idade: " + getIdade() + 
           ", Loja: " + loja.getNomeFantasia() + 
           ", Cidade: " + getCidade() + 
           ", Bairro: " + getBairro() + 
           ", Rua: " + getRua() + 
           ", Salário Base: " + getSalarioBase() + 
           ", Salário Recebido: " + Arrays.toString(getSalarioRecebido());
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " tenho " + idade + " anos de idade e trabalho na loja " + loja.getNomeFantasia());
    }
    public double calcularBonus() {
        double bonus = getSalarioBase() * 0.2;
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