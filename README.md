# Checkpoint 4

Checkpoint 4 Microsserviços em Java


# Docker Hub

No docker hub, criar um repositório para armazenar as imagens


# Subir no Docker Hub

1 - Fazer o Login no docker  
2 - Criar a tag e inserir o nome dela  
3 - Fazer o push para o Docker Hub  

```
docker login
docker build -t usuario/checkpoint5:0.0.1 .
docker push usuario/checkpoint5:0.0.1
```

# Orientações para o Docker Compose

Docker compose up - Roda a aplicação
Docker compose up -d - Roda a aplcação porém sem o log
Docker compose stop - Para a aplicação

```
docker compose up
docker compose up -d
docker compose stop
```
