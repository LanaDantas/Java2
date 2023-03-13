package it.lanadantas;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class Menu {
	ArrayList<Consumazione> consumazioni = new ArrayList<>();

	Menu() {
	}

	public void stampaMenu() {
		for (Consumazione elemento : consumazioni) {
			System.out.println(elemento);
		}
	}

	public void setConsumazioni(ArrayList<Consumazione> consumazioni) {
		this.consumazioni = consumazioni;
	}

	public ArrayList<Consumazione> getConsumazioni() {
		return consumazioni;
	}
	
	public void addConsumazione(Consumazione consumazione) {
		consumazioni.add(consumazione);
	}

	@Override
	public String toString() {
		return "Menu [consumazioni=" + consumazioni + "]";
	}

}
