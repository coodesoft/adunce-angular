package org.adunce.rest.gestion.controllers.rest;

import java.util.List;

import org.adunce.rest.gestion.model.Afiliado;
import org.adunce.rest.gestion.repositories.AfiliadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value="Afiliados",description="Controlador REST de Afiliados")
@RestController
@RequestMapping("/REST/afiliados")
public class AfiliadoRestController {

	@Autowired
	private AfiliadosRepository afRepo;
	
	@ApiOperation(value="Retorna a los afiliados.", notes="Retorna una lista completa de todos los afiliados del gremio.",response=Afiliado[].class)
	@RequestMapping(method=RequestMethod.GET)
	public List<Afiliado> list(){
		return afRepo.findAll();
	}
	
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public Afiliado get(@PathVariable String username){
		if (afRepo.exists(username))
			return afRepo.getOne(username);
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestParam("afiliado") Afiliado af){
		if(afRepo.exists(af.getUsername())){
			afRepo.save(af);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestParam("afiliado") Afiliado af){
		if(afRepo.exists(af.getUsername())){
			afRepo.save(af);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable String username){
		if(afRepo.exists(username)){
			afRepo.delete(afRepo.findOne(username));
			return true;
		}
		return false;
	}
}
