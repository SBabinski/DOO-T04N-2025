# Paradigmas de Programação: Imperativo e Declarativo

A programação pode ser classificada em diferentes paradigmas, que definem a forma como os programas são estruturados e executados. Dois dos principais paradigmas são:

## Paradigma Imperativo

O paradigma imperativo foca em "como" uma tarefa deve ser realizada, especificando detalhadamente cada etapa da execução. Ele é baseado em comandos sequenciais, estados mutáveis e controle explícito do fluxo de execução. Linguagens como C, Java e Python permitem essa abordagem.

Exemplo em Java:

```java
public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        System.out.println(calcularFatorial(5)); // Saída: 120
    }
}
```

No exemplo acima, utilizamos um loop para calcular o fatorial de um número, alterando o estado da variável `resultado` a cada iteração.

## Paradigma Declarativo

O paradigma declarativo, por outro lado, foca no "o que" deve ser realizado, sem detalhar explicitamente os passos para atingir o resultado. Esse paradigma inclui programação funcional e lógica, sendo usado em linguagens como Prolog e Haskell.

Exemplo em Prolog:

```prolog
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.

% Consulta: fatorial(5, Resultado).
% Saída esperada: Resultado = 120.
```

Aqui, o Prolog define regras lógicas para calcular o fatorial, sem explicitar um fluxo de controle tradicional. O mecanismo de inferência do Prolog resolve a consulta recursivamente.

## Comparação

| Aspecto             | Java (Imperativo) | Prolog (Declarativo) |
|--------------------|----------------|----------------|
| Controle de fluxo  | Uso de loops e variáveis mutáveis | Uso de recursão e inferência lógica |
| Estado            | Alteração direta de variáveis | Definição de relações lógicas |
| Como funciona     | Executa instruções sequenciais | Resolve consultas com base em fatos e regras |

O paradigma imperativo oferece maior controle sobre a execução, sendo adequado para aplicações que exigem gerenciamento detalhado de estados. Já o paradigma declarativo abstrai a execução, sendo útil em problemas de inteligência artificial e lógica computacional.

Ambos os paradigmas têm suas vantagens e aplicações específicas, sendo importante escolher o mais adequado para cada contexto de desenvolvimento.
