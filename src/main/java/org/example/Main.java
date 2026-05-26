package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	static void main() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem vindo ao leitor livre!");

		menuTeste();
		System.out.println("Digite uma opcao: ");
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
					System.out.println("----------------------------------");
					emprestimo2.imprimirExtratoEmprestimo();
					System.out.println("----------------------------------");

					menuTeste();
					opcaoCliente = scanner.nextInt();
				}
				case 2 ->{
					Unidade unidade1 = new Unidade(2);
					System.out.println("Adicionando 3 livros ao leitor comum andrey");

					Item livro1 = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);
					Item livro2 = new Revista("A volta dos  que irao", "1232", LocalDate.now(), unidade1,
							FaixaEtaria.ADULTO);
					Item livro3 = new HQ("A volta dos que ja foram", "1233", LocalDate.now(), unidade1,
							FaixaEtaria.INFANTIL);
					Leitor andrey = new LeitorComum("andrey", 30);
					System.out.println(andrey.getNome() + " é um leitor: " + andrey.getClass().getSimpleName());

					andrey.adicionarLivro(livro1);
					andrey.adicionarLivro(livro2);
					andrey.adicionarLivro(livro3);

					System.out.println("Tamanho da lista do leitor comum:  ");
					System.out.println(andrey.getItensEmPosse().size());
					System.out.println("Itens em posse do leitor comum: ");
					andrey.getItensEmPosse().forEach( item -> System.out.println(item.getTitulo()));

					Item livro4 = new Livro("A volta dos atrasados", "1235", LocalDate.now(), unidade1,
							FaixaEtaria.JUVENIL);
					System.out.println("Tenta adicionar um quarto livro a " + andrey.getNome());
					andrey.adicionarLivro(livro4);
					System.out.println("Itens em posse de andrey: ");
					andrey.getItensEmPosse().forEach( item -> System.out.println(item.getTitulo()));

					menuTeste();
					opcaoCliente = scanner.nextInt();

				}
				case 3 -> {
					Unidade unidade1 = new Unidade(1);
					Leitor leitorPremium = new LeitorComum("andrey", 30);
					Leitor leitorComum = new LeitorPremium("luiz", 12);
					Item livro1 = new Livro("A volta dos que nao foram 2", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);

					Emprestimo emprestimo = new Emprestimo(leitorComum, livro1);

					System.out.println("O emprestimo para o " + emprestimo.getLeitor().getClass().getSimpleName() + ", do livro: " + livro1.getTitulo() +
							": " +emprestimo.calcularPrazoInicial().format(Emprestimo.formatter));

					emprestimo = new Emprestimo(leitorPremium, livro1);
					System.out.println("O emprestimo para o " + emprestimo.getLeitor().getClass().getSimpleName() + ", do livro: " + livro1.getTitulo() +
							": " +emprestimo.calcularPrazoInicial().format(Emprestimo.formatter));

					menuTeste();
					opcaoCliente = scanner.nextInt();
				}
				case 4 ->{

					Unidade unidade1 = new Unidade(1);
					Leitor leitorAdulto = new LeitorPremium("andrey", 30);
//
					Item livroInfantil = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.INFANTIL);

					System.out.println("Tentando emprestar o livro: " + livroInfantil.getTitulo() + ", Faixa etaria: " + livroInfantil.getFaixaEtaria()
					+ "\nPara o leitor: " + leitorAdulto.getClass().getSimpleName() + " - " + leitorAdulto.getNome() + " de idade: " + leitorAdulto.getIdade()
					+ " faixa etaria: " + leitorAdulto.getFaixaEtaria());
					Emprestimo emprestimo = new Emprestimo(leitorAdulto, livroInfantil);
					System.out.println();

					Leitor leitorInfantil = new LeitorPremium("cesar", 10);
					Item livroAdulto = new Livro("A volta dos que já foram",  "5555", LocalDate.now(), unidade1, FaixaEtaria.ADULTO);
					System.out.println("Tentando emprestar o livro: " + livroAdulto.getTitulo() + ", Faixa etaria: " + livroAdulto.getFaixaEtaria()
							+ "\nPara o leitor: " + leitorInfantil.getClass().getSimpleName() + " - " + leitorInfantil.getNome() + " de idade: " + leitorInfantil.getIdade()
							+ " faixa etaria: " + leitorInfantil.getFaixaEtaria());
					Emprestimo emprestimo2 = new Emprestimo(leitorInfantil, livroAdulto);
					System.out.println();

					menuTeste();
					opcaoCliente = scanner.nextInt();
				}
				case 5-> {

					Unidade unidade1 = new Unidade(1);
					Leitor leitorPremium = new LeitorPremium("andrey", 30);
					Item livroLivre = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);
					Emprestimo emprestimo = new Emprestimo(leitorPremium, livroLivre);
					emprestimo.finalizarEmprestimo(LocalDate.now().plusDays(100));
					menuTeste();
					opcaoCliente = scanner.nextInt();
				}
				case 6 ->{
					Unidade unidade1 = new Unidade(1);
					Leitor leitorPremium = new LeitorPremium("andrey", 30);
					Item livroLivre = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);
					Emprestimo emprestimo = new Emprestimo(leitorPremium, livroLivre);

					emprestimo.renovarEmprestimo();
					menuTeste();
					opcaoCliente = scanner.nextInt();

				}
				case 7 ->{

					Unidade unidade1 = new Unidade(1);
					Leitor leitorPremium = new LeitorPremium("andrey", 30);
					Item livroLivre = new Livro("A volta dos que nao foram", "1234", LocalDate.now(), unidade1,
							FaixaEtaria.LIVRE);
					Emprestimo emprestimo = new Emprestimo(leitorPremium, livroLivre);

					emprestimo.imprimirExtratoEmprestimo();

					Emprestimo emprestimo1 = new Emprestimo(leitorPremium, livroLivre);
					emprestimo1.setDataDevolucaoReal(LocalDate.now().minusDays(2));
					emprestimo1.imprimirExtratoEmprestimo();

					Emprestimo emprestimo2 = new Emprestimo(leitorPremium, livroLivre);
					emprestimo2.setEstadoEmprestimo();
					menuTeste();
					opcaoCliente = scanner.nextInt();
				}


			}
		} while (opcaoCliente != 0);
	}

	static void menuTeste () {
		System.out.println("CENARIO 1 - CADASTRAR E EMPRESTIMO SIMPLES");
		System.out.println("CENARIO 2 - LIMITE EMRESTIMO ATINGIDO");
		System.out.println("CENARIO 3 - PRAZO DIFERENCIADO PARA PREMIUM");
		System.out.println("CENARIO 4 - RESTRICAO FAIXA ETARIA");
		System.out.println("CENARIO 5 - DEVOLUCAO COM ATRASO");
		System.out.println("CENARIO 6 - RENOVACAO");
		System.out.println("CENARIO 7 - EXTRATO EMPRESTIMO");
	}
}
