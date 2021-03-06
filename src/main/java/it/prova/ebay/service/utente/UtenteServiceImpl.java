package it.prova.ebay.service.utente;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.model.Utente;
import it.prova.ebay.repository.utente.UtenteRepository;
import it.prova.ebay.service.ruolo.RuoloService;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository repository;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return (List<Utente>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtente(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		repository.save(utenteInstance);
	}

	@Transactional
	public void inserisci(Utente utenteInstance) {
		if (utenteInstance == null) {
			throw new RuntimeException("Errore nell'inserimento dell'utente.");
		}
		utenteInstance.setPassword(passwordEncoder.encode(utenteInstance.getPassword()));
		utenteInstance.setDataCreazione(new Date());
		utenteInstance.setCredito(0.0);
		utenteInstance.getRuoli().add(ruoloService.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
		utenteInstance.setStato(StatoUtente.ATTIVO);
		repository.save(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		repository.delete(utenteInstance);
	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente utenteExample) {
		return repository.findByExample(utenteExample);
	}

	@Transactional(readOnly = true)
	public Utente findByUserName(String username) {
		return repository.findByUsername(username).orElse(null);
	}

	@Transactional
	public void invertUserAbilitation(Long utenteInstanceId) {
		if (utenteInstanceId == null || utenteInstanceId < 1) {
			throw new RuntimeException("Input invalido.");
		}
		Utente utenteInstance = caricaSingoloUtente(utenteInstanceId);
		if (utenteInstance == null) {
			throw new RuntimeException("Elemento non trovato.");
		}
		if (utenteInstance.isAdmin() && repository
				.findByRuoliAndStato(ruoloService.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"),
						StatoUtente.ATTIVO)
				.size() == 1) {
			throw new RuntimeException("Impossibile eliminare l'ultimo Admin!!!");

		}
		if (utenteInstance.getStato().equals(StatoUtente.ATTIVO)) {
			utenteInstance.setStato(StatoUtente.DISABILITATO);
		} else if (utenteInstance.getStato().equals(StatoUtente.DISABILITATO)) {
			utenteInstance.setStato(StatoUtente.ATTIVO);
		}
	}

	@Transactional(readOnly = true)
	public List<Utente> findByCognomeNomeRuolo(String cognome, String nome, Ruolo ruolo) {
		return repository.findByCognomeIgnoreCaseContainingAndNomeIgnoreCaseContainingAndRuoli(cognome, nome, ruolo);
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtenteEager(Long id) {
		return repository.findByIdEager(id).orElse(null);
	}

}
