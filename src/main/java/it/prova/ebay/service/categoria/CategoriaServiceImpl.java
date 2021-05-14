package it.prova.ebay.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.model.Categoria;
import it.prova.ebay.repository.categoria.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional(readOnly = true)
	public List<Categoria> listAllCategorie() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Categoria caricaSingoloCategoria(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Categoria categoriaInstance) {
		categoriaRepository.save(categoriaInstance);
	}

	@Transactional
	public void inserisci(Categoria categoriaInstance) {
		categoriaRepository.save(categoriaInstance);
	}

	@Transactional
	public void rimuovi(Categoria categoriaInstance) {
		categoriaRepository.delete(categoriaInstance);
	}

	@Transactional(readOnly = true)
	public Categoria findByDescrizione(String term) {
		return categoriaRepository.findByDescrizioneContaining(term);
	}

}
