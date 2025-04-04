# Paradigma Imperativo e Declarativo

## Características de cada Paradigma

## **Paradigma Declarativo**  
O **paradigma declarativo** concentra-se no **"o que fazer"**. Ele prioriza o resultado final, sem se preocupar com os passos intermediários para alcançá-lo. Em outras palavras, o programador descreve o que deseja obter, e a linguagem se encarrega de definir a melhor forma de executar essa operação. Isso torna o código mais conciso, expressivo e de fácil manutenção.  

## **Paradigma Imperativo**  
O **paradigma imperativo** enfatiza **"como realizar"** uma tarefa, detalhando cada passo do processo. O programador especifica detalhadamente as operações a serem executadas. Esse paradigma requer um controle do fluxo de execução para alcançar o resultado desejado.  

### Exemplo de código em JAVA
````JAVA
public class Paradigmas {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};

        // Paradigma Imperativo
        int somaImperativa = somaImperativa(numeros);
        System.out.println("Soma Imperativa em Java: " + somaImperativa);

        // Paradigma Declarativo
        int somaDeclarativa = somaDeclarativa(numeros);
        System.out.println("Soma Declarativa em Java: " + somaDeclarativa);
    }

    // Implementação imperativa: especifica cada passo detalhadamente
    public static int somaImperativa(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        return soma;
    }

    // Implementação declarativa: foca no resultado, sem detalhar o processo
    public static int somaDeclarativa(int[] numeros) {
        return Arrays.stream(numeros).sum();
    }
}
````
### Exemplo de código em PROLOG
```prolog
PROLOG % Paradigma Imperativo (usa recursão e acumulador)
soma_imperativa([], Soma, Soma).
soma_imperativa([Cabeça|Cauda], Parcial, Soma) :- 
    NovaParcial is Parcial + Cabeça, 
    soma_imperativa(Cauda, NovaParcial, Soma).

% Consulta para o imperativo:
% ?- soma_imperativa([1, 2, 3, 4, 5], 0, Soma).
% Soma = 15.

% Paradigma Declarativo (usa sum_list para somar os elementos da lista)
numeros([1, 2, 3, 4, 5]).

soma_declarativa(Soma) :- 
    numeros(Lista), 
    sum_list(Lista, Soma).

% Consulta para o declarativo:
% ?- soma_declarativa(Soma).
% Soma = 15.
```

## Explicação dos códigos
**Neste código, podemos observar como funcionam ambos os paradigmas.**  
No primeiro método, temos o paradigma **imperativo**, cuja forma de utilização baseia-se em loops ou estruturas de repetição em Java, e em acumuladores no Prolog.  
A lógica é detalhada etapa por etapa para alcançar o resultado.  

Já no segundo método, temos o paradigma **declarativo**, que foca no **"o que"** queremos alcançar, sem descrever o processo intermediário.  
Em Java, utilizamos a API de Streams, e no Prolog, abstrações, evitando detalhar os passos.
