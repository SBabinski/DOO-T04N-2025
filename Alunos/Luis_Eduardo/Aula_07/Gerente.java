package gabrielinha;

public class Gerente extends Funcionario{
    double[] salariosRecebidos = new double[] {4300, 4300, 4400};

    @Override
    public void apresentarse(){
        System.out.println("Olá, meu nome é "+nome+", tenho "+idade+
        " anos e sou gerente da loja "+loja);
        if(endereco != null){   //se o endereço não foi adicionado
            endereco.apresentarLogradouro();
        }
        System.out.println();
    }

    @Override
    public void calcularMedia(){
        float soma = 0;
        float media;
        for (int i = 0;i < 3;i++) {
            soma += salariosRecebidos[i];
        }
        media = (soma / 3);
        System.out.printf("A média salarial de %s é %.2f\n",nome,media);
    }

    @Override
    public float calcularBonus() {
        return salarioBase * 0.35f;
    }
}
