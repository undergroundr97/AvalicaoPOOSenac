package org.example;

import java.time.LocalDate;

public class Livro extends Item{
    int prazoDeEntrega=14;
    @Override
    public int getPrazoDeEntrega() {
        return prazoDeEntrega;
    }
    public Livro(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
        super(titulo, codUnico, dataPublicacao, unidadeOrigem, faixaEtaria);
    }

}
