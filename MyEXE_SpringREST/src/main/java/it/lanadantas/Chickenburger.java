package it.lanadantas;

public class Chickenburger extends Hamburger {
	
	String nome = "X-Chicken";
	Double prezzo = 7.50;
	Double calorie = 270.3;
	
	Chickenburger() {
	}
	
	public Chickenburger(String nome, Double prezzo, Double calorie) {
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
