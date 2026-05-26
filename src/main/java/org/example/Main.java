package org.example;

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
					Unidade unidade2 = new Unidade(2);
					System.out.println("Criando quatro livros");
					Item livro1 = new Livro();
					Item livro2 = new Revista();
					Item livro3 = new HQ();
					Item livro4 = new Livro();
					System.out.println("Criando dois leitores");
					Leitor leitor1 = new LeitorComum();
					Leitor leitor2 = new LeitorPremium();
				}
				case 2 ->{


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
