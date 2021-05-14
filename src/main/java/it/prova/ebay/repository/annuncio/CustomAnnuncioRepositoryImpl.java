package it.prova.ebay.repository.annuncio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.ebay.model.Annuncio;

public class CustomAnnuncioRepositoryImpl implements CustomAnnuncioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Annuncio> findByExample(Annuncio annuncioExample) {
		List<String> whereClauses = new ArrayList<>();
		Map<String, Object> parameterMap = new HashMap<>();

		StringBuilder queryBuilder = new StringBuilder(
				"select a from Annuncio a left join fetch a.utente left join fetch a.categorie c where a.id = a.id");

		if (annuncioExample.getAperto() != null) {
			whereClauses.add(" a.aperto = :aperto ");
			parameterMap.put("aperto", annuncioExample.getAperto());
		}
		if (StringUtils.isNotBlank(annuncioExample.getTestoAnnuncio())) {
			whereClauses.add(" a.testoAnnuncio like :testoAnnuncio ");
			parameterMap.put("testoAnnuncio", "%" + annuncioExample.getTestoAnnuncio() + "%");
		}
		if (annuncioExample.getPrezzo() != null) {
			whereClauses.add(" a.prezzo = :prezzo ");
			parameterMap.put("prezzo", annuncioExample.getPrezzo());
		}
		if (annuncioExample.getDataPubblicazione() != null) {
			whereClauses.add(" a.dataPubblicazione = :dataPubblicazione ");
			parameterMap.put("dataPubblicazione", annuncioExample.getDataPubblicazione());
		}
		if (annuncioExample.getUtente() != null && annuncioExample.getUtente().getId() != null) {
			whereClauses.add(" a = :utente ");
			parameterMap.put("utente", annuncioExample.getUtente());
		}
		if (annuncioExample.getCategorie() != null) {
			whereClauses.add(" a.categorie = :categorie ");
			parameterMap.put("categorie", annuncioExample.getCategorie());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Annuncio> typedQuery = entityManager.createQuery(queryBuilder.toString(), Annuncio.class);

		for (String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
