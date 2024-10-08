
# API REST para consultar a tabela Tarefa

Esta API RESTful desenvolvida para a atividade de POO II e permite gerenciar tarefas, incluindo a criação, consulta, atualização e exclusão de tarefas. O endpoint principal é http://localhost:8080/tarefas.
## Métodos HTTP
- GET
- POST
- PUT
- DELETE
#

GET
- Requisição de todas as tarefas
```bash
  GET http://localhost:8080/tarefas
```
Exemplo de resposta esperada:
```
  {
    "id": 1,
    "titulo": "Finalizar relatório",
    "descricao": "Finalizar o relatório anual até sexta-feira",
    "finalizado": false,
    "dataPrevistaFinalizacao": "2024-09-15",
    "dataFinalizacao": null
  }
```
- Requisição por ID específico
```bash
  GET http://localhost:8080/tarefas/2
```
```
Exemplo de resposta:
{
  "id": 2,
  "titulo": "Finalizar projeto",
  "descricao": "Finalizar o projeto comunitário sexta-feira",
  "finalizado": false,
  "dataPrevista": "2024-10-01",
  "dataFinalizacao": null
}
```
#
POST
- Requisição para inserir uma nova tarefas
```bash
  GET http://localhost:8080/tarefas
```
Exemplo de corpo para a requisição:
```
{
  "titulo": "Reunião com equipe",
  "descricao": "Organizar reunião para discutir o andamento do projeto",
  "dataPrevista": "2024-09-18"
}
```
Exemplo de resposta esperada:
```
{
  "id": 3,
  "titulo": "Reunião com equipe",
  "descricao": "Organizar reunião para discutir o andamento do projeto",
  "finalizado": false,
  "dataPrevista": "2024-09-18",
  "dataFinalizacao": null
}
```
#
PUT
- Requisição para atualizar uma determinada tarefa
```bash
  GET http://localhost:8080/tarefas/3 --> inserir ID da tarefa que deseja atualizar
```
Exemplo de corpo para a requisição:
```
{
  "titulo": "Reunião com equipe atualizada",
  "descricao": "Reunião atualizada para discutir novos prazos",
  "finalizado": false,
  "dataPrevista": "2024-09-18",
  "dataFinalizacao": null
}
```
Exemplo de resposta esperada:
```
{
  "id": 3,
  "titulo": "Reunião com equipe atualizada",
  "descricao": "Reunião atualizada para discutir novos prazos",
  "finalizado": false,
  "dataPrevista": "2024-09-18",
  "dataFinalizacao": null
}
```
#
DELETE
- Requisição para atualizar uma determinada tarefa
```bash
  GET http://localhost:8080/tarefas/2 --> inserir ID da tarefa que deseja excluir
```
Resposta:

Código de status: *200 OK* (se a exclusão for bem-sucedida).
## Regras de Validação

- O campo *titulo* é obrigatório e deve conter pelo menos 5 caracteres.
- O campo *dataPrevista* é obrigatório.
- Não é possível excluir ou atualizar tarefas que estejam marcadas como finalizadas *(finalizado = true)*.


## Erros Comuns

*400 Bad Request:* Se o corpo da requisição estiver faltando campos obrigatórios ou se o formato dos dados estiver incorreto.

*500 Internal Server Error:* mensagem de erro genérica caso tente manipular alguma tarefa inexistente, ou tente manipular uma tarefa finalizada.


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/amanda-crispim/)


