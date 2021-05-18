package it.prova.ebay.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.prova.ebay.dto.CategoriaDTO;

@Component
public class CategoriaDTOConverterSingleElement implements Converter<String, Set<CategoriaDTO>> {

	@Override
	public Set<CategoriaDTO> convert(String source) {
		Set<CategoriaDTO> categorieDTO = new HashSet<>(0);
		categorieDTO.add(new CategoriaDTO(Long.parseLong(source)));
		return categorieDTO;
	}
}
