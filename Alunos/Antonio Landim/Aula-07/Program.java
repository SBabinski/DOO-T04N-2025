package application;

import entities.Clientes;
import entities.Endereco;
import entities.Loja;
import entities.Vendedor;

public class Program {

    public static void main(String[] args) {

        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Centro", 123, "Sala 2");
        Loja loja = new Loja("Tech Store", "Tech Store Ltda", "12.345.678/0001-99", enderecoLoja);

        Endereco enderecoVendedor = new Endereco("PR", "Cascavel", "Pioneiros", 45, "Ap 101");
        Vendedor vendedor = new Vendedor("João", 30, loja, 3000.0, enderecoVendedor);
        vendedor.adicionarSalario(3100.0);
        vendedor.adicionarSalario(2900.0);
        vendedor.adicionarSalario(3050.0);

        Endereco enderecoCliente = new Endereco("PR", "Cascavel", "São Cristóvão", 88, "Casa");
        Clientes cliente = new Clientes("Maria", 25, enderecoCliente);

        loja.adicionarVendedor(vendedor);
        loja.adicionarCliente(cliente);

        System.out.println("===== VENDEDOR =====");
        vendedor.apresentarse();
        System.out.printf("Média salarial: R$ %.2f ", vendedor.calcularMedia());
        System.out.println("");
        System.out.println("Bônus: R$ " + vendedor.calcularBonus());

        System.out.println("\n===== CLIENTE =====");
        cliente.apresentarse();

        System.out.println("\n===== LOJA =====");
        loja.apresentarse();
        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());
    }
}

