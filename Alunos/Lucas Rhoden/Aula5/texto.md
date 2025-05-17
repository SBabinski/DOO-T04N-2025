  #🖥️ Abordagens de Programação#
🎯 Estilos Declarativo e Imperativo
O que são abordagens de programação?
As abordagens de programação determinam diferentes formas de estruturar e organizar o código de um software. Elas estabelecem diretrizes sobre como os problemas devem ser resolvidos e como o fluxo de execução ocorre. Cada estilo possui uma filosofia própria sobre a forma de expressar uma solução por meio do código.

🔷 Estilo Imperativo
A programação imperativa é baseada na definição explícita das etapas para resolver um problema. O programador descreve, de forma sequencial, todas as instruções que devem ser seguidas para atingir um resultado esperado. Linguagens como C, Java e Python fazem parte desse paradigma, utilizando loops, variáveis mutáveis e sequências de comandos.

🔶 Estilo Declarativo
Por outro lado, a abordagem declarativa se concentra em descrever o que precisa ser realizado, sem detalhar o procedimento passo a passo. O programador define as condições ou regras a serem atendidas, enquanto a linguagem ou sistema se encarrega da execução. Exemplos de linguagens declarativas incluem SQL, Haskell e Prolog, que evitam manipulação explícita do fluxo e estados mutáveis.

🆚 Comparação entre Java e Prolog
🏁 Objetivo: Verificar se um número é múltiplo de 5.
Java

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

ProLog

% Regra para verificar se um número é múltiplo de 5
multiplo_de_cinco(N) :- 
    N mod 5 =:= 0.

% Consultas de exemplo:
% ?- multiplo_de_cinco(10).
% true.
% ?- multiplo_de_cinco(7).
% false.
