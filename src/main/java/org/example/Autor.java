package org.example;

import java.time.LocalDate;

public class Autor {

    private Long id;
    private static Long contadorId = 1L;
    private String nome;
    private LocalDate dataNascimento;

    public Autor() {
    }

    public Autor(String nome, LocalDate dataNascimento) {
        this.id = contadorId++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + '}';
    }
}
