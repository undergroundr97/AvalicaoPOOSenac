package org.example;

import java.time.LocalDate;

public abstract class Item {
    private String titulo;
    private String codUnico;
    private LocalDate dataPublicacao;
    private Unidade unidadeOrigem;
    private FaixaEtaria faixaEtaria;
    private int prazoDeEntrega;

    public Item(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
        this.titulo = titulo;
        this.codUnico = codUnico;
        this.dataPublicacao = dataPublicacao;
        this.unidadeOrigem = unidadeOrigem;
        this.faixaEtaria = faixaEtaria;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract int getPrazoDeEntrega();

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public Unidade getUnidadeOrigem() {
        return unidadeOrigem;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCodUnico() {
        return codUnico;
    }
}
