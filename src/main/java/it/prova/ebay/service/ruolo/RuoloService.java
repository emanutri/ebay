package it.prova.ebay.service.ruolo;

import java.util.List;

import it.prova.ebay.model.Ruolo;

public interface RuoloService {
	
	public List<Ruolo> listAllRuoli();

	public Ruolo caricaSingoloElemento(Long id);

	public void aggiorna(Ruolo ruoloInstance);

	public void inserisci(Ruolo ruoloInstance);

	public void rimuovi(Ruolo ruoloInstance);

	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice);

}
