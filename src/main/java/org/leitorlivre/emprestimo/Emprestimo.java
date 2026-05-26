package org.leitorlivre.emprestimo;

import org.leitorlivre.enums.EstadoEmprestimo;
import org.leitorlivre.enums.FaixaEtaria;
import org.leitorlivre.itens.HQ;
import org.leitorlivre.itens.Item;
import org.leitorlivre.itens.Revista;
import org.leitorlivre.leitor.Leitor;
import org.leitorlivre.leitor.LeitorPremium;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Leitor leitor;
	private Item item;
	private LocalDate dataEmprestimo;
	private LocalDate prazoEntrega;
	private LocalDate dataDevolucaoReal;
	private boolean renovado = false;
	private EstadoEmprestimo estadoEmprestimo;

	public Emprestimo(Leitor leitor, Item item) {
		if(verificarFaixaEtaria(leitor, item)){
			this.leitor = leitor;
			this.item = item;
			this.dataEmprestimo = LocalDate.now();

			this.prazoEntrega = calcularPrazoInicial();
		} else {
			System.out.println("Nao e possivel realizar emprestimo!");
		}
	}

	public LocalDate calcularPrazoInicial() {
		if (leitor instanceof LeitorPremium) {
			return dataEmprestimo.plusDays(item.getPrazoDeEntrega() + (item.getPrazoDeEntrega() / 2));
		} else {
			return dataEmprestimo.plusDays(item.getPrazoDeEntrega());
		}
	}

	public boolean verificarFaixaEtaria(Leitor leitor, Item item){
		if(item.getFaixaEtaria().equals(FaixaEtaria.ADULTO) && !leitor.getFaixaEtaria().equals(FaixaEtaria.ADULTO)){
			System.out.println("Não é possivel emprestar um livro adulto para menores.");
			return false;
		} else if ((item.getFaixaEtaria().equals(FaixaEtaria.INFANTIL) ||  item.getFaixaEtaria().equals(FaixaEtaria.JUVENIL))  && !leitor.getFaixaEtaria().equals(FaixaEtaria.INFANTIL)){
			System.out.println("O Item esta fora da faixa etaria do adulto");
			return false;
		} else {
			return true;
		}
	}

	public void setEstadoEmprestimo(){
		if(!(dataDevolucaoReal == null) && dataDevolucaoReal.isAfter(prazoEntrega)){
			estadoEmprestimo = EstadoEmprestimo.ATRASADO;
		} else if(!renovado){
			estadoEmprestimo = EstadoEmprestimo.PODERENOVAR;
		} else {
			estadoEmprestimo = EstadoEmprestimo.EMDIA;
		}
	}

	public double calcularMulta() {
		if (dataDevolucaoReal == null || !dataDevolucaoReal.isAfter(prazoEntrega)) {
			return 0.0;
		}
		long diasAtraso = ChronoUnit.DAYS.between(prazoEntrega, dataDevolucaoReal);
		System.out.println(ChronoUnit.DAYS.between(prazoEntrega, dataDevolucaoReal));
		System.out.println(diasAtraso);
		return diasAtraso * 1.5;
	}

	public void renovarEmprestimo() {
		if(item instanceof HQ || item instanceof Revista){
			System.out.println("Nao e possivel renovar HQ ou Revista!");
		} else if(isRenovado()) {
			System.out.println("Item ja foi renovado! Nao e possivel renovar.");
		} else {
			renovado = true;
			setEstadoEmprestimo();
			System.out.println("Item sera renovado para: " + prazoEntrega.plusDays(item.getPrazoDeEntrega() + item.getPrazoDeEntrega()).format(formatter));
			prazoEntrega = prazoEntrega.plusDays(item.getPrazoDeEntrega() + item.getPrazoDeEntrega());
		}

	}

	public void finalizarEmprestimo(LocalDate date) {
		this.dataDevolucaoReal = date;
		setEstadoEmprestimo();
		double valorMulta = calcularMulta();
		if (valorMulta == 0) {
			System.out.println("Livro devolvido no prazo. Sem multa.");
		} else {
			System.out.println("Livro devolvido em atraso. Multa: R$ " + valorMulta);
		}
	}

	public void imprimirExtratoEmprestimo(){
		System.out.println("Data hoje: " + LocalDate.now().format(formatter));
		System.out.println("Leitor: " + getLeitor().getNome());
		System.out.println("Livro: " + getItem().getTitulo());
		System.out.println("Prazo para entrega: " + prazoEntrega.format(formatter));
		if( !(dataDevolucaoReal == null)) {
			System.out.println("Dia da entrega: " + dataDevolucaoReal.format(formatter));
		}
		System.out.println("Item ja renovado: " + isRenovado());
		System.out.println("Estado do emprestimo: " + estadoEmprestimo);
	}


	public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}

	public LocalDate getPrazoEntrega() {
		return prazoEntrega;
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