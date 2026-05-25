package org.example;

import java.time.LocalDate;

public abstract class Item {
    protected String titulo;
    protected String codUnico;
    protected LocalDate dataPublicacao;
    protected Unidade unidadeOrigem;
    protected FaixaEtaria faixaEtaria;
    protected int prazoDeEntrega;

    public Item(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
        this.titulo = titulo;
        this.codUnico = codUnico;
        this.dataPublicacao = dataPublicacao;
        this.unidadeOrigem = unidadeOrigem;
        this.faixaEtaria = faixaEtaria;
    }


}
