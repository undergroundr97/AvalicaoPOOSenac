package org.example;

import java.time.LocalDate;

public class HQ extends Item{
    private int prazoDeEntrega=10;
    public HQ(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
        super(titulo, codUnico, dataPublicacao, unidadeOrigem, faixaEtaria);
    }

    @Override
    public int getPrazoDeEntrega() {
        return prazoDeEntrega;
    }
}
