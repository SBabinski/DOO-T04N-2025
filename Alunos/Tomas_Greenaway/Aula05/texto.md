Paradigmas Imperativo e Declarativo
Imperativo
No paradigma imperativo, você diz ao computador como fazer as coisas, passo a passo. Ou seja, você define explicitamente cada etapa do processo.

Exemplo em Java:

java
Copiar
public class Fatorial {
    public static void main(String[] args) {
        int numero = 5;
        int resultado = 1;
        
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        
        System.out.println("Fatorial de " + numero + " é " + resultado);
    }
}
Aqui, o código calcula o fatorial de um número usando um laço for, e você tem o controle de cada passo do processo.

Declarativo
No paradigma declarativo, você diz o que quer que aconteça, e o sistema cuida de como fazer isso. O foco está na descrição do resultado, não nos detalhes de como alcançá-lo.

Exemplo em Prolog:

prolog
Copiar
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.
Aqui, você define as regras para calcular o fatorial, e o Prolog se encarrega de encontrar a solução.

Comparação
No imperativo (Java), você diz como fazer, controlando o fluxo (como o for).

No declarativo (Prolog), você define o que precisa e o sistema resolve o resto.

Em resumo, no imperativo você controla o processo, e no declarativo o sistema cuida disso por voc