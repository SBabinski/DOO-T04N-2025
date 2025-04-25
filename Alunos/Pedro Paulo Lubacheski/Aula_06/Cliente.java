
public class Cliente {

    private String nome;
    private Integer idade;
    private String cidade;
    private String bairro;
    private String rua;

    public Cliente(String nome, Integer idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade + ", Bairro: " + bairro + ", Rua: " + rua;
    }

    public void apresentarse() {
        System.out.println("Olá, meu nome é " + nome + " e eu tenho " + idade + " anos.");
    }

}
