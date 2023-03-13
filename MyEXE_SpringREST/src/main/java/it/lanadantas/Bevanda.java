package it.lanadantas;

public abstract class Bevanda implements Consumazione {

	String nome;
	Double prezzo;
	Double calorie;
	int cl;
			
	Bevanda() {
	}
	
	public Bevanda(String nome, Double prezzo, Double calorie, int cl) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.calorie = calorie;
		this.cl = cl;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}

	public int getCl() {
		return cl;
	}

	public void setCl(int cl) {
		this.cl = cl;
	}

	@Override
	public String toString() {
		return "Bevanda [nome=" + nome + ", prezzo=" + prezzo + ", calorie=" + calorie + ", cl=" + cl + "]";
	}
}
