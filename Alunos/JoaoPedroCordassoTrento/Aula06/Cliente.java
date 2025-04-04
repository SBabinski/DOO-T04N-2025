package classes;

public class Cliente {
    private int idLojaCliente;
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;

    public int getidLojaCliente() {
        return idLojaCliente;
    }
    public void setidLojaCliente(int idLojaCliente) {
        this.idLojaCliente = idLojaCliente;
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
    public Cliente() {
        super();
    }
    public Cliente(int idLojaCliente, String nome, int idade, Loja loja, String cidade, String bairro, String rua) {
        this.idLojaCliente = idLojaCliente;
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }
    @Override
    public String toString() {
        return "Id Loja: " + getidLojaCliente() + 
           ", Nome: " + getNome() + 
           ", Idade: " + getIdade() + 
           ", Loja: " + loja.getNomeFantasia() +
           ", Cidade: " + getCidade() + 
           ", Bairro: " + getBairro() + 
           ", Rua: " + getRua();
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos de idade");
    }

}