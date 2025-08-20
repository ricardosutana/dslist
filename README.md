# 🎮 DSList - Catálogo de Jogos

Projeto desenvolvido em **Java com Spring Boot**, utilizando **JPA/Hibernate** para persistência de dados em um banco **H2 em memória**.  
O objetivo é criar uma **API REST** para gerenciar uma lista de jogos, com separação em **camadas (Controller, Service, Repository)** e uso de **DTOs** para transferência de dados.

---

## 🚀 Tecnologias utilizadas
- Java 21
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Banco H2 (em memória)
- Maven

---

## 📂 Estrutura do projeto
```
src/main/java/com/devsuperior/dslist
 ┣ 📂 controllers
 ┃ ┗ 📜 GameController.java   # Exposição da API REST
 ┣ 📂 dto
 ┃ ┗ 📜 GameMinDTO.java       # DTO para exposição resumida dos jogos
 ┣ 📂 entities
 ┃ ┗ 📜 Game.java             # Entidade JPA mapeada para tb_game
 ┣ 📂 repositories
 ┃ ┗ 📜 GameRepository.java   # Acesso ao banco de dados via JPA
 ┣ 📂 services
 ┃ ┗ 📜 GameService.java      # Regras de negócio da aplicação
 ┗ 📜 DslistApplication.java  # Classe principal do Spring Boot
```

---

## 🗄️ Entidade `Game`

A classe `Game` é mapeada para a tabela `tb_game`:

| Campo              | Tipo       | Descrição                                  |
|--------------------|------------|---------------------------------------------|
| `id`               | Long       | Identificador único (PK, auto-incremento)  |
| `title`            | String     | Nome do jogo                               |
| `year`             | String     | Ano de lançamento                          |
| `genre`            | String     | Gênero do jogo                             |
| `platforms`        | String     | Plataformas disponíveis                    |
| `score`            | Double     | Nota/avaliação                             |
| `imgUrl`           | String     | URL da imagem do jogo                      |
| `shortDescription` | Text       | Descrição curta                            |
| `longDescription`  | Text       | Descrição detalhada                        |

---

## 📊 Banco de dados H2

- O projeto utiliza **H2 em memória**, recriado a cada execução.  
- Dados iniciais são carregados automaticamente via `data.sql`.  
- Para acessar o console do H2:
  - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - JDBC URL: `jdbc:h2:mem:testdb`
  - User: `sa`
  - Password: (em branco)

---

## 🌐 Endpoints da API

### 🔹 Listar todos os jogos
```http
GET /games
```
**Resposta (usando `GameMinDTO`):**
```json
[
  {
    "id": 1,
    "title": "Mass Effect Trilogy",
    "year": "2012",
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
    "shortDescription": "Lorem ipsum dolor sit amet..."
  },
  {
    "id": 2,
    "title": "Red Dead Redemption 2",
    "year": "2018",
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png",
    "shortDescription": "Lorem ipsum dolor sit amet..."
  }
]
```

> 📌 O uso do **DTO (`GameMinDTO`)** garante que apenas as informações necessárias sejam expostas pela API, evitando retornar todos os dados da entidade `Game`.

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 21
- Maven 3+

### Passos
```bash
# clonar o repositório
git clone https://github.com/ricardosutana/dslist.git

# entrar na pasta do projeto
cd dslist

# compilar e executar
./mvnw spring-boot:run
```

Aplicação estará disponível em:  
👉 [http://localhost:8080](http://localhost:8080)

---


