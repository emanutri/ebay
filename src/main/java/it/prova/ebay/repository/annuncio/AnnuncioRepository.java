package it.prova.ebay.repository.annuncio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Annuncio;

public interface AnnuncioRepository extends CrudRepository<Annuncio, Long>, CustomAnnuncioRepository {

	@Query("from Annuncio a left join fetch a.utente u left join fetch a.categorie c where a.id = ?1")
	Annuncio findSingleAnnuncioEager(Long id);
}
