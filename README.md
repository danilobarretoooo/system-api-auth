# 🛡️ System API Auth

System API Auth é uma API de autenticação e gerenciamento de usuários desenvolvida com **Spring Boot 3.4.3** e **Java 21**. O projeto fornece um sistema seguro de login e controle de acesso, utilizando **JWT (JSON Web Token)** para autenticação.

Atualmente, a aplicação conta com:

- 🔐 **Autenticação e Autorização** via **JWT**
- 👤 **Gerenciamento de Usuários** (Cadastro, Login)
- 🔒 **Integração com Spring Security**
- 🛠️ **Configuração pronta para expansão**

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **JPA + Hibernate**
- **MySQL (ou outro banco de dados configurável)**

---

## 📦 Como Rodar o Projeto

### Pré-requisitos

- **JDK 21** instalado
- **Maven** instalado
- Banco de dados MySQL (ou outra configuração no `application.properties`)

### Passos para execução

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/system-api-auth.git
   cd system-api-auth
2. Configure o banco de dados no arquivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update

3. Execute o projeto com Maven:
   ```sh
     mvn spring-boot:run


### 🔑 Endpoints Disponíveis

🔹 Autenticação

POST /auth/login → Faz login e retorna o JWT
POST /auth/register → Registra um novo usuário

🔹 Usuários

GET /users → Lista todos os usuários (Acesso restrito)
GET /users/{id} → Detalhes de um usuário específico
PUT /users/{id} → Atualiza dados do usuário
DELETE /users/{id} → Exclui um usuário

📜 Licença
Este projeto é open-source e pode ser utilizado livremente. 😊





