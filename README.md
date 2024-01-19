# LEONARD WMS v1.0
Sistema do tipo WMS (Warehouse Management System, ou [Sistema de Gerenciamento de Armaz�m](https://ilos.com.br/wms-no-gerenciamento-de-depositos-armazens-e-centros-de-distribuicao/)) capaz de monitorar e gerenciar as opera��es b�sicas de um centro de distribui��o. 
 
## ? Sobre o projeto:
Projeto desenvolvido em ambiente acad�mico, cujo objetivo foi apresent�-lo como trabalho de conclus�o de curso, no curso de gradua��o em Engenharia da Computa��o, na faculdade FEITEP. A monografia completa pode ser baixada [clicando aqui](assets/TCC-final.pdf)

## ??? Desenvolvedor:
- [Allan Chavier Felintro](https://www.linkedin.com/in/allanfelintro/)

## ?? Modelagem:
<img src = "assets/leonard_db.png" />

A primeira modelagem foi para definir a estrutura do projeto e os endpoints


<img src = "./universitario/universitario/assets/Modelagem BD Sistema Universit�rio.png"  width="350" height="300"/>

Modelagem original do projeto para Sistema Universit�rio onde adequamos ao MVP (M�nimo Produto Vi�vel) para nossa primeira entrega ao cliente focando na gest�o de turmas


<img src = "./universitario/universitario/assets/BD UNIVERSIDADE CRESCER.png"  width="350" height="300"/>

## ? Manipula��o das Rotas de Usu�rios:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ | --------------------------- | ------------------------------------ |
| GET          | `/usuarios`                 | Retorna todos os usu�rios            |
| GET          | `/usuarios/{id}`            | Retorna as informa��es do usu�rio    |
| POST         | `/usuarios`                 | Cria/cadastra um novo usu�rio        |
| PUT          | `/usuarios/{idUser}/{email}`| Altera email de um usu�rio           |
| PUT          | `/usuarios/{idUser}/{senha}`| Altera senha de um usu�rio           |     
| DELETE       | `/usuarios/{id}`            | Deleta um usu�rio                    |

## ? Manipula��o das Rotas de Endere�o:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ | --------------------------- | ------------------------------------ |
| GET          | `/endereco/{id}`            | Retorna as informa��es do endere�o   |
| POST         | `/endereco`                 | Cria/cadastra um novo endere�o       |
| PUT          | `/endereco/{id}`            | Altera informa��es de um endere�o    |   
| DELETE       | `/endereco/{id}`            | Deleta um endere�o                   |

## ? Manipula��o das Rotas de Alunos:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ | --------------------------- | ------------------------------------ |
| GET          | `/aluno/todos-alunos`       | Retorna todos os alunos              |
| GET          | `/aluno/aluno-ativo`        | Retorna alunos ativos                |
| POST         | `/aluno`                    | Cria/cadastra um novo aluno          |
| PUT          | `/aluno/{id}`               | Altera informa��es de um aluno       |
| DELETE       | `/aluno/deletar-aluno/{id}` | Adiciona status de inativo ao aluno  |

## ? Manipula��o das Rotas de Professores:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ | --------------------------- | ------------------------------------ |
| GET          | `/professor/listar-todos`   | Retorna todos os professores         |
| GET          | `/professor/listar-ativos`  | Retorna professores ativos           |
| GET          | `/professor/encontrar/{id}` | Retorna informa��es de um professor  |
| POST         | `/professor/cadastrar`      | Cria/cadastra um novo professor      |
| PUT          | `/professor/atualizar/{id}` | Altera informa��es do professor      |
| DELETE       | `/professor/deletar/{id}`   | Adiciona status inativo ao professor |

## ? Manipula��o das Rotas de Cursos:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ | --------------------------- | ------------------------------------ |
| GET          | `/cursos/todos-cursos`      | Retorna todos os cursos              |
| GET          | `/cursos/{id}`              | Retorna as informa��es do curso      |
| POST         | `/cursos/novo-curso`        | Cria/cadastra um novo curso          |
| POST         | `/cursos/add-disciplina`    | Adiciona o relacionamento de curso   |
|@RequestParam |`("idCurso")("idDisciplina")`| com uma disciplina                   |
| PUT          | `/cursos/{id}`              | Altera informa��es de um curso       |
| DELETE       | `/cursos/deletar/{id}`      | Deleta um curso                      |
| DELETE       | `/cursos/del-disciplina`    | Deleta o relacionamento de curso     |
|@RequestParam |`("idCurso")("idDisciplina")`| com uma disciplina                   |

## ? Manipula��o das Rotas de Disciplinas:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ | --------------------------- | ------------------------------------ |
| GET          | `/disciplina`               | Retorna todas as disciplina          |
| POST         | `/disciplina`               | Cria/cadastra uma nova disciplina    |
| PUT          | `/disciplina/{id}`          | Altera informa��es de uma disciplina |
| DELETE       | `/disciplina/{id}`          | Deleta uma disciplina                |
| DELETE       | `/disciplina/deletar-profe` | Deleta o relacionamento              |
|              | `ssor/{idProf}/{idDisci}`   | do professor(a) com a disciplina     |


## ? Manipula��o das Rotas de Turmas:

| M�todo HTTP  | Endpoint                    | Descri��o                            |
| ------------ |  -------------------------- | ------------------------------------ |
| GET          | `/turma`                    | Retorna todas as turmas              |
| GET          | `/turma/{id}`               | Retorna as informa��es da turma      |
| POST         | `/turma/salvar-turma`       | Cria/cadastra uma nova turma         |
| POST         | `/turma/add-turma-aluno`    | Adiciona o relacionamento de         |
|              | `/{idTurma}/{idAluno}`      | aluno a uma turma                    |
| POST         | `/turma/add-turma-professor`| Adiciona o relacionamento de         |
|              | `/{idTurma}/{idProfessor}`  | professor a uma turma                |
| POST         |`/turma/add-turma-disciplina`| Adiciona o relacionamento de         |
|              | `/{idTurma}/{idDisciplina}` | disciplina a uma turma               |
| PUT          | `/turma/update-turma/{id}`  | Altera informa��es de uma turma      |
| DELETE       | `/turma/remove-turma/{id}`  | Deleta uma turma                     |
| DELETE       | `/turma/remove-turma-aluno` | Deleta o relacionamento              |
|              | `/{idTurma}/{idAluno}`      | de aluno com a turma                 |
| DELETE       | `/turma/remove-turma-profe` | Deleta o relacionamento              |
|              | `ssor/{idTurma}/{idProf}`   | de professor com a turma             |
| DELETE       | `/turma/remove-turma-disci` | Deleta o relacionamento              |
|              | `plina/{idTurma}/{idDisc}`  | de disciplina com a turma            |

## ? Melhorias para o futuro (Em constru��o):

* Terminar toda a modelagem do projeto.
* Adicionar mais tabelas ao banco de dados.
* Implementar o front-end na aplica��o.

