# Desafio Crawlers Parte 1

## Plataforma
* Java 8
* Netbeans 8.2

## Dependências
* Jsoup 1.11.3

## Descrição da solução
Para desenvolvimento do desafio de crawlers parte 1 foi necessário aprender sobre a biblioteca Jsoup.
A primeira etapa o programa recebe uma lista de subreddit que podem ser alterados e arrays vazios para armazenar as informações.

```
String nomes = "askreddit;worldnews;cats";
String lista[] = nomes.split(";");
```
Em seguida recebo as informações por de um get pela url e armazeno o resultado em uma variável que percorre um for selecionando cada elemento e  adicionando cada informação em um array específico.
Na última etapa é impresso o subrretids que tem 5000 ou mais upvotes.
