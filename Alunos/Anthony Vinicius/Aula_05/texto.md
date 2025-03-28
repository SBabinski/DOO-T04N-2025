# Paradigmas de Programação: Imperativo vs. Declarativo

## Introdução

A programação de computadores pode ser classificada em diferentes paradigmas, dependendo da abordagem utilizada para estruturar e expressar a lógica do programa. Os paradigmas de programação representam estilos distintos de resolução de problemas computacionais, influenciando diretamente a estrutura e a forma como os programas são escritos e executados.

Dentre os diversos paradigmas existentes, destacam-se o **paradigma imperativo** e o **paradigma declarativo**. Enquanto o primeiro se baseia na definição de um conjunto de instruções a serem executadas sequencialmente para modificar o estado do programa, o segundo descreve o que deve ser feito, sem especificar exatamente como a operação deve ser realizada.

## Paradigma Imperativo

O **paradigma imperativo** é caracterizado pela execução sequencial de instruções que manipulam variáveis e estados internos do programa. Linguagens que adotam essa abordagem, como Java, C e Python, utilizam comandos explícitos, loops, condicionais e estruturas de controle para definir o fluxo de execução.

### Exemplo em Java

O código a seguir ilustra um exemplo de implementação em Java que verifica se um número é par:

```java
public class Paridade {
    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
    public static void main(String[] args) {
        System.out.println(ehPar(10)); // true
    }
}
```

Neste código, a função `ehPar(int numero)` verifica se o número passado como argumento é divisível por 2, retornando `true` para números pares e `false` para números ímpares. O paradigma imperativo é evidente, pois o programa segue um conjunto explícito de instruções para processar a entrada e produzir a saída desejada.

## Paradigma Declarativo

O **paradigma declarativo**, por sua vez, é baseado na descrição do problema em termos de relações lógicas, sem especificar a sequência exata de passos para a sua resolução. Linguagens como Prolog, SQL e Haskell utilizam esse modelo, permitindo que o programador defina apenas as regras e relações necessárias, deixando para o interpretador ou compilador a responsabilidade de encontrar uma solução.

### Exemplo em Prolog

O mesmo problema pode ser resolvido em Prolog da seguinte forma:

```prolog
eh_par(N) :- 0 is N mod 2.
```

Para verificar se um número é par, basta executar a seguinte consulta:

```prolog
?- eh_par(10).
true.
```

Neste caso, a lógica declarativa define que `eh_par(N)` é verdadeiro quando `N mod 2` resulta em 0. Diferente de Java, onde a execução segue uma sequência de comandos predefinidos, o Prolog utiliza um mecanismo interno de inferência para verificar a veracidade da afirmação.

## Comparação entre Java e Prolog

A seguir, são destacadas algumas diferenças fundamentais entre os paradigmas imperativo e declarativo:

1. **Abordagem de resolução**: No Java, o programador define explicitamente os passos necessários para atingir um objetivo. Em Prolog, o programador estabelece regras e relações, deixando a execução para o motor de inferência.
2. **Controle de fluxo**: No paradigma imperativo, o controle é realizado manualmente pelo programador, utilizando estruturas condicionais e de repetição. No paradigma declarativo, a resolução ocorre de forma automática, sem a necessidade de comandos explícitos.
3. **Gerenciamento de estado**: Em Java, o estado do programa pode ser alterado diretamente através da manipulação de variáveis. Em Prolog, não há mudanças de estado explícitas, pois o código consiste em regras lógicas que descrevem propriedades do problema.
4. **Legibilidade e expressividade**: O código declarativo tende a ser mais conciso e próximo da especificação do problema, enquanto o código imperativo oferece mais controle sobre a execução, podendo ser mais detalhado e verboso.

## Conclusão

Os paradigmas de programação oferecem diferentes abordagens para a resolução de problemas computacionais. O paradigma imperativo proporciona maior controle sobre a execução do programa, sendo adequado para aplicações que exigem manipulação direta de estados e dados. Já o paradigma declarativo se destaca em domínios onde a descrição lógica do problema é mais importante do que a definição do fluxo de execução, como inteligência artificial, bancos de dados e sistemas baseados em regras.

A escolha entre um paradigma e outro depende do contexto da aplicação e dos requisitos específicos do problema a ser resolvido. Enquanto linguagens imperativas são amplamente utilizadas no desenvolvimento de software tradicional, linguagens declarativas desempenham um papel fundamental em áreas como computação lógica, bancos de dados e programação funcional.
