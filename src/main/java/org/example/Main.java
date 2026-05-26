package org.example;

import org.example.Emprestimo.Emprestimo;
import org.example.Enum.FaixaEtaria;
import org.example.InputValidator.InputValidator;
import org.example.Items.HQ;
import org.example.Items.Item;
import org.example.Items.Livro;
import org.example.Items.Revista;
import org.example.Leitor.Leitor;
import org.example.Leitor.LeitorComum;
import org.example.Leitor.LeitorPremium;
import org.example.Unidade.Unidade;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	static void main() {

		System.out.println("Bem vindo ao leitor livre!");
		menuTeste();

		System.out.println("Digite uma opcao: ");
		InputValidator.intValidator(scanner);
		int opcaoCliente = scanner.nextInt();
		do {
			switch (opcaoCliente) {
				case 1 -> {
					System.out.println("Criando duas unidades");
					Unidade unidade1 = new Unidade(1);

					System.out.println("Criando quatro livros");
					Item livro1 = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);
					Item livro2 = new Revista("A volta dos irão", "1232", LocalDate.now(), unidade1,
							FaixaEtaria.ADULTO);
					Item livro3 = new HQ("A volta dos que ja foram - versao infantil", "1233", LocalDate.now(), unidade1,
							FaixaEtaria.INFANTIL);
					Item livro4 = new Livro("A volta dos atrasados", "1235", LocalDate.now(), unidade1,
							FaixaEtaria.JUVENIL);

					System.out.println("Criando dois leitores");
					Leitor leitorInfatil = new LeitorComum("Andrey", 10);
					Leitor leitor2 = new LeitorPremium("Cesar", 20);

					System.out.println("Realizando emprestimos: ");
					Emprestimo emprestimo = new Emprestimo(leitorInfatil, livro3);
					Emprestimo emprestimo2 = new Emprestimo(leitor2, livro2);

					System.out.println("Exibindo resumo: ");
					emprestimo.imprimirExtratoEmprestimo();
					imprimirSeparador();
					emprestimo2.imprimirExtratoEmprestimo();
					imprimirSeparador();

					opcaoCliente = menuComInput(opcaoCliente);
				}
				case 2 ->{
					Unidade unidade1 = new Unidade(2);
					Item livro1 = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);
					Item livro2 = new Revista("A volta dos  que irao", "1232", LocalDate.now(), unidade1,
							FaixaEtaria.ADULTO);
					Item livro3 = new HQ("A volta dos que ja foram", "1233", LocalDate.now(), unidade1,
							FaixaEtaria.INFANTIL);
					Leitor andrey = new LeitorComum("andrey", 30);
					System.out.println(andrey.getNome() + " é um leitor: " + andrey.getClass().getSimpleName());

					System.out.println("Adicionar 3 livros: ");
					andrey.adicionarLivro(livro1);
					andrey.adicionarLivro(livro2);
					andrey.adicionarLivro(livro3);

					System.out.println("Tamanho da lista do leitor comum:  ");
					System.out.println(andrey.getItensEmPosse().size());
					System.out.println("Itens em posse do leitor comum: ");
					andrey.getItensEmPosse().forEach( item -> System.out.println(item.getTitulo()));
					imprimirSeparador();

					Item livro4 = new Livro("A volta dos atrasados", "1235", LocalDate.now(), unidade1,
							FaixaEtaria.JUVENIL);
					System.out.println("Tenta adicionar um quarto livro a " + andrey.getNome());
					andrey.adicionarLivro(livro4);

					System.out.println("Itens em posse de andrey: ");
					andrey.getItensEmPosse().forEach( item -> System.out.println(item.getTitulo()));
					imprimirSeparador();

					opcaoCliente = menuComInput(opcaoCliente);
				}
				case 3 -> {
					Unidade unidade1 = new Unidade(1);

					Leitor leitorPremium = new LeitorComum("andrey", 30);
					Leitor leitorComum = new LeitorPremium("luiz", 12);
					Item livro1 = new Livro("A volta dos que nao foram 2", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);

					Emprestimo emprestimo = new Emprestimo(leitorComum, livro1);
					System.out.println("O emprestimo para o " + emprestimo.getLeitor().getClass().getSimpleName() + " " +emprestimo.getLeitor().getNome()
							+ ", do livro: " + livro1.getTitulo() +
							", codigo: " + livro1.getCodUnico() + ", data estimada para entrega: "+emprestimo.calcularPrazoInicial().format(Emprestimo.formatter));
					imprimirSeparador();

					emprestimo = new Emprestimo(leitorPremium, livro1);
					System.out.println("O emprestimo para o " + emprestimo.getLeitor().getClass().getSimpleName() + " " +emprestimo.getLeitor().getNome()
							+ ", do livro: " + livro1.getTitulo() +
							", codigo: " + livro1.getCodUnico() + ", data estimada para entrega: "+emprestimo.calcularPrazoInicial().format(Emprestimo.formatter));
					imprimirSeparador();

					opcaoCliente = menuComInput(opcaoCliente);
				}
				case 4 ->{
					Unidade unidade1 = new Unidade(1);

					Leitor leitorAdulto = new LeitorPremium("andrey", 30);
					Item livroInfantil = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.INFANTIL);

					System.out.println("Tentando emprestar o livro: " + livroInfantil.getTitulo() + ", Faixa etaria: " + livroInfantil.getFaixaEtaria()
							+ "\nPara o leitor: " + leitorAdulto.getClass().getSimpleName() + " - " + leitorAdulto.getNome().toUpperCase() + " de idade: " + leitorAdulto.getIdade()
							+ " anos, faixa etaria: " + leitorAdulto.getFaixaEtaria());
					Emprestimo emprestimo = new Emprestimo(leitorAdulto, livroInfantil);
					imprimirSeparador();

					Leitor leitorInfantil = new LeitorPremium("cesar", 10);
					Item livroAdulto = new Livro("A volta dos que já foram",  "5555", LocalDate.now(), unidade1, FaixaEtaria.ADULTO);

					System.out.println("Tentando emprestar o livro: " + livroAdulto.getTitulo() + ", Faixa etaria: " + livroAdulto.getFaixaEtaria()
							+ "\nPara o leitor: " + leitorInfantil.getClass().getSimpleName() + " - " + leitorInfantil.getNome().toUpperCase() + " de idade: " + leitorInfantil.getIdade()
							+ " anos, faixa etaria: " + leitorInfantil.getFaixaEtaria());
					Emprestimo emprestimo2 = new Emprestimo(leitorInfantil, livroAdulto);
					imprimirSeparador();

					opcaoCliente = menuComInput(opcaoCliente);
				}
				case 5-> {
					Unidade unidade1 = new Unidade(1);

					Leitor leitorPremium = new LeitorPremium("andrey", 30);
					Item livroLivre = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1, FaixaEtaria.LIVRE);
					Emprestimo emprestimo = new Emprestimo(leitorPremium, livroLivre);

					System.out.println("Data hoje: " + LocalDate.now().format(Emprestimo.formatter));
					System.out.println("Data entrega maximo do Item: " + livroLivre.getClass().getSimpleName() + ", prazo maximo: " + livroLivre.getPrazoDeEntrega() + " dias.");
					System.out.println("Data esperada para devolucao emprestimo: " + emprestimo.getPrazoEntrega().format(Emprestimo.formatter));
					System.out.println("Devolucao para entregar 5 dias após emprestimo: " + LocalDate.now().plusDays(5).format(Emprestimo.formatter));
					emprestimo.finalizarEmprestimo(LocalDate.now().plusDays(5));
					imprimirSeparador();

					Item HQLivre = new HQ("A ida dos que irao", "1333", LocalDate.now(), unidade1, FaixaEtaria.LIVRE);
					Emprestimo emprestimo1 = new Emprestimo(leitorPremium, HQLivre);

					System.out.println("Data entrega maximo do Item: " + HQLivre.getClass().getSimpleName() + ", prazo maximo: " + HQLivre.getPrazoDeEntrega() + " dias.");
					System.out.println("Data esperada para devolucao emprestimo: " + emprestimo1.getPrazoEntrega().format(Emprestimo.formatter));
					System.out.println("Entregar 10 apos a data limite do emprestimo: " + emprestimo1.getPrazoEntrega().plusDays(10).format(Emprestimo.formatter) );
					emprestimo1.finalizarEmprestimo(emprestimo1.getPrazoEntrega().plusDays(10));
					imprimirSeparador();


					opcaoCliente = menuComInput(opcaoCliente);
				}
				case 6 ->{
					Unidade unidade1 = new Unidade(1);

					Leitor leitorPremium = new LeitorPremium("andrey", 30);
					Item livroLivre = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1, FaixaEtaria.LIVRE);
					Emprestimo emprestimo = new Emprestimo(leitorPremium, livroLivre);

					System.out.println("Tentando renovar o Item " + livroLivre.getClass().getSimpleName()+": "  + livroLivre.getTitulo()+".");
					emprestimo.renovarEmprestimo();
					System.out.println("Tentando renovar o Item " + livroLivre.getClass().getSimpleName()+": "  + livroLivre.getTitulo()+", que ja " +
							"foi renovado");
					emprestimo.renovarEmprestimo();
					imprimirSeparador();

					Item HQLivre = new HQ("A saida dos que saíram", "12345", LocalDate.now(), unidade1, FaixaEtaria.LIVRE);
					Emprestimo emprestimoHQLivre = new Emprestimo(leitorPremium, HQLivre);
					System.out.println("Tentando renovar o Item " + HQLivre.getClass().getSimpleName()+": "  + HQLivre.getTitulo()+".");
					emprestimoHQLivre.renovarEmprestimo();
					imprimirSeparador();

					Item RevistaLivre = new Revista("A vida e bela", "12321", LocalDate.now(), unidade1, FaixaEtaria.LIVRE);
					Emprestimo emprestimoRevistaLivre = new Emprestimo(leitorPremium, HQLivre);
					System.out.println("Tentando renovar o Item " + RevistaLivre.getClass().getSimpleName()+": "  + RevistaLivre.getTitulo()+".");
					emprestimoHQLivre.renovarEmprestimo();
					imprimirSeparador();

					opcaoCliente = menuComInput(opcaoCliente);
				}
				case 7 ->{
					Unidade unidade1 = new Unidade(1);
					Leitor leitorPremium = new LeitorPremium("andrey", 30);
					Item livroLivre = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);

					System.out.println("Emprestimo 1 - Emprestimo em dia: ");
					Emprestimo emprestimo = new Emprestimo(leitorPremium, livroLivre);
					emprestimo.renovarEmprestimo();
					emprestimo.setEstadoEmprestimo();
					emprestimo.imprimirExtratoEmprestimo();
					imprimirSeparador();

					System.out.println("Emprestimo 2 - Emprestimo atrasado: ");
					Emprestimo emprestimo1 = new Emprestimo(leitorPremium, livroLivre);
					emprestimo1.renovarEmprestimo();
					emprestimo1.setDataDevolucaoReal(LocalDate.now().plusDays(50));
					emprestimo1.setEstadoEmprestimo();
					emprestimo1.imprimirExtratoEmprestimo();
					imprimirSeparador();

					System.out.println("Emprestimo 3 - Pode renovar: ");
					Emprestimo emprestimo2 = new Emprestimo(leitorPremium, livroLivre);
					emprestimo2.imprimirExtratoEmprestimo();
					imprimirSeparador();

					opcaoCliente = menuComInput(opcaoCliente);
				}
				default -> {
					System.out.println("Opcao não encontrada");
					opcaoCliente = menuComInput(opcaoCliente);
				}
			}
		} while (opcaoCliente != 0);
	}

	static void menuTeste() {
		System.out.println("1 - CENARIO -> CADASTRAR E EMPRESTIMO SIMPLES");
		System.out.println("2 - CENARIO -> LIMITE EMRESTIMO ATINGIDO");
		System.out.println("3 - CENARIO -> PRAZO DIFERENCIADO PARA PREMIUM");
		System.out.println("4 - CENARIO -> RESTRICAO FAIXA ETARIA");
		System.out.println("5 - CENARIO -> DEVOLUCAO COM ATRASO");
		System.out.println("6 - CENARIO -> RENOVACAO");
		System.out.println("7 - CENARIO -> EXTRATO EMPRESTIMO");
		System.out.println("0 - ENCERRAR PROGRAMA");
	}

	public static void imprimirSeparador(){
		System.out.println("----------------------------------");
	}

	static Integer menuComInput(Integer opt){
		menuTeste();
		InputValidator.intValidator(scanner);
		opt = scanner.nextInt();
		return opt;
	}

}
