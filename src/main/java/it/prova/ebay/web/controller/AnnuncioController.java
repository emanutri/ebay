package it.prova.ebay.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.prova.ebay.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;
import it.prova.ebay.service.utente.UtenteService;

@Controller
@RequestMapping("/annuncio")
public class AnnuncioController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private AnnuncioService annuncioService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ModelAndView listAllAnnunci() {
		ModelAndView mv = new ModelAndView();
		List<AnnuncioDTO> annunciDTO = AnnuncioDTO.createAnnuncioDTOListFromModelList(annuncioService.listAllAnnunci());
		mv.addObject("annunci_list_attribute", annunciDTO);
		mv.setViewName("annuncio/list");
		return mv;
	}
	
	@GetMapping("/search")
	public String searchAnnuncio(Model model) {
		model.addAttribute("list_categorie_attr", categoriaService.listAllCategorie());
		model.addAttribute("list_annunci_attr", annuncioService.listAllAnnunci());
		model.addAttribute("list_utenti_attr", utenteService.listAllUtenti());
		return "annuncio/search";
	}

}
