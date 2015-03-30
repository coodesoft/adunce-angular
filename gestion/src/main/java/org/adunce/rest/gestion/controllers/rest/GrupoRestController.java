package org.adunce.rest.gestion.controllers.rest;

import java.util.List;

import org.adunce.rest.gestion.model.Afiliado;
import org.adunce.rest.gestion.model.Grupo;
import org.adunce.rest.gestion.repositories.AfiliadosRepository;
import org.adunce.rest.gestion.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

@Api(value="Grupos",description="Controlador REST de Grupos")
@RestController
@RequestMapping("/REST/grupos")
public class GrupoRestController {

	@Autowired
	private GrupoRepository grRepo;
	
	@Autowired
	private AfiliadosRepository afRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Grupo> list(){
		return grRepo.findAll();
	}
	
	@RequestMapping(value="/{grupo}",method=RequestMethod.GET)
	public Grupo get(@PathVariable String grupoId){
		if(grRepo.exists(grupoId)){
			return grRepo.findOne(grupoId);
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestParam("grupo")Grupo grupo){
		if(grRepo.exists(grupo.getShortname())){
			grRepo.save(grupo);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestParam("grupo") Grupo grupo){
		if(!grRepo.exists(grupo.getShortname())){
			grRepo.save(grupo);
			return true;
		}
		return true;
	}
	
	@RequestMapping(value="/{grupo}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable String grupoId){
		if(grRepo.exists(grupoId)){
			grRepo.delete(grupoId);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/{grupo}/afiliados",method=RequestMethod.GET)
	public List<Afiliado> getAfiliados(@PathVariable String grupoId){
		if(grRepo.exists(grupoId)){
			return grRepo.getOne(grupoId).getAfiliados();
		}
		return null;
	}
	
	@RequestMapping(value="/{grupoId}/afiliados/{username}",method=RequestMethod.PUT)
	public Boolean addAfiliado(@PathVariable String grupoId,@PathVariable String username){
		if(afRepo.exists(username)&&grRepo.exists(grupoId)){
			Grupo grupo = grRepo.findOne(grupoId);
			grupo.getAfiliados().add(afRepo.getOne(username));
			grRepo.save(grupo);
			return true;
		}
		return false;
	}
	@RequestMapping(value="/{grupoId}/afiliados/{username}",method=RequestMethod.DELETE)
	public Boolean removeAfiliado(@PathVariable String grupoId,@PathVariable String username){
		if(afRepo.exists(username)&&grRepo.exists(grupoId)){
			Grupo grupo = grRepo.findOne(grupoId);
			grupo.getAfiliados().add(afRepo.getOne(username));
			grRepo.save(grupo);
			return true;
		}
		return false;
	}
}
