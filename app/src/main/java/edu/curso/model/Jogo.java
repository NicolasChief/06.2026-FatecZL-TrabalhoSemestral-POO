package edu.curso.model;

import java.time.LocalDate;

public class Jogo {

    private Long id;
    private String nome;
    private Double preco;
    private LocalDate dataLancamento;
    private Double espacoGB;
    private String genero;
    private String descricao;
    
    public Jogo(Long id, String nome, Double preco, LocalDate dataLancamento, Double espacoGB, String genero, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
        this.espacoGB = espacoGB;
        this.genero = genero;
        this.descricao = descricao;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getEspacoGB() {
        return espacoGB;
    }

    public void setEspacoGB(Double espacoGB) {
        this.espacoGB = espacoGB;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
