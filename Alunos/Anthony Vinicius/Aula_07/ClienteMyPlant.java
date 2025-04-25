package sistemamyplant;

public class ClienteMyPlant extends Pessoa {
    public ClienteMyPlant(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}