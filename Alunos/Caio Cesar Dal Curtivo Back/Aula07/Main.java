package Aula07;
public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Paraná", "Cascavel", "Centro", "321", "Sobrado");
        Gerente gerente = new Gerente("Caio", 19, "My Plant", "Cascavel", "Centro", "Rua Avenida Brasil", 3000, 4000, 5000, 6000);

        gerente.apresentarse();
        System.out.println("Média de Salários: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        endereco.apresentarLogradouro();

        Item item1 = new Item(1, "Rosa", "Buquê", 100.0);
        Item item2 = new Item(2, "Cravos", "Vasos", 200.0);
        Item item3 = new Item(3, "Orquídeas", "Arranjos", 300.0);

        Pedido pedido = new Pedido(101, "2025-04-01", "2025-04-03", "2025-04-06", "João", "Pedrão", "My Plant", item1, item2, item3);

        pedido.gerarDescricaoPedido();
        pedido.gerarDescricaoItens();

        ProcessaPedido processador = new ProcessaPedido();
        processador.processar(pedido);
    }
}