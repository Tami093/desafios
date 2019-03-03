# Desafio Crawlers Parte 1

## Plataforma
Java 8

## Dependências
* Jsoup 1.11.3

## Pré requisito
* JDK8+
* Maven 4.0.0

## Construção
Executar a execução
mvm install

## Descrição da solução

Para desenvolvimento do desafio de crawlers parte 1 foi necessario aprender sobre a biblioteca jsoup.

A primeira etapa o programa recebe uma lista com subreddit que podem ser alterados e com laço for pecorre 
um os elementos especificos coletando informações e adicionando em um ArrayList.
Após dessa interação verifiquei que alguns subreddits possuiam a classe relacionadas ao elementos"<a>" 
titulo com nomes diferentes,para resolução desse problema implementação o codigo abaixo:
```
div[class=top-matter]>p[class=title]>a

```
A etapa final verifica se o subreddit possui 5000 ou mais upvotes. Caso sim, as infomações são impressa.
