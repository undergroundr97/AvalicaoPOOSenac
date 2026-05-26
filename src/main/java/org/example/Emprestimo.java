package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Leitor leitor;
    private Item item;
    private LocalDate dataEmprestimo;
    private LocalDate prazoEntrega;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(Leitor leitor, Item item) {
        this.leitor = leitor;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.prazoEntrega = calcularPrazoInicial();
        this.dataDevolucaoReal = null;
    }

    private LocalDate calcularPrazoInicial() {
        if (leitor instanceof LeitorPremium) {
            return dataEmprestimo.plusDays(item.getPrazoDeEntrega() + (item.getPrazoDeEntrega() / 2));
        } else {
            return dataEmprestimo.plusDays(item.getPrazoDeEntrega());
        }
    }

    public double calcularMulta() {
        if (dataDevolucaoReal == null || !dataDevolucaoReal.isAfter(prazoEntrega)) {
            return 0.0;
        }
        long diasAtraso = ChronoUnit.DAYS.between(prazoEntrega, dataDevolucaoReal);
        return diasAtraso * 1.5; //multa por dia ao atrasar a entrega
    }

    public void renovarEmprestimo(LocalDate novoPrazo) {
        if (dataDevolucaoReal != null) {
            System.out.println("Erro: Livro já devolvido.");
            return;
        }

        if (LocalDate.now().isAfter(this.prazoEntrega)) {
            System.out.println("Erro: Nao é possivel renovar um livro em atraso.");
            return;
        }
        if (!novoPrazo.isAfter(this.prazoEntrega)) {
            System.out.println("Erro: O novo prazo deve ser posterior ao prazo atual.");
            return;
        }else {
            this.prazoEntrega = novoPrazo;
            System.out.println("Renovado com sucesso!");
        }
    }

    public void finalizarEmprestimo() {
        this.dataDevolucaoReal = LocalDate.now();
        double valorMulta = calcularMulta();
        if (valorMulta == 0) {
            System.out.println("Livro devolvido no prazo. Sem multa.");
        } else {
            System.out.println("Livro devolvido em atraso. Multa: R$ " + valorMulta);
        }
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Item getItem() {
        return item;
    }
}