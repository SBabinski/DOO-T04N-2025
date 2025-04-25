# Comparação entre Paradigmas Imperativo e Declarativo

Os paradigmas de programação imperativo e declarativo possuem abordagens distintas para resolver problemas computacionais. Neste resumo, comparamos como cada um funciona, utilizando exemplos em Java (imperativo) e Prolog (declarativo).

## Paradigma Imperativo (Java)

O paradigma imperativo se baseia na execução sequencial de instruções, onde o programador define explicitamente os passos necessários para resolver um problema. Em Java, um exemplo de cálculo do fatorial seria:

```java
public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(calcularFatorial(5)); // Saída: 120
    }
}
```

## Paradigma Declarativo (Prolog)

O paradigma declarativo foca em descrever **o que** deve ser feito, ao invés de **como** deve ser feito. O código se baseia em regras e inferências lógicas. Um exemplo do cálculo do fatorial em Prolog seria:

```prolog
fatorial(0, 1).
fatorial(N, R) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, R1),
    R is N * R1.
```

## Conclusão

Enquanto Java exige que o programador descreva detalhadamente cada passo da execução, Prolog permite definir relações lógicas e o interpretador se encarrega da resolução. Essa diferença ilustra bem a distinção entre os paradigmas imperativo e declarativo.

