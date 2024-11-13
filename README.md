[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/ixmgleRn)
<center><h1>Avaliação Continuada 3</h1></center>

## ⚠️ Aviso Importante: Por favor, leia as instruções abaixo com cuidado antes de iniciar a prova. ⚠️

## Confirme se o seu código foi devidamente enviado para o repositório remoto.

## Lembre-se: Não nos responsabilizamos por falhas no envio do código.

<hr>

<h1 style="color: yellow;">Início Enunciado:</h1>

## Entidades

### Descrição da Classe Curso

A classe `Curso` é uma entidade JPA que representa um curso. Abaixo estão descritas suas características e validações:

#### Características

- **id**: Identificador único do curso.
    - Tipo: `Integer`
    - Descrição: Campo autoincrementado que serve como chave primária.

- **nome**: Nome do curso.
    - Tipo: `String`
    - Descrição: Campo obrigatório que não pode estar vazio ou em branco.

- **descricao**: Descrição do curso.
    - Tipo: `String`
    - Descrição: Campo obrigatório que não pode estar vazio ou em branco.

- **cargaHoraria**: Carga horária do curso.
    - Tipo: `Integer`
    - Descrição: Campo obrigatório que deve ser um número positivo.

#### Outras regras

- **nome**: Deve ser único. Independe de maiúsculas e minúsculas.

### Descrição da Classe Inscricao

A classe `Inscricao` é uma entidade JPA que representa uma inscrição em um curso. Abaixo estão descritas suas
características e validações:

### Características

- **id**: Identificador único da inscrição.
    - Tipo: `Integer`
    - Descrição: Campo autoincrementado que serve como chave primária.

- **nome**: Nome da pessoa inscrita.
    - Tipo: `String`
    - Descrição: Campo obrigatório que não pode estar vazio ou em branco.

- **email**: Email da pessoa inscrita.
    - Tipo: `String`
    - Descrição: Campo obrigatório que deve ser um endereço de email válido e não pode estar vazio ou em branco.

- **dataNascimento**: Data de nascimento da pessoa inscrita.
    - Tipo: `LocalDate`
    - Descrição: Campo obrigatório que deve conter uma data no passado.

- **dataInscricao**: Data da inscrição.
    - Tipo: `LocalDate`
    - Descrição: Campo obrigatório que deve conter uma data.

- **curso**: Curso associado à inscrição.
    - Tipo: `Curso`
    - Descrição: Representando que uma inscrição deve estar associada a um curso. Um curso pode ter muitas inscrições
      associadas a ele, e a relação não deve ser bidirecional.

#### Outras regras

- **email**: Deve ser único. Independe de maiúsculas e minúsculas.
- **dataNascimento**: o inscrito deve ter no mínimo 18 anos completos na data da inscrição, ou seja, a diferença entre a
  data de nascimento e a data da inscrição deve ser de no mínimo 18 anos.

<hr>

## Endpoints

### Cursos

#### GET /cursos

Retorna a lista de todos os cursos cadastrados.

#### GET /cursos/{id}

Retorna o curso com o id informado.

#### POST /cursos

Cadastra um novo curso. (Utilize a própria entidade `Curso` no corpo da requisição).
Ignore o campo `id` no corpo da requisição, pois o id será gerado automaticamente.

### Inscricões

#### GET /inscricoes

Retorna a lista de todas as inscrições cadastradas.

#### GET /inscricoes/{id}

Retorna a inscrição com o id informado.

#### POST /inscricoes/cursos/{idCurso}

Cadastra uma nova inscrição. (Utilize a própria entidade `Inscricao` no corpo da requisição)
Ignore o campo `curso` no corpo da requisição, pois o curso será informado através do id do curso.

#### DELETE /inscricoes/{id}

Remove APENAS a inscrição com o id informado, mantendo o curso cadastrado.

<h1 style="color: yellow;">Fim Enunciado:</h1>

<hr>

## FAQ

### Deve utilizar mapeamento bidirecional entre `Curso` e `Inscricao`?

- Não, a relação entre `Curso` e `Inscricao` deve ser unidirecional. Ou seja, a entidade `Inscricao` deve possuir uma
referência para o `Curso`, mas a entidade `Curso` não deve possuir uma referência para a `Inscricao`.

### Como validar a regra de que o inscrito deve ter no mínimo 18 anos completos na data da inscrição?

- Utilize os métodos da própria classe LocalDate para calcular a diferença entre as datas e validar a regra.

### Posso Utilizar DTOs?

- Não, utilize as próprias entidades JPA nos endpoints.

### Nenhum teste passa, o que fazer?

- Verifique se as entidades estão mapeadas corretamente. Se estiverem, verifique o repository e o service de cada
entidade. Se ainda assim não conseguir resolver, **verifique se o PROJETO roda.**

### A nota será baseada em testes?

- SIM, a nota será baseada nos testes. Portanto, é importante que todos os testes estejam passando.

### A prova tem consulta? Posso usar GPT, Copilot, StackOverflow, etc?

- Sim, a prova tem consulta. Você pode usar qualquer fonte de consulta, **mas não pode pedir ajuda a outras pessoas.**

### Posso pedir ajuda a outras pessoas?

- Não, você não pode pedir ajuda a outras pessoas. A prova é individual. **Casos de plágio serão desclassificados.**

### Preciso usar Lombok?

- Não, você não precisa usar Lombok. **Mas pode usar se preferir(a dependência já está no `pom.xml`).**

### Posso adicionar dependências no projeto?

- Não, você não pode adicionar dependências no projeto. Utilize apenas as dependências que já estão no arquivo `pom.xml`.

### Posso alterar o arquivo `application.properties`?

- Não, você não pode alterar o arquivo `application.properties`, **ISSO PODE IMPACTAR SUA NOTA**

### Posso alterar o arquivo `data.sql`?

- Não, você não pode alterar o arquivo `data.sql`, **ISSO PODE IMPACTAR SUA NOTA**

### Posso alterar os testes?

- Não, você não pode alterar os testes. Caso encontre algum erro nos testes, reporte ao professor posteriormente. **ISSO
PODE IMPACTAR SUA NOTA**

### O projeto tem Swagger?

- Sim, caso queira testar os endpoints, o projeto possui o Swagger. Para acessar, utilize a
URL `http://localhost:8080/swagger-ui/index.html`.
