package it.prova.ebay.repository.acquisto;

import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Utente;

public interface AcquistoRepository extends CrudRepository<Acquisto, Long>{
	
	Acquisto findByUtente(Utente utente);

}
