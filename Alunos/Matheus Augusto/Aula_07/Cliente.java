public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, Endereco endereco) {
        super(nome, idade, endereco);
    }

    @Override
    public void apresentarse() {
        System.out.println("Meu nome é " + getNome() + " e tenho " + getIdade() + " anos.");
    }
}
