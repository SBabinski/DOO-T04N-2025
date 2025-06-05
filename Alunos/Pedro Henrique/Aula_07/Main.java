
package gerenciamento_empresa;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua A", "123", "Bairro Centro", "Cidade X", "UF");
        Loja loja = new Loja("Loja 01", endereco);

        Gerente gerente = new Gerente("Carlos", 40, loja.getNome(), endereco, 5000, new double[]{5000, 5200, 5300});
        Vendedor vendedor = new Vendedor("Ana", 30, loja.getNome(), endereco, 2500, new double[]{2500, 2600, 2700});
        Cliente cliente = new Cliente("João", 25, endereco);

        Item[] itens = {
            new Item("Camisa", 100),
            new Item("Calça", 150)
        };

        Pedido pedido = new Pedido(1, new Date(), new Date(), new Date(), cliente, vendedor, loja, itens);
        pedido.gerarDescricaoVenda();

        System.out.println("Bônus do gerente: R$" + gerente.calcularBonus());
        System.out.println("Bônus do vendedor: R$" + vendedor.calcularBonus());
    }
}