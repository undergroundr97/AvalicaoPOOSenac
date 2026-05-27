package org.leitorlivre.leitor;

import org.leitorlivre.itens.Item;

public class LeitorPremium extends Leitor {

	public LeitorPremium(String nome, int idade) {
		super(nome, idade);
	}

	public void adicionarLivro(Item livro) {
		if(getItensEmPosse().size() < 7) {
			getItensEmPosse().add(livro);
		} else {
			System.out.println("Não e possivel alugar um novo livro");
		}
	}

}
