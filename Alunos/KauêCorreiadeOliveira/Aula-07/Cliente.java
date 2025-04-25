public class Cliente {
    public String nome;
    public Integer idade;
    public Endereco endereco;

    public Cliente(String nome, Integer idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Endereço: " + endereco.cidade + ", " + endereco.bairro);
    }
}
