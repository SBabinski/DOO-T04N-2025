# Aula 5 – Paradigmas de Programação: Imperativo e Declarativo

## Introdução

Nesta aula, exploramos dois paradigmas fundamentais da programação: o **imperativo** e o **declarativo**. Cada um apresenta uma maneira diferente de pensar a resolução de problemas computacionais.

---

## Paradigma Imperativo

No paradigma imperativo, você instrui o computador **como fazer** determinada tarefa, passo a passo. O controle do fluxo da execução está nas mãos do programador, que define cada etapa do processo.


### Exemplo em Java

```java
public class Fatorial {
    public static void main(String[] args) {
        int numero = 5;
        int resultado = 1;

        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }

        System.out.println("Fatorial de " + numero + " é " + resultado);
    }
}
```


## Paradigma Declarativo

Já no paradigma declarativo, o foco está em descrever o que deve ser feito, e não como fazer. O programador define o resultado desejado, e o sistema se encarrega de encontrar o caminho para alcançá-lo.


fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.


## Conclusão

A escolha entre paradigma imperativo e declarativo depende do problema a ser resolvido e das ferramentas disponíveis. Entender ambos permite ao programador escolher a abordagem mais eficiente e clara para cada situação.


