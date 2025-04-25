package gabrielinha;

public class Cliente {
    String nome;
    int idade;
    Endereco endereco;

    public void apresentarse(){
        System.out.println("Olá, meu nome é "+nome+" e tenho "+idade+" anos.");
        if(endereco != null){   //se o endereço não foi adicionado
            endereco.apresentarLogradouro();
        }
        System.out.println();
    }
}
