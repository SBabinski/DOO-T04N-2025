package gabrielinha;

public class Vendedor {
    String nome;
    int idade;
    int loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    double[] salariosRecebidos = new double[3];


    void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja ID: " + loja);
    }

    double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return soma / salariosRecebidos.length;
    }

    double calcularBonus() {
        return salarioBase * 0.2;
    }
}



