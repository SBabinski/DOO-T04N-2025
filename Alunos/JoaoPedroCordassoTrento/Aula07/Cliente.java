public class Cliente {
    private int idLojaCliente;
    private String nome;
    private int idade;
    private Loja loja;
    private Endereco endereco;

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
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Cliente(int idLojaCliente, String nome, int idade, Loja loja, Endereco endereco) {
        this.idLojaCliente = idLojaCliente;
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return "Id Loja: " + getidLojaCliente() + 
           ", Nome: " + getNome() + 
           ", Idade: " + getIdade() + 
           ", Loja: " + loja.getNomeFantasia() +
           ", Endereço: " + getEndereco();
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos de idade");
    }

}