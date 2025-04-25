package grande_loja;

public class Main {
	 public static void main(String[] args) {
	        // Criando Vendedor
	        Vendedor v1 = new Vendedor();
	        v1.nome = "João";
	        v1.idade = 30;
	        v1.loja = "My Plant Central";
	        v1.cidade = "Cidade A";
	        v1.bairro = "Centro";
	        v1.rua = "Rua das Flores";
	        v1.salarioBase = 2000.0;

	        // Criando Cliente
	        Cliente c1 = new Cliente();
	        c1.nome = "Maria";
	        c1.idade = 25;
	        c1.cidade = "Cidade A";
	        c1.bairro = "Centro";
	        c1.rua = "Rua Verde";

	        // Criando Loja
	        Loja loja = new Loja();
	        loja.nomeFantasia = "My Plant";
	        loja.razaoSocial = "My Plant Comércio LTDA";
	        loja.cnpj = "00.000.000/0001-00";
	        loja.cidade = "Cidade A";
	        loja.bairro = "Centro";
	        loja.rua = "Rua das Plantas";

	        loja.vendedores = new Vendedor[]{v1};
	        loja.clientes = new Cliente[]{c1};

	        // Testando os métodos
	        loja.apresentarse();
	        System.out.println("Total de Clientes: " + loja.contarClientes());
	        System.out.println("Total de Vendedores: " + loja.contarVendedores());

	        v1.apresentarse();
	        System.out.println("Média Salarial: R$ " + v1.calcularMedia());
	        System.out.println("Bônus: R$ " + v1.calcularBonus());

	        c1.apresentarse();
	    }
}
