package it.prova.ebay.service.acquisto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Utente;
import it.prova.ebay.repository.acquisto.AcquistoRepository;

@Service
public class AcquistoServiceImpl implements AcquistoService {

	@Autowired
	private AcquistoRepository repository;

	@Transactional(readOnly = true)
	public List<Acquisto> listAllAcquisti() {
		return (List<Acquisto>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Acquisto caricaSingoloUtente(Long id) {
		return repository.findById(id).orElse(null);

	}

	@Transactional
	public void aggiorna(Acquisto acquistoInstance) {
		repository.save(acquistoInstance);
	}

	@Transactional
	public void inserisci(Acquisto acquistoInstance) {
		repository.save(acquistoInstance);

	}

	@Transactional
	public void rimuovi(Acquisto acquistoInstance) {
		repository.delete(acquistoInstance);

	}

	@Transactional(readOnly = true)
	public Acquisto findByUser(Utente utente) {
		return repository.findByUtente(utente);
	}
}
