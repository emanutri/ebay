package it.prova.ebay.repository.acquisto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Utente;

public interface AcquistoRepository extends CrudRepository<Acquisto, Long>{
	
	Acquisto findByUtente(Utente utente);
	
	@Query("select a from Acquisto a left join fetch a.utente where a.id = ?1")
	Acquisto findByIdEager(Long id);

}
