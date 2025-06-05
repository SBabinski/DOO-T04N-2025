package gabrielinha;

import java.util.ArrayList;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    Endereco endereco;
    ArrayList<Vendedor> listaVendedores = new ArrayList<>();
    ArrayList<Gerente> listaGerentes = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    public void apresentarse(){
        System.out.println("Nome fantasia: "+nomeFantasia+
        ".\nCnpj: "+cnpj);
        if(endereco != null){   //se o endereço não foi adicionado
            endereco.apresentarLogradouro();
        }
        System.out.println();
    }

    public void contarClientes() {
        System.out.println("Total de clientes: "+listaClientes.size());
    }

    public void contarVendedores() {
        System.out.println("Total de vendedores: "+listaVendedores.size());
    }
    
    public void contarGerentes() {
        System.out.println("Total de gerentes: "+listaGerentes.size());
    }    
}
