# Paradigmas Imperativo e Declarativo
 # Comparação entre Java e Prolog


Os paradigmas de programação podem ser classificados de várias formas, e dois dos mais notáveis são o paradigma imperativo e o declarativo. Esses paradigmas representam abordagens distintas para a resolução de problemas na programação de software. O paradigma imperativo foca em como algo deve ser feito, ou seja, descreve os passos a serem seguidos para atingir um determinado resultado. Já o paradigma declarativo enfatiza o o quê se deseja alcançar, sem especificar explicitamente o caminho ou as etapas para isso.

# Paradigma Imperativo

No paradigma imperativo, o código descreve uma sequência de instruções que o computador deve executar para modificar o estado do sistema. Esse estilo é característico de linguagens como Java, onde o programador especifica de forma detalhada a execução do processo. A lógica de controle é expressa através de loops, condicionais e manipulação direta de variáveis.

# Paradigma Declarativo

Por outro lado, o paradigma declarativo não se preocupa com o processo detalhado de execução, mas sim com a definição do que deve ser alcançado. O programador define a lógica do problema e a linguagem ou sistema de execução cuida de como os resultados serão alcançados. Prolog é um exemplo clássico de uma linguagem declarativa, em que a programação é baseada em relações e regras, e o sistema de inferência resolve essas relações de acordo com os dados fornecidos.

# Comparação de Código

A seguir, apresentamos dois trechos de código que resolvem o mesmo problema: encontrar o maior número entre três valores. O primeiro código está em Java (imperativo), e o segundo em Prolog (declarativo).

## Código em Java (Imperativo)

```java
public class MaiorNumero {
    public static void main(String[] args) {
        int a = 10, b = 15, c = 7;
        int maior = a;

        if (b > maior) {
            maior = b;
        }
        if (c > maior) {
            maior = c;
        }

        System.out.println("O maior número é: " + maior);
    }
}
```

# Análise do Código em Java:
Neste exemplo de Java, o programador define explicitamente como o valor maior entre três números deve ser calculado. A variável `maior` é inicializada com o valor de `a`, e o código segue uma sequência de comparações (`if`) para atualizar o valor de `maior` caso algum dos outros números seja maior. O foco é no controle do fluxo de execução, especificando as condições e ações que precisam ser tomadas. Esse é um exemplo claro de programação imperativa, pois o programador deve fornecer todos os passos necessários para a solução.

# Código em Prolog (Declarativo)

```prolog
maior(A, B, A) :- A > B.
maior(A, B, B) :- B >= A.

consultar_maior :-
    maior(10, 15, Maior),
    write('O maior número é: '), write(Maior).
```

# Análise do Código em Prolog:
Em Prolog, o programador define as relações e regras que devem ser satisfeitas para determinar o maior número. A regra `maior/3` afirma que `A` é maior que `B` se `A > B`, ou então `B` é maior ou igual a `A`. O sistema Prolog se encarrega de buscar a solução mais adequada para o problema de acordo com as regras fornecidas. O código não especifica como as comparações devem ser feitas, apenas o que constitui a relação de maioridade. Isso é típico de programação declarativa, onde o foco é em descrever o problema sem se preocupar com os passos exatos da solução.

A comparação entre o código em Java e Prolog demonstra a diferença fundamental entre os paradigmas imperativo e declarativo. No caso de Java, o programador é responsável por detalhar as instruções exatas para encontrar o maior número. Em Prolog, o programador define as regras que descrevem a relação entre os números, e o sistema de inferência resolve qual número é o maior, sem que o programador precise especificar a sequência de comparações.
Ambos os paradigmas têm seus méritos e são adequados para diferentes tipos de problemas. O paradigma imperativo, como mostrado em Java, é útil quando o controle exato sobre a execução é necessário. Por outro lado, o paradigma declarativo, como ilustrado em Prolog, pode ser vantajoso para problemas que envolvem a descrição de relações lógicas complexas, onde o sistema pode assumir a responsabilidade de realizar as inferências necessárias para alcançar a solução.