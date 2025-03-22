# **Aula 05**

## Paradigmas de Programação: Imperativo e Declarativo

### Oque é um paradigma de programação:

Paradigmas de programação são **modelos** que **definem como um programa é estruturado** e como as instruções são escritas para resolver problemas. Eles estabelecem **princípios** e **padrões** que influenciam a organização do código, a forma de manipulação de dados e a execução das operações.

### Paradigma imperativo:

Ele foca em **como** um problema deve ser resolvido, descrevendo **passo a passo** as instruções que o computador deve seguir. Linguagens como **C, Java** e **Python** adotam essa abordagem, utilizando estruturas como loops e variáveis mutáveis.

### Paradigma declarativo:

Ele, ao contrario do paradgma imperativo, enfatiza **o que** deve ser feito, **sem especificar** detalhadamente o fluxo de execução. Exemplos incluem **SQL, Haskell** e **Prolog**, que evitam, na maioria dos casos, estados mutáveis e priorizam a definição de regras lógicas.

## Comparação entre Java e Prolog
O objetivo de ambos os códigos é verificar se a pesso é maior de idade ou não.

### Java:
```java
public class Maioridade {
    public static void main(String[] args) {
        int idade = 20;

        if (idade >= 18) {
            System.out.println("A pessoa é maior de idade.");
        } else {
            System.out.println("A pessoa é menor de idade.");
        }
    }
}
```
Em **Java**, a abordagem é **imperativa**: definimos um valor para a **variável** idade e depois utilizamos uma condicional **if-else** para verificar se a pessoa é maior de idade ou não.<br> **Se** a **variável** idade for maior ou igual a 18, o programa imprime "A pessoa é maior de idade".<br> **Senão**, imprime "A pessoa é menor de idade".<br> O fluxo de execução é controlado pelo programador, que especifica as condições e ações a serem realizadas, decidindo como o programa deve reagir de acordo com o valor da **variável** idade.

### Prolog:
```prolog
maior_de_idade(Idade) :- Idade >= 18, write('A pessoa é maior de idade.').
maior_de_idade(Idade) :- Idade < 18, write('A pessoa é menor de idade.').

% Consulta:
% maior_de_idade(20).
```
Em **Prolog**, a abordagem é **declarativa**: definimos **regras** que descrevem quando uma pessoa é maior ou menor de idade.<br> A **regra** maior_de_idade(Idade) fala que se a idade for maior ou igual a 18, a frase "A pessoa é maior de idade." será exibida.<br> Senão, se encaixará na segunda **regra** que afirma que, se a idade for menor que 18, será exibida a frase "A pessoa é menor de idade."<br> O fluxo de execução é determinado pelas consultas, onde, ao realizar a consulta maior_de_idade(20)., o Prolog verifica **qual das regras é aplicável** e executa a ação correspondente.

*João Pedro Cordasso Trento <br> 3° período de Engenharia de Software - FAG <br> 22/03/2025*
