package it.prova.ebay.repository.categoria;

import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	Categoria findByDescrizioneContaining(String term);

}
