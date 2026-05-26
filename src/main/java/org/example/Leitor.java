package org.example;

import java.util.ArrayList;

public abstract class Leitor {
    private String nome;
    private int idade;

    private ArrayList<Item> itensEmPosse;

    public Leitor(String nome, int idade) {
        this.idade = idade;
        this.nome = nome;

        itensEmPosse = new ArrayList<>();
    }

    public abstract void adicionarLivro(Livro livro);

    public String exibirExtratoLeitor() {
        System.out.println("Leitor: " + nome);
        System.out.println("Livros emprestados: ");

        for (Item livro : itensEmPosse) {
            System.out.println(livro.getTitulo());
        }

        return "Leitor: " + nome + "Livros emprestados: " + itensEmPosse;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }
}