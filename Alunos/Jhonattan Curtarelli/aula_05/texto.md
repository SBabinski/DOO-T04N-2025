# Programação Imperativa X Programação Declarativa

# Programação Imperativa
## O que é a programação imperativa?
> A programação imperativa funciona a partir de uma sequência de comandos, onde o código é executado linha por linha seguindo uma ordem específica. Ela faz uso explícito de variáveis, onde o estado do programa é alterado através de varáveis e atribuições. A programação imperativa usa também estruturas de repetição e estruturas condicionais para organizar seu fluxo. Na programação imperativa o foco sempre é em como resolver o problema
## Exemplo da programação imperativa
> Como calcular a área de um quadrado em java
```java
// Modificador de acesso
// |
// |         Nome da classe
// |         |
// |         |  
public class Main {
    //            Retorno do método
    //            | 
    //            |    Nome da função
    //            |    | 
    //            |    |    Parâmetro da função
    //            |    |    |
    public static void main(String[] args) {
        // Tipo da variavel
        // |   Nome da variável
        // |   |   Operador de atribuição    
        // |   |   |  Valor atribuido para a variável lado
        double lado = 5.0; // Definição do lado do quadrado
        // Tipo da variavel
        // |   Nome da variável
        // |   |    Operador de atribuição    
        // |   |    |  Valor atribuido para a variável lado
        // |   |    |  Operação de multiplicação
        // |   |    | |    Operador de Multiplicação
        // |   |    | |    | 
        double area = lado * lado; // Cálculo da área
        // Classe System que contém membros estáticos como "out"
        // |   Objeto de out
        // |   |   Método de printar coisas no console
        // |   |   |       String sendo passada como parâmetro
        // |   |   |       |  
        System.out.println("A área do quadrado é: " + area);
    }
}
```


# Programação Declarativa
## O que é a programação declarativa?
> É um paradigma com foco em o que deve ser feito, e não em como ser feito. Em vez de descrever passo a passo das instruições como o paradigma anterior, o programador apenas declara a lógica do programa deixando que a implementação exata seja gerenciada pelo compilador, interpretador ou framework.
## Exemplo de programação declarativa
> Cálculo da área de um quadrado em prolog
```prolog
% Definição da regra para calcular a área do quadrado
% Aqui estamos dizendo que a "área de um quadrado" (area_quadrado) 
% é calculada multiplicando o valor do lado por ele mesmo.

% Fato/Regra para área de um quadrado
% A função recebe dois parâmetros: Lado e Area.
area_quadrado(Lado, Area) :- Area is Lado * Lado.

% Consulta: Queremos calcular a área quando o lado for 5.
% A consulta é feita da seguinte forma:
% ?- area_quadrado(5, X).
% Aqui, Lado é 5 e queremos encontrar o valor de Area (X).

% A resposta de Prolog será: X = 25.
% Ou seja, a área de um quadrado com lado 5 é 25.
```