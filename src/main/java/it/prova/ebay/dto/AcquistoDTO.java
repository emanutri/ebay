package it.prova.ebay.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.ebay.model.Acquisto;
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
	
	public Acquisto buildAcquistoModel() {
		return new Acquisto(this.descrizione, this.anno ,this.prezzo);
	}

	public static AcquistoDTO createAcquistoDTOInstanceFromParams(String descrizione, Date anno, Double prezzo) {

		AcquistoDTO result = new AcquistoDTO(descrizione,prezzo,anno);

		return result;
	}

	public static Acquisto createModelFromDTO(AcquistoDTO acquistoInstance) {
		return new Acquisto(acquistoInstance.getDescrizione(), acquistoInstance.getAnno(), acquistoInstance.getPrezzo());
	}

	public static AcquistoDTO createDTOFromModel(Acquisto acquistoInstance) {
		return new AcquistoDTO(acquistoInstance.getDescrizione(), acquistoInstance.getPrezzo(), acquistoInstance.getAnno());
	}

	public static List<Acquisto> createAcquistoModelListFromDTOList(List<AcquistoDTO> dtoListInput) {
		return dtoListInput.stream().map(utenteEntity -> createModelFromDTO(utenteEntity)).collect(Collectors.toList());
	}

	public static Set<AcquistoDTO> createAcquistoDTOListFromModelList(Collection<Acquisto> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> createDTOFromModel(utenteEntity))
				.collect(Collectors.toSet());
	}


}
