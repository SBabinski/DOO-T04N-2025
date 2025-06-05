public class Endereco {
    public String estado;
    public String cidade;
    public String bairro;
    public Integer numero;
    public String complemento;

    public Endereco(String estado, String cidade, String bairro, Integer numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço completo:");
        System.out.println(ruaFormatada());
    }
    
    public String ruaFormatada() {
        return String.format("%s, Nº %s - %s\n%s - %s",
            bairro, numero, complemento, cidade, estado);
    }
    
}
