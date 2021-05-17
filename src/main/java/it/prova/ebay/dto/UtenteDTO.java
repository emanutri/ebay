package it.prova.ebay.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.model.Utente;
import it.prova.ebay.validate.RegistrationOrInsertValid;
import it.prova.ebay.validate.UpdateValid;

public class UtenteDTO {

	private Long id;

	@NotBlank(message = "{nome.notblank}", groups = { RegistrationOrInsertValid.class, UpdateValid.class })
	private String nome;

	@NotBlank(message = "{cognome.notblank}", groups = { RegistrationOrInsertValid.class, UpdateValid.class })
	private String cognome;

	@NotBlank(message = "{username.notblank}", groups = { RegistrationOrInsertValid.class, UpdateValid.class })
	private String username;

	@NotBlank(message = "{password.notblank}", groups = RegistrationOrInsertValid.class)
	private String password;

	@NotBlank(message = "{confermaPassword.notblank}", groups = RegistrationOrInsertValid.class)
	private String confermaPassword;

	@NotNull(message = "{credito.notull}", groups = UpdateValid.class)
	private Double credito;

	@NotNull(message = "{dataNascita.notnull}", groups = { RegistrationOrInsertValid.class, UpdateValid.class })
	private Date dataNascita;

	@NotNull(message = "{dataCreazione.notnull}")
	private Date dataCreazione;

	@NotBlank(message = "{codiceFiscale.notblank}", groups = { RegistrationOrInsertValid.class, UpdateValid.class })
	@Size(max = 16, min = 16, message = "{codiceFiscale.sizeproblem}", groups = { RegistrationOrInsertValid.class,
			UpdateValid.class })
	private String codiceFiscale;

	@NotNull(message = "{stato.notnull}", groups = UpdateValid.class)
	private StatoUtente stato;

	@NotEmpty(message = "{ruoli.notempty}", groups = UpdateValid.class)
	private Set<RuoloDTO> ruoliDTO = new HashSet<>(0);

	private Set<AcquistoDTO> acquisti = new HashSet<>(0);

	private Set<AnnuncioDTO> annunci = new HashSet<>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfermaPassword() {
		return confermaPassword;
	}

	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Double getCredito() {
		return credito;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

	public StatoUtente getStato() {
		return stato;
	}

	public void setStato(StatoUtente stato) {
		this.stato = stato;
	}

	public Set<RuoloDTO> getRuoliDTO() {
		return ruoliDTO;
	}

	public void setRuoliDTO(Set<RuoloDTO> ruoli) {
		this.ruoliDTO = ruoli;
	}

	public Set<AcquistoDTO> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(Set<AcquistoDTO> acquisti) {
		this.acquisti = acquisti;
	}

	public Set<AnnuncioDTO> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<AnnuncioDTO> annunci) {
		this.annunci = annunci;
	}

	public UtenteDTO() {

	}

	public UtenteDTO(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotNull Double credito, @NotNull Date dataNascita, @NotNull Date dataCreazione,
			@NotBlank String codiceFiscale, @NotNull StatoUtente stato, @NotEmpty Set<RuoloDTO> ruoli) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
		this.ruoliDTO = ruoli;
	}

	public UtenteDTO(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotNull Double credito, @NotNull Date dataNascita, @NotNull Date dataCreazione,
			@NotBlank String codiceFiscale, @NotNull StatoUtente stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
	}

	public UtenteDTO(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotBlank String confermaPassword, @NotNull Double credito,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull StatoUtente stato, @NotEmpty Set<RuoloDTO> ruoli) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.confermaPassword = confermaPassword;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
		this.ruoliDTO = ruoli;
	}

	public UtenteDTO(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotBlank String confermaPassword, @NotNull Double credito,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull StatoUtente stato, @NotEmpty Set<RuoloDTO> ruoli) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.confermaPassword = confermaPassword;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
		this.ruoliDTO = ruoli;
	}

	public UtenteDTO(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotBlank String confermaPassword, @NotNull Double credito,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull StatoUtente stato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.confermaPassword = confermaPassword;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
	}

	public UtenteDTO(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotNull Double credito, @NotNull Date dataNascita, @NotNull Date dataCreazione,
			@NotBlank String codiceFiscale, @NotNull StatoUtente stato, @NotEmpty Set<RuoloDTO> ruoli,
			Set<AcquistoDTO> acquisti, Set<AnnuncioDTO> annunci) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
		this.ruoliDTO = ruoli;
		this.acquisti = acquisti;
		this.annunci = annunci;
	}

	public UtenteDTO(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotNull Date dataCreazione, @NotNull StatoUtente stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.dataCreazione = dataCreazione;
		this.stato = stato;
	}

	public UtenteDTO(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotNull Date dataCreazione, @NotNull StatoUtente stato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.dataCreazione = dataCreazione;
		this.stato = stato;

	}

	public UtenteDTO(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotNull Double credito, @NotNull Date dataNascita, @NotNull Date dataCreazione,
			@NotBlank String codiceFiscale, @NotNull StatoUtente stato,
			@NotEmpty Set<RuoloDTO> ruoli) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.credito = credito;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
		this.ruoliDTO = ruoli;

	}

	public Utente buildUtenteModel() {
		return new Utente(this.nome, this.cognome, this.username, this.password, this.dataNascita, this.dataCreazione,
				this.codiceFiscale, this.credito, this.stato, RuoloDTO.createRuoloModelListFromDTOList(this.ruoliDTO));
	}

	public static UtenteDTO createUtenteDTOInstanceFromParams(String nomeInput, String cognomeInput,
			String usernameInput, String passwordInput, String confermaPasswordInput, Double credito,
			Date dataNascitaInput, Date dataCreazioneInput, String codiceFiscale, StatoUtente statoInput,
			Set<RuoloDTO> ruoli) {

		UtenteDTO result = new UtenteDTO(nomeInput, cognomeInput, usernameInput, passwordInput, confermaPasswordInput,
				credito, dataNascitaInput, dataCreazioneInput, codiceFiscale, statoInput, ruoli);

		return result;
	}

	public static UtenteDTO createUtenteDTOInstanceFromParamsNoPwd(String usernameInput, String nomeInput,
			String cognomeInput, Date dataCreazioneInput, StatoUtente statoInput) {

		UtenteDTO result = new UtenteDTO(nomeInput, cognomeInput, usernameInput, dataCreazioneInput, statoInput);

		return result;
	}

	public static Utente createModelFromDTO(UtenteDTO utenteInstance) {
		return new Utente(utenteInstance.getUsername(), utenteInstance.getPassword(), utenteInstance.getNome(),
				utenteInstance.getCognome(), utenteInstance.getDataCreazione(), utenteInstance.getStato());
	}

	public static UtenteDTO createDTOFromModel(Utente utenteInstance) {
		return new UtenteDTO(utenteInstance.getId(), utenteInstance.getNome(), utenteInstance.getCognome(),
				utenteInstance.getUsername(), utenteInstance.getDataCreazione(), utenteInstance.getStato());
	}

	public static UtenteDTO createDTOFromModelForEdit(Utente utenteInstance) {
		return new UtenteDTO(utenteInstance.getId(), utenteInstance.getNome(), utenteInstance.getCognome(),
				utenteInstance.getUsername(), utenteInstance.getCredito(), utenteInstance.getDataNascita(),
				utenteInstance.getDataCreazione(), utenteInstance.getCodiceFiscale(), utenteInstance.getStato(),
				RuoloDTO.createRuoloDTOListFromModelList(utenteInstance.getRuoli()));
	}

	public static UtenteDTO createDTOFromModelForShow(Utente utenteInstance) {
		return new UtenteDTO(utenteInstance.getId(), utenteInstance.getNome(), utenteInstance.getCognome(),
				utenteInstance.getUsername(), utenteInstance.getCredito(), utenteInstance.getDataNascita(),
				utenteInstance.getDataCreazione(), utenteInstance.getCodiceFiscale(), utenteInstance.getStato(),
				RuoloDTO.createRuoloDTOListFromModelList(utenteInstance.getRuoli()),
				AcquistoDTO.createAcquistoDTOListFromModelList(utenteInstance.getAcquisti()),
				AnnuncioDTO.createAnnuncioDTOListFromModelList(utenteInstance.getAnnunci()));
	}

	public static List<Utente> createUtenteModelListFromDTOList(List<UtenteDTO> dtoListInput) {
		return dtoListInput.stream().map(utenteEntity -> createModelFromDTO(utenteEntity)).collect(Collectors.toList());
	}

	public static List<UtenteDTO> createUtenteDTOListFromModelList(List<Utente> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> createDTOFromModel(utenteEntity))
				.collect(Collectors.toList());
	}

	public boolean isAttivo() {
		return this.stato.equals(StatoUtente.ATTIVO);
	}

	public boolean isDisabilitato() {
		return this.stato.equals(StatoUtente.DISABILITATO);
	}

	public boolean validatePassword() {

		if (this.getPassword().equals(this.getConfermaPassword())) {
			return true;
		}

		return false;
	}

}
