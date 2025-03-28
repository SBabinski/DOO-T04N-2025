Paradigma Declarativo: "Seu foco está no "o que fazer", deixando de lado "como fazer". Ou seja, prioriza
totalmente o resultado em vez do processo. Significa escrever algoritmos que especificam o objetivo, sem detalhar a
implementação. Sendo assim, o programador dedica-se ao resultado esperado, deixando para a linguagem a execução
dos passos."
Paradigma Imperativo: "Enfatiza no "como realizar" uma tarefa, sendo seu foco a execução detalhada de cada processo. Sua
função remete-se à sequência de ações para alcançar um objetivo. Este paradigma, na computação, especifica cada passo 
para o computador executar, utilizando variáveis, condicionais e estruturas de repetição, preocupando-se em detalhar 
como o resultado será alcançado."

JAVA
public class Paradigmas {
public static void main(String[] args) {
int[] numeros = {1, 2, 3, 4, 5};
int somaImperativa = somaImperativa(numeros);
System.out.println("Soma Imperativa em Java: " + somaImperativa);
        int somaDeclarativa = somaDeclarativa(numeros);
        System.out.println("Soma Declarativa em Java: " + somaDeclarativa);
    }
    public static int somaImperativa(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        return soma;
    }
    public static int somaDeclarativa(int[] numeros) {
        return Arrays.stream(numeros).sum();
    }
}

PROLOG
% Paradigma Imperativo (Prolog)
soma_imperativa([], Soma, Soma).
soma_imperativa([Cabeça|Cauda], Parcial, Soma) :-
NovaParcial is Parcial + Cabeça,
soma_imperativa(Cauda, NovaParcial, Soma).

% Consulta para o imperativo:
% ?- soma_imperativa([1, 2, 3, 4, 5], 0, Soma).
% Soma = 15.

% Paradigma Declarativo (Prolog)
numeros([1, 2, 3, 4, 5]).

soma_declarativa(Soma) :-
numeros(Lista),
sum_list(Lista, Soma).

% Consulta para o declarativo:
% ?- soma_declarativa(Soma).
% Soma = 15.

Explicação: Neste código, podemos observar como funcionam ambos os paradigmas. No primeiro método, temos o paradigma 
imperativo, cuja forma de utilização baseia-se em loops ou estruturas de repetição em Java, e em acumuladores no Prolog. 
A lógica é detalhada etapa por etapa para alcançar o resultado. Já no segundo método, temos o paradigma declarativo, 
que foca no "o que" queremos alcançar, sem descrever o processo intermediário. Em Java, utilizamos a API de Streams, 
e no Prolog, abstrações como sum_list, evitando detalhar os passos.





