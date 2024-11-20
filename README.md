# Biblioteca

Este é um projeto de uma biblioteca em Java que permite gerenciar livros, autores, clientes e empréstimos.

## Funcionalidades

- **Cadastro de Clientes**: Crie uma classe `Cliente` para representar os usuários da biblioteca, com atributos como `id`, `nome`, `dataNascimento` e `email`.
- **Cadastro de Livros**: Adicione livros à biblioteca, associando-os a autores.
- **Empréstimos**: Realize e gerencie empréstimos de livros para clientes.
- **Histórico de Empréstimos**: Consulte o histórico de empréstimos de um livro ou cliente específico.
- **Busca de Livros**: Busque livros por título ou autor.
- **Listagem de Clientes e Livros**: Liste todos os clientes e livros cadastrados, bem como livros disponíveis e emprestados.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

src/ ├── main/ │ └── java/ │ └── org/ │ └── example/ │ ├── Autor.java │ ├── Biblioteca.java │ ├── Cliente.java │ ├── Emprestimo.java │ ├── Livro.java │ └── Main.java └── test/ └── java/ └── org/ └── example/ └── BibliotecaTest.java

## Classes Principais

### `Cliente`

Representa um cliente da biblioteca.

### `Livro`

Representa um livro da biblioteca.

### `Autor`

Representa um autor de livros.

### `Emprestimo`

Representa um empréstimo de livro.

### `Biblioteca`

Gerencia os livros, autores, clientes e empréstimos.

### `Main`

Classe principal que contém o método `main` e a interface de usuário.

## Como Executar

1. Compile o projeto:
    ```sh
    mvn compile
    ```
2. Execute o projeto:
    ```sh
    mvn exec:java -Dexec.mainClass="org.example.Main"
    ```

## Requisitos

- Java 11 ou superior
- Maven

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.