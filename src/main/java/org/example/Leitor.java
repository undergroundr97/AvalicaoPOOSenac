package org.example;


import java.time.LocalDate;

import java.util.ArrayList;

public abstract class Leitor {
    private String nome;
    private int idade;
    FaixaEtaria faixaEtaria;

    private ArrayList <Item> itensEmPosse=  itensEmPosse = new ArrayList<>();

    public Leitor (String nome, int idade) {
        this.idade = idade;
    }

    public abstract void adicionarLivro(Item livro);

    public ArrayList<Item> getItensEmPosse() {
        return itensEmPosse;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {

    }
}

