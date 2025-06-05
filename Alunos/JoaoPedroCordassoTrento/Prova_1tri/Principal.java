import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Funcoes funcao = new Funcoes();

        boolean menu1 = true;
        while (menu1) {
            System.out.println("[1] Eventos \n[2] Clientes \n[3] Sair \nSua escolha: ");
            int esc = scan.nextInt();

            switch (esc) {
                case 1:
                    boolean menuEventos = true;
                    while (menuEventos) {
                        System.out.println("[1] Cadastrar evento \n[2] Exibir eventos \n[3] Voltar \nSua escolha: ");
                        int esc1 = scan.nextInt();
                        switch (esc1) {
                            case 1:
                                funcao.cadastrarEvento();
                                break;
                            case 2:
                                funcao.exibirEventos();
                                break;
                            case 3:
                                menuEventos = false;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;

                case 2:
                    boolean menuClientes = true;
                    while (menuClientes) {
                        System.out.println("[1] Cadastrar cliente \n[2] Comprar ingresso \n[3] Voltar \nSua escolha: ");
                        int esc2 = scan.nextInt();
                        switch (esc2) {
                            case 1:
                                funcao.cadastrarCliente();
                                break;
                            case 2:
                                funcao.comprarIngresso();
                                break;
                            case 3:
                                menuClientes = false;
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    }
                    break;

                case 3:
                    menu1 = false;
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }

        scan.close();
    }
}
