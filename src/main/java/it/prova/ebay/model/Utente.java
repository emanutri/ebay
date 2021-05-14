package it.prova.ebay.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{nome.notblank}")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	@Column(name = "cognome")
	private String cognome;

	@NotBlank(message = "{username.notblank}")
	@Column(name = "username", unique = true)
	private String username;

	@NotBlank(message = "{password.notblank}")
	@Column(name = "password")
	private String password;

	@NotNull(message = "{data.notnull}")
	@Column(name = "data_nascita")
	private Date dataNascita;

	@NotNull(message = "{data.notnull}")
	@Column(name = "data_creazione")
	private Date dataCreazione;

	@NotBlank(message = "{codiceFiscale.notblank}")
	@Column(name = "codice_fiscale", length = 16)
	private String codiceFiscale;

	@NotNull(message = "{credito.notnull}")
	@DecimalMin("0.0")
	@Column(name = "credito")
	private Double credito;

	@NotNull(message = "{stato.notnull}")
	@Enumerated(EnumType.STRING)
	private StatoUtente stato = StatoUtente.ATTIVO;

	@NotEmpty(message = "{ruoli.notempty}")
	@ManyToMany
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "id"))
	private Set<Ruolo> ruoli = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Acquisto> acquisti = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Annuncio> annunci = new HashSet<>(0);

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

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Set<Acquisto> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(Set<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}

	public Set<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
	}

	public Utente() {

	}

	public Utente(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotNull Date dataNascita, @NotNull Date dataCreazione,
			@NotBlank String codiceFiscale, @NotNull Double credito, @NotNull StatoUtente stato,
			@NotEmpty Set<Ruolo> ruoli, Set<Acquisto> acquisti, Set<Annuncio> annunci) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.credito = credito;
		this.stato = stato;
		this.ruoli = ruoli;
		this.acquisti = acquisti;
		this.annunci = annunci;
	}

	public Utente(Long id, @NotBlank String nome, @NotBlank String cognome, @NotBlank String username,
			@NotBlank String password, @NotNull Date dataNascita, @NotNull Date dataCreazione,
			@NotBlank String codiceFiscale, @NotNull Double credito, @NotNull StatoUtente stato) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.credito = credito;
		this.stato = stato;
	}

	public Utente(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username, @NotBlank String password,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull Double credito, @NotNull StatoUtente stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.credito = credito;
		this.stato = stato;
	}

	public Utente(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username, @NotBlank String password,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull Double credito, @NotNull StatoUtente stato, @NotEmpty Set<Ruolo> ruoli) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.credito = credito;
		this.stato = stato;
		this.ruoli = ruoli;
	}

	public Utente(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username, @NotBlank String password,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull Double credito, @NotNull StatoUtente stato, @NotEmpty Set<Ruolo> ruoli, Set<Acquisto> acquisti,
			Set<Annuncio> annunci) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.credito = credito;
		this.stato = stato;
		this.ruoli = ruoli;
		this.acquisti = acquisti;
		this.annunci = annunci;
	}

	public Utente(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username, @NotBlank String password,
			@NotNull Date dataNascita, @NotNull Date dataCreazione, @NotBlank String codiceFiscale,
			@NotNull StatoUtente stato, @NotEmpty Set<Ruolo> ruoli) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataNascita = dataNascita;
		this.dataCreazione = dataCreazione;
		this.codiceFiscale = codiceFiscale;
		this.stato = stato;
		this.ruoli = ruoli;
	}

	public Utente(@NotBlank String nome, @NotBlank String cognome, @NotBlank String username, @NotBlank String password,
			@NotNull Date dataCreazione, @NotNull StatoUtente stato) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataCreazione = dataCreazione;
		this.stato = stato;
	}

}
