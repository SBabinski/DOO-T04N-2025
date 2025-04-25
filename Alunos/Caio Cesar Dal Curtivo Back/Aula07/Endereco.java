package Aula07;
public class Endereco {
    String estado, cidade, bairro, numero, complemento;

    Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    void apresentarLogradouro() {
        System.out.println("Endereço: " + estado + ", " + cidade + ", " + bairro + ", " + numero + ", " + complemento);
}
}
