package it.lanadantas;

public class Cheeseburger extends Hamburger {
	
	String nome = "Cheeseburger";
	Double prezzo = 10.5;
	Double calorie = 310.6;
	
	Cheeseburger() {
	}
	
	public Cheeseburger(String nome, Double prezzo, Double calorie) {

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
