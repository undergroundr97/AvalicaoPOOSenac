package org.example;

import java.time.LocalDate;

public class Revista extends Item{

	private final int prazoDeEntrega = 7;

	public Revista(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
		super(titulo, codUnico, dataPublicacao, unidadeOrigem, faixaEtaria);
	}

	public int getPrazoDeEntrega() {
		return prazoDeEntrega;
	}

}
