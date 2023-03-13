package it.lanadantas.MySpringREST;

public class Evento {
	
	private int id_evento;
	private String titolo;
	private String luogo;
	
	public Evento() {
	}

	public Evento(int id_evento, String titolo, String luogo) {
		super();
		this.id_evento = id_evento;
		this.titolo = titolo;
		this.luogo = luogo;
	}

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public void add(Evento evento) {
	}

}
