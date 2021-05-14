package it.prova.ebay.repository.annuncio;

import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Annuncio;

public interface AnnuncioRepository extends CrudRepository<Annuncio, Long>, CustomAnnuncioRepository {

}
