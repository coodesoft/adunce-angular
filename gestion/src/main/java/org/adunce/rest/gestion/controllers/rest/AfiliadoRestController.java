package org.adunce.rest.gestion.controllers.rest;

import java.util.List;

import org.adunce.rest.gestion.model.Afiliado;
import org.adunce.rest.gestion.repositories.AfiliadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

@Api(value="Afiliados",description="Controlador REST de Afiliados")
@RestController
@RequestMapping("/REST/afiliados")
public class AfiliadoRestController {

	@Autowired
	private AfiliadosRepository afRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Afiliado> get(){
		return afRepo.findAll();
	}
	
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public Afiliado getAfiliado(@PathVariable String username){
		if (afRepo.exists(username))
			return afRepo.getOne(username);
		return null;
	}
	
	
	@RequestMapping(value="/{username}/delete",method=RequestMethod.GET)
	public Boolean delete(@PathVariable String username){
		if(afRepo.exists(username)){
			afRepo.delete(afRepo.findOne(username));
			return true;
		}
		return false;
	}
}
