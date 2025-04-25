# Paradigmas de Programação: Imperativo e Declarativo

Os paradigmas de programação são modelos que orientam a maneira como os programas são estruturados e executados. Dentre eles, destacam-se os paradigmas imperativo e declarativo. O paradigma imperativo foca na sequência de comandos que modificam o estado do programa ao longo do tempo. Ele é baseado no conceito de instruções sequenciais e controle de fluxo, sendo comum em linguagens como Java, C e Python. Em contrapartida, o paradigma declarativo enfatiza o "o que" deve ser feito, ao invés de "como" deve ser realizado. Ele se concentra em expressar lógicas e relações matemáticas, sendo amplamente utilizado em linguagens como SQL, Prolog e Haskell.

Para exemplificar essa diferença, considere os seguintes trechos de código que verificam se um número pertence a uma lista.

## Java (Paradigma Imperativo)

```java
public class BuscaNumero {
    public static boolean pertence(int[] lista, int num) {
        for (int elemento : lista) {
            if (elemento == num) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};
        System.out.println(pertence(lista, 3)); // true
    }
}
```

Neste código, a função `pertence` percorre explicitamente a lista utilizando um laço `for` e compara cada elemento com o valor desejado. O estado do programa é alterado a cada iteração, seguindo uma sequência lógica de instruções.

## Prolog (Paradigma Declarativo)

```prolog
pertence(X, [X|_]).
pertence(X, [_|T]) :- pertence(X, T).

?- pertence(3, [1, 2, 3, 4, 5]). % true
```

Em Prolog, a abordagem é completamente diferente. A definição do predicado `pertence/2` é feita por meio de regras recursivas que descrevem a relação entre um elemento e uma lista. Não há laços ou alterações de estado; em vez disso, Prolog utiliza inferência lógica para determinar a veracidade da consulta.

## Comparando os Paradigmas

No código Java, o programador especifica exatamente como a verificação deve ser feita, iterando sobre a lista e utilizando um fluxo de controle. Já no código Prolog, a solução é definida por regras lógicas, permitindo que o motor de inferência determine automaticamente a resposta. Enquanto a programação imperativa é mais natural para quem pensa em termos de passos sequenciais, a abordagem declarativa simplifica problemas ao expressá-los como relações matemáticas.

Ambos os paradigmas têm suas vantagens e desvantagens. A programação imperativa costuma ser mais intuitiva para operações que exigem controle detalhado do estado, enquanto a declarativa é mais sucinta e favorece a clareza em problemas baseados em regras e lógica. A escolha entre eles depende da natureza do problema e das preferências do desenvolvedor.
