package projetojava;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Carrinho> carrinhoDeCompras = new ArrayList<Carrinho>();

		Scanner leia = new Scanner(System.in);
		int opcao, qtde;

		do {
			try {
				System.out.println("		BRECHÓ	GEN\r\n" + "\r\n" + "Item		Camiseta		Valor\r\n"
						+ "1.		Manga curta		R$ 10,00\r\n" + "2.		Manga longa		R$ 20,00\r\n"
						+ "3.		Xadrez			R$ 30,00\r\n" + "0. 		Sair");
				System.out.println("Escolha uma opção:");
				opcao = leia.nextInt();

				if (opcao >= 1 && opcao <= 3) {
					System.out.println("Digite a quantidade desejada:");
					qtde = leia.nextInt();
					adicionarAoCarrinho(carrinhoDeCompras, opcao, qtde);

				} else if (opcao != 0) {
					System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro: Insira um número inteiro.");
				leia.nextLine();
				opcao = -1;
			}

		} while (opcao != 0);

		imprimirResumoCarrinho(carrinhoDeCompras);

		System.out.println("Programa encerrado.");
	}

	private static void adicionarAoCarrinho(List<Carrinho> carrinho, int escolha, int quantidade) {
		Camiseta opcaoEscolhida = null;

		switch (escolha) {
		case 1:
			opcaoEscolhida = new Camiseta("Manga curta", 10.00);
			break;
		case 2:
			opcaoEscolhida = new Camiseta("Manga longa", 20.00);
			break;
		case 3:
			opcaoEscolhida = new Camiseta("Xadrez", 30.00);
			break;
		}

		double total = opcaoEscolhida.getPreco() * quantidade;
		Carrinho item = new Carrinho(opcaoEscolhida, quantidade, total);
		carrinho.add(item);

		System.out.println("Produto adicionado ao carrinho!");
	}

	private static void imprimirResumoCarrinho(List<Carrinho> carrinho) {
		System.out.println("------- Resumo do Carrinho -------");
		for (Carrinho item : carrinho) {
			System.out.println("Tipo: " + item.getCamiseta().getTipo());
			System.out.println("Quantidade: " + item.getQuantidade());
			System.out.println("Valor Total: R$ " + item.getTotal());
			System.out.println("----------------------------------");
		}
	}
}
