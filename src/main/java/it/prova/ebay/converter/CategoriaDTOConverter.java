package it.prova.ebay.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import it.prova.ebay.dto.CategoriaDTO;

public class CategoriaDTOConverter implements Converter<String[], Set<CategoriaDTO>> {

	@Override
	public Set<CategoriaDTO> convert(String[] source) {
		Set<CategoriaDTO> categorieDTO = new HashSet<>(0);
		for(String categoriaIdParam : source) {
			categorieDTO.add(new CategoriaDTO(Long.parseLong(categoriaIdParam)));
		}
	
		return categorieDTO;
		
	}

}
