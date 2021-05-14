package it.prova.ebay.service.annuncio;

import java.util.List;

import it.prova.ebay.model.Annuncio;

public interface AnnuncioService {
	
	public List<Annuncio> listAllUtenti();

	public Annuncio caricaSingoloUtente(Long id);

	public void aggiorna(Annuncio annuncioInstance);

	public void inserisci(Annuncio annuncioInstance);

	public void rimuovi(Annuncio annuncioInstance);

	public List<Annuncio> findByExample(Annuncio annuncioExample);


}
