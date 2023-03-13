package it.lanadantas;

import java.util.ArrayList;

public abstract class Hamburger implements Consumazione {
	
	String nome;
	Double prezzo;
	Double calorie;
		
	Hamburger() {
	}

	public Hamburger(String nome, Double prezzo, Double calorie) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.calorie = calorie;
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

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}

	@Override
	public String toString() {
		return "Hamburger [nome=" + nome + ", prezzo=" + prezzo + ", calorie=" + calorie +"]";
	}

}
