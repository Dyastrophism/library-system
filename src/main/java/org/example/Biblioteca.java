package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Autor> listarAutores() {
        return autores;
    }

    public List<Livro> listarLivrosDisponiveis() {
        ArrayList<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public List<Livro> listarLivrosEmprestados() {
        ArrayList<Livro> livrosEmprestados = new ArrayList<>();
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                livrosEmprestados.add(livro);
            }
        }
        return livrosEmprestados;
    }

    public Livro buscarLivroPorId(Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    public Autor buscarAutorPorId(Long id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                return autor;
            }
        }
        return null;
    }

    public void emprestarLivro(Livro livro, Cliente cliente) {
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, cliente);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        } else {
            System.out.println("Livro indisponível para empréstimo");
        }

    }

    public void devolverLivro(Long idEmprestimo) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId().equals(idEmprestimo)) {
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public List<Emprestimo> listarEmprestimosPorCliente(Cliente cliente) {
        ArrayList<Emprestimo> emprestimosCliente = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().equals(cliente)) {
                emprestimosCliente.add(emprestimo);
            }
        }
        return emprestimosCliente;
    }

    public List<Emprestimo> listarEmprestimosPorLivro(Livro livro) {
        ArrayList<Emprestimo> emprestimosLivro = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().equals(livro)) {
                emprestimosLivro.add(emprestimo);
            }
        }
        return emprestimosLivro;
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarLivrosPorAutor(Autor autor) {
        ArrayList<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equals(autor)) {
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
}
