package it.prova.ebay.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.ebay.dto.UtenteDTO;
import it.prova.ebay.service.utente.UtenteService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping("/register")
	public String registerUtente(Model model) {
		model.addAttribute("registra_utente_attr", new UtenteDTO());
		return "registration/registration";
	}

	@PostMapping("/save")
	public String saveUtente(@Valid @ModelAttribute("registra_utente_attr") UtenteDTO utenteDTO, BindingResult result,
			RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			return "registration/registration";
		}
		utenteService.inserisci(utenteDTO.buildUtenteModel());
		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/login";
	}

}
