# **Trabalho de  Paradigmas (Imperativo e declarativo)**

**Eduardo de Carvalho Fernandez**  
**Turma TN04**  
**3º Período Noturno**  
  
  

## Introdução


-  Os paradigmas de programação definem a forma como um programa é estruturado e executado. Dois dos principais paradigmas são o imperativo e o declarativo, que se diferenciam na maneira como as instruções são dadas ao computador.

---
## Imperativo

- No paradigma imperativo, o programador especifica como o programa deve executar cada passo para chegar ao resultado. Já no paradigma declarativo, o foco está no que precisa ser feito, sem detalhar como a execução deve acontecer.

---

## Declarativo

- Por outro lado, o paradigma **declarativo** enfatiza a descrição do que deve ser feito, sem especificar diretamente como. Ele inclui subparadigmas como **programação funcional e lógica**, com linguagens como **Prolog e Haskell**.

---

## **Comparando Java (Imperativo) e Prolog (Declarativo)**

Abaixo está a comparação entre dois trechos de código que verificam se um número é par.

### **Java (Imperativo)**
```java
public class Paridade {
    public static boolean Par(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        int numero = 4;
        System.out.println("O número " + numero + " é par? " + Par(numero));
    }
}
```
### **Prolog (Declarativo)**
``` prolog
  par(Numero) :- 
    0 is Numero mod 2.

?- par(4).
true.

``` 
### **Análise dos Códigos**

**Java (Imperativo):**
 O programa define uma função **Par** que recebe um inteiro e retorna **true** se o resto da divisão por 2 for zero. O método main executa a verificação e imprime o resultado.

**Prolog (Declarativo):**
 A regra **par/1** define que um número é par se o resto da divisão por 2 for zero. O programa consulta essa regra diretamente **(?- par(4).)**, e o motor de inferência do Prolog determina a resposta automaticamente.

### **Conclusão**
O paradigma imperativo (Java) exige que o programador defina explicitamente os passos para a verificação, enquanto o paradigma declarativo (Prolog) apenas expressa a relação entre os dados, deixando a resolução a cargo do interpretador. Ambos atingem o mesmo objetivo, mas seguem abordagens distintas.