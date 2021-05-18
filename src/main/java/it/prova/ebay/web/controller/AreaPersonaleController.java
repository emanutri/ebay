package it.prova.ebay.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.prova.ebay.dto.AcquistoDTO;
import it.prova.ebay.dto.AnnuncioDTO;
import it.prova.ebay.dto.RuoloDTO;
import it.prova.ebay.dto.UtenteDTO;
import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.model.Utente;
import it.prova.ebay.service.acquisto.AcquistoService;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

@Controller
@RequestMapping("/areapersonale")
public class AreaPersonaleController {
	
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private AcquistoService acquistoService;
	@Autowired
	private AnnuncioService annuncioService;

	@GetMapping("/show")
	public String showUtenteInfo(Model model, Principal principal) {
		
		Utente utenteInSessione = utenteService.findByUserName(principal.getName());
		model.addAttribute("show_utente_attr",
				UtenteDTO.createDTOFromModelForShow(utenteInSessione));
		model.addAttribute("list_ruoli_attr", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
		model.addAttribute("list_stati_attribute", StatoUtente.values());
		return "areapersonale/show";
	}
	
	@GetMapping("/showInfoAcquisto/{idAcquisto}")
	public String showAcquistiInfo(@PathVariable(required = true) Long idAcquisto, Model model) {
		model.addAttribute("show_acquisto_attr", AcquistoDTO.createDTOFromModel(acquistoService.caricaSingoloElementoEager(idAcquisto)));
		return "areapersonale/showInfoAcquisto";
	}
	
	@GetMapping("/showInfoAnnuncio/{idAnnuncio}")
	public String showAnnunciInfo(@PathVariable(required = true) Long idAnnuncio, Model model) {
		model.addAttribute("show_annuncio_attr", AnnuncioDTO.createDTOFromModel(annuncioService.caricaSingoloAnnuncio(idAnnuncio)));
		return "areapersonale/showInfoAnnuncio";
	}
}