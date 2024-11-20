package org.example;

import java.time.LocalDate;

public class Emprestimo {

    private Long id;
    private static Long contadorId = 1L;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Cliente cliente) {
        this.id = contadorId++;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now().plusDays(7);
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void devolverLivro() {
        this.livro.setDisponivel(true);
        this.dataDevolucao = LocalDate.now();
        this.ativo = false;
    }

}
