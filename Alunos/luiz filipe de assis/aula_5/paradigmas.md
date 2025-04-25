# Paradigmas de Programação: Imperativo vs. Declarativo

## Paradigma Imperativo
O paradigma **imperativo** foca em **como** uma tarefa deve ser realizada. O programador define os passos exatos (comandos) que o computador deve executar, incluindo controle de fluxo (loops, condicionais) e alteração de estados. Linguagens como Java, C e Python seguem esse modelo.

## Paradigma Declarativo
Já o paradigma **declarativo** descreve **o que** deve ser resolvido, sem especificar os detalhes de implementação. O sistema (ou linguagem) decide a melhor forma de atingir o resultado. Prolog, SQL e Haskell são exemplos desse estilo.

---

## Comparação: Java (Imperativo) vs. Prolog (Declarativo)

### Objetivo: Verificar se um elemento pertence a uma lista.

#### **Código em Java** (Imperativo)
```java
import java.util.List;

public class Main {
    public static boolean contem(List<Integer> lista, int elemento) {
        for (int item : lista) {
            if (item == elemento) {
                return true;
            }
        }
        return false;
    }

 public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4);
        System.out.println(contem(numeros, 3)); // Saída: true
    }
}
```

**Funcionamento**:

-   O programador define um loop para percorrer a lista e compara cada elemento manualmente.
    
-   O estado é modificado a cada iteração até encontrar (ou não) o valor desejado.
    

#### **Código em Prolog  (Declarativo)**

```prolog
pertence(X, [X | _]).
pertence(X, [_ | Cauda]) :- pertence(X, Cauda).

% Consulta:
% ?- pertence(3, [1, 2, 3, 4]). -> true.

```

**Funcionamento**:

-   As regras  **declarativas**  definem que:
    
    1.  `X`  pertence à lista se é o primeiro elemento (`[X | _]`).
        
    2.  Caso contrário, verifica-se a  `Cauda`  da lista recursivamente.
        
-   Não há descrição de "como" a busca é feita; o mecanismo de unificação do Prolog resolve a consulta automaticamente.

---

## Conclusão

Enquanto o Java exige uma descrição passo a passo do algoritmo (**imperativo**), o Prolog declara regras lógicas e deixa o sistema inferir a solução (**declarativo**). Cada paradigma tem vantagens dependendo do problema: controle detalhado vs. abstração e concisão.