package it.prova.ebay.repository.utente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.ebay.model.Utente;

public class CustomUtenteRepositoryImpl implements CustomUtenteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Utente> findByExample(Utente utenteInstance) {

		List<String> whereClauses = new ArrayList<>();
		Map<String, Object> parameterMap = new HashMap<>();

		StringBuilder queryBuilder = new StringBuilder("select u from Utente u left join fetch u.ruoli r "
				+ "left join fetch u.annunci a left join fetch u.acquisti b where u.id = u.id");

		if (StringUtils.isNotBlank(utenteInstance.getNome())) {
			whereClauses.add(" u.nome like :nome ");
			parameterMap.put("nome", "%" + utenteInstance.getNome() + "%");
		}
		if (StringUtils.isNotBlank(utenteInstance.getCognome())) {
			whereClauses.add(" u.cognome like :cognome ");
			parameterMap.put("cognome", "%" + utenteInstance.getCognome() + "%");
		}
		if (StringUtils.isNotBlank(utenteInstance.getUsername())) {
			whereClauses.add(" u.username like :username ");
			parameterMap.put("username", "%" + utenteInstance.getUsername() + "%");
		}
		if (StringUtils.isNotBlank(utenteInstance.getCodiceFiscale())) {
			whereClauses.add(" u.codiceFiscale like :codiceFiscale ");
			parameterMap.put("codiceFiscale", "%" + utenteInstance.getCodiceFiscale() + "%");
		}
		if (utenteInstance.getDataNascita() != null) {
			whereClauses.add(" u.dataNascita >= :dataNascita ");
			parameterMap.put("dataNascita", utenteInstance.getDataNascita());
		}
		if (utenteInstance.getDataCreazione() != null) {
			whereClauses.add(" u.dataCreazione >= :dataCreazione ");
			parameterMap.put("dataCreazione", utenteInstance.getDataCreazione());
		}
		if (utenteInstance.getCredito() != null && utenteInstance.getCredito()>=0) {
			whereClauses.add(" u.credito = :credito ");
			parameterMap.put("credito", utenteInstance.getCredito());
		}
		if (utenteInstance.getDataNascita() != null) {
			whereClauses.add(" u.dataNascita = :dataNascita ");
			parameterMap.put("dataNascita", utenteInstance.getDataNascita());
		}
		if (utenteInstance.getRuoli() != null && !utenteInstance.getRuoli().isEmpty()) {
			whereClauses.add(" r = :ruoli ");
			parameterMap.put("ruoli", utenteInstance.getRuoli());
		}
		if (utenteInstance.getStato() != null) {
			whereClauses.add(" u.stato = :stato ");
			parameterMap.put("stato", utenteInstance.getStato());
		}
		if (utenteInstance.getAcquisti() != null && !utenteInstance.getAcquisti().isEmpty()) {
			whereClauses.add(" b = :acquisti ");
			parameterMap.put("acquisti", utenteInstance.getAcquisti());
		}
		if (utenteInstance.getAnnunci() != null && !utenteInstance.getAnnunci().isEmpty()) {
			whereClauses.add(" a = :annunci ");
			parameterMap.put("annunci", utenteInstance.getAnnunci());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Utente> typedQuery = entityManager.createQuery(queryBuilder.toString(), Utente.class);

		for (String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}

		return typedQuery.getResultList();

	}

}
