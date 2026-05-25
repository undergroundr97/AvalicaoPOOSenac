package org.example;

public class LeitorComum extends Leitor {

    public LeitorComum(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void adicionarLivro(Livro livro) {
        if(getItensEmPosse().size() < 3) {
            getItensEmPosse().add(livro);
        } else {
            System.out.println("Não e possivel alugar um novo livro");
        }
    }
}
