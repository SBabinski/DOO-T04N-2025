public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + estado + ", " + cidade + ", " + bairro + 
                         ", " + numero + " - " + complemento);
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }
}
