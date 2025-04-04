package sistemamyplant;

public class ClienteMyPlant {
    private String nome;
    private int idade;
    private String cidade;
    private String bairro;
    private String rua;

    public ClienteMyPlant(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }
}
