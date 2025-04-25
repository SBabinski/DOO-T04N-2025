package sistemamyplant;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends FuncionarioMyPlant {
    private List<Double> salarioRecebido;

    public Gerente(String nome, int idade, LojaMyPlant loja, Endereco endereco, double salarioBase) {
        super(nome, idade, loja, endereco, salarioBase);
        salarioRecebido = new ArrayList<>();
        
        salarioRecebido.add(salarioBase);  
        salarioRecebido.add(salarioBase + 500);  
        salarioRecebido.add(salarioBase + 700); 
    }

    
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return arredondar(soma / salarioRecebido.size());
    }

   
    public double calcularBonus() {
        return arredondar(getSalarioBase() * 0.35);
    }

    
    public void apresentarse() {
        System.out.println("Gerente: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Loja: " + getLoja().getNomeFantasia());
        getEndereco().apresentarLogradouro();
    }

   
    public List<Double> getSalarioRecebido() {
        return salarioRecebido;
    }
}
