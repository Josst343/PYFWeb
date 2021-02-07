package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Conferencista;
import com.example.demo.service.ConferencistaService;


@Controller
public class ConferencistaController {
	
	@Autowired
	private ConferencistaService conferencistaService;

	@GetMapping("/")
	public String index(Model model) {
		List<Conferencista> conferencistas = conferencistaService.listaConferencistas();

		
		model.addAttribute("conferencistas",conferencistas );
		
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Conferencista conferencista) {	
		return "modificar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Conferencista conferencista) {
		System.out.println(conferencista.getBiografia());
		conferencistaService.guardar(conferencista);
		return "redirect:/";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarConferencista(Conferencista conferencista, Model model) {
		//System.err.println(conferencista.getId());
		conferencista=conferencistaService.encontrarConferencista(conferencista);
		model.addAttribute("conferencista", conferencista);
		return "modificar";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarConferencista(Conferencista conferencista) {
		System.err.println(conferencista.getId());
		conferencista=conferencistaService.encontrarConferencista(conferencista);
		conferencistaService.eliminar(conferencista);
		return"redirect:/";
	}
}
