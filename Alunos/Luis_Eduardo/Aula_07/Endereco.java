package gabrielinha;

public class Endereco {
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numero;
    String complemento;

    public void apresentarLogradouro(){
        System.out.println("Estado: "+estado+"\nCidade: "+cidade+
        "\nBairro: "+bairro+"\nRua: "+rua+"\nNumero: "+numero+"\nComplemento: "+complemento);
    }
}
