package it.lanadantas;

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String cartaDiCredito;
	
	public Cliente() {
	}

	public Cliente(int idCliente, String nome, String cartaDiCredito) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cartaDiCredito = cartaDiCredito;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCartaDiCredito() {
		return cartaDiCredito;
	}

	public void setCartaDiCredito(String cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cartaDiCredito=" + cartaDiCredito + "]";
	}

}
