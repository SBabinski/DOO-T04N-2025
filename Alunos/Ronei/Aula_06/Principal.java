
package principal;

import java.util.Scanner;
import classes.*;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Funcoes funcao = new Funcoes();

        boolean menu1 = true;
        while(menu1) {
            System.out.println("(Lembre de Cadastrar uma Loja Antes de Usar as Outras Funções)");
            System.out.println("[1] cadastrar loja \n[2] adicionar Vendedor \n[3] adicionar cliente \n[4] lojas \n[5] sair \nSua escolha:");
            int esc1 = scan.nextInt();

            switch(esc1) {
                case 1:
                    funcao.cadastrarLoja();
                    break;

                case 2:
                    funcao.adicionarVendedorLoja();
                    break;

                case 3:
                    funcao.adicionarClienteLoja();
                    break;

                case 4:
                    boolean menu2 = true;
                    while (menu2) {
                        System.out.println("[1] exibir lojas \n[2] analitico vendedores \n[3] analitico clientes \n[4] salarios e bonus \n[5] sair \nSua escolha:");
                        int esc2 = scan.nextInt();
                        switch(esc2) {
                            case 1:
                                funcao.exibirLojas();
                                break;

                            case 2:
                                funcao.analisarVendedores();
                                break;

                            case 3:
                                funcao.analisarClientes();
                                break;

                            case 4:
                                funcao.salariosBonus();
                                break;

                            case 5:
                                menu2 = false;
                                break;

                            default:
                                System.out.println("Opção Invalida!");
                        }
                    }
                    break;

                case 5:
                    menu1 = false;
                    break;

                default:
                    System.out.println("Opçaõ Invalida!");
            }
        }
        scan.close();
    }
}
