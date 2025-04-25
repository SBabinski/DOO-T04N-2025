public class Endereco {
    private String cidade;
    private String bairro;
    private String rua;

    public Endereco(String cidade, String bairro, String rua) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public String apresentarLogradouro() {
        return rua + ", " + bairro + ", " + cidade;
    }
}
