package it.prova.ebay.web.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.ebay.dto.AnnuncioDTO;
import it.prova.ebay.dto.CategoriaDTO;
import it.prova.ebay.dto.UtenteDTO;
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
		Set<AnnuncioDTO> annunciDTO = AnnuncioDTO.createAnnuncioDTOListFromModelList(annuncioService.listAllAnnunci());
		mv.addObject("annunci_list_attribute", annunciDTO);
		mv.setViewName("annuncio/list");
		return mv;
	}

	@GetMapping("/search")
	public String searchAnnuncio(Model model) {
		model.addAttribute("list_categorie_attr",
				CategoriaDTO.createCategoriaDTOListFromModelList(categoriaService.listAllCategorie()));
		model.addAttribute("list_utenti_attr",
				UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti()));
		return "annuncio/search";
	}

	@PostMapping("/list")
	public String listAnnunci(AnnuncioDTO annuncioExample, ModelMap model) {
		System.out.println(annuncioExample.getCategorie());
		Set<AnnuncioDTO> annunciDTO = AnnuncioDTO.createAnnuncioDTOListFromModelList(
				annuncioService.findByExample(AnnuncioDTO.createModelFromDTOForSearch(annuncioExample)));
		model.addAttribute("annunci_list_attribute", annunciDTO);
		return "annuncio/list";
	}

	@GetMapping("/insert")
	public String createAnnuncio(Model model) {
		model.addAttribute("insert_utente_annuncio",
				UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti()));
		AnnuncioDTO annuncioDTO = new AnnuncioDTO();
		annuncioDTO.setDataPubblicazione(new Date());
		model.addAttribute("insert_annuncio_attr", annuncioDTO);
		model.addAttribute("insert_categoria_attr",
				CategoriaDTO.createCategoriaDTOListFromModelList(categoriaService.listAllCategorie()));
		return "annuncio/insert";
	}

	@PostMapping("/save")
	public String saveAnnuncio(@Valid @ModelAttribute("insert_annuncio_attr") AnnuncioDTO annuncioDTO,
			BindingResult result, RedirectAttributes redirectAttrs, HttpServletRequest request, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("insert_annuncio_attr", annuncioDTO);
			model.addAttribute("insert_utente_annuncio",
					UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti()));
			model.addAttribute("insert_categoria_attr",
					CategoriaDTO.createCategoriaDTOListFromModelList(categoriaService.listAllCategorie()));
			return "annuncio/insert";
		}
		annuncioService.inserisci(AnnuncioDTO.createModelFromDTO(annuncioDTO));

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/annuncio";
	}

	@GetMapping("/show/{idAnnuncio}")
	public String showAcquisto(@PathVariable(required = true) Long idAnnuncio, Model model) {
		model.addAttribute("show_annuncio_attr", annuncioService.caricaSingoloAnnuncioEager(idAnnuncio));
		return "annuncio/show";
	}

//	@GetMapping("/preparaAcquisto/{idAnnuncio}")
//	public String preparaAcquisto(@PathVariable(required = true) Long idAnnuncio, Model model) {
//		model.addAttribute("show_annuncio_attr", annuncioService.caricaSingoloAnnuncioEager(idAnnuncio));
//		return "annuncio/dettaglio";
//	}
}
