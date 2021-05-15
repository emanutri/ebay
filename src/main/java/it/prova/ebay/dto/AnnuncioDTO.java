package it.prova.ebay.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.Utente;

public class AnnuncioDTO {

	private Long id;

	@NotNull(message = "{aperto.notnull}")
	private Boolean aperto;

	@NotBlank(message = "{testoAnnuncio.notblank}")
	private String testoAnnuncio;

	@NotNull(message = "{prezzo.notnull}")
	private Double prezzo;

	@NotNull(message = "{dataPubblicazione.notnull}")
	private Date dataPubblicazione;

	@NotNull(message = "{utente.notnull}")
	private Utente utente;

	private Set<Categoria> categorie = new HashSet<Categoria>(0);

	public AnnuncioDTO() {
	}

	public AnnuncioDTO(Long id, Boolean aperto, String testoAnnuncio, Double prezzo, Date dataPubblicazione, Utente utente) {
		this.id=id;
		this.aperto=aperto;
		this.testoAnnuncio=testoAnnuncio;
		this.prezzo=prezzo;
		this.dataPubblicazione=dataPubblicazione;
		this.utente=utente;
	}

	public AnnuncioDTO(Long id, Boolean aperto, String testoAnnuncio, Double prezzo, Date dataPubblicazione,
			Utente utente, Set<Categoria> categorie) {
		this.id=id;
		this.aperto=aperto;
		this.testoAnnuncio=testoAnnuncio;
		this.prezzo=prezzo;
		this.dataPubblicazione=dataPubblicazione;
		this.utente=utente;
		this.categorie=categorie;
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

	public Annuncio buildAnnuncioModel() {
		return new Annuncio(this.id, this.aperto, this.testoAnnuncio, this.prezzo, this.dataPubblicazione, this.utente);
	}

	public static AnnuncioDTO createAnnuncioDTOInstanceFromParams(Long id, Boolean aperto, String testoAnnuncio,
			Double prezzo, Date dataPubblicazione, Utente utente, Set<Categoria> categorie) {

		AnnuncioDTO result = new AnnuncioDTO(id, aperto, testoAnnuncio, prezzo, dataPubblicazione, utente);

		return result;
	}
	
	public static Annuncio createModelFromDTO(AnnuncioDTO annuncioInstance) {
		return new Annuncio(annuncioInstance.getId(), annuncioInstance.getAperto(), annuncioInstance.getTestoAnnuncio(), annuncioInstance.getPrezzo(),
				annuncioInstance.getDataPubblicazione(), annuncioInstance.getUtente(), annuncioInstance.getCategorie());
	}
	
	public static AnnuncioDTO createDTOFromModel(Annuncio annuncioInstance) {
		return new AnnuncioDTO(annuncioInstance.getId(), annuncioInstance.getAperto(), annuncioInstance.getTestoAnnuncio(),
				annuncioInstance.getPrezzo(), annuncioInstance.getDataPubblicazione(), annuncioInstance.getUtente(), annuncioInstance.getCategorie());
	}
	
	public static List<Annuncio> createAnnuncioModelListFromDTOList(List<AnnuncioDTO> dtoListInput) {
		return dtoListInput.stream().map(utenteEntity -> createModelFromDTO(utenteEntity)).collect(Collectors.toList());
	}

	public static List<AnnuncioDTO> createAnnuncioDTOListFromModelList(List<Annuncio> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> createDTOFromModel(utenteEntity))
				.collect(Collectors.toList());
	}
}
