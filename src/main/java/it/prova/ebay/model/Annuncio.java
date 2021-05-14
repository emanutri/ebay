package it.prova.ebay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "annuncio")
public class Annuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "{aperto.notnull}")
	@Column(name = "aperto")
	private Boolean aperto = true;

	@NotBlank(message = "{testoAnnuncio.notblank}")
	@Column(name = "testo_annuncio")
	private String testoAnnuncio;

	@NotNull(message = "{prezzo.notnull}")
	@DecimalMin("0.01")
	@Column(name = "prezzo")
	private Double prezzo;

	@NotNull(message = "{dataPubblicazione.notnull}")
	@Column(name = "data_pubblicazione")
	private Date dataPubblicazione;
	
	@NotNull(message = "{utente.notnull}")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToMany(mappedBy = "annunci")
	private Set<Categoria> categorie = new HashSet<Categoria>(0);

	public Annuncio() {
	}

	// non inserisco aperto in quanto all'inserimento dell'annuncio, diventa subito
	// aperto=true
	public Annuncio(String testoAnnuncio, Double prezzo, Date dataPubblicazione, Set<Categoria> categorie) {
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.dataPubblicazione = dataPubblicazione;
		this.categorie = categorie;
	}

	public Annuncio(Long id, Boolean aperto, String testoAnnuncio, Double prezzo, Date dataPubblicazione, Utente utente,
			Set<Categoria> categorie) {
		this.id = id;
		this.aperto = aperto;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.dataPubblicazione = dataPubblicazione;
		this.utente = utente;
		this.categorie = categorie;
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

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
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
