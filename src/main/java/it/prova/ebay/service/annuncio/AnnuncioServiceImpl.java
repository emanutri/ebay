package it.prova.ebay.service.annuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;
import it.prova.ebay.repository.annuncio.AnnuncioRepository;
import it.prova.ebay.service.categoria.CategoriaService;

@Service
public class AnnuncioServiceImpl implements AnnuncioService {

	@Autowired
	private AnnuncioRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	@Transactional(readOnly = true)
	public List<Annuncio> listAllAnnunci() {
		return (List<Annuncio>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Annuncio caricaSingoloAnnuncio(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public Annuncio caricaSingoloAnnuncioEager(Long id) {
		return repository.findSingleAnnuncioEager(id);
	}

	@Transactional
	public void aggiorna(Annuncio annuncioInstance) {
		repository.save(annuncioInstance);

	}

	@Transactional
	public void inserisci(Annuncio annuncioInstance) {
		repository.save(annuncioInstance);
		if(!annuncioInstance.getCategorie().isEmpty()) {
			for (Categoria categoriaItem : annuncioInstance.getCategorie()) {
				categoriaItem = categoriaService.caricaSingoloCategoria(categoriaItem.getId());
				categoriaItem.getAnnunci().add(annuncioInstance);
				categoriaService.aggiorna(categoriaItem);//al posto di service repo
			}
		}

	}

	@Transactional
	public void rimuovi(Annuncio annuncioInstance) {
		repository.delete(annuncioInstance);

	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample(Annuncio annuncioExample) {
		return repository.findByExample(annuncioExample);
	}

}
