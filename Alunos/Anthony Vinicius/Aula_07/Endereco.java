package sistemamyplant;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;

 
    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

   
    public void apresentarLogradouro() {
        System.out.println(cidade + ", " + bairro + ", nº " + numero + " - " + complemento + " - " + estado);
    }

   
    public String toString() {
        return cidade + ", " + bairro + ", nº " + numero + " - " + complemento + " - " + estado;
    }

 
    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
