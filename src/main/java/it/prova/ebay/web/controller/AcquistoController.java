package it.prova.ebay.web.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.ebay.dto.AcquistoDTO;
import it.prova.ebay.dto.AnnuncioDTO;
import it.prova.ebay.service.acquisto.AcquistoService;

@Controller
@RequestMapping("/acquisto")
public class AcquistoController {

	@Autowired
	private AcquistoService acquistoService;
	
	@GetMapping
	public ModelAndView listAllAcquisti() {
		ModelAndView mv = new ModelAndView();
		Set<AcquistoDTO> acquistiDTO = AcquistoDTO.createAcquistoDTOListFromModelList(acquistoService.listAllAcquisti());
		mv.addObject("acquisti_list_attribute", acquistiDTO);
		mv.setViewName("acquisto/list");
		return mv;
	}
	
	@PostMapping("/compra")
	public String saveAnnuncio(@Valid @ModelAttribute("show_annuncio_attr") AnnuncioDTO annuncioDTO,
			BindingResult result, RedirectAttributes redirectAttrs, HttpServletRequest request, Model model) {

		if (result.hasErrors()) {
			return "annuncio/preparaAcquisto";
		}
		AcquistoDTO acquistoDTO = new AcquistoDTO();
		acquistoDTO.setDescrizione(annuncioDTO.getTestoAnnuncio());
		acquistoDTO.setPrezzo(annuncioDTO.getPrezzo());
		acquistoDTO.setUtente(annuncioDTO.getUtente());
		acquistoDTO.setAnno(annuncioDTO.getDataPubblicazione());
		
		acquistoService.inserisci(AcquistoDTO.createModelFromDTO(acquistoDTO));

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/list";
	}
}
