package it.zeurelscan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pagina database table.
 * 
 */
@Entity
@NamedQuery(name="Pagina.findAll", query="SELECT p FROM Pagina p")
public class Pagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idipagina;

	@Column(name="indirizzo_immagini")
	private String indirizzoImmagini;

	@Column(name="numero_capitolo")
	private int numeroCapitolo;

	@Column(name="numero_immagini")
	private int numeroImmagini;

	@Column(name="titolo_capitolo")
	private String titoloCapitolo;

	//bi-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumn(name="id_serie")
	private Serie serie;

	public Pagina() {
	}

	public int getIdipagina() {
		return this.idipagina;
	}

	public void setIdipagina(int idipagina) {
		this.idipagina = idipagina;
	}

	public String getIndirizzoImmagini() {
		return this.indirizzoImmagini;
	}

	public void setIndirizzoImmagini(String indirizzoImmagini) {
		this.indirizzoImmagini = indirizzoImmagini;
	}

	public int getNumeroCapitolo() {
		return this.numeroCapitolo;
	}

	public void setNumeroCapitolo(int numeroCapitolo) {
		this.numeroCapitolo = numeroCapitolo;
	}

	public int getNumeroImmagini() {
		return this.numeroImmagini;
	}

	public void setNumeroImmagini(int numeroImmagini) {
		this.numeroImmagini = numeroImmagini;
	}

	public String getTitoloCapitolo() {
		return this.titoloCapitolo;
	}

	public void setTitoloCapitolo(String titoloCapitolo) {
		this.titoloCapitolo = titoloCapitolo;
	}

	public Serie getSerie() {
		return this.serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}