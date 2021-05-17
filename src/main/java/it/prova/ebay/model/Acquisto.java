package it.prova.ebay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "acquisto")
public class Acquisto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{descrizione.notblank}")
	@Column(name = "descrizione")
	private String descrizione;

	@NotNull(message = "{anno.notnull}")
	@Column(name = "anno")
	private Date anno;

	@NotNull(message = "{prezzo.notnull}")
	@DecimalMin("0.01")
	@Column(name = "prezzo")
	private Double prezzo;

	@NotNull(message = "{utente.notnull}")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utente;

	public Acquisto() {
	}

	public Acquisto(@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{anno.notnull}") Date anno,
			@NotNull(message = "{prezzo.notnull}") @DecimalMin("0.01") Double prezzo) {
		super();
		this.descrizione = descrizione;
		this.anno = anno;
		this.prezzo = prezzo;
	}

	public Acquisto(Long id, @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{anno.notnull}") Date anno,
			@NotNull(message = "{prezzo.notnull}") @DecimalMin("0.01") Double prezzo) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.anno = anno;
		this.prezzo = prezzo;
	}

	public Acquisto(Long id, @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{anno.notnull}") Date anno,
			@NotNull(message = "{prezzo.notnull}") @DecimalMin("0.01") Double prezzo,
			@NotNull(message = "{utente.notnull}") Utente utente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.anno = anno;
		this.prezzo = prezzo;
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
