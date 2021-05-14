package it.prova.ebay.repository.annuncio;

import java.util.List;

import it.prova.ebay.model.Annuncio;

public interface CustomAnnuncioRepository {

	List<Annuncio> findByExample(Annuncio annuncioExample);
}
