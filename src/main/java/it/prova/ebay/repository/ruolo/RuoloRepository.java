package it.prova.ebay.repository.ruolo;

import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long> {

	Ruolo findByDescrizioneAndCodice(String descrizione, String codice);

}
