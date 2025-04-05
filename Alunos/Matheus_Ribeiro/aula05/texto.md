# Paradigmas de Programação: Imperativo vs Declarativo

Na aula foram apresentados dois paradigmas: **imperativo** e **declarativo**.

O paradigma **imperativo** é baseado em comandos. Você escreve o passo a passo do que o programa deve fazer. Ele muda o estado do sistema conforme executa. Linguagens como Java e C seguem esse estilo.

Já o **declarativo** é o oposto. Você só descreve o que quer, sem explicar como chegar lá. A linguagem cuida da execução. Prolog e SQL são exemplos desse tipo.

## Comparação de código

### Java (Imperativo)

```java
public class Main {
    public static void main(String[] args) {
        int[] lista = {1, 3, 5, 7, 9};
        int alvo = 5;
        boolean encontrado = false;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == alvo) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Número encontrado!");
        } else {
            System.out.println("Número não está na lista.");
        }
    }
}
```

Nesse código Java, a gente faz tudo na mão: cria a lista, percorre, compara e decide o que imprimir. É tudo explícito.

### Prolog (Declarativo)

```prolog
pertence(X, [X|_]).
pertence(X, [_|T]) :- pertence(X, T).
```

Consulta:

```prolog
?- pertence(5, [1,3,5,7,9]).
true.
```

No Prolog, a gente só define o que significa um elemento pertencer a uma lista. Não tem laço, não tem variável de controle. A linguagem se vira pra resolver a consulta.

## Conclusão

O paradigma imperativo exige que você diga exatamente *como* o programa deve agir. No declarativo, você diz *o que* quer e deixa a linguagem resolver. São formas diferentes de pensar, e saber usar ambos te dá mais liberdade na hora de resolver problemas.
