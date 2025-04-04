# Paradigmas de Programação: Imperativo vs. Declarativo

## Introdução
Os paradigmas de programação representam diferentes formas de estruturar e resolver problemas computacionais. Dois dos principais paradigmas são:

1. **Paradigma Imperativo**: Baseia-se na execução sequencial de instruções que modificam o estado do programa. Exemplos incluem C, Java e Python.
2. **Paradigma Declarativo**: Descreve **o que** deve ser feito em vez de **como** fazer. Exemplos incluem SQL e Prolog.

## Comparação entre Java (Imperativo) e Prolog (Declarativo)
programa que calcula a média de notas em **Java** e **Prolog**.

### Código em Java (Paradigma Imperativo)
java
import java.util.Scanner;

public class MediaAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas notas deseja inserir? ");
        int n = scanner.nextInt();
        
        double soma = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            soma += scanner.nextDouble();
        }
        
        double media = soma / n;
        System.out.println("Média das notas: " + media);
        scanner.close();
    }
}

**Explicação:**
- O programa segue uma sequência de comandos (imperativo).
- Usa um loop for para coletar as notas e calcular a soma.
- No final, divide pelo número de notas para obter a média.

### Código em Prolog (Paradigma Declarativo)
prolog
soma_lista([], 0).
soma_lista([H|T], Soma) :- soma_lista(T, SomaParcial), Soma is H + SomaParcial.

media(Lista, Media) :- 
    soma_lista(Lista, Soma),
    length(Lista, N),
    N > 0,
    Media is Soma / N.

**Explicação:**
- Em vez de definir um fluxo de execução, usamos **recursão** para somar a lista de notas.
- A regra media/2 calcula a média chamando soma_lista/2 e obtendo o tamanho da lista com length/2.
- O Prolog apenas expressa as **relações lógicas** entre os dados, sem definir como iterar sobre eles.

## Conclusão
- **Java (Imperativo)**: O programador controla explicitamente os passos e o fluxo de execução.
- **Prolog (Declarativo)**: Define relações lógicas entre os dados, sem especificar um fluxo detalhado