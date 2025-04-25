package Aula07;
public class Gerente {
    String nome, loja, cidade, bairro, rua;
    int idade;
    double salarioBase;
    double salarioRecebido1, salarioRecebido2, salarioRecebido3;

    Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase,
            double salarioRecebido1, double salarioRecebido2, double salarioRecebido3) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido1 = salarioRecebido1;
        this.salarioRecebido2 = salarioRecebido2;
        this.salarioRecebido3 = salarioRecebido3;
    }

    void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    double calcularMedia() {
        return (salarioRecebido1 + salarioRecebido2 + salarioRecebido3)/3;
    }

    double calcularBonus() {
        return salarioBase * 0.35;
    }
}