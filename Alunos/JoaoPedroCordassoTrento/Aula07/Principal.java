import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Funcoes funcao = new Funcoes();

        boolean menu1 = true;
        while(menu1) {
            System.out.println("(Lembre de Cadastrar uma Loja Antes de Usar as Outras Funções)");
            System.out.println("[1] cadastrar loja\n" +
                            "[2] adicionar Vendedor\n" +
                            "[3] adicionar cliente\n" +
                            "[4] adicionar gerente\n" +
                            "[5] lojas\n" +
                            "[6] sair\n" +
                            "Sua escolha:");
                            
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
                    funcao.adicionarGerenteLoja();
                    break;

                case 5:
                    boolean menu2 = true;
                    while (menu2) {
                        System.out.println("[1] exibir lojas\n" +
                                        "[2] analitico vendedores\n" +
                                        "[3] analitico clientes\n" +
                                        "[4] analitico gerentes\n" +
                                        "[5] salarios e bonus\n" +
                                        "[6] sair\n" +
                                        "Sua escolha:");

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
                                funcao.analisarGerentes();
                                break;

                            case 5:
                                funcao.salariosBonusGerente();
                                funcao.salariosBonusVendedor();
                                break;

                            case 6:
                                menu2 = false;
                                break;

                            default:
                                System.out.println("Opção Invalida!");
                        }
                    }
                    break;

                case 6:
                    menu1 = false;
                    break;

                default:
                    System.out.println("Opção Invalida!");
            }
        }
        scan.close();
    }
}