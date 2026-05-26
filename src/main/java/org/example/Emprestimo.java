package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Leitor leitor;
    private Item item;
    private LocalDate dataEmprestimo;
    private LocalDate prazoEntrega;
    private LocalDate dataDevolucaoReal;
    private boolean renovado = false;
    private EstadoEmprestimo estadoEmprestimo;

    public Emprestimo(Leitor leitor, Item item) {
        this.leitor = leitor;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();

        this.prazoEntrega = LocalDate.now().plusDays(item.getPrazoDeEntrega());

        this.dataDevolucaoReal = LocalDate.now().plusDays(3);
        setEstadoEmprestimo();

    }



    public LocalDate calcularPrazoInicial() {
        if (leitor instanceof LeitorPremium) {
            return dataEmprestimo.plusDays(item.getPrazoDeEntrega() + (item.getPrazoDeEntrega() / 2));
        } else {
            return dataEmprestimo.plusDays(item.getPrazoDeEntrega());
        }
    }

    public void setEstadoEmprestimo(){
        if(prazoEntrega.isAfter(dataDevolucaoReal)){
            estadoEmprestimo = EstadoEmprestimo.ATRASDO;
        } else if(prazoEntrega.isBefore(dataDevolucaoReal)){
            estadoEmprestimo = EstadoEmprestimo.EMDIA;
        } else {
            estadoEmprestimo = EstadoEmprestimo.PODERENOVAR;
        }

    }

    public double calcularMulta() {
        if (dataDevolucaoReal == null || !dataDevolucaoReal.isAfter(prazoEntrega)) {
            return 0.0;
        }
        long diasAtraso = ChronoUnit.DAYS.between(prazoEntrega, dataDevolucaoReal);
        return diasAtraso * 1.5;
    }

    public void renovarEmprestimo() {
        if(item instanceof HQ){
            System.out.println("Nao e possivel renovar revista");
        } else if(isRenovado()) {
            System.out.println("Item ja foi renovado!, nao e possivel renovar");
        } else {
            renovado = true;
            System.out.println("Item sera renovado para: " + prazoEntrega.plusDays(item.getPrazoDeEntrega() + item.getPrazoDeEntrega()));
        }

    }

    public void finalizarEmprestimo(LocalDate date) {
        this.dataDevolucaoReal = date;
        double valorMulta = calcularMulta();
        if (valorMulta == 0) {
            System.out.println("Livro devolvido no prazo. Sem multa.");
        } else {
            System.out.println("Livro devolvido em atraso. Multa: R$ " + valorMulta);
        }
    }

    public void imprimirExtratoEmprestimo(){
        System.out.println("Leitor: " + getLeitor().getNome());
        System.out.println("Livro: " + getItem().getTitulo());
        System.out.println("Data de entrega: " + prazoEntrega.format(formatter));
        System.out.println("Item ja renovado: " + isRenovado());
        System.out.println("Estado do emprestimo: " + estadoEmprestimo);
    }


    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Item getItem() {
        return item;
    }

    public boolean isRenovado() {
        return renovado;
    }
}