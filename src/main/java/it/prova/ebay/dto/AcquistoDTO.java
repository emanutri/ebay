package it.prova.ebay.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.ebay.model.Utente;

public class AcquistoDTO {

	private Long id;

	@NotBlank(message = "{descrizione.notblank}")
	private String descrizione;

	@NotNull(message = "{prezzo.notnull}")
	private Double prezzo;

	@NotNull(message = "{anno.notnull}")
	private Date anno;

	@NotNull(message = "{utente.notnull}")
	private Utente utente;

	public AcquistoDTO() {
	}

	public AcquistoDTO(@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{prezzo.notnull}") Double prezzo, @NotNull(message = "{anno.notnull}") Date anno) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
	}

	public AcquistoDTO(Long id, @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{prezzo.notnull}") Double prezzo, @NotNull(message = "{anno.notnull}") Date anno,
			@NotNull(message = "{utente.notnull}") Utente utente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
		this.utente = utente;
	}

	public AcquistoDTO(Long id, @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotNull(message = "{prezzo.notnull}") Double prezzo, @NotNull(message = "{anno.notnull}") Date anno) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
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

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	// TO-DO createDTOfrom

}
