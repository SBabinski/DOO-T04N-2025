package system;

import entities.*;
import service.ProcessaPedido;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Endereco enderecoLoja = new Endereco("MG", "Belo Horizonte", "Centro", "123", "Próximo ao metrô");
        Loja loja = new Loja("My Plant", "My Plant S.A.", 123456, enderecoLoja);

        Endereco enderecoCliente = new Endereco("MG", "BH", "Savassi", "45", "Apto 302");
        Cliente cliente = new Cliente("João", 30, enderecoCliente);

        Endereco enderecoVendedor = new Endereco("MG", "BH", "Funcionários", "10", "Casa amarela");
        ArrayList<Double> salarios = new ArrayList<>(Arrays.asList(3000.0, 3100.0, 3200.0));
        Vendedor vendedor = new Vendedor("Carlos", 28, enderecoVendedor, "My Plant", 3000.0, salarios);

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Vaso", "Decoração", 50.0));
        itens.add(new Item(2, "Planta", "Natureza", 100.0));

        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = processaPedido.processar(1, new Date(), new Date(), new Date(System.currentTimeMillis() + 86400000), cliente, vendedor, loja, itens);

        if (pedido != null) {
            System.out.println(pedido.gerarDescricaoVenda());
        }
    }
}
