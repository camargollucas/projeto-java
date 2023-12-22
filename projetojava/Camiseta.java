package projetojava;

abstract class Produto {
	private String tipo;
	private double preco;

	public Produto(String tipo, double preco) {
		this.tipo = tipo;
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPreco() {
		return preco;
	}
}

public class Camiseta extends Produto {

	public Camiseta(String tipo, double preco) {
		super(tipo, preco);
	}
}
