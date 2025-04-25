public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco() {
        super();
    }
    public Endereco(String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
    @Override
    public String toString() {
        return "Estado: " + getEstado() + 
           ", Cidade: " + getCidade() + 
           ", Bairro: " + getBairro() + 
           ", Rua: " + getRua() +
           ", Numero: " + getNumero() +
           ", Complemento: " + getComplemento();
    }

    public String apresentarLogradouro() {
        return "Eu sou do estado " + getEstado() +
        ", moro na cidade " + getCidade() + 
        ", no bairro " + getBairro() +
        " na rua " + getRua() + 
        " numero " + getNumero() + 
        ", " + getComplemento();
    }
}
