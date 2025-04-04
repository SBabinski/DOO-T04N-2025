### **Aula 05**
## Paradigmas de Programação
## Declarativo e Imperativo
### O que são os paradigmas de programação?

Paradigmas de programação são abordagens que estabelecem maneiras distintas de organizar e estruturar o código de um programa. Eles definem as diretrizes sobre como os problemas devem ser resolvidos e como o fluxo de execução do programa será conduzido. Cada paradigma tem uma filosofia própria sobre como a solução de um problema deve ser expressa no código.

### Paradigma Imperativo

O paradigma imperativo é baseado na ideia de **especificar os passos necessários para resolver um problema**. Nesse estilo, o programador descreve, de forma sequencial, todas as instruções que o computador deve seguir para alcançar o resultado desejado. Linguagens como **C, Java** e **Python** são exemplos que seguem esse paradigma, utilizando estruturas como loops, variáveis mutáveis e sequências de instruções.

### Paradigma Declarativo

Em contraste, o paradigma declarativo foca mais em **descrever o que precisa ser feito** ao invés de detalhar como o problema deve ser resolvido. Em vez de especificar as etapas a serem seguidas, o programador define as condições ou regras a serem satisfeitas, deixando que o sistema ou linguagem decida como realizá-las. Exemplos de linguagens declarativas são **SQL, Haskell** e **Prolog**, que evitam manipulação explícita do fluxo do programa e dos estados mutáveis.

## Comparação entre Java e Prolog

Objetivo dos códigos: Verificar se um número é múltiplo de 5.

## Java

import java.util.Scanner;

public class MultiploDeCinco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        scanner.close();

        if (ehMultiploDeCinco(numero)) {
            System.out.println(numero + " é múltiplo de 5.");
        } else {
            System.out.println(numero + " não é múltiplo de 5.");
        }
    }

    public static boolean ehMultiploDeCinco(int numero) {
        return numero % 5 == 0;
    }
}

## Prolog

% Regra para verificar se um número é múltiplo de 5
multiplo_de_cinco(N) :- 
    N mod 5 =:= 0.

% Consultas de exemplo:
% ?- multiplo_de_cinco(10).
% true.
% ?- multiplo_de_cinco(7).
% false.