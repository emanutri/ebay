package it.prova.ebay.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import it.prova.ebay.model.Categoria;

public class CategoriaDTO {

	private Long id;

	@NotBlank(message = "{descrizione.notblank}")
	private String descrizione;

	@NotBlank(message = "{codice.notblank}")
	private String codice;

	private Set<AnnuncioDTO> annunci = new HashSet<>(0);

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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Set<AnnuncioDTO> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<AnnuncioDTO> annunci) {
		this.annunci = annunci;
	}

	public CategoriaDTO() {

	}

	public CategoriaDTO(Long id, @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotBlank(message = "{codice.notblank}") String codice, Set<AnnuncioDTO> annunci) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.annunci = annunci;
	}

	public CategoriaDTO(@NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotBlank(message = "{codice.notblank}") String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public CategoriaDTO(Long id, @NotBlank(message = "{descrizione.notblank}") String descrizione,
			@NotBlank(message = "{codice.notblank}") String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public CategoriaDTO(Long id) {
		this.id = id;
	}

	public Categoria buildCategoriaModel() {
		return new Categoria(this.id, this.descrizione, this.codice);
	}

	public static CategoriaDTO createCategoriaDTOInstanceFromParams(String descrizione, String codice) {

		CategoriaDTO result = new CategoriaDTO(descrizione, codice);
		return result;
	}

	public static Categoria createModelFromDTO(CategoriaDTO categoriaInstance) {
//		System.out.println(categoriaInstance);
//		System.out.println(categoriaInstance.getId());
		
		return new Categoria(categoriaInstance.getId(), categoriaInstance.getDescrizione(),
				categoriaInstance.getCodice());
	}

	public static CategoriaDTO createDTOFromModel(Categoria categoriaInstance) {
		return new CategoriaDTO(categoriaInstance.getId(), categoriaInstance.getDescrizione(),
				categoriaInstance.getCodice());
	}

	public static Set<Categoria> createCategoriaModelListFromDTOList(Set<CategoriaDTO> dtoListInput) {
		System.out.println(dtoListInput + "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		System.out.println(dtoListInput.size() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return dtoListInput.stream().map(categoriaEntity -> {
			System.out.println(categoriaEntity);
			return createModelFromDTO(categoriaEntity);
			}).collect(Collectors.toSet());
	}

	public static Set<CategoriaDTO> createCategoriaDTOListFromModelList(Collection<Categoria> modelListInput) {
		return modelListInput.stream().map(categoriaEntity -> createDTOFromModel(categoriaEntity))
				.collect(Collectors.toSet());
	}

}
