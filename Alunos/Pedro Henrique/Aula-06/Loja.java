package grande_loja;

public class Loja {
	   String nomeFantasia;
	    String razaoSocial;
	    String cnpj;
	    String cidade;
	    String bairro;
	    String rua;

	    Vendedor[] vendedores;
	    Cliente[] clientes;

	    public int contarClientes() {
	        return clientes != null ? clientes.length : 0;
	    }

	    public int contarVendedores() {
	        return vendedores != null ? vendedores.length : 0;
	    }

	    public void apresentarse() {
	        System.out.println("Nome Fantasia: " + nomeFantasia);
	        System.out.println("CNPJ: " + cnpj);
	        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
	    }
}
