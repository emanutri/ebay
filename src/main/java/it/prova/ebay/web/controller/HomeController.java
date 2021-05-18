package it.prova.ebay.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.prova.ebay.dto.CategoriaDTO;
import it.prova.ebay.service.categoria.CategoriaService;

@Controller
public class HomeController {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = { "/home", "" })
	public String loginMessage(Model model) {
		model.addAttribute("list_categorie_attr",
				CategoriaDTO.createCategoriaDTOListFromModelList(categoriaService.listAllCategorie()));
		return "index";
	}
}
