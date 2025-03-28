Paradigmas Imperativo e Declarativo:

No paradigma imperativo, a programação é focada em como resolver o problema. Isso é típico de linguagens como Java, onde o controle do fluxo é explícito. 
Em contrapartida, o paradigma declarativo foca no o que deve ser alcançado, sem detalhar como fazer. 
Em vez de instruções passo a passo, define-se a relação entre dados, como em Prolog, e o sistema decide como resolver o problema.

Exemplo em Java (imperativo):

public class MaiorNumero {
    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 7, 5, 9, 3};
        int maior = numeros[0];
        
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }
        
        System.out.println("O maior número é: " + maior);
    }
}

No Java, o programador especifica exatamente como encontrar o maior número, com um laço e uma condicional para comparar os valores um a um.

Exemplo em Prolog (declarativo):

maior([X], X).
maior([X|Xs], Maior) :-
    maior(Xs, MaiorRestante),
    (X > MaiorRestante -> Maior = X; Maior = MaiorRestante).
    
Em Prolog, a lógica é declarada de forma mais simples: as regras para encontrar o maior número são expressas sem detalhar o fluxo, e o sistema de inferência resolve o restante.

Comparação:
Java (imperativo): O fluxo é explícito, com controle detalhado de como percorrer os números e comparar.
Prolog (declarativo): A solução é expressa de forma concisa, com regras lógicas, e o motor do Prolog cuida da execução.
