package it.prova.ebay.service.categoria;

import java.util.List;

import it.prova.ebay.model.Categoria;

public interface CategoriaService {

	public List<Categoria> listAllCategorie();

	public Categoria caricaSingoloCategoria(Long id);

	public void aggiorna(Categoria categoriaInstance);

	public void inserisci(Categoria categoriaInstance);

	public void rimuovi(Categoria categoriaInstance);

	public Categoria findByDescrizione(String term);
	
}
