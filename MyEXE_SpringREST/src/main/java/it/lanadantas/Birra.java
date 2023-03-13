package it.lanadantas;

public class Birra extends Bevanda {
	
	String nome = "Leffe";
	Double prezzo = 3.5;
	Double calorie = 225.3;
	int cl = 50;
	
	Birra() {
	}
	
	public Birra(String nome, Double prezzo, Double calorie, int cl) {
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

	public int getCl() {
		return cl;
	}

	public void setCl(int cl) {
		this.cl = cl;
	}

	@Override
	public String toString() {
		return "Birra " + nome + ", " + prezzo + "Є, " + calorie + " calorie, " + cl + " cl";
	}
}
