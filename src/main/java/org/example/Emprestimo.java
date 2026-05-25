package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Leitor leitor;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate prazoEntrega;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(Leitor leitor, Livro livro) {
        this.leitor = leitor;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();

        this.prazoEntrega = LocalDate.now().plusDays(livro.getPrazoDeEntrega());
        this.dataDevolucaoReal = null;
    }

    public double calcularMulta() {
        if (dataDevolucaoReal == null || !dataDevolucaoReal.isAfter(prazoEntrega)) {
            return 0.0;
        }
        long diasAtraso = ChronoUnit.DAYS.between(prazoEntrega, dataDevolucaoReal);
        return diasAtraso + 1.5;
    }

    public void finalizarEmprestimo(){
        this.dataDevolucaoReal = LocalDate.now();
        this.livro.setDisponivel(true);
        System.out.println("Livro devolvido. Multa: R$ " + calcularMulta());
    }


    public Leitor getLeitor() { return leitor; }
    public Livro getLivro() { return livro; }
}