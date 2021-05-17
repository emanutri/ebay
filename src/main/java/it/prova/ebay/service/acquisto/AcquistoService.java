package it.prova.ebay.service.acquisto;

import java.util.List;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Utente;

public interface AcquistoService {

	public List<Acquisto> listAllAcquisti();

	public Acquisto caricaSingoloAcquisto(Long id);

	public void aggiorna(Acquisto acquistoInstance);

	public void inserisci(Acquisto acquistoInstance);

	public void rimuovi(Acquisto acquistoInstance);
	
	public Acquisto findByUser(Utente utente);
}
