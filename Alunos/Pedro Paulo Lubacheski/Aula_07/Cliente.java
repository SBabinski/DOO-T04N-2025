public class Cliente {
    private String nome;
    private Integer idade;
    private Endereco endereco;

    public Cliente(String nome, Integer idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Olá, meu nome é " + nome + " e eu tenho " + idade + " anos.");
        endereco.apresentarLogradouro();
    }
}
