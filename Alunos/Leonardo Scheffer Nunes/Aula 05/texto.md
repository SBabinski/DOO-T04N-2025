# Paradigmas de Programação: Imperativo vs Declarativo

A programação pode ser abordada de diferentes maneiras, sendo os paradigmas imperativo e declarativo dois dos mais influentes.

## Paradigma Imperativo

O paradigma imperativo foca em descrever como um problema deve ser resolvido, especificando cada passo necessário para alcançar um resultado. Ele é baseado no conceito de estado e mutabilidade, onde variáveis são modificadas ao longo da execução do programa. Linguagens como Java, C e Python são exemplos de linguagens imperativas.

## Paradigma Declarativo

O paradigma declarativo, por outro lado, descreve o que deve ser feito, sem especificar detalhadamente os passos necessários. Ele enfatiza a expressividade e abstração, muitas vezes utilizando conceitos como lógica e funções matemáticas. Prolog, SQL e Haskell são exemplos de linguagens declarativas.

Comparação de Código: Java vs Prolog

Exemplo: Verificação de Número Par

Código em Java (Paradigma Imperativo)
````

public class Paridade {
    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
    
    public static void main(String[] args) {
        int numero = 10;
        System.out.println("O número " + numero + " é par? " + ehPar(numero));
    }
}`
````

### Como funciona?

>Define-se um método ehPar que recebe um número e retorna true se for divisível por 2. No main, chamamos esse método e imprimimos o resultado. O controle de fluxo é explícito, e o programa segue um conjunto de instruções definidas pelo programador.

Código em Prolog (Paradigma Declarativo)
````

eh_par(N) :- N mod 2 =:= 0.

?- eh_par(10).
````

### Como funciona?

>Define-se uma regra (eh_par) que determina se um número é par verificando a operação mod. O interpretador Prolog consulta a base de conhecimento e retorna true ou false para a consulta ?- eh_par(10).. O código expressa uma relação lógica, sem a necessidade de definir explicitamente o fluxo de execução.

### Conclusão

>Enquanto o código Java detalha explicitamente os passos necessários para verificar se um número é par, o código Prolog apenas declara a relação lógica entre o número e sua paridade. Isso exemplifica a principal diferença entre os paradigmas: o imperativo detalha como fazer, enquanto o declarativo foca no o que deve ser feito.

