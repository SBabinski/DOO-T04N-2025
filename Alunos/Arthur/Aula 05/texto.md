Na programação de computadores, os paradigmas imperativo e declarativo representam duas abordagens distintas para resolver 
problemas.
O paradigma imperativo foca na execução sequencial de instruções, onde o programador especifica passo a passo como alcançar 
a soluçãodesejada. Já o paradigma declarativo preocupa-se com o que precisa ser feito, sem detalhar o fluxo de controle,
permitindo que o sistema determine como atingir o resultado.
No paradigma imperativo, a linguagem Java é um exemplo claro. No código a seguir, o cálculo da sequência de Fibonacci é 
feito de maneira explícita e sequencial.O programador define as variáveis, controla o fluxo de execução com um laço de 
repetição e altera o estado da memória conforme necessário:
public class Fibonacci {
    public static int fibonacci(int n) {
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
Neste exemplo, o como o cálculo é feito é explícito, e o programador tem controle total sobre os detalhes da implementação.
Por outro lado, no paradigma declarativo, a linguagem Prolog oferece uma abordagem diferente, onde o programador descreve o 
que precisa ser feito sem se preocupar com os passos intermediários. No código abaixo,
o cálculo de Fibonacci é feito de maneira recursiva, declarando as relações necessárias para o cálculo:

fibonacci(0, 0).
fibonacci(1, 1).
fibonacci(N, F) :-
    N > 1,
    N1 is N - 1,
    N2 is N - 2,
    fibonacci(N1, F1),
    fibonacci(N2, F2),
    F is F1 + F2.
    Aqui, o programador define as regras e os casos base, e o Prolog cuida de como calcular o número desejado, resolvendo as relações de
    forma automática e recursiva.
