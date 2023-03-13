package it.lanadantas;

import java.util.List;

public class Ordine {
	
	private int idOrdine;
	private Cliente cliente;
	List<Consumazione> consumazioni;
	private double conto;
	
	public Ordine() {
	}

	public Ordine(int idOrdine, Cliente cliente, List<Consumazione> consumazioni) {
		this.idOrdine = idOrdine;
		this.cliente = cliente;
		this.consumazioni = consumazioni;
		this.conto = conto;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Consumazione> getConsumazioni() {
		return consumazioni;
	}

	public void setConsumazioni(List<Consumazione> consumazioni) {
		this.consumazioni = consumazioni;
	}

	public double getConto() {
		return conto;
	}

	public void setConto(double conto) {
		this.conto = conto;
	}

	@Override
	public String toString() {
		return "Ordine [idOrdine=" + idOrdine + ", cliente=" + cliente + ", consumazioni=" + consumazioni + ", conto="
				+ conto + "]";
	}

	public void add(Ordine ordine) {
		
	}
}
