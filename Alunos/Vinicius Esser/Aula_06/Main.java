package Aula_06;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor1 = new Vendedor("Carlos", 30, "My Plant", "Curitiba", "Centro", "Rua das Flores", 2000);
        Cliente cliente1 = new Cliente("Joana", 28, "Curitiba", "Centro", "Rua XV de Novembro");

        Vendedor[] vendedores = {vendedor1};
        Cliente[] clientes = {cliente1};

        Loja loja = new Loja("My Plant", "My Plant Ltda", "12.345.678/0001-00", "Curitiba", "Centro", "Rua Verde", vendedores, clientes);

        vendedor1.apresentarse();
        System.out.println("Média dos salários: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        cliente1.apresentarse();

        loja.apresentarse();
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());
    }
}
