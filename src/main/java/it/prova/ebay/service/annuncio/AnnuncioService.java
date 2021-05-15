package it.prova.ebay.service.annuncio;

import java.util.List;

import it.prova.ebay.model.Annuncio;

public interface AnnuncioService {

	public List<Annuncio> listAllAnnunci();

	public Annuncio caricaSingoloAnnuncio(Long id);

	public Annuncio caricaSingoloAnnuncioEager(Long id);

	public void aggiorna(Annuncio annuncioInstance);

	public void inserisci(Annuncio annuncioInstance);

	public void rimuovi(Annuncio annuncioInstance);

	public List<Annuncio> findByExample(Annuncio annuncioExample);

}
