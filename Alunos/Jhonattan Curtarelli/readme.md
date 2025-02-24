professor não estou afim de baixar java na minha máquina e vou usar docker para rodar o código. Se por acaso você
não gostar me avise que eu paro

# como rodar o projeto com docker
acesse a pasta do projeto no terminal, no caso aula_01 ou assim por diante e rode o comando por 
```docker-compose up```

as vezes o docker faz cache da imagem se alterar alguma coisa. precisaria rodar com a flag --build para limpar o cache
ficando o comando assim
``` docker-compose up --build```

Não use a FLAG -d que ela não exibe as mensagens do terminal do container. assim n exibindo o resultado