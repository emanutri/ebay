package it.prova.ebay.dto;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.validate.InsertAnnuncioValid;

public class AnnuncioDTO {

	private Long id;

	@NotNull(message = "{aperto.notnull}", groups = InsertAnnuncioValid.class)
	private Boolean aperto;

	@NotBlank(message = "{testoAnnuncio.notblank}", groups = InsertAnnuncioValid.class)
	private String testoAnnuncio;

	@NotNull(message = "{prezzo.notnull}", groups = InsertAnnuncioValid.class)
	private Double prezzo;

	@NotNull(message = "{dataPubblicazione.notnull}")
	private Date dataPubblicazione;

	@NotNull(message = "{utente.notnull}")
	private UtenteDTO utente;

	private Set<CategoriaDTO> categorie = new HashSet<CategoriaDTO>(0);

	public AnnuncioDTO() {
	}

	public AnnuncioDTO(Long id, Boolean aperto, String testoAnnuncio, Double prezzo, Date dataPubblicazione,
			UtenteDTO utente) {
		this.id = id;
		this.aperto = aperto;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.dataPubblicazione = dataPubblicazione;
		this.utente = utente;
	}

	public AnnuncioDTO(Long id, Boolean aperto, String testoAnnuncio, Double prezzo, Date dataPubblicazione,
			UtenteDTO utente, Set<CategoriaDTO> categorie) {
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

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public Set<CategoriaDTO> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<CategoriaDTO> categorie) {
		this.categorie = categorie;
	}

	public Annuncio buildAnnuncioModel() {
		return new Annuncio(this.id, this.aperto, this.testoAnnuncio, this.prezzo, this.dataPubblicazione,
				this.utente.buildUtenteModel());
	}

	public static AnnuncioDTO createAnnuncioDTOInstanceFromParams(Long id, Boolean aperto, String testoAnnuncio,
			Double prezzo, Date dataPubblicazione, UtenteDTO utente, Set<CategoriaDTO> categorie) {

		AnnuncioDTO result = new AnnuncioDTO(id, aperto, testoAnnuncio, prezzo, dataPubblicazione, utente);

		return result;
	}

	public static Annuncio createModelFromDTO(AnnuncioDTO annuncioInstance) {
		return new Annuncio(annuncioInstance.getId(), annuncioInstance.getAperto(), annuncioInstance.getTestoAnnuncio(),
				annuncioInstance.getPrezzo(), annuncioInstance.getDataPubblicazione(),
				annuncioInstance.getUtente().buildUtenteModel(),
				CategoriaDTO.createCategoriaModelListFromDTOList(annuncioInstance.getCategorie()));
	}

	public static Annuncio createModelFromDTOForSearch(AnnuncioDTO annuncioInstance) {
		return new Annuncio(annuncioInstance.getId(), annuncioInstance.getAperto(), annuncioInstance.getTestoAnnuncio(),
				annuncioInstance.getPrezzo(), annuncioInstance.getDataPubblicazione(),
				CategoriaDTO.createCategoriaModelListFromDTOList(annuncioInstance.getCategorie()));
	}

	public static AnnuncioDTO createDTOFromModel(Annuncio annuncioInstance) {
		return new AnnuncioDTO(annuncioInstance.getId(), annuncioInstance.getAperto(),
				annuncioInstance.getTestoAnnuncio(), annuncioInstance.getPrezzo(),
				annuncioInstance.getDataPubblicazione(), UtenteDTO.createDTOFromModel(annuncioInstance.getUtente()),
				CategoriaDTO.createCategoriaDTOListFromModelList(annuncioInstance.getCategorie()));
	}

	public static List<Annuncio> createAnnuncioModelListFromDTOList(List<AnnuncioDTO> dtoListInput) {
		return dtoListInput.stream().map(utenteEntity -> createModelFromDTO(utenteEntity)).collect(Collectors.toList());
	}

	public static Set<AnnuncioDTO> createAnnuncioDTOListFromModelList(Collection<Annuncio> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> createDTOFromModel(utenteEntity))
				.collect(Collectors.toSet());
	}
}
