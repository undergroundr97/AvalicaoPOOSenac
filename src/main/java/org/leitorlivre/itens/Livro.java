package org.leitorlivre.itens;

import org.leitorlivre.enums.FaixaEtaria;
import org.leitorlivre.unidade.Unidade;

import java.time.LocalDate;

public class Livro extends Item {

	private final int prazoDeEntrega = 14;

	public Livro(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
		super(titulo, codUnico, dataPublicacao, unidadeOrigem, faixaEtaria);
	}

	@Override
	public int getPrazoDeEntrega() {
		return prazoDeEntrega;
	}

}
