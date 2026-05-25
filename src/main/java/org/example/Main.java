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
					Item livro1 = new Item();
					Item livro2 = new Revista();
					Item livro3 = new HQ();
					Item livro4 = new Livro();
					System.out.println("Criando dois leitores");
					Leitor leitor1 = new LeitorComum();
					Leitor leitor2 = new LeitorPremium();
				}
			}
		} while (opcaoCliente != 0);
	}

			static void menuTeste () {
				System.out.println("CENARIO A - CADASTRAR E EMPRESTIMO SIMPLES");
				System.out.println("CENARIO B - LIMITE EMRESTIMO ATINGIDO");
				System.out.println("CENARIO C - PRAZO DIFERENCIADO PARA PREMIUM");
				System.out.println("CENARIO D - RESTRICAO FAIXA ETARIA");
				System.out.println("CENARIO E - DEVOLUCAO COM ATRASO");
				System.out.println("CENARIO F - RENOVACAO");
				System.out.println("CENARIO G - EXTRATO EMPRESTIMO");
			}
}
