package org.example.Leitor;

import org.example.Items.Item;

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
