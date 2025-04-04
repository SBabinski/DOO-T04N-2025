 # **Aula05**

**Paradigmas Imperativo e Declarativo**

**Paradigma Imperativo**

No paradigma imperativo, o programador especifica de maneira clara como o problema deve ser resolvido, ou seja, ele escreve uma sequência de instruções que o computador deve executar para atingir um resultado específico. Este paradigma está intimamente ligado ao conceito de controle de fluxo, onde o programador controla passo a passo as variáveis, loops, e condições. A execução de um programa imperativo envolve mudanças de estado explícitas ao longo do tempo. A execução de cada instrução altera o estado do sistema, seja alterando variáveis, seja realizando operações.

Linguagens como Java, C, Python e C++ são exemplos de linguagens que seguem esse paradigma, permitindo ao programador controlar diretamente o fluxo de execução e o estado da aplicação.

**Paradigma Declarativo**

Por outro lado, o paradigma declarativo se concentra mais no o que deve ser feito do que no como. Ao invés de especificar uma sequência de passos a ser seguida, o programador descreve as propriedades ou relações que a solução deve satisfazer. No contexto declarativo, o sistema de execução é responsável por determinar a sequência de passos e como atingir o objetivo desejado.

Linguagens como Prolog, SQL e Haskell se encaixam nesse paradigma. Em vez de o programador descrever detalhes sobre o fluxo de execução, ele simplesmente define o problema, e o sistema encontra a solução. Prolog, por exemplo, usa um mecanismo de inferência baseado em lógica para resolver questões declarativas.

Comparação entre Java (Imperativo) e Prolog (Declarativo)
Exemplo de Código em Java (Imperativo)

**java**

int soma = 0;
for (int i = 1; i <= 10; i++) {
    soma += i;
}
System.out.println(soma);


Explicação:

Sequência de instruções: O código define um processo explícito e sequencial para somar os números de 1 a 10. Ele começa com uma variável soma inicializada em 0 e, em seguida, percorre uma sequência de passos, iterando de 1 até 10 e somando cada valor à variável soma.

Controle do fluxo: O programador tem controle total sobre o fluxo de execução, utilizando um laço for que controla a quantidade de iterações. O contador i é incrementado a cada volta no loop.

Mudança de estado explícita: Cada iteração do laço modifica o valor de soma. O fluxo de execução vai alterando o estado da variável a cada passo, até que o laço seja concluído e o valor final da soma seja impresso.

Visibilidade: A solução é explicitamente detalhada pelo programador, e o computador segue as instruções uma a uma.

Exemplo de Código em Prolog (Declarativo)
prolog

soma(0, 0).
soma(X, Y) :- X > 0, X1 is X - 1, soma(X1, Y1), Y is Y1 + X.

Explicação:

Definição de relações: Em Prolog, o programador define fatos e regras que descrevem as relações entre as variáveis. O fato soma(0, 0) define a base da soma, ou seja, a soma de 0 é 0.

Recursão e inferência: A regra soma(X, Y) define a soma de um número X com Y. A recursão ocorre na parte soma(X1, Y1), onde o valor X1 é obtido subtraindo 1 de X. Prolog então tenta encontrar Y1 de forma recursiva até que o valor de X chegue a 0.

Abstração do fluxo de controle: Ao contrário de Java, o programador não especifica como iterar ou manipular variáveis. Prolog, por meio de seu motor de inferência, tenta diferentes combinações de X e Y para satisfazer a regra. O processo de execução é invisível para o programador, que apenas descreve a relação.

Lógica e backtracking: O sistema de Prolog realiza backtracking, ou seja, ele tenta diferentes possibilidades para satisfazer as relações definidas, o que é uma característica fundamental da execução de programas declarativos.

**Como Ambos Atingem o Objetivo**

Java (Imperativo): No código Java, o objetivo é simplesmente calcular a soma dos números de 1 a 10. O programador descreve de maneira explícita o que o computador deve fazer, isto é, somar os números em uma sequência de passos controlada. Cada passo é bem definido, e o estado da variável soma é modificado iterativamente até que o resultado final seja obtido.

Prolog (Declarativo): Em Prolog, a soma dos números de 1 a 10 é descrita como uma série de relações lógicas. A base da soma é definida pelo fato soma(0, 0), e a soma recursiva é dada pela regra soma(X, Y). O sistema de Prolog, ao invés de seguir uma sequência de passos, tenta satisfazer essas relações de forma recursiva, utilizando seu motor de inferência e backtracking para chegar à solução. O programador não especifica diretamente como a soma deve ser feita, apenas descreve a relação lógica entre os números.

**Conclusão**
Controle e Sequência: No paradigma imperativo, como visto no código Java, o programador tem controle explícito sobre cada passo da execução, descrevendo como os valores são manipulados e acumulados ao longo do tempo. O fluxo de execução é linear e sequencial.

Abstração e Inferência: No paradigma declarativo, como em Prolog, o programador foca em definir relações lógicas e propriedades do problema, enquanto o sistema de execução resolve essas relações por meio de técnicas de inferência, recursão e backtracking. O controle do fluxo é totalmente abstraído, permitindo um nível maior de concisão e flexibilidade, mas, ao mesmo tempo, exigindo que o programador confie no sistema para encontrar a solução.

Portanto, a principal diferença entre os dois paradigmas é a forma como o problema é abordado: imperativo exige a definição explícita do "como", enquanto declarativo se concentra no "o que" precisa ser alcançado, deixando o sistema responsável por encontrar o caminho para a solução.