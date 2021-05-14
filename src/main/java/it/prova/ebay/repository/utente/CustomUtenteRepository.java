package it.prova.ebay.repository.utente;

import java.util.List;

import it.prova.ebay.model.Utente;

public interface CustomUtenteRepository {
	
	List<Utente> findByExample(Utente utenteInstance);

}
