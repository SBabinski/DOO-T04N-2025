# Paradigmas de Programação: Imperativo e Declarativo

## Introdução
Os paradigmas de programação são abordagens diferentes para resolver problemas computacionais de diferentes formas de se pensar. Os paradigmas mais conhecidos dessa área seriam o **paradigma imperativo** e o **paradigma declarativo**, segue abaixo as informações sobre os mesmos.

## Paradigma Imperativo
O paradigma imperativo se baseia em uma sequência de instruções que modificam o estado do programa. Programas imperativos descrevem como uma tarefa deve ser realizada, geralmente utilizando estruturas como loops e condicionais. Linguagens como **Java, C e Python** são exemplos de linguagens imperativas.

### Exemplo em Java
Abaixo, um trecho de código em Java que calcula o fatorial do número 5:

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
        System.out.println(calcularFatorial(5)); 
    }
}
```

### Explicação
O código acima faz a conta de uma calculadora fatorial do número 5, o laço for multiplica progressivamente os valores de i. A variável resultado mantém o resultado ao longo da execução para no final mostrar ao usuário 120.

## Paradigma Declarativo
O paradigma declarativo se concentra no o quê deve ser resolvido, ao invés de como resolvê-lo. Esse paradigma inclui programação funcional e lógica, sendo Prolog um dos principais exemplos de linguagem declarativa.

### Exemplo em Prolog
O mesmo cálculo do fatorial pode ser expresso em Prolog da seguinte maneira:

```prolog
fatorial(0, 1).
fatorial(N, Resultado) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, R1),
    Resultado is N * R1.
```

### Explicação
- Em Prolog, o código define relações lógicas, sem descrever a ordem exata de execução.
- O primeiro fato (fatorial(0, 1).) define que o fatorial de 0 é 1.
- A regra especifica que para calcular fatorial(N), primeiro devemos calcular fatorial(N-1), multiplicando o resultado por N.
- A linguagem se encarrega de resolver as definição, sem precisar de um laço explícito.

## Comparação Entre os Paradigmas
Os dois trechos de código atingem o mesmo objetivo, mas de formas diferentes. O programa em Java segue uma abordagem imperativa, onde o programador deve definir explicitamente cada etapa do cálculo, controlando o fluxo de execução com um laço for e manipulando diretamente as variáveis. Já no Prolog, a abordagem declarativa permite que o código seja uma descrição matemática do problema, deixando que o interpretador resolva a lógica recursiva por conta própria.

Outra diferença importante é o controle de fluxo: enquanto o código Java exige que o programador determine a sequência de operações, em Prolog essa sequência é inferida pelo próprio sistema. Isso pode facilitar a manutenção e a expressividade do código declarativo, mas também exige um paradigma de pensamento diferente para quem está acostumado à programação imperativa.

## Conclusão
No paradigma imperativo, como no exemplo de Java, o programador especifica cada passo da execução, alterando estados e variáveis diretamente. Já no paradigma declarativo, como no exemplo de Prolog, descreve-se apenas o problema, e o sistema de inferência cuida da resolução.

O paradigma imperativo detalha como realizar uma operação, utilizando controle explícito do fluxo do programa. Já o paradigma declarativo foca no o quê deve ser resolvido, deixando para o interpretador a execução das regras definidas. Ambos os paradigmas têm suas vantagens e são mais adequados para diferentes contextos de desenvolvimento.