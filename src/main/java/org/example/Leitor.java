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
        setFaixaEtaria();
    }

    public abstract void adicionarLivro(Item livro);

    public ArrayList<Item> getItensEmPosse() {
        return itensEmPosse;
    }

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
}

