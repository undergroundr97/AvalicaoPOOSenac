package org.example;

import java.time.LocalDate;

public class LeitorPremium extends Leitor {
    public LeitorPremium(String nome, int idade) {
        super(nome, idade);
    }

    public void adicionarLivro(Livro livro) {
        if (getItensEmPosse().size() < 7) {
            getItensEmPosse().add(livro);
        } else {
            System.out.println("Não e possivel alugar um novo livro");
        }
    }
}
