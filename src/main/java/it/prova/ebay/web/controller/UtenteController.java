package it.prova.ebay.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.ebay.model.Utente;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private AnnuncioService annuncioService;
	
	@GetMapping
	public ModelAndView listAllUtenti() {
		ModelAndView mv = new ModelAndView();
		List<Utente> utenti = utenteService.listAllUtenti();
		mv.addObject("utente_list_attribute", utenti);
		mv.setViewName("utente/list");
		return mv;
	}

	@GetMapping("/search")
	public String searchUtente(Model model) {
		model.addAttribute("list_ruoli_attr", ruoloService.listAllRuoli());
		model.addAttribute("list_annunci_attr", annuncioService.listAllAnnunci());		
		return "utente/search";
	}

	@PostMapping("/list")
	public String listUtenti(Utente utenteExample, ModelMap model) {
		List<Utente> utenti = utenteService.findByExample(utenteExample);
		model.addAttribute("utente_list_attribute", utenti);
		return "utente/list";
	}

	@PostMapping("/cambiaStato")
	public String cambiaStato(@RequestParam(name = "idUtenteForChangingStato", required = true) Long idUtente) {
		utenteService.invertUserAbilitation(idUtente);
		return "redirect:/utente";
	}

	@GetMapping("/insert")
	public String insertUtente(Model model) {
		model.addAttribute("insert_utente_attr", new Utente());
		model.addAttribute("list_ruoli_attr",  ruoloService.listAllRuoli());
		return "utente/insert";
	}

	@PostMapping("/save")
	public String saveUtente(@Valid @ModelAttribute("insert_utente_attr") Utente utente, BindingResult result,
			RedirectAttributes redirectAttrs) {
		
		if(result.hasErrors()) {
			return "utente/insert";
		}
		utenteService.inserisci(utente);
		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/utente";
	}

}
