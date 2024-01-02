package projetojava;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Carrinho> carrinhoDeCompras = new ArrayList<Carrinho>();

		Scanner leia = new Scanner(System.in);
		int opcao, qtde = 0;
		double valorTotal = 0.0;

		do {
			try {
				System.out.println(Cores.BRANCO_BOLD + "\n		BRECHÓ	GEN\r\n" + "\r\n"
						+ "Item		Camiseta		Valor\r\n" + "1.		Manga curta		R$ 10,00\r\n"
						+ "2.		Manga longa		R$ 20,00\r\n" + "3.		Xadrez			R$ 30,00\r\n"
						+ "0. 		Encerrar pedido e ver carrinho");
				System.out.println("\nEscolha o tipo de camiseta:");
				opcao = leia.nextInt();

				if (opcao >= 1 && opcao <= 3) {
					System.out.println("\nDigite a quantidade desejada:");
					qtde = leia.nextInt();

					if (qtde > 0) {
						double valorPedido = adicionarAoCarrinho(carrinhoDeCompras, opcao, qtde);
						valorTotal += valorPedido;
					} else {
						System.out.println("Erro: Quantidade deve ser maior que 0. Tente novamente.");
					}

				} else if (opcao != 0) {
					System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro: Insira a quantidade em número(s) inteiro(s).");
				leia.nextLine();
				opcao = -1;
			}

		} while (opcao != 0);

		imprimirResumoCarrinho(carrinhoDeCompras);
		System.out.println("Valor total dos pedidos: R$ " + valorTotal);
		System.out.println("Pedido finalizado.");
	}

	private static double adicionarAoCarrinho(List<Carrinho> carrinho, int escolha, int quantidade) {
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

		System.out.println("Produto adicionado ao carrinho.");
		return total;
	}

	private static void imprimirResumoCarrinho(List<Carrinho> carrinho) {
		System.out.println("------- Resumo do carrinho -------");
		for (Carrinho item : carrinho) {
			System.out.println("Tipo: " + item.getCamiseta().getTipo());
			System.out.println("Quantidade: " + item.getQuantidade());
			System.out.println("Valor total: R$ " + item.getTotal());
			System.out.println("----------------------------------");
		}
	}
}

class Cores {
	public static final String RESET = "\u001B[0m";
	public static final String BOLD = "\u001B[1m";
	public static final String BRANCO = "\u001B[37m";
	public static final String BRANCO_BOLD = BOLD + BRANCO;

}
