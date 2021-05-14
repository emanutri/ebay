package it.prova.ebay.service.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.model.Utente;
import it.prova.ebay.repository.utente.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository repository;

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
		Utente utenteInstance = caricaSingoloUtente(utenteInstanceId);
		if (utenteInstance == null) {
			throw new RuntimeException("Elemento non trovato.");
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

}
