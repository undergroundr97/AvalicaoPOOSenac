package org.example;

import java.util.ArrayList;

public abstract class Leitor {
    private String nome;
    private int idade;

    private ArrayList <Item> itensEmPosse;

    public Leitor (int idade) {
        this.idade = idade;

    }


}
