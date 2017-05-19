package it.zeurelscan.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serie database table.
 * 
 */
@Entity
@NamedQuery(name="Serie.findAll", query="SELECT s FROM Serie s")
public class Serie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idserie;

	@Column(name="prima_immagine")
	private String primaImmagine;

	private String start;

	private String titolo;

	@Column(name="ultima_immagine")
	private String ultimaImmagine;

	//bi-directional many-to-one association to Pagina
	@Transient
	@OneToMany(mappedBy="serie", fetch=FetchType.EAGER)
	private List<Pagina> paginas;

	//bi-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumn(name="serie_precedente")
	private Serie serie1;

	//bi-directional many-to-one association to Serie
	@OneToMany(mappedBy="serie1", fetch=FetchType.EAGER)
	private List<Serie> series1;

	//bi-directional many-to-one association to Serie
	@ManyToOne
	@JoinColumn(name="serie_successiva")
	private Serie serie2;

	//bi-directional many-to-one association to Serie
	@OneToMany(mappedBy="serie2", fetch=FetchType.EAGER)
	private List<Serie> series2;

	public Serie() {
	}

	public int getIdserie() {
		return this.idserie;
	}

	public void setIdserie(int idserie) {
		this.idserie = idserie;
	}

	public String getPrimaImmagine() {
		return this.primaImmagine;
	}

	public void setPrimaImmagine(String primaImmagine) {
		this.primaImmagine = primaImmagine;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getUltimaImmagine() {
		return this.ultimaImmagine;
	}

	public void setUltimaImmagine(String ultimaImmagine) {
		this.ultimaImmagine = ultimaImmagine;
	}

	public List<Pagina> getPaginas() {
		return this.paginas;
	}

	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}

	public Pagina addPagina(Pagina pagina) {
		getPaginas().add(pagina);
		pagina.setSerie(this);

		return pagina;
	}

	public Pagina removePagina(Pagina pagina) {
		getPaginas().remove(pagina);
		pagina.setSerie(null);

		return pagina;
	}

	public Serie getSerie1() {
		return this.serie1;
	}

	public void setSerie1(Serie serie1) {
		this.serie1 = serie1;
	}

	public List<Serie> getSeries1() {
		return this.series1;
	}

	public void setSeries1(List<Serie> series1) {
		this.series1 = series1;
	}

	public Serie addSeries1(Serie series1) {
		getSeries1().add(series1);
		series1.setSerie1(this);

		return series1;
	}

	public Serie removeSeries1(Serie series1) {
		getSeries1().remove(series1);
		series1.setSerie1(null);

		return series1;
	}

	public Serie getSerie2() {
		return this.serie2;
	}

	public void setSerie2(Serie serie2) {
		this.serie2 = serie2;
	}

	public List<Serie> getSeries2() {
		return this.series2;
	}

	public void setSeries2(List<Serie> series2) {
		this.series2 = series2;
	}

	public Serie addSeries2(Serie series2) {
		getSeries2().add(series2);
		series2.setSerie2(this);

		return series2;
	}

	public Serie removeSeries2(Serie series2) {
		getSeries2().remove(series2);
		series2.setSerie2(null);

		return series2;
	}

}