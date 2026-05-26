package org.example.Items;

import org.example.Enum.FaixaEtaria;
import org.example.Unidade.Unidade;

import java.time.LocalDate;

public class HQ extends Item{

	private final int prazoDeEntrega = 10;

	public HQ(String titulo, String codUnico, LocalDate dataPublicacao, Unidade unidadeOrigem, FaixaEtaria faixaEtaria) {
		super(titulo, codUnico, dataPublicacao, unidadeOrigem, faixaEtaria);
	}

	@Override
	public int getPrazoDeEntrega() {
		return prazoDeEntrega;
	}

}
