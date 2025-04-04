### **Aula 05**

## Paradigmas de Programação
## Declarativo e Imperativo

### O que são os paradigmas de programação?

Paradigmas de programação são abordagens que estabelecem maneiras distintas de organizar e estruturar o código de um programa. Eles definem as diretrizes sobre como os problemas devem ser resolvidos e como o fluxo de execução do programa será conduzido. Cada paradigma tem uma filosofia própria sobre como a solução de um problema deve ser expressa no código.

### Paradigma Imperativo

O paradigma imperativo é baseado na ideia de **especificar os passos necessários para resolver um problema**. Nesse estilo, o programador descreve, de forma sequencial, todas as instruções que o computador deve seguir para alcançar o resultado desejado. Linguagens como **C, Java** e **Python** são exemplos que seguem esse paradigma, utilizando estruturas como loops, variáveis mutáveis e sequências de instruções.

### Paradigma Declarativo

Em contraste, o paradigma declarativo foca mais em **descrever o que precisa ser feito** ao invés de detalhar como o problema deve ser resolvido. Em vez de especificar as etapas a serem seguidas, o programador define as condições ou regras a serem satisfeitas, deixando que o sistema ou linguagem decida como realizá-las. Exemplos de linguagens declarativas são **SQL, Haskell** e **Prolog**, que evitam manipulação explícita do fluxo do programa e dos estados mutáveis.

## Comparação entre Código Prolog e Java
O objetivo de ambos os códigos é verificar se um número é par ou ímpar.

```java
public class ParOuImpar {
    public static void main(String[] args) {
        int numero = 7;

        if (numero % 2 == 0) {
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar.");
        }
    }
}
```
No paradigma imperativo, especificamos passo a passo como o programa deve executar a verificação.
Aqui utilizamos uma estrutura condicional para determinar se o número é par ou ímpar

```prolog
par(N) :- N mod 2 =:= 0, write('O número é par.').
impar(N) :- N mod 2 =\= 0, write('O número é ímpar.').
```
Já no paradigma declarativo (Prolog), não descrevemos o fluxo de execução, apenas declaramos regras.
Em Prolog, definimos relações lógicas ao invés de comandos sequenciais.
O interpretador Prolog utiliza essas regras para responder a consultas.
Exemplo:
- par(7).   % Retorna falso, pois 7 não é par.
- impar(7). % Retorna "O número é ímpar.", pois 7 satisfaz a regra de número ímpar.
