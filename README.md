# 💳 Sistema Bancário com Interface Gráfica (JavaFX + JDBC + PostgreSQL)

Este projeto é uma aplicação desktop desenvolvida em Java com JavaFX, simulando um sistema bancário com interface gráfica. Permite o cadastro, visualização, atualização e exclusão de clientes, com persistência dos dados em banco de dados PostgreSQL e segurança de senhas.

![Interface do sistema](./screenshot.png)

---

## 🧰 Tecnologias Utilizadas

- **Java 21**
- **JavaFX** (interface gráfica)
- **JDBC puro** (para conexão com banco de dados)
- **PostgreSQL** (armazenamento dos dados)
- **BCrypt (jbcrypt)** (criptografia segura de senhas)
- **DBeaver** (para visualização e gerenciamento do banco)

---

## 📋 Funcionalidades

- ✅ Cadastro de clientes
- ✅ Listagem dos clientes cadastrados
- ✅ Edição de dados do cliente
- ✅ Exclusão de cliente
- ✅ Armazenamento seguro da senha com hash (BCrypt)
- ✅ Interface gráfica intuitiva e responsiva
- ✅ Ao clicar no nome de um cliente na interface, é possível **editar ou excluir** diretamente

---

## 🖼️ Interface Gráfica

A interface foi construída com JavaFX.  
Ela possui:

- Campos de entrada para: nome, CPF, idade, sexo, tipo de conta e senha
- Botão para salvar dados
- Tabela de clientes cadastrados com:
  - ID, nome, sexo, idade
  - Ao clicar no nome do cliente, surgem opções de **editar** ou **excluir**

---

## 🔐 Segurança das Senhas

As senhas dos clientes **nunca são armazenadas em texto plano**.

Utilizamos a biblioteca [`jbcrypt`](https://www.mindrot.org/projects/jBCrypt/) para aplicar hash seguro:

```java
SenhaUtils.hashSenha("senhaPura");
SenhaUtils.verificarSenha("senhaDigitada", hashArmazenado); 
```
🐘 Banco de Dados
📦 Criação do banco no PostgreSQL
Você pode usar o DBeaver ou o terminal SQL:

CREATE TYPE gender AS ENUM ('MASCULINO', 'FEMININO');
CREATE TYPE account AS ENUM ('POUPANCA', 'CORRENTE');

CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    account account NOT NULL,
    gender gender NOT NULL,
    age INTEGER NOT NULL
);

🚀 Docker (opcional)
```bash
docker run --name postgres-banco -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```

🛠️ Como rodar o projeto
1. Clone o repositório
```bash
git clone https://github.com/arthurvasc-hub/sistema-bancarioFX.git
```
2. Configure o banco PostgreSQL

Banco: sistemafx
Usuário e senha: postgres (ou altere em Gateway.java)
Tabela: veja instruções acima

3. Compile o projeto

Java 21 instalado
JavaFX adicionado ao classpath (ou configurado via SDK)

4. Execute o Main.java na sua IDE

✅ Próximas melhorias (ideias)
 Tela de login com autenticação

 Separar cliente por contas (corrente/poupança)

 Funcionalidade de saque, depósito, transferência

 Histórico de transações por conta

 Empacotamento .jar ou .exe com JavaFX incluído

👨‍💻 Autor
Arthur Vasconcelos
🔗 LinkedIn: [linkedIn.](https://www.linkedin.com/in/arthurvasc/)

