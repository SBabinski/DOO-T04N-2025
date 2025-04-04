# Paradigmas da Programação: Imperativo e Declarativo

Os paradigmas de programação são abordagens que orientam a forma como os desenvolvedores escrevem e organizam o código. Dois dos paradigmas mais comuns são o **imperativo** e o **declarativo**.

## Paradigma Imperativo

O paradigma imperativo se concentra em como um programa deve executar suas tarefas. Ele utiliza uma sequência de instruções que alteram o estado do sistema. O programador especifica passo a passo as operações que devem ser realizadas, controlando o fluxo de execução. Linguagens como Java, C e Python são exemplos de linguagens imperativas.

## Paradigma Declarativo

Em contraste, o paradigma declarativo foca no que o programa deve alcançar, descrevendo as propriedades desejadas do resultado sem especificar como alcançá-las. O programador define o que quer que o sistema faça, e não como fazê-lo. Linguagens como Prolog e SQL são exemplos de linguagens declarativas.

## Comparação de Códigos

### Exemplo em Java (Imperativo)

```java
public class Soma {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        System.out.println("Soma: " + soma);
    }
}
```
Código Java: a soma de uma lista de números é realizada através de um loop for, onde itera sobre cada elemento do array numeros, acumulando o resultado na variável soma. O controle do fluxo e a manipulação do estado são explicitamente definidos pelo programador.

### Exemplo em Prolog (Declarativo)
```prolog
soma([], 0).
soma([Cabeca|Cauda], Resultado) :-
    soma(Cauda, SomaCauda),
    Resultado is Cabeca + SomaCauda.
```
Código Prolog: a soma é definida através de regras lógicas. A primeira regra estabelece que a soma de uma lista vazia é 0. A segunda regra define como somar uma lista não vazia, utilizando recursão para somar o primeiro elemento (Cabeça) com a soma dos elementos restantes (Cauda). O Prolog não especifica como a soma deve ser realizada, mas sim as condições que devem ser satisfeitas.

