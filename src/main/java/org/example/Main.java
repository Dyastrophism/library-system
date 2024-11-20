package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Autor autor1 = new Autor("George R. R. Martin", LocalDate.of(1948, 9, 20));
        Autor autor2 = new Autor("J. K. Rowling", LocalDate.of(1965, 7, 31));

        Livro livro1 = new Livro("A Game of Thrones", autor1, LocalDate.of(1996, 8, 6));
        Livro livro2 = new Livro("Harry Potter and the Philosopher's Stone", autor2, LocalDate.of(1997, 6, 26));

        Cliente cliente1 = new Cliente(1L, "João", LocalDate.of(1990, 1, 1), "joao@email.com");
        Cliente cliente2 = new Cliente(2L, "Maria", LocalDate.of(1995, 2, 2), "maria@email.com");

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarCliente(cliente1);
        biblioteca.adicionarCliente(cliente2);

        while (true) {
            System.out.println("Bem-vindo à biblioteca!");
            System.out.println("1 - Listar autores");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Listar livros disponíveis");
            System.out.println("4 - Listar clientes");
            System.out.println("5 - Consultar histórico de empréstimos de um cliente");
            System.out.println("6 - Consultar histórico de empréstimos de um livro");
            System.out.println("7 - Buscar livro por título");
            System.out.println("8 - Buscar livros por autor");
            System.out.println("9 - Cadastrar novo livro");
            System.out.println("10 - Realizar empréstimo");
            System.out.println("11 - Realizar devolução");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Autores cadastrados:");
                for (Autor autor : biblioteca.listarAutores()) {
                    System.out.println(autor);
                }
            } else if (opcao == 2) {
                System.out.println("Livros cadastrados:");
                for (Livro livro : biblioteca.listarLivros()) {
                    System.out.println(livro);
                }
            } else if (opcao == 3) {
                System.out.println("Livros disponíveis:");
                for (Livro livro : biblioteca.listarLivrosDisponiveis()) {
                    System.out.println(livro);
                }
            } else if (opcao == 4) {
                System.out.println("Clientes cadastrados:");
                for (Cliente cliente : biblioteca.listarClientes()) {
                    System.out.println(cliente);
                }
            } else if (opcao == 5) {
                System.out.println("Digite o ID do cliente:");
                Long idCliente = scanner.nextLong();
                Cliente cliente = biblioteca.listarClientes().stream().filter(c -> c.getId().equals(idCliente)).findFirst().orElse(null);
                if (cliente != null) {
                    System.out.println("Histórico de empréstimos do cliente " + cliente.getNome() + ":");
                    for (Emprestimo emprestimo : biblioteca.listarEmprestimosPorCliente(cliente)) {
                        System.out.println(emprestimo);
                    }
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            } else if (opcao == 6) {
                System.out.println("Digite o ID do livro:");
                Long idLivro = scanner.nextLong();
                Livro livro = biblioteca.buscarLivroPorId(idLivro);
                if (livro != null) {
                    System.out.println("Histórico de empréstimos do livro " + livro.getTitulo() + ":");
                    for (Emprestimo emprestimo : biblioteca.listarEmprestimosPorLivro(livro)) {
                        System.out.println(emprestimo);
                    }
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } else if (opcao == 7) {
                System.out.println("Digite o título do livro:");
                String titulo = scanner.nextLine();
                Livro livro = biblioteca.buscarLivroPorTitulo(titulo);
                if (livro != null) {
                    System.out.println("Livro encontrado: " + livro);
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } else if (opcao == 8) {
                System.out.println("Digite o ID do autor:");
                Long idAutor = scanner.nextLong();
                Autor autor = biblioteca.buscarAutorPorId(idAutor);
                if (autor != null) {
                    System.out.println("Livros do autor " + autor.getNome() + ":");
                    for (Livro livro : biblioteca.buscarLivrosPorAutor(autor)) {
                        System.out.println(livro);
                    }
                } else {
                    System.out.println("Autor não encontrado.");
                }
            } else if (opcao == 9) {
                System.out.println("Digite o título do livro:");
                String titulo = scanner.nextLine();
                System.out.println("Digite o ID do autor:");
                Long idAutor = scanner.nextLong();
                Autor autor = biblioteca.buscarAutorPorId(idAutor);
                if (autor != null) {
                    System.out.println("Digite a data de publicação (AAAA-MM-DD):");
                    String dataPublicacaoStr = scanner.next();
                    LocalDate dataPublicacao = LocalDate.parse(dataPublicacaoStr);
                    Livro novoLivro = new Livro(titulo, autor, dataPublicacao);
                    biblioteca.adicionarLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                } else {
                    System.out.println("Autor não encontrado.");
                }
            } else if (opcao == 10) {
                System.out.println("Digite o ID do livro:");
                Long idLivro = scanner.nextLong();
                Livro livro = biblioteca.buscarLivroPorId(idLivro);
                if (livro != null) {
                    System.out.println("Digite o ID do cliente:");
                    Long idCliente = scanner.nextLong();
                    Cliente cliente = biblioteca.buscarClientePorId(idCliente);
                    if (cliente != null) {
                        biblioteca.emprestarLivro(livro, cliente);
                        System.out.println("Livro emprestado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                } else {
                    System.out.println("Livro não encontrado.");
                }
            } else if (opcao == 11) {
                System.out.println("Digite o ID do empréstimo:");
                Long idEmprestimo = scanner.nextLong();
                biblioteca.devolverLivro(idEmprestimo);
                System.out.println("Livro devolvido com sucesso!");

            } else if (opcao == 0) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}