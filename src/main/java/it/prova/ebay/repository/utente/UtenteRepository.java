package it.prova.ebay.repository.utente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, CustomUtenteRepository {

	Optional<Utente> findByUsername(String username);

	@EntityGraph(attributePaths = { "ruoli" })
	Utente findByUsernameAndPasswordAndStato(String username, String password, StatoUtente stato);

	@EntityGraph(attributePaths = { "ruoli" })
	List<Utente> findByCognomeIgnoreCaseContainingAndNomeIgnoreCaseContainingAndRuoli(String cognome, String nome,
			Ruolo ruolo);
	
	@Query("select u from Utente u left join fetch u.ruoli r left join fetch u.annunci a left join fetch u.acquisti b where u.id = ?1")
	Optional<Utente> findByIdEager(Long id);
	
	List<Utente> findByRuoliAndStato(Ruolo ruolo, StatoUtente stato);

}
