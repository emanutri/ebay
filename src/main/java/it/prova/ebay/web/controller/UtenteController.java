package it.prova.ebay.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.ebay.dto.RuoloDTO;
import it.prova.ebay.dto.UtenteDTO;
import it.prova.ebay.model.StatoUtente;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;
import it.prova.ebay.validate.RegistrationOrInsertValid;

@Controller
@RequestMapping("/utente")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
//	private AnnuncioService annuncioService;

	@GetMapping
	public ModelAndView listAllUtenti() {
		ModelAndView mv = new ModelAndView();
		List<UtenteDTO> utentiDTO = UtenteDTO.createUtenteDTOListFromModelList(utenteService.listAllUtenti());
		mv.addObject("utente_list_attribute", utentiDTO);
		mv.setViewName("utente/list");
		return mv;
	}

	@GetMapping("/search")
	public String searchUtente(Model model) {
		model.addAttribute("list_ruoli_attr", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
//		model.addAttribute("list_ruoli_attr", ruoloService.listAllRuoli());
		model.addAttribute("list_stati_attribute", StatoUtente.values());
//		model.addAttribute("list_annunci_attr",
//				AnnuncioDTO.createAnnuncioDTOListFromModelList(annuncioService.listAllAnnunci()));
		return "utente/search";
	}

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String listUtenti(UtenteDTO utenteExampleDTO, ModelMap model) {
		System.out.println(utenteExampleDTO.getId());
		System.out.println(utenteExampleDTO.getCognome());
		System.out.println(utenteExampleDTO.getRuoliDTO());
//		String[] ruoliParam = request.getParameterValues("roles");
//		utenteExampleDTO.setRuoli(convertParamsInDTO(ruoliParam));
		List<UtenteDTO> utentiDTO = UtenteDTO
				.createUtenteDTOListFromModelList(utenteService.findByExample(utenteExampleDTO.buildUtenteModel()));
//		List<UtenteDTO> utentiDTO = UtenteDTO
//				.createUtenteDTOListFromModelList(utenteService.findByExample(utenteExampleDTO.buildUtenteModel()));
		model.addAttribute("utente_list_attribute", utentiDTO);
		return "utente/list";
	}

	@PostMapping("/cambiaStato")
	public String cambiaStato(@RequestParam(name = "idUtenteForChangingStato", required = true) Long idUtente) {
		utenteService.invertUserAbilitation(idUtente);
		return "redirect:/utente";
	}

	@GetMapping("/insert")
	public String insertUtente(Model model) {
		model.addAttribute("insert_utente_attr", new UtenteDTO());
		model.addAttribute("list_ruoli_attr", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
		model.addAttribute("list_stati_attribute", StatoUtente.values());
		return "utente/insert";
	}

	@PostMapping("/save")
	public String saveUtente(
			@Validated(RegistrationOrInsertValid.class) @ModelAttribute("insert_utente_attr") UtenteDTO utenteDTO,
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {

		if (!utenteDTO.validatePassword()) {
			result.rejectValue("confermaPassword", "confermaPassword.notequals");
		}

		if (result.hasErrors()) {
			model.addAttribute("list_ruoli_attr",
					RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
			model.addAttribute("list_stati_attribute", StatoUtente.values());
			return "utente/insert";
		}
		utenteService.inserisci(utenteDTO.buildUtenteModel());
		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/utente";
	}

	@GetMapping("/edit/{idUtente}")
	public String editUtente(@PathVariable(required = true) Long idUtente, Model model) {
		model.addAttribute("edit_utente_attr",
				UtenteDTO.createDTOFromModelForEdit(utenteService.caricaSingoloUtenteEager(idUtente)));
		model.addAttribute("list_stati_attribute", StatoUtente.values());
		model.addAttribute("list_ruoli_attr", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
		return "utente/edit";
	}

	@PostMapping("/edit/update")
	public String updateUtente(
			@Validated(RegistrationOrInsertValid.class) @ModelAttribute("edit_utente_attr") UtenteDTO utenteDTO,
			BindingResult result, RedirectAttributes redirectAttrs, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("list_ruoli_attr",
					RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
			model.addAttribute("list_stati_attribute", StatoUtente.values());
			return "utente/edit";
		}

		utenteService.aggiorna(utenteDTO.buildUtenteModel());
		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/utente";
	}

	@GetMapping("/show/{idUtente}")
	public String showUtente(@PathVariable(required = true) Long idUtente, Model model) {
		model.addAttribute("show_utente_attr",
				UtenteDTO.createDTOFromModelForShow(utenteService.caricaSingoloUtenteEager(idUtente)));
		model.addAttribute("list_ruoli_attr", RuoloDTO.createRuoloDTOListFromModelList(ruoloService.listAllRuoli()));
		model.addAttribute("list_stati_attribute", StatoUtente.values());
		return "utente/show";
	}

//	public Set<RuoloDTO> convertParamsInDTO(String[] ruoliParams) {
//		Set<RuoloDTO> ruoli = new HashSet<>(0);
//		if (ruoliParams != null) {
//			for (String ruoloItem : ruoliParams) {
//				ruoli.add(RuoloDTO.createDTOFromModel(ruoloService.caricaSingoloElemento(Long.parseLong(ruoloItem))));
//			}
//		}
//		return ruoli;
//	}

}
