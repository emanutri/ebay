package it.prova.ebay.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.prova.ebay.dto.RuoloDTO;

@Component
public class RuoloDTOConverter implements Converter<String, Set<RuoloDTO>>{

	@Override
	public Set<RuoloDTO> convert(String source) {
		Set<RuoloDTO> ruoliDTO = new HashSet<>(0);
//		for(String ruoloIdParam : source) {
//			ruoliDTO.add(new RuoloDTO(Long.parseLong(ruoloIdParam)));
		ruoliDTO.add(new RuoloDTO(Long.parseLong(source)));

//		}
		
		return ruoliDTO;
	}
		
}
