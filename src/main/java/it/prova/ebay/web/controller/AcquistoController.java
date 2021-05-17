package it.prova.ebay.web.controller;

import java.security.Principal;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.ebay.dto.AcquistoDTO;
import it.prova.ebay.dto.AnnuncioDTO;
import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Utente;
import it.prova.ebay.service.acquisto.AcquistoService;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.utente.UtenteService;

@Controller
@RequestMapping("/acquisto")
public class AcquistoController {

	@Autowired
	private AnnuncioService annuncioService;

	@Autowired
	private AcquistoService acquistoService;

	@Autowired
	private UtenteService utenteService;

	@GetMapping
	public ModelAndView listAllAcquisti() {
		ModelAndView mv = new ModelAndView();
		Set<AcquistoDTO> acquistiDTO = AcquistoDTO
				.createAcquistoDTOListFromModelList(acquistoService.listAllAcquisti());
		mv.addObject("acquisti_list_attribute", acquistiDTO);
		mv.setViewName("acquisto/listAcquisti");
		return mv;
	}
	
	@GetMapping("/riepilogo/{idAnnuncio}")
	public String riepilogoAcquisto(@PathVariable(required = true) Long idAnnuncio, Model model) {
		model.addAttribute("show_annuncio_attr", annuncioService.caricaSingoloAnnuncioEager(idAnnuncio));
		return "acquisto/riepilogo";
	}
	
	@GetMapping("/preparaAcquisto/{idAnnuncio}")
	public String preparaAcquisto(@PathVariable(required = true) Long idAnnuncio, Model model) {
		model.addAttribute("show_annuncio_attr", annuncioService.caricaSingoloAnnuncioEager(idAnnuncio));
		return "annuncio/dettaglio";
	}

	@PostMapping("/compra")
	public String completaAcquisto(@ModelAttribute("show_annuncio_attr") AnnuncioDTO annuncioDTO, Model model,
			BindingResult result, HttpServletRequest request, Principal principal, RedirectAttributes redirectAttrs) {

		Utente utenteInSessione = utenteService.findByUserName(principal.getName());

		if (result.hasErrors()) {
			model.addAttribute("show_annuncio_attr", annuncioService.caricaSingoloAnnuncioEager(annuncioDTO.getId()));
			model.addAttribute("errorMessage", "Ops.. si è verificato un problema");
			return "annuncio/dettaglio";
		}

		Annuncio annuncio = annuncioService.caricaSingoloAnnuncioEager(annuncioDTO.getId());
		if (utenteInSessione.getCredito() >= annuncio.getPrezzo()) {
			utenteInSessione.setCredito(utenteInSessione.getCredito() - annuncio.getPrezzo());
			annuncio.setAperto(false);
			
			utenteService.aggiorna(utenteInSessione);
			annuncioService.aggiorna(annuncio);
			
			Acquisto acquisto = new Acquisto();
			acquisto.setDescrizione(annuncio.getTestoAnnuncio());
			acquisto.setPrezzo(annuncio.getPrezzo());
			acquisto.setUtente(utenteInSessione);
			acquisto.setAnno(new Date());

			acquistoService.inserisci(acquisto);

			redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
			return "redirect:/acquisto";
		}else {
			model.addAttribute("show_annuncio_attr", annuncioService.caricaSingoloAnnuncioEager(annuncioDTO.getId()));
			model.addAttribute("errorMessage", "Non hai credito sufficiente per effettuare l'acquisto, ricarica il portafoglio");
			return "annuncio/dettaglio";
		}
	}
}
