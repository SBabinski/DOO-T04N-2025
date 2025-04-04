public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("Caio Back", 19, "BACK´S Eletro", "Cascavel", "Centro", "Avenida Brasil", 5000, new double[]{6000, 7000, 8000});
        Cliente cliente = new Cliente("João", 18, "Cascavel", "Centro", "Souza Naves");
        
        Vendedor[] vendedores = {vendedor};
        Cliente[] clientes = {cliente};
        
        Loja loja = new Loja("Bruno Eletro", "Bruno Eletro LTDA", "01.234.567/8901-23", "Cascavel", "Centro", "Marechal", vendedores, clientes);
        
        vendedor.printando();
        System.out.println("Média salarial: " + vendedor.calcularMedia());
        System.out.println("Bonificação: " + vendedor.calcularBonus());
        
        cliente.printando();
        
        loja.printando();

        System.out.println("Quantidade de clientes: " + loja.contarClientes());
        System.out.println("Quantidade de vendedores: " + loja.contarVendedores());
    }
}
