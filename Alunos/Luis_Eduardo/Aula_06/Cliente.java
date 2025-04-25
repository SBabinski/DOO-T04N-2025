package gabrielinha;

public class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}