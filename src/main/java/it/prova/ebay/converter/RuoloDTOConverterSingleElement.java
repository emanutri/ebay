package it.prova.ebay.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import it.prova.ebay.dto.RuoloDTO;

public class RuoloDTOConverterSingleElement implements Converter<String, Set<RuoloDTO>> {

	@Override
	public Set<RuoloDTO> convert(String source) {
		Set<RuoloDTO> ruoliDTO = new HashSet<>(0);
		ruoliDTO.add(new RuoloDTO(Long.parseLong(source)));
		return ruoliDTO;
	}

}
