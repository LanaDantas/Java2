package it.lanadantas;

public class HamburgerSemplice extends Hamburger {
	
	String nome = "X-burger";
	Double prezzo = 9.5;
	Double calorie = 290.5;
	
	HamburgerSemplice() {
	}

	public HamburgerSemplice(String nome, Double prezzo, Double calorie) {
	}

	public String getNome() {
		return nome;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public Double getCalorie() {
		return calorie;
	}

	@Override
	public String toString() {
		return "Hamburger " + nome + ", " + prezzo + "Є, " + calorie + " calorie";
	}
}
