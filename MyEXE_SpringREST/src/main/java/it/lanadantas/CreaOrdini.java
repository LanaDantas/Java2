package it.lanadantas;

import java.util.ArrayList;
import java.util.List;

public class CreaOrdini {

	private List<Ordine> ordini = new ArrayList<>();
	
	public CreaOrdini() {
	}
	
	public CreaOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
	public void addOrdine(Ordine ordine) {
		ordini.add(ordine);
	}
	
	public void stampaOrdini() {
		System.out.println("--------------- Ordine 1 ---------------");	
		for (Ordine ordine : ordini) {
			System.out.println(ordine);
		}
	}

}
