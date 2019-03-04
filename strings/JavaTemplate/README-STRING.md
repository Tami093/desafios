# Desafio String

## Plataforma
Java 8

## Descrição da solução
O desafio consistia em receber uma String sem formatação para podemos parametrizar.
O método percorre a String e verifica o limite de caractere em cada linha, conforme  especificado no desafio.
Após da verificação  acima é dividido em duas etapas. A primeira etapa busca o último elemento da linha e verifica se é espaço, caso ao contrário verifica se o próximo é um espaço para não ocorre uma quebra de palavra. 
Com resultado da etapa acima a última etapa verifica quais as linhas que tem menos de 40 caracteres e adiciona espaço até atingir o limite.


