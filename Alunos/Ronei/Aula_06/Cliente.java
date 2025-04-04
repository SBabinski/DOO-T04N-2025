package classes;

public class Cliente {
    private int idLojaCliente;
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;

    public int getFuncoes> registroDeVendas = new ArrayList<>();

        while (menu) {
            System.out.println("[1] Calcular Preço Total \n[2] Calcular Troco \n[3] Registro de Vendas \n[4] Histórico por Mês e Dia \n[5] Sair \nSua Escolha: ");
            int esc = scan.nextInt();

            switch (esc) {
                case 1:
                    System.out.println("Quantidade de Plantas: ");
                    int qtdaPlantas = scan.nextInt();
                    System.out.println("Preço da Planta: ");
                    double precoPlanta = scan.nextDouble();
                    double precoTotal = qtdaPlantas * precoPlanta;

                    double desconto = 0;
                    if (qtdaPlantas >= 10) {
                        desconto = 5;
                        precoTotal = ((precoTotal / 100) * (100 - desconto));
                        System.out.println("Valor total: R$" + precoTotal);
                    } else {
                        System.out.println("Valor total: R$" + precoTotal);
                    }
                    Funcoes venda = new Funcoes(qtdaPlantas, precoPlanta, desconto, precoTotal);
                    registroDeVendas.add(venda);
                    break;

                case 2:
                    System.out.println("Qual o valor total: ");
                    double preco = scan.nextDouble();
                    System.out.println("Qual o valor recebido: ");
                    double recebido = scan.nextDouble();
                    System.out.println("R$" + (recebido - preco) + " de troco");
                    break;

                case 3:
                    // Exibe o histórico completo de vendas
                    for (Funcoes venda2 : registroDeVendas) {
                        System.out.println(venda2);
                    }
                    break;

                case 4:
                    // Histórico filtrado por mês e dia
                    System.out.println("Digite o mês para filtrar: ");
                    int mesFiltro = scan.nextInt();
                    System.out.println("Digite o dia para filtrar: ");
                    int diaFiltro = scan.nextInt();

                    System.out.println("Vendas no mês " + mesFiltro + " e dia " + diaFiltro + ":");
                    boolean encontrou = false;
                    for (Funcoes
        this.bairro = bairro;
        this.rua = rua;
    }
    @Override
    public String toString() {
        return "Id Loja: " + getidLojaCliente() + 
           ", Nome: " + getNome() + 
           ", Idade: " + getIdade() + 
           ", Loja: " + loja.getNomeFantasia() +
           ", Cidade: " + getCidade() + 
           ", Bairro: " + getBairro() + 
           ", Rua: " + getRua();
    }

    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos de idade");
    }

}