package org.adunce.rest.gestion.controllers.rest;

import java.util.List;

import org.adunce.rest.gestion.model.Grupo;
import org.adunce.rest.gestion.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/REST/grupos")
public class GrupoRestController {

	@Autowired
	private GrupoRepository grRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Grupo> get(){
		return grRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestParam("grupo") Grupo grupo){
		
		return true;
	}
	
}
