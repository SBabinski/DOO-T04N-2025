package Aula_07;

public class Endereço {


	    String estado;
	    String cidade;
	    String bairro;
	    String numero;
	    String complemento;

	    public Endereço (String estado, String cidade, String bairro, String numero, String complemento) {
	        this.estado = estado;
	        this.cidade = cidade;
	        this.bairro = bairro;
	        this.numero = numero;
	        this.complemento = complemento;
	    }

	    public void apresentarLogradouro() {
	        System.out.println("Endereço: " + ruaCompleta());
	    }

	    private String ruaCompleta() {
	        return bairro + ", " + numero + " - " + complemento + ", " + cidade + " - " + estado;
	    }
	}
