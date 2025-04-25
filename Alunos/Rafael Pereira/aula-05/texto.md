
# Comparação de Paradigmas de Programação: Imperativo vs Declarativo

**FAG**  
Engenharia de Software  
Rafael Pereira da Silva  
22/03/2025  

---



## Introdução

O desenvolvimento de algoritmos e soluções computacionais pode ser feito de diversas formas, a depender do paradigma de programação utilizado. Neste relatório, serão analisados dois paradigmas clássicos: o imperativo e o declarativo. Além disso, serão apresentados exemplos práticos, destacando as principais diferenças entre as abordagens.

## Paradigmas de Programação

### Paradigma Imperativo

O paradigma imperativo tem como foco a definição detalhada das ações que o programa deve realizar, especificando cada passo necessário para transformar o estado do sistema até obter o resultado esperado. Linguagens como Java, C e Python adotam majoritariamente esse paradigma.

### Paradigma Declarativo

No paradigma declarativo, o programador se preocupa em descrever o que deseja alcançar, deixando para o sistema de execução a tarefa de decidir como a solução será encontrada. Linguagens como Prolog e SQL são representações típicas deste paradigma.

## Exemplos e Análise

### Cálculo de Fatorial

**Imperativo (Java)**

```java
public class Fatorial {
    public static int fatorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    public static void main(String[] args) {
        System.out.println(fatorial(5));
    }
}
```

**Declarativo (Prolog)**

```prolog
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.
```

## Comparação Entre os Paradigmas

O paradigma imperativo descreve de forma detalhada o passo a passo do algoritmo, enquanto o declarativo descreve a relação entre as variáveis e o sistema busca a solução automaticamente.

## Vantagens e Desvantagens

- **Imperativo**: Mais controle e eficiência, porém mais verboso e suscetível a erros.
- **Declarativo**: Código mais conciso e legível, ideal para sistemas baseados em regras, mas com menor controle de execução.

## Conclusão

A escolha entre paradigma imperativo ou declarativo deve considerar a natureza do problema. Dominar ambos é essencial para a formação de um bom programador.
