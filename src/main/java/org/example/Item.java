package org.example;

import java.time.LocalDate;

public abstract class Item {
    private String titulo;
    private String codUnico;
    private LocalDate dataPublicacao;
    private Unidade unidadeOrigem;
    private FaixaEtaria faixaEtaria;
    private int prazoDeEntrega;

    public Item(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria, int prazoDeEntrega) {
        this.titulo = titulo;
        this.codUnico = codUnico;
        this.dataPublicacao = dataPublicacao;
        this.unidadeOrigem = unidadeOrigem;
        this.faixaEtaria = faixaEtaria;
        this.prazoDeEntrega=prazoDeEntrega;
    }


}
