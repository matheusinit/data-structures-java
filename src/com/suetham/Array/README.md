## Array

Array é estrutura fixa e contínua de dados de um tipo único. Por exemplo o código abaixo em Java:

```java
class Program {
    public static void Run() {
        int[] nums = new int[5];
    }
}
```

Array de Inteiros (*Integer*) com tamanho fixo 5.

Mas e se o Array precisar que o seu tamanho aumente?
Pra isso existe *Array Dinâmico (Dynamic Array)*, um
array que aumenta quando o atual ficar cheio.

**Acesso**

O acesso é constante, ou seja, O(1) em notação Big O.
Isso quer dizer que essa ação é sempre a mesma
independente do número do tamanho do Array.

Acesso é tão rápido devido ao endereçamento. O
array possui o endereço de memória que começa o 
Array. Por ser contínuo os outros itens podem ser 
acesso com aritmética e o tipo de dado do Array.

#### Explicação de Aritmética de Ponteiros

O código abaixo vai ser implementado em C pois Java
não suporta ponteiros (*pointers*). Para mais detalhes:
https://qr.ae/pGBD40

```c
#include <stdio.h>

int main() {
  int z[10];
  int *ip;

  z[0] = 2;
  z[1] = 4;
  z[2] = 8;
  z[3] = 16;

  ip = &z[0];

  printf("Pointer: %d\n", *(ip + 1));

  printf("Array: ");
  printf("[ %d, %d, %d, %d ]\n", z[0], z[1], z[2], z[3]);

  return 0;
}
```

O código acima demonstra a utilização de aritmética
de endereçamento utilizando linguagem C.

O uso de acesso com `z[1]` é o mesmo que 
`*(ip + 1)`. O porquê é simples, como já citado antes
o Array possui o endereço de memória em que começa.
Com esse endereço é possível acessar somente o primeiro
elemento, mas se quiser acessar outros?

Porque Array utilizam tipo de dado fixo e é contínuo,
basta somar o endereço de início do Array somando com
o produto tamanho do dado e o index.

```markdown
Assuma que o endereço de início: 0x00000000 (Vamos usar A)
Estamos utilizando Integers (Inteiros): 4 bytes em C

Para acessar o primeiro elemento o tamanho é irrelevante. 
Mas para o segundo não.

Acessar segundo elemento: A + (4 bytes * 1) (0x00000004)
```

0x00000004 é o endereço do segundo elemento, e é assim 
como o acesso de Arrays é utilizado por baixo dos panos.

Um simples `a[4]` é uma aritmética de 
`A + (tamanho do tipo * 4)` 

Isso só é possível, pois C suporta uso de *Pointer* 
(Ponteiro). Em Java e muitas outras linguagens de programação, 
*Pointers* não é utilizado por questão de segurança e falhas que poderiam
ser gerada, invés disso é utilizado *Referências (Reference)*.

**Inserção**

A complexidade da inserção depende do caso. Inserção no final do array
pode ser O(1) (*constante*), ou O(n), em caso de precisar aumentar o
tamanho do array em inserção.

Inserção no meio ou no início do Array é O(n), pois é preciso que os
itens sejam movidos um *index* a mais.

**Remoção**

Remoção no final é O(1). Mas nos casos do início e do meio é O(n) pelos
mesmos motivos que a da inserção.