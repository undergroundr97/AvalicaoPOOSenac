package org.example;

import java.util.ArrayList;

public abstract class Leitor {

	private String nome;
	private int idade;
	FaixaEtaria faixaEtaria;
	private ArrayList<Item> itensEmPosse;

	public Leitor(String nome, int idade) {
		this.idade = idade;
		this.nome = nome;
		itensEmPosse = new ArrayList<>();
		setFaixaEtaria();
	}

	public abstract void adicionarLivro(Item livro);

	public void setFaixaEtaria() {
		if(idade < 11){
			faixaEtaria = FaixaEtaria.INFANTIL;
		} else if (idade >= 12 && idade <= 17) {
			faixaEtaria = FaixaEtaria.JUVENIL;
		} else if (idade >= 18) {
			faixaEtaria = FaixaEtaria.ADULTO;
		} else {
			faixaEtaria = FaixaEtaria.LIVRE;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public int getIdade() {
		return idade;
	}

	public ArrayList<Item> getItensEmPosse() {
		return itensEmPosse;
	}

}


