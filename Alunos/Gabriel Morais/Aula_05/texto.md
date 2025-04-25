# Paradigmas de Programação: Imperativo vs. Declarativo

Durante a aula do dia 20/03/2025, foi apresentado dois paradigmas fundamentais da programação: o imperativo e o declarativo. Esses paradigmas influenciam a forma como escrevemos código e como pensamos na solução de problemas computacionais. O professor destacou que cada abordagem tem suas vantagens e aplicações específicas, dependendo do contexto e da necessidade do programa.

## Paradigma Imperativo

O paradigma imperativo foca na execução de uma sequência de instruções que modificam o estado do programa. Essa abordagem detalha **como** a solução deve ser implementada, utilizando comandos que manipulam diretamente variáveis e estruturas de controle como loops e condicionais.

### Exemplo em Java
```java
public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(calcularFatorial(5)); // Saída: 120
    }
}
```
Esse código segue a abordagem imperativa, onde o cálculo do fatorial ocorre através de um loop `for`. Cada iteração modifica diretamente o estado da variável `resultado` até atingir o valor final.

## Paradigma Declarativo

Por outro lado, o paradigma declarativo se concentra em **o que** deve ser feito, sem detalhar explicitamente **como** a execução ocorre. Linguagens como Prolog adotam essa abordagem, definindo relações lógicas entre os valores sem especificar o fluxo de execução.

### Exemplo em Prolog
```prolog
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.
```
Neste exemplo, o fatorial é calculado de forma recursiva, seguindo a ideia apresentada em aula. O código declara as condições e regras matemáticas do problema, permitindo que o interpretador encontre a solução automaticamente.

## Comparação

| Aspecto           | Java (Imperativo) | Prolog (Declarativo) |
|------------------|----------------|------------------|
| Abordagem       | Sequência de instruções | Definição de regras |
| Controle de Fluxo | Estruturas como loops e condicionais | Recursão e inferência lógica |
| Estado          | Modificado explicitamente | Implícito na resolução |
| Foco            | Como fazer | O que fazer |

Enquanto Java detalha cada passo da execução, Prolog descreve apenas as relações do problema e delega ao interpretador a resolução.
