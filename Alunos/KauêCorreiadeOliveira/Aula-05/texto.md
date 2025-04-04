# Paradigmas de Programação: Imperativo vs. Declarativo

A programação pode ser abordada por diferentes paradigmas, sendo dois dos principais o **paradigma imperativo** e o **paradigma declarativo**. O paradigma imperativo instrui o computador sobre "como" realizar uma tarefa, especificando cada etapa do processo, enquanto o paradigma declarativo foca no "o que" deve ser alcançado, deixando a implementação dos detalhes para o próprio sistema.

## Comparação entre Código Imperativo (Java) e Declarativo (Prolog)

A seguir, comparamos dois trechos de código que resolvem o mesmo problema: verificar se um número está presente em uma lista.

### Implementação em Java (Paradigma Imperativo)

```java
import java.util.List;

public class BuscaNumero {
    public static boolean contemNumero(List<Integer> lista, int numero) {
        for (int elemento : lista) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        System.out.println(contemNumero(numeros, 3)); 
    }
}
```

### Implementação em Prolog (Paradigma Declarativo)

```prolog
% Definição da relação
contem_numero(Numero, [Numero|_]).
contem_numero(Numero, [_|Resto]) :- contem_numero(Numero, Resto).

% Consulta
?- contem_numero(3, [1, 2, 3, 4, 5]).
true.
```

## Análise Comparativa

No código **Java**, adotamos um estilo imperativo, onde um laço **for** percorre a lista verificando cada elemento até encontrar o número desejado. O programador descreve explicitamente o fluxo de controle e as instruções necessárias para realizar a verificação.

Já no código **Prolog**, a solução é expressa de forma declarativa. Definimos uma relação entre um número e uma lista por meio de recursão, sem especificar explicitamente como a busca ocorre. O interpretador do Prolog resolve a consulta automaticamente utilizando unificação e busca lógica.

## Conclusão

O paradigma imperativo exige um controle detalhado do fluxo de execução, enquanto o paradigma declarativo permite que o programador descreva o problema em termos de relações e regras lógicas, delegando a resolução ao interpretador. Cada abordagem possui vantagens e aplicações específicas, sendo que a escolha do paradigma ideal depende do contexto e dos requisitos do problema a ser resolvido.
