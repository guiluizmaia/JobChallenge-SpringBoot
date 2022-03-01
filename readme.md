# Desáfio
## _Votação Pauta_

A aplicação fará a criação de pautas e essas pautas poderão receber votos de usuários, enquanto aberta.
Técnologias usadas

- Java Spring Boot
- MongoDb
- RabbitMq
- Docker / Docker-Compose

## Início
Para iniciar, rode os containers
```sh
docker-compose up --build
```

## Estruturação de Pastas
Dentro do JobChallenge tem  quatro pastas
 - connections
    É a pasta que se encontra a conexão com o RabbitMQ e respectivo Adapter
 - exception
    Contém duas classes de exceção, BadRequestException(recebe uma mensagem como parâmetro e retorna com o mesmo com o status 400) e ResourceNotFoundException(recebe como parametro o que não foi encontrado, qual foi o atributo em que foi buscado e qual o valor desse atributo. Retorna 404 com uma mensagem elaborada com os atributos recebidos)
 - utils
    Contém  a requisição para a API externa passada
 - modules
    Contém dois modulos, schedule e users, cada um é focado em um recurso. Dentro de cada módulo contém 
    - application
        - dto
            Contém os dtos
        - service
            Contém os services
        - web
            Contém os controllers
    - domain
        Contém as entidades e os repositórios


## Rotas
### POST - /user
Cria um usuário novo. Caso de erro retornará 400
- Exemplo de Body:
```sh
{	
	"firstName":"Rodrigo",
    "lastName":"Silva",
    "email":"silva@test.com",
    "cpf":"12143896000"
}
```
### GET - /user
Lista todos os usuários criados

### GET - /user/{id}
Lista um usuário por seu id. Caso não exista retornará 404

### POST - /schedule
Cria uma nova pauta. Caso não seja enviado o "timeMin", ele fica 1 por default. Nessa mesma hora é chamada a função que calculará o resultado, passará o campo active da pauta para false e mandará o resultado para uma fila criada assim que o server inicia
- Exemplo de Body:
```sh
{
	"schedule": "Vou passar no processo?",
	"timeMin": "5"
} 
```

### GET - /schedule
Lista todas as pautas criadas

### GET - /schedule/{id}
Lista uma pauta por seu id. Caso não exista retornará 404

### POST - /schedule/vote
Cria um voto em uma tabela separada apenas para votos, nessa chamada, antes de efetivamente criar o voto, é verificado se o user existe, se a schedule exista, se está ativa, se o cpf do usuário é válido, e por fim se o usuário ja votou nessa pauta. Se tudo isso estiver de acordo ele cria o voto
- Exemplo de Body:
```sh
{
	"userId": "726d8f49-14ec-41b0-917a-27b34fcccb87",
	"scheduleId": "cc6fac91-6f0e-4a01-9e9d-54a0393df7b1",
	"response": "y"
} 
```


## Para Testar
Para testar recomendo criar 3 usuários com CPFs diferentes para pelo menos um dar o erro de não estar válido para votar, depois criar uma pauta e usar eles para votar