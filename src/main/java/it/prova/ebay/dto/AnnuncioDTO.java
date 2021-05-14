package it.prova.ebay.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.Utente;

public class AnnuncioDTO {

	private Long id;

	@NotNull(message = "{aperto.notnull}")
	private Boolean aperto;

	@NotBlank(message = "{testoAnnuncio.notblank}")
	private String testoAnnuncio;

	@NotNull(message = "{prezzo.notprezzo}")
	private Double prezzo;

	
	private Date data;

	private Utente utente;

	private Set<Categoria> categorie = new HashSet<Categoria>(0);

	public AnnuncioDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAperto() {
		return aperto;
	}

	public void setAperto(Boolean aperto) {
		this.aperto = aperto;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

}
