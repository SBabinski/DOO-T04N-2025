package sistemamyplant;

public class SistemaPrincipal {
    public static void main(String[] args) {
        LojaMyPlant loja = new LojaMyPlant("My Plant", "My Plant LTDA", "12.345.678/0001-90", "Floripa", "Centro", "Rua das Flores");

        FuncionarioMyPlant vendedor1 = new FuncionarioMyPlant("Lucas", 28, "My Plant", "Floripa", "Centro", "Rua das Violetas", 1800);
        FuncionarioMyPlant vendedor2 = new FuncionarioMyPlant("Marina", 32, "My Plant", "Floripa", "Trindade", "Rua dos Lírios", 2000);
        loja.adicionarFuncionario(vendedor1);
        loja.adicionarFuncionario(vendedor2);

        ClienteMyPlant cliente1 = new ClienteMyPlant("João", 45, "Floripa", "Estreito", "Rua das Begônias");
        ClienteMyPlant cliente2 = new ClienteMyPlant("Clara", 22, "São José", "Campinas", "Rua das Rosas");
        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);

        loja.apresentarse();

        System.out.println("\n--- Funcionários ---");
        vendedor1.apresentarse();
        System.out.println("Média Salarial: R$" + vendedor1.calcularMedia());
        System.out.println("Bônus: R$" + vendedor1.calcularBonus());

        System.out.println();

        vendedor2.apresentarse();
        System.out.println("Média Salarial: R$" + vendedor2.calcularMedia());
        System.out.println("Bônus: R$" + vendedor2.calcularBonus());

        System.out.println("\n--- Clientes ---");
        cliente1.apresentarse();
        cliente2.apresentarse();

        System.out.println("\nTotal de Funcionários: " + loja.contarFuncionarios());
        System.out.println("Total de Clientes: " + loja.contarClientes());
    }
}
