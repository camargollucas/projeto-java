package projetojava;

public class Carrinho {
	private Camiseta camiseta;
	private int quantidade;
	private double total;

	public Carrinho(Camiseta camiseta, int quantidade, double total) {
		this.camiseta = camiseta;
		this.quantidade = quantidade;
		this.total = total;
	}

	public Camiseta getCamiseta() {
		return camiseta;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getTotal() {
		return total;
	}
}
